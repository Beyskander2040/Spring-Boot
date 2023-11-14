package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IresevationRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Reservation;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationServicesImpl implements IReservationServices{
    final IresevationRepository resevationRepository;
    @Override
    public List<Reservation> getAllReservations() {

        return (List<Reservation>) resevationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {

        return resevationRepository.save(r);
    }

    @Override
    public Reservation getReservation(long idReservation) {
        return resevationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return resevationRepository.save(r);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        resevationRepository.deleteById(idReservation);
    }


}
