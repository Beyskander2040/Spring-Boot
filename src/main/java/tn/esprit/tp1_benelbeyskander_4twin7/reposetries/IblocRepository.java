package tn.esprit.tp1_benelbeyskander_4twin7.reposetries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;

public interface IblocRepository extends CrudRepository<Bloc, Long> {
    Bloc findByNomBloc(String nom);
}
