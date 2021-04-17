package com.opc.webapp.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Kupac {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Naziv;
    @ManyToOne
    private Grad Grad;
    private boolean Aktivan;

    public Kupac() {
    }

    public Kupac(int id, String naziv, Grad grad, boolean aktivan) {
        Id = id;
        Naziv = naziv;
        Grad = grad;
        Aktivan = aktivan;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public Grad getGrad() {
        return Grad;
    }

    public void setGrad(Grad grad) {
        Grad = grad;
    }

    public boolean isAktivan() {
        return Aktivan;
    }

    public void setAktivan(boolean aktivan) {
        Aktivan = aktivan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kupac kupac = (Kupac) o;
        return Id == kupac.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
