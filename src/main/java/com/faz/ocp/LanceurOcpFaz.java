package com.faz.ocp;

import com.faz.ocp.config.ConfigurationFaz;
import com.faz.ocp.metier.IMoteurMetierFaz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LanceurOcpFaz {

    public static void main(String[] args) {
        System.out.println("=== TP SPRING OCP : Injection de dependances ===\n");

        // Activer le profil "simple" pour que MoteurMetierFaz soit chargé
        AnnotationConfigApplicationContext contexteFaz =
                new AnnotationConfigApplicationContext();
        contexteFaz.getEnvironment().setActiveProfiles("simple");
        contexteFaz.register(ConfigurationFaz.class);
        contexteFaz.refresh();

        IMoteurMetierFaz moteurFaz = contexteFaz.getBean(IMoteurMetierFaz.class);

        double resultatFaz = moteurFaz.executerCalculFaz();
        System.out.println("\nResultat final : " + resultatFaz);

        contexteFaz.close();
    }
}