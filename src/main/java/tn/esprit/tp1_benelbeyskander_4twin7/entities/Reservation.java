package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
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

    private  long idReservation ;
    private String numReservation ;
    @Temporal(TemporalType.DATE)
    private Date DebutAnneeUniversitaire ;
    @Temporal(TemporalType.DATE)
    private LocalDate finAnneeUniv ;
    private Boolean estValide ;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    Chambre chambres ;
    @ManyToMany (mappedBy = "reservations",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants ;



}