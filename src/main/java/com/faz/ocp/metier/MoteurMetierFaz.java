package com.faz.ocp.metier;

import com.faz.ocp.dao.IAccesDonneesFaz;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("simple")   // ⬅️ Actif uniquement avec le profil "simple"
public class MoteurMetierFaz implements IMoteurMetierFaz {

    private final IAccesDonneesFaz sourceFaz;

    public MoteurMetierFaz(IAccesDonneesFaz sourceFaz) {
        this.sourceFaz = sourceFaz;
    }

    @PostConstruct
    public void init() {
        System.out.println("[TRACE] Implementation DAO injectee : " + sourceFaz.getClass().getSimpleName());
    }

    @Override
    public double executerCalculFaz() {
        double valeurFaz = sourceFaz.extraireDonneeFaz();
        double resultatFaz = valeurFaz * 2;
        System.out.println("[MoteurMetierFaz] Calcul : " + valeurFaz + " x 2 = " + resultatFaz);
        return resultatFaz;
    }
}