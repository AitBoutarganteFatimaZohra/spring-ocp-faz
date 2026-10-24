package com.faz.ocp.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("sourceLocaleFaz")
@Profile("prod")   // ⬅️ Réactivé
public class SourceLocaleFaz implements IAccesDonneesFaz {

    @Override
    public double extraireDonneeFaz() {
        double valeurFaz = 100.0;
        System.out.println("[SourceLocaleFaz] Donnee extraite en LOCAL (prod) : " + valeurFaz);
        return valeurFaz;
    }
}