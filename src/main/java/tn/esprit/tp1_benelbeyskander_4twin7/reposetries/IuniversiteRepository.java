package tn.esprit.tp1_benelbeyskander_4twin7.reposetries;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Universite;

public interface IuniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite(String nom);
}
