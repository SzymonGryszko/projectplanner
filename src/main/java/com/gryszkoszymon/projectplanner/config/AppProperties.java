package com.gryszkoszymon.projectplanner.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Auth auth = new Auth();

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;
    }

    public Auth getAuth() {
        return auth;
    }

}
