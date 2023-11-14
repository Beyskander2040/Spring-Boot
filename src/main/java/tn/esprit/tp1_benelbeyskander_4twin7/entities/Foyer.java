package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)


    @Id
    private long idFoyer ;
    private String nomFoyer ;
    private long capaciteFoyer ;

    @OneToOne ( mappedBy = "foyer",fetch =FetchType.EAGER )
     private Universite universite ;
//
    @OneToMany (cascade  = CascadeType.ALL, mappedBy="foyers")
    private Set <Bloc> blocs ;

}
