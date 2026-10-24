package com.faz.ocp;

import com.faz.ocp.config.ConfigurationFaz;
import com.faz.ocp.metier.IMoteurMetierFaz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LanceurMultipleFaz {

    public static void main(String[] args) {
        System.out.println("=== TP SPRING OCP : Injection multiple ===\n");

        AnnotationConfigApplicationContext contexteFaz =
                new AnnotationConfigApplicationContext();
        contexteFaz.getEnvironment().setActiveProfiles("dev", "api", "fichier");
        contexteFaz.register(ConfigurationFaz.class);
        contexteFaz.refresh();

        IMoteurMetierFaz moteurMultipleFaz =
                contexteFaz.getBean("moteurMultipleFaz", IMoteurMetierFaz.class);

        double resultatFaz = moteurMultipleFaz.executerCalculFaz();
        System.out.println("\nResultat final : " + resultatFaz);

        contexteFaz.close();
    }
}