package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Universite;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IUniversiteServices;
import java.util.List;
@Tag(name = "Universite Management")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("Universite")
public class UniversiteRestController {
    private final IUniversiteServices universiteServices;
    @Operation(description = "Get all universities")

    @GetMapping("/getalluniversites")
    public List<Universite> getalluniversite() {
        return universiteServices.getAllUniversite();

    }
    @Operation(description = "add universite")
    @PostMapping("/adduniversite")
    public Universite ajouteruniversite(@RequestBody Universite universite) {
        return universiteServices.addUniversite(universite);

    }
    @Operation(description = "Update universite")
    @PutMapping("/updateuniversite/{idUniversite}")
    public Universite modifieruniversite(@PathVariable Long idUniversite, @RequestBody Universite updatedUniversite) {
        Universite existingUniversite = universiteServices.getUniversite(idUniversite);
        if (existingUniversite != null) {
            // Mettez à jour les attributs de l'université existante avec les nouvelles valeurs
            existingUniversite.setNomUniversite(updatedUniversite.getNomUniversite());
            existingUniversite.setAdresse(updatedUniversite.getAdresse());
            return universiteServices.updateUniversite(existingUniversite);
        } else {
            return null;
        }
    }

    @Operation(description = "Delete universite")
    @DeleteMapping("/delete/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite) {
        Universite existingUniversite = universiteServices.getUniversite(idUniversite);

        if (existingUniversite != null) {
            universiteServices.deleteUniversite(idUniversite);
        } else {
            log.warn("N'existe pas");
        }
    }

    @PutMapping("/affecterUnivFoyer/{idFoyer}/{nom}")
    public Universite affecterUnivFoyer(@PathVariable Long idFoyer, @PathVariable String nom) {
        return universiteServices.affecterFoyerAUniversite(idFoyer, nom);
    }

    }


