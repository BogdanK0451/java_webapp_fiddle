package com.opc.webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Kartica {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(unique = true)
    private Integer Broj_kartice;
    @ManyToOne
    private Kupac Kupac;

    public Kartica() {
    }

    public Kartica(Integer broj_kartice, Kupac kupac) {
        Broj_kartice = broj_kartice;
        Kupac = kupac;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getBroj_kartice() {
        return Broj_kartice;
    }

    public void setBroj_kartice(Integer broj_kartice) {
        Broj_kartice = broj_kartice;
    }

    public Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(Kupac kupac) {
        Kupac = kupac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kartica kartica = (Kartica) o;
        return Id == kartica.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
