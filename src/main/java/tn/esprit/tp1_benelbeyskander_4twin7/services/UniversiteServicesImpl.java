package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IfoyerRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IuniversiteRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Universite;

import java.util.List;
@Service
@RequiredArgsConstructor

public class UniversiteServicesImpl implements IUniversiteServices{
    final IuniversiteRepository universiteRepository ;
    final IfoyerRepository ifoyerRepository;

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepository.findAll() ;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void deleteUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
@Transactional
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer  = ifoyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
       // return universiteRepository.save(universite);
    return universite;
        //save pour faire la mise a jour dans la base
    }
}
