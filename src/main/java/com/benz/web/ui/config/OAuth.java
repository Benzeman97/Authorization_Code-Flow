package com.benz.web.ui.config;

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

    private Github github;

    public Github getGithub() {
        return github;
    }

    public void setGithub(Github github) {
        this.github = github;
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

     public static class Github{

         private String clientId;
         private String clientSecret;
         private String accessTokenUri;
         private String userAuthorizationUri;
         private String clientAuthenticationScheme;
         private String userInfoUri;
         private boolean preferTokenInfo;
         private String responseType;
         private String grantType;

         public String getClientId() {
             return clientId;
         }

         public void setClientId(String clientId) {
             this.clientId = clientId;
         }

         public String getClientSecret() {
             return clientSecret;
         }

         public void setClientSecret(String clientSecret) {
             this.clientSecret = clientSecret;
         }

         public String getAccessTokenUri() {
             return accessTokenUri;
         }

         public void setAccessTokenUri(String accessTokenUri) {
             this.accessTokenUri = accessTokenUri;
         }

         public String getUserAuthorizationUri() {
             return userAuthorizationUri;
         }

         public void setUserAuthorizationUri(String userAuthorizationUri) {
             this.userAuthorizationUri = userAuthorizationUri;
         }

         public String getClientAuthenticationScheme() {
             return clientAuthenticationScheme;
         }

         public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
             this.clientAuthenticationScheme = clientAuthenticationScheme;
         }

         public String getUserInfoUri() {
             return userInfoUri;
         }

         public void setUserInfoUri(String userInfoUri) {
             this.userInfoUri = userInfoUri;
         }

         public boolean isPreferTokenInfo() {
             return preferTokenInfo;
         }

         public void setPreferTokenInfo(boolean preferTokenInfo) {
             this.preferTokenInfo = preferTokenInfo;
         }

         public String getResponseType() {
             return responseType;
         }

         public void setResponseType(String responseType) {
             this.responseType = responseType;
         }

         public String getGrantType() {
             return grantType;
         }

         public void setGrantType(String grantType) {
             this.grantType = grantType;
         }
     }
}
