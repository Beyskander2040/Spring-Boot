package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IFoyerSevices;
import java.util.List;
@Tag(name = "Foyer Management")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("foyer")
public class FoyerRestController {
    private final IFoyerSevices foyerServices;
    @Operation(description = "Get all foyers")

    @GetMapping("/allfoyer")
    public List<Foyer> getallfoyer() {
        return foyerServices.getAllFoyer();
    }
    @Operation(description = "Get foyer by id ")
    @GetMapping("getfoyer/{idFoyer}")
    public Foyer getfoyerbyid(@PathVariable long idFoyer){
        return  foyerServices.getFoyer(idFoyer);    }
    @Operation(description = "add foyer")
    @PostMapping("/addfoyer")
    public Foyer ajouterfoyer(@RequestBody Foyer f) {
        return foyerServices.ajouterFoyer(f);

    }
    @Operation(description = "update foyer")
    @PutMapping("/updatefoyer/{idFoyer}")
    public Foyer modifierfoyer(@PathVariable long idFoyer, @RequestBody Foyer updatedfoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);

        if (existingFoyer != null) {

            existingFoyer.setNomFoyer(updatedfoyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(updatedfoyer.getCapaciteFoyer());


            return foyerServices.updateFoyer(existingFoyer);
        } else {
            return null;
        }

    }
    @Operation(description = "delete foyer")
    @DeleteMapping("/deletefoyer/{idFoyer}")
    public void supprimerfoyer(@PathVariable long idFoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);

        if (existingFoyer != null) {
            foyerServices.supprimerFoyer(idFoyer);
        } else {
            log.warn("N'existe pas");
        }
    }
}




