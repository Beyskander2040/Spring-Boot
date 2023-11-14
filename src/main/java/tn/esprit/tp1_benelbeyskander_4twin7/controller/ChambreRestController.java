package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Chambre;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IChmabreServices;
import java.util.List;
@Tag(name = "Chambre Management")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("Chambre")

public class ChambreRestController {
    private final IChmabreServices chambreServices;
    @Operation(description = "Get all chambres")
    @GetMapping("/allchambres")
    public List<Chambre> getallchambre() {
        return chambreServices.getAllChmabres();

    }
    @Operation(description = "retrive chambres")
    @PostMapping("/add")
    public Chambre addchambre(@RequestBody Chambre chambre) {
        return chambreServices.addChambre(chambre);


    }
    @Operation(description = "update chambre")
    @PutMapping("/updatechambre/{idChambre}")
    public Chambre updatechambre(@PathVariable long idChambre, @RequestBody Chambre updatedchambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);
        if (existingChambre != null) {
            // Mettez à jour les attributs de la chambre existante avec les nouvelles valeurs
            existingChambre.setNumeroChambre(updatedchambre.getNumeroChambre());
            existingChambre.setTypeC(updatedchambre.getTypeC());
            existingChambre.setBloc(updatedchambre.getBloc());
            existingChambre.setReservations(updatedchambre.getReservations());
            return chambreServices.updateChambre(existingChambre);
        } else {
            return null;
        }
    }
    @Operation(description = "delete chambre")

    @DeleteMapping("/delete/{idChambre}")
    public void deleteChambre(@PathVariable long  idChambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);

        if (existingChambre != null) {
            chambreServices.supprimerChambre(idChambre);

        } else {
            log.warn("N'existe pas");
        }
    }
}
