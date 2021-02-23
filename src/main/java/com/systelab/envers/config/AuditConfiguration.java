package com.systelab.envers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.context.annotation.Bean;


import javax.persistence.EntityManagerFactory;

@Configuration
@ConfigurationProperties(prefix = "systelab.envers")
@ComponentScan(basePackages = {"com.systelab.envers"})
public class AuditConfiguration {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    AuditConfiguration(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    AuditReader auditReader() {
        return AuditReaderFactory.get(entityManagerFactory.createEntityManager());
    }
}
