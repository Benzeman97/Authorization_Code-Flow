package com.benz.web.ui.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth")
public class OAuth {

    private Authorization authorization;

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

     public static class Authorization{

        private String authToken;
        private String clientId;
        private String clientSecret;
        private String responseType;
        private String accessToken;
        private String grantType;
        private String resourceUrl;

         public String getAuthToken() {
             return authToken;
         }

         public String getClientId() {
             return clientId;
         }

         public String getClientSecret() {
             return clientSecret;
         }

         public String getResponseType() {
             return responseType;
         }

         public String getAccessToken() {
             return accessToken;
         }

         public String getGrantType() {
             return grantType;
         }

         public String getResourceUrl() {
             return resourceUrl;
         }

         public void setAuthToken(String authToken) {
             this.authToken = authToken;
         }

         public void setClientId(String clientId) {
             this.clientId = clientId;
         }

         public void setClientSecret(String clientSecret) {
             this.clientSecret = clientSecret;
         }

         public void setResponseType(String responseType) {
             this.responseType = responseType;
         }

         public void setAccessToken(String accessToken) {
             this.accessToken = accessToken;
         }

         public void setGrantType(String grantType) {
             this.grantType = grantType;
         }

         public void setResourceUrl(String resourceUrl) {
             this.resourceUrl = resourceUrl;
         }
     }
}
