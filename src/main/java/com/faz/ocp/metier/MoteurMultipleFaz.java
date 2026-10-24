package com.faz.ocp.metier;

import com.faz.ocp.dao.IAccesDonneesFaz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("moteurMultipleFaz")   // ⬅️ RÉACTIVÉ
public class MoteurMultipleFaz implements IMoteurMetierFaz {

    private final List<IAccesDonneesFaz> sourcesListeFaz;
    private final Map<String, IAccesDonneesFaz> sourcesMapFaz;

    public MoteurMultipleFaz(List<IAccesDonneesFaz> sourcesListeFaz,
                             Map<String, IAccesDonneesFaz> sourcesMapFaz) {
        this.sourcesListeFaz = sourcesListeFaz;
        this.sourcesMapFaz = sourcesMapFaz;
    }

    @Override
    public double executerCalculFaz() {
        System.out.println("[MoteurMultipleFaz] Nombre de DAO injectes : " + sourcesListeFaz.size());
        for (IAccesDonneesFaz sourceFaz : sourcesListeFaz) {
            System.out.println("  - " + sourceFaz.getClass().getSimpleName());
        }
        double sommeFaz = sourcesListeFaz.stream()
                .mapToDouble(IAccesDonneesFaz::extraireDonneeFaz)
                .sum();
        System.out.println("[MoteurMultipleFaz] Somme des valeurs : " + sommeFaz);
        return sommeFaz;
    }
}