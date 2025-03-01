package com.algerage.auth.infraestructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakConfigProperties {
    private String authServerUrl;
    private String realm;
    private String clientId;
    private String clientSecret;
}
