package com.faz.ocp.config;

import com.faz.ocp.dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DynamicSourceFaz {

    @Value("${dao.target}")
    private String cibleDaoFaz;

    @Bean
    @Primary
    public IAccesDonneesFaz sourceDynamiqueFaz() {
        System.out.println("[DynamicSourceFaz] Cible choisie : " + cibleDaoFaz);
        switch (cibleDaoFaz) {
            case "sourceLocaleFaz":   return new SourceLocaleFaz();
            case "sourceDistanteFaz": return new SourceDistanteFaz();
            case "sourceFichierFaz":  return new SourceFichierFaz();
            case "sourceApiFaz":      return new SourceApiFaz();
            default:
                throw new IllegalArgumentException("Cible DAO inconnue : " + cibleDaoFaz);
        }
    }
}