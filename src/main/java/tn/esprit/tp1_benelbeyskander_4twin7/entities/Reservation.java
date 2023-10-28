package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation  implements Serializable {
    @Id
    @GeneratedValue ( strategy  = GenerationType.IDENTITY)

    private  int idReservation ;
    private Date anneeUniversitaire ;
    private Boolean estValide ;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    Chambre chambres ;
    @ManyToMany (mappedBy = "reservations",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants ;



}