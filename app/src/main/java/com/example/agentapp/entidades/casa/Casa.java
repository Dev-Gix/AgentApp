package com.example.agentapp.entidades.casa;

public class Casa {
    Long CasaPK;
    int NumeroDeCasa;
    String Direccion;
    Long Manzana_ClaveFR;

    public Casa() {
    }

    public Casa(Long casaPK, int numeroDeCasa, String direccion, Long manzana_ClaveFR) {
        CasaPK = casaPK;
        NumeroDeCasa = numeroDeCasa;
        Direccion = direccion;
        Manzana_ClaveFR = manzana_ClaveFR;
    }


    public Long getCasaPK() {
        return CasaPK;
    }

    public void setCasaPK(Long casaPK) {
        CasaPK = casaPK;
    }

    public int getNumeroDeCasa() {
        return NumeroDeCasa;
    }

    public void setNumeroDeCasa(int numeroDeCasa) {
        NumeroDeCasa = numeroDeCasa;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Long getManzana_ClaveFR() {
        return Manzana_ClaveFR;
    }

    public void setManzana_ClaveFR(Long manzana_ClaveFR) {
        Manzana_ClaveFR = manzana_ClaveFR;
    }
}
