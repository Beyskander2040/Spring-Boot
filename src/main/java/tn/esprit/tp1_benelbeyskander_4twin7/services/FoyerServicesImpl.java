package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Universite;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IblocRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IfoyerRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IuniversiteRepository;

import java.util.List;
@RequiredArgsConstructor

@Service

public class FoyerServicesImpl implements IFoyerSevices{

  final  IfoyerRepository foyerRepository ;
  final IuniversiteRepository universiteRepository;
  final IblocRepository blocRepository ;

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

    @Override
    public Foyer ajouterFoyeretaffecterUniversite(Foyer f, long idUniversite) {
       // on a utiliser le fetch fel entite  pour recuperer la liste des bloc
        //on a affecter le foyer a une universite
        Universite univ = universiteRepository.findById(idUniversite).orElse(null);
        univ.setFoyer(f);
        //bech njib bel liste taa el  bloc eli mawjouda fel foyer w bech n affecti el bloc lel foyer
    for(Bloc aBloc:f.getBlocs()) {
        aBloc.setFoyers(f);
      blocRepository.save(aBloc);
     }return f;
    }
}
