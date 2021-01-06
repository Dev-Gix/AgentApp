package com.example.agentapp.entidades.obrasocial;

public class ObraSocial {
    Long ObraSocial_PK;
    String NombreObraSocial;


    public ObraSocial(Long obraSocialPK, String nombreObraSocial) {
        ObraSocial_PK = obraSocialPK;
        NombreObraSocial = nombreObraSocial;
    }

    public ObraSocial() {
    }


    public boolean isnull() {
        if (NombreObraSocial.equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ObraSocial{" +
                "ObraSocialPK=" + ObraSocial_PK +
                ", NombreObraSocial='" + NombreObraSocial + '\'' +
                '}';
    }

    public Long getObraSocial_PK() {
        return ObraSocial_PK;
    }

    public void setObraSocial_PK(Long obraSocial_PK) {
        ObraSocial_PK = obraSocial_PK;
    }

    public String getNombreObraSocial() {
        return NombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        NombreObraSocial = nombreObraSocial;
    }
}
