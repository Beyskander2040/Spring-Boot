package tn.esprit.tp1_benelbeyskander_4twin7.services;


import tn.esprit.tp1_benelbeyskander_4twin7.entities.Chambre;
import java.util.List;
public interface IChmabreServices {
    List<Chambre> getAllChmabres();
    Chambre addChambre(Chambre chambre );
        Chambre updateChambre(Chambre chambre);
        Chambre getChambre(int idChambre);
}
