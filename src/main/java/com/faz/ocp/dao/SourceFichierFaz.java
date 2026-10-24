package com.faz.ocp.dao;

import org.springframework.stereotype.Component;

@Component("sourceFichierFaz")
public class SourceFichierFaz implements IAccesDonneesFaz {

    @Override
    public double extraireDonneeFaz() {
        double valeurFaz = 300.0;
        System.out.println("[SourceFichierFaz] Donnee extraite depuis un FICHIER : " + valeurFaz);
        return valeurFaz;
    }
}