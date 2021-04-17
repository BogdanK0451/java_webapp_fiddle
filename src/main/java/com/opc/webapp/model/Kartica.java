package com.opc.webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Kartica {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(unique = true)
    private int Broj_kartice;
    @OneToMany
    private Set<Kupac> Kupac;

    public Kartica() {
    }

    public Kartica(int id, int broj_kartice, Set<Kupac> kupac) {
        Id = id;
        Broj_kartice = broj_kartice;
        Kupac = kupac;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getBroj_kartice() {
        return Broj_kartice;
    }

    public void setBroj_kartice(int broj_kartice) {
        Broj_kartice = broj_kartice;
    }

    public Set<Kupac> getKupac() {
        return Kupac;
    }

    public void setKupac(Set<Kupac> kupac) {
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
