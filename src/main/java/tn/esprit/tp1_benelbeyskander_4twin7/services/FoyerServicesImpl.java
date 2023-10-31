package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IfoyerRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;

import java.util.List;
@RequiredArgsConstructor

@Service

public class FoyerServicesImpl implements IFoyerSevices{

  final  IfoyerRepository foyerRepository ;

    @Override
    public Foyer ajouterFoyer(Foyer F) {

        return foyerRepository.save(F);
    }

    @Override
    public Foyer updateFoyer(Foyer F) {

        return foyerRepository.save(F);
    }

    @Override
    public void supprimerFoyer(long IdFoyer) {
        foyerRepository.deleteById(IdFoyer);

    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
        // el get ken l ka l objet yrajoo sinonn ykharejli exception
        //orelse khyr
    }

    @Override
    public List<Foyer> getAllFoyer() {

        return (List<Foyer>) foyerRepository.findAll();
    }
}
