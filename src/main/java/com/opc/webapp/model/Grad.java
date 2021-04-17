package com.opc.webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Grad {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int Id;
    private String Naziv;

    public Grad() {
    }

    public Grad(int id, String naziv) {
        Id = id;
        Naziv = naziv;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grad grad = (Grad) o;
        return Id == grad.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
