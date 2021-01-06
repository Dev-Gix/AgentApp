package com.example.agentapp.entidades.persona;

public class Persona {
    Long PersonaPK;
    String NombrePersona,ApellidoPersona,FNACPersona,DNI,Observacion,EstadoCivil,Nacionalidad,Ocupacion;
    Long HistoriaClinica_ClaveFR,Empadronador_ClaveFR,Casa_ClaveFR;

    public Persona() {
    }

    public Persona(Long personaPK, String nombrePersona, String apellidoPersona, String FNACPersona, String DNI, String observacion, String estadoCivil, String nacionalidad, String ocupacion, Long historiaClinica_ClaveFR, Long empadronador_ClaveFR, Long casa_ClaveFR) {
        PersonaPK = personaPK;
        NombrePersona = nombrePersona;
        ApellidoPersona = apellidoPersona;
        this.FNACPersona = FNACPersona;
        this.DNI = DNI;
        Observacion = observacion;
        EstadoCivil = estadoCivil;
        Nacionalidad = nacionalidad;
        Ocupacion = ocupacion;
        HistoriaClinica_ClaveFR = historiaClinica_ClaveFR;
        Empadronador_ClaveFR = empadronador_ClaveFR;
        Casa_ClaveFR = casa_ClaveFR;
    }

    public boolean isnull() {
        if (NombrePersona.equals("") || ApellidoPersona.equals("") || DNI.equals("") || EstadoCivil.equals("") || Ocupacion.equals("") ||  Nacionalidad.equals("")) {
            return true;
        }
        return false;
    }


    public Long getPersonaPK() {
        return PersonaPK;
    }

    public void setPersonaPK(Long personaPK) {
        PersonaPK = personaPK;
    }

    public String getNombrePersona() {
        return NombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return ApellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        ApellidoPersona = apellidoPersona;
    }

    public String getFNACPersona() {
        return FNACPersona;
    }

    public void setFNACPersona(String FNACPersona) {
        this.FNACPersona = FNACPersona;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        Ocupacion = ocupacion;
    }

    public Long getHistoriaClinica_ClaveFR() {
        return HistoriaClinica_ClaveFR;
    }

    public void setHistoriaClinica_ClaveFR(Long historiaClinica_ClaveFR) {
        HistoriaClinica_ClaveFR = historiaClinica_ClaveFR;
    }

    public Long getEmpadronador_ClaveFR() {
        return Empadronador_ClaveFR;
    }

    public void setEmpadronador_ClaveFR(Long empadronador_ClaveFR) {
        Empadronador_ClaveFR = empadronador_ClaveFR;
    }

    public Long getCasa_ClaveFR() {
        return Casa_ClaveFR;
    }

    public void setCasa_ClaveFR(Long casa_ClaveFR) {
        Casa_ClaveFR = casa_ClaveFR;
    }
}
