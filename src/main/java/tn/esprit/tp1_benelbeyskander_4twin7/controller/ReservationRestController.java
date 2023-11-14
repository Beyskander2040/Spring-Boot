package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Reservation;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IReservationServices;
import java.util.List;
@Tag(name = "Reservation Management")
@Slf4j
@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor

public class ReservationRestController {
private final IReservationServices reservationServices ;
    @Operation(description = "Get all Reservations")
@GetMapping("/getallreservation")
    public List<Reservation> getallreservation(){
    return reservationServices.getAllReservations();
}
    @Operation(description = "add Reservation")
    @PostMapping("/addreservation")
    public Reservation ajouterreservation(@RequestBody Reservation r) {
        return reservationServices.addReservation(r);
    }
    @Operation(description = "Update reservation")
    @PutMapping("/update/{idReservation}")
    public Reservation modifierreservation(@PathVariable long idRservatoion ,@RequestBody Reservation updatedReservation){
    Reservation existingReservation = reservationServices.getReservation(idRservatoion);
    if (existingReservation != null){
        existingReservation.setDebutAnneeUniversitaire(updatedReservation.getDebutAnneeUniversitaire());
        existingReservation.setDebutAnneeUniversitaire(updatedReservation.getDebutAnneeUniversitaire());
        existingReservation.setFinAnneeUniv(updatedReservation.getFinAnneeUniv());

        existingReservation.setEstValide(updatedReservation.getEstValide());
        existingReservation.setEtudiants(updatedReservation.getEtudiants());

        // Enregistrez la réservation mise à jour
        return reservationServices.updateReservation(existingReservation);
    } else {
        return null;
    }

        }
    @Operation(description = "Delete reservation")
    @DeleteMapping("/delete/{idReservation}")
    public void supprimerreservation(@PathVariable long idRservatoion,@RequestBody Reservation updatedReservation){
        Reservation existingReservation = reservationServices.getReservation(idRservatoion);
        if (existingReservation != null){
            reservationServices.supprimerReservation(idRservatoion);


    }


    }
}
