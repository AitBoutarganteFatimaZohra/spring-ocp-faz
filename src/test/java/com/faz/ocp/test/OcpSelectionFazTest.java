package com.faz.ocp.test;

import com.faz.ocp.config.ConfigurationFaz;
import com.faz.ocp.metier.IMoteurMetierFaz;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Test de non-regression : verifie que le choix de la source
 * impacte le resultat sans modifier le code metier.
 *
 * ⚠️ Le resultat attendu depend de application.properties :
 *   dao.target=sourceLocaleFaz   → 200.0 (100 × 2)
 *   dao.target=sourceDistanteFaz → 400.0 (200 × 2)
 *   dao.target=sourceFichierFaz  → 600.0 (300 × 2)
 *   dao.target=sourceApiFaz      → 800.0 (400 × 2)
 */
public class OcpSelectionFazTest {

    @Test
    public void testResultatSelonConfiguration() {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext contexteFaz =
                new AnnotationConfigApplicationContext(ConfigurationFaz.class);

        // Recuperer le bean metier
        IMoteurMetierFaz moteurFaz = contexteFaz.getBean(IMoteurMetierFaz.class);

        // Verifier le resultat selon application.properties
        // Configuration actuelle : dao.target=sourceApiFaz
        // Resultat attendu : 400.0 × 2 = 800.0
        assertEquals(800.0, moteurFaz.executerCalculFaz(), 0.001);

        contexteFaz.close();
    }
}