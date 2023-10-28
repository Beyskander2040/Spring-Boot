package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IetudiantRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Etudiant;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EtudiantServicesImpl implements  IEtudiantServices {
    final IetudiantRepository etudiantRepository ;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addALLEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {

        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiant(long idEtudiant) {

        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
}
