package com.opc.webapp.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class KarticaDozvoljeniGrad {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @OneToOne
    private Kartica kartica;
    @OneToOne
    private Grad grad;

    public KarticaDozvoljeniGrad() {
    }

    public KarticaDozvoljeniGrad(Kartica kartica, Grad grad) {
        this.kartica = kartica;
        this.grad = grad;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Kartica getKartica() {
        return kartica;
    }

    public void setKartica(Kartica kartica) {
        this.kartica = kartica;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
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
