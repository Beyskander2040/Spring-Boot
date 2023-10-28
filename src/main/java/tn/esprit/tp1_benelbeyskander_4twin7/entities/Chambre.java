
package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int idchambre;
    private long numeroChambre;
  @ManyToOne

    Bloc bloc ;
    @OneToMany(cascade = CascadeType.ALL )
    private Set<Reservation> reservations ;


    @Enumerated(EnumType.STRING) // Spécifiez EnumType.STRING si vous stockez les valeurs en tant que chaînes de caractères
    private TypeChambre typeC;


}