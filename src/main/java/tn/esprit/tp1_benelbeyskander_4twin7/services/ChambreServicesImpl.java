package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IchambreRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Chambre;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChambreServicesImpl implements IChmabreServices {
    final IchambreRepository chambreRepository ;
    @Override
    public List<Chambre> getAllChmabres() {
        return (List<Chambre>) chambreRepository.findAll() ;
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}
