package com.faz.ocp.dao;

import org.springframework.stereotype.Component;

@Component("sourceDistanteFaz")
public class SourceDistanteFaz implements IAccesDonneesFaz {

    @Override
    public double extraireDonneeFaz() {
        double valeurFaz = 200.0;
        System.out.println("[SourceDistanteFaz] Donnee extraite A DISTANCE : " + valeurFaz);
        return valeurFaz;
    }
}