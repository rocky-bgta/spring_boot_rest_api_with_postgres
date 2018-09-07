package com.nybsys.tillboxweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@PropertySource(value = {"classpath:application.yml"})
public class YAMLConfig {
  
    private String url;
    private String username;
    private String password;
    private List<String> jpa = new ArrayList<>();

    @Autowired
    private Environment env;
    // standard getters and setters

    @Value("${spring.datasource.url}")
    private String userBucketPath;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getJpa() {
        return jpa;
    }

    public void setJpa(List<String> jpa) {
        this.jpa = jpa;
    }
}