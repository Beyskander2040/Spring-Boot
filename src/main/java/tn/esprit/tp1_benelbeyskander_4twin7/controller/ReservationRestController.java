package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Reservation;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IReservationServices;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor

public class ReservationRestController {
private final IReservationServices reservationServices ;
@GetMapping("/getallfoyer")
    public List<Reservation> getallreservation(){
    return reservationServices.getAllReservations();
}
    @PostMapping("/addfoyer")
    public Reservation ajouterfoyer(@RequestBody Reservation r) {
        return reservationServices.addReservation(r);
    }
    @PutMapping("/update/{idReservation}")
    public Reservation modifierreservation(@PathVariable int idRservatoion ,@RequestBody Reservation updatedReservation){
    Reservation existingReservation = reservationServices.getReservation(idRservatoion);
    if (existingReservation != null){
        existingReservation.setAnneeUniversitaire(updatedReservation.getAnneeUniversitaire());
        existingReservation.setEstValide(updatedReservation.getEstValide());
        existingReservation.setEtudiants(updatedReservation.getEtudiants());

        // Enregistrez la réservation mise à jour
        return reservationServices.updateReservation(existingReservation);
    } else {
        return null;
    }

        }
    @DeleteMapping("/delete/{idReservation}")
    public void supprimerreservation(@PathVariable int idRservatoion,@RequestBody Reservation updatedReservation){
        Reservation existingReservation = reservationServices.getReservation(idRservatoion);
        if (existingReservation != null){
            reservationServices.supprimerReservation(idRservatoion);


    }


    }
}
