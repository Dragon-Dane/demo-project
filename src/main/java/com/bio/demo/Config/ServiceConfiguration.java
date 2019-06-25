package com.bio.demo.Config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ServiceConfiguration {

    @Value("${service.properties.short-code:STR}")
    private String shortCode;
}
