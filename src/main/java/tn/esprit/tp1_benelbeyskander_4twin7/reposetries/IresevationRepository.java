package tn.esprit.tp1_benelbeyskander_4twin7.reposetries;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Reservation;

public interface IresevationRepository extends CrudRepository<Reservation,Integer> {
}
