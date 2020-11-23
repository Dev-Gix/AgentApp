package com.example.agentapp.entidades.historiaclinica;

public class HistoriaClinica {
    Long HistoriaClinicaPk;
    String NumeroDeHistoriaClinica;
    Long ObraSocial_ClaveFR;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long historiaClinicaPk, String numeroDeHistoriaClinica, Long obraSocial_ClaveFR) {
        HistoriaClinicaPk = historiaClinicaPk;
        NumeroDeHistoriaClinica = numeroDeHistoriaClinica;
        ObraSocial_ClaveFR = obraSocial_ClaveFR;
    }

    public boolean isnull() {
        if (NumeroDeHistoriaClinica.equals("")) {
            return true;
        }
        return false;
    }

    public Long getHistoriaClinicaPk() {
        return HistoriaClinicaPk;
    }

    public void setHistoriaClinicaPk(Long historiaClinicaPk) {
        HistoriaClinicaPk = historiaClinicaPk;
    }

    public String getNumeroDeHistoriaClinica() {
        return NumeroDeHistoriaClinica;
    }

    public void setNumeroDeHistoriaClinica(String numeroDeHistoriaClinica) {
        NumeroDeHistoriaClinica = numeroDeHistoriaClinica;
    }

    public Long getObraSocial_ClaveFR() {
        return ObraSocial_ClaveFR;
    }

    public void setObraSocial_ClaveFR(Long obraSocial_ClaveFR) {
        ObraSocial_ClaveFR = obraSocial_ClaveFR;
    }
}
