package com.benz.resource.web.api.config;

import com.benz.resource.web.api.db.ResourceId;
import com.benz.resource.web.api.security.SecurityProperties;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
@EnableResourceServer
@EnableConfigurationProperties(SecurityProperties.class)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private SecurityProperties securityProperties;

    private TokenStore tokenStore;

    public ResourceServerConfiguration(SecurityProperties securityProperties)
    {
        this.securityProperties=securityProperties;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
        resources.resourceId(ResourceId.RESOURCE_APP.toLowerCase());
        resources.resourceId(ResourceId.PRIVATE.toLowerCase());
    }

    @Bean
    public TokenStore tokenStore() throws Exception
    {
        if(tokenStore==null)
            tokenStore=new JwtTokenStore(jwtAccessTokenConverter());
        return tokenStore;
    }

    @Bean
    public DefaultTokenServices tokenServices() throws Exception
    {
        DefaultTokenServices tokenServices=new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() throws Exception
    {
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setVerifierKey(getPublicKeyAsString());
        return jwtAccessTokenConverter;
    }

    private String getPublicKeyAsString() throws Exception
    {
        return IOUtils.toString(securityProperties.getJwt().getPublicKey().getInputStream(),UTF_8);
    }
}
