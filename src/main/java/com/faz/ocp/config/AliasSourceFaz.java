package com.faz.ocp.config;

import com.faz.ocp.dao.IAccesDonneesFaz;
import com.faz.ocp.dao.SourceApiFaz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AliasSourceFaz {

    @Bean
    @Primary
    public IAccesDonneesFaz sourceAliasFaz() {
        return new SourceApiFaz();
    }
}