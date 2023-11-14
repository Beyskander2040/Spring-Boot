package tn.esprit.tp1_benelbeyskander_4twin7.services;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Reservation;

import java.util.List;
public interface IReservationServices {
    List<Reservation> getAllReservations();
    Reservation updateReservation(Reservation r);
    Reservation  getReservation(long idReservation);
    Reservation addReservation(Reservation r );
    void supprimerReservation(long idReservation);}
