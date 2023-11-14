
package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Bloc  implements Serializable {
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Id
    private long idBloc ;
    private String nomBloc;
    private long capaciteBloc ;
   @ManyToOne(cascade =CascadeType.PERSIST)
   @JoinColumn(name = "foyer_id") //pour renommer le colone de jointure
           //el  mapedby dima nhoto fel child (cardinalite li akal )
           //el fk yemchi leli ando cardinalite akwa
   Foyer foyers  ;
   @OneToMany (cascade =  {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "bloc")
    private Set<Chambre> chambres ;
   //fel fetch  fel onetomanymanytomany  lazy w fel one eager


}