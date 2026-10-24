package com.faz.ocp.dao;

import org.springframework.stereotype.Component;

@Component("sourceApiFaz")
public class SourceApiFaz implements IAccesDonneesFaz {

    @Override
    public double extraireDonneeFaz() {
        double valeurFaz = 400.0;
        System.out.println("[SourceApiFaz] Donnee extraite depuis une API : " + valeurFaz);
        return valeurFaz;
    }
}