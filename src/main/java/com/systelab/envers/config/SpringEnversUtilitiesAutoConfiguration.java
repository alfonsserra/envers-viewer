package com.systelab.envers.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "systelab.envers")
@ComponentScan(basePackages = {"com.systelab.envers"})
public class SpringEnversUtilitiesAutoConfiguration {
}
