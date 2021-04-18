package com.opc.webapp.viewmodel;

public class Kupac_Grad_Kartica {
    private Integer Id;
    private String Naziv;
    private String Grad;
    private boolean Aktivan;
    private Integer BrojKartica;

    public Kupac_Grad_Kartica(Integer id, String naziv, String grad, boolean aktivan) {
        Id = id;
        Naziv = naziv;
        Grad = grad;
        Aktivan = aktivan;
    }

    public Integer getBrojKartica() {
        return BrojKartica;
    }

    public void setBrojKartica(Integer brojKartica) {
        BrojKartica = brojKartica;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String grad) {
        Grad = grad;
    }

    public boolean isAktivan() {
        return Aktivan;
    }

    public void setAktivan(boolean aktivan) {
        Aktivan = aktivan;
    }
}
