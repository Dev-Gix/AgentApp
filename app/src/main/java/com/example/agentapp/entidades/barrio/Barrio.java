package com.example.agentapp.entidades.barrio;

public class Barrio {
    Long BarrioPK;
    String NombreBarrio;


    public Barrio() {
    }

    public Barrio(Long barrioPK, String nombreBarrio, Long sectorClaveFR) {
        BarrioPK = barrioPK;
        NombreBarrio = nombreBarrio;

    }

    public boolean isnull() {
        if (NombreBarrio.equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Barrio{" +
                "BarrioPK=" + BarrioPK +
                ", NombreBarrio='" + NombreBarrio +
                '}';
    }

    public Long getBarrioPK() {
        return BarrioPK;
    }

    public void setBarrioPK(Long barrioPK) {
        BarrioPK = barrioPK;
    }

    public String getNombreBarrio() {
        return NombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        NombreBarrio = nombreBarrio;
    }

}
