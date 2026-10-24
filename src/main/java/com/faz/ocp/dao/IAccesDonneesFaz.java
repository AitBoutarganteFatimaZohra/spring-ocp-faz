package com.faz.ocp.dao;

/**
 * Contrat d'acces aux donnees.
 * Toutes les implementations (locale, distante, fichier, API) doivent respecter ce contrat.
 */
public interface IAccesDonneesFaz {

    /**
     * Extrait une donnee numerique depuis la source.
     * @return La valeur extraite.
     */
    double extraireDonneeFaz();
}