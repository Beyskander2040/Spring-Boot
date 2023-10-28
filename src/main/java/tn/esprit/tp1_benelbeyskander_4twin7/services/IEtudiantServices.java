package tn.esprit.tp1_benelbeyskander_4twin7.services;

import tn.esprit.tp1_benelbeyskander_4twin7.entities.Etudiant;
import java.util.List;
public interface IEtudiantServices {

    List<Etudiant> getAllEtudiants();
    List<Etudiant> addALLEtudiants(List<Etudiant>etudiants);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant getEtudiant(long idEtudiant);
    void deleteEtudiant(long idEtudiant);
     Etudiant addEtudiant(Etudiant e );

    }
