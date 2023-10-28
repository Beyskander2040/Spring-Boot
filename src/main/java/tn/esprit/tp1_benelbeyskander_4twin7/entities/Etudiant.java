package tn.esprit.tp1_benelbeyskander_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant  implements Serializable {
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Id
    private  long idEtudiant ;
    private String nomEtu ;
    private String prenomEtu ;
    private long cin ;
    private String ecole ;
    private Date datenaissance ;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;

    public long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtu() {
        return nomEtu;
    }

    public void setNomEtu(String nomEtu) {
        this.nomEtu = nomEtu;
    }

    public String getPrenomEtu() {
        return prenomEtu;
    }

    public void setPrenomEtu(String prenomEtu) {
        this.prenomEtu = prenomEtu;
    }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}

