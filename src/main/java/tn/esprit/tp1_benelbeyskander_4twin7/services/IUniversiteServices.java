package tn.esprit.tp1_benelbeyskander_4twin7.services;

import tn.esprit.tp1_benelbeyskander_4twin7.entities.Universite;
import java.util.List;
public interface IUniversiteServices {
    List<Universite> getAllUniversite();
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    Universite getUniversite(long idUniversite );
    void deleteUniversite(long idUniversite);
}
