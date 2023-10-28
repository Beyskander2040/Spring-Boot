package tn.esprit.tp1_benelbeyskander_4twin7.services;

import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;
import java.util.List;
public interface IFoyerSevices {
    Foyer ajouterFoyer(Foyer F);
    Foyer updateFoyer (Foyer  F );
    void supprimerFoyer(long idFoyer);
    Foyer getFoyer(long idFoyer);
    List<Foyer> getAllFoyer();



}
