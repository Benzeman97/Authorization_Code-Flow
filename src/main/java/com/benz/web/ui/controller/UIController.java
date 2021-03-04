package com.benz.web.ui.controller;

import com.benz.web.ui.util.OAuth;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Arrays;

@Controller
@EnableConfigurationProperties(OAuth.class)
public class UIController {

    private OAuth oAuth;

    public UIController(OAuth oAuth)
    {
       this.oAuth=oAuth;
    }

    @GetMapping("/public")
    public ModelAndView loadPublicUI()
    {
        return new ModelAndView("public",HttpStatus.OK);
    }

    @RequestMapping("/code")
    public ResponseEntity<Object> getAuthToken() throws Exception
    {

        OAuth.Authorization auth = oAuth.getAuthorization();

        String url = auth.getAuthToken();
        url = url.concat("?client_id="+auth.getClientId());
        url=url.concat("&response_type="+auth.getResponseType());

        URI uri =new URI(url);
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders,HttpStatus.FOUND);


    }

    @GetMapping(value = "/private")
    @ResponseBody
    public String loadPrivate(@RequestParam("code") String code) throws Exception
    {
        OAuth.Authorization auth = oAuth.getAuthorization();
        System.out.printf("Authorization Token------- %s\n",code);

        RestTemplate restTemplate =new RestTemplate();
        String credentials = auth.getClientId().concat(":").concat(auth.getClientSecret());
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization","Basic "+encodedCredentials);

        HttpEntity<String> request =new HttpEntity(httpHeaders);
        String access_token_url = auth.getAccessToken();
        access_token_url = access_token_url.concat("?code="+code);
        access_token_url = access_token_url.concat("&grant_type="+auth.getGrantType());

        ResponseEntity<String> response = restTemplate.exchange(access_token_url, HttpMethod.POST,request,String.class);

        System.out.printf("Access Token Response ----------- %s\n",response.getBody());


        ObjectMapper objectMapper =new ObjectMapper();
        JsonNode node = objectMapper.readTree(response.getBody());
        String access_token = node.path("access_token").asText();


        String url = auth.getResourceUrl();

        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.add("Authorization","Bearer "+access_token);

        HttpEntity<String> accessRequest = new HttpEntity<>(authHeaders);

       ResponseEntity<String> resourceRes = restTemplate.exchange(url,HttpMethod.GET,accessRequest,String.class);

          return resourceRes.getBody();

    }

}

