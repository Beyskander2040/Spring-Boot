package tn.esprit.tp1_benelbeyskander_4twin7.reposetries;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Etudiant;

public interface IetudiantRepository extends CrudRepository<Etudiant, Long> {
}
