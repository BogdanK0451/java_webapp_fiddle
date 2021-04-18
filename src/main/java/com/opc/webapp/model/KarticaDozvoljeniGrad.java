package com.opc.webapp.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class KarticaDozvoljeniGrad {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @OneToOne
    private Kartica Kartica;
    @OneToOne
    private Grad Grad;

    public KarticaDozvoljeniGrad() {
    }

    public KarticaDozvoljeniGrad(Kartica kartica, Grad grad) {
        Kartica = kartica;
        Grad = grad;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Kartica getKartica() {
        return Kartica;
    }

    public void setKartica(Kartica kartica) {
        Kartica = kartica;
    }

    public Grad getGrad() {
        return Grad;
    }

    public void setGrad(Grad grad) {
        Grad = grad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KarticaDozvoljeniGrad that = (KarticaDozvoljeniGrad) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
