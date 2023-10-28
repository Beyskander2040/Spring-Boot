package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Etudiant;
import tn.esprit.tp1_benelbeyskander_4twin7.services.EtudiantServicesImpl;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("Etudiant")

public class EtudiantRestController {
    private  final EtudiantServicesImpl etudiantServices ;
    @GetMapping("/getalletudiants")
    public List<Etudiant> getalletudiants(){
        return etudiantServices.getAllEtudiants();
    }
    @PostMapping("/addetudiant")
    public Etudiant ajouteretudiant( @RequestBody Etudiant e){
        return etudiantServices.addEtudiant(e);
    }
    @PutMapping("/updateetudiant/{idEtudiant}")
    public Etudiant updateetudiant(@PathVariable long idEtudiant,@RequestBody  Etudiant updatedEtudiant){
        Etudiant existingEtudiant =  etudiantServices.getEtudiant(idEtudiant);
        if (existingEtudiant !=null){
            // Mettez à jour les attributs de l'étudiant existant avec les nouvelles valeurs
            existingEtudiant.setNomEtu(updatedEtudiant.getNomEtu());
            existingEtudiant.setPrenomEtu(updatedEtudiant.getPrenomEtu());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDatenaissance(updatedEtudiant.getDatenaissance());

            // Enregistrez l'étudiant mis à jour
            return etudiantServices.updateEtudiant(existingEtudiant);
        } else {
            return null;
        }
        }
        @DeleteMapping("/deleteetudiant/{idEtudiant}")
    public  void supprimeretudiant(@PathVariable  long idEtudiant, @RequestBody Etudiant updatedEtudiant){
            Etudiant existingEtudiant =  etudiantServices.getEtudiant(idEtudiant);
            if (existingEtudiant !=null) {
                etudiantServices.deleteEtudiant(idEtudiant);
            }else {
        log.warn("N'existe pas");
    }

        }
}
