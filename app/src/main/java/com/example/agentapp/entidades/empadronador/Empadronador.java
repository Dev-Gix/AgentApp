package com.example.agentapp.entidades.empadronador;

public class Empadronador {
    private Long Empadronador_Pk;
    private String Empadronador_Nombre, Empadronador_Apellido, Empadronador_DNI, Empadronador_Usuario, Empadronador_Clave;
    private Long SectorClaveFR;

    public Empadronador() {
        Empadronador_Pk = 0L;
        Empadronador_Nombre = "";
        Empadronador_Apellido = "";
        Empadronador_DNI = "";
        Empadronador_Usuario = "";
        Empadronador_Clave = "";
        SectorClaveFR = 0L;
    }

    public Empadronador(Long empadronador_Pk, String empadronador_Nombre, String empadronador_Apellido, String empadronador_DNI, String empadronador_Usuario, String empadronador_Clave, Long sectorClaveFR) {
        Empadronador_Pk = empadronador_Pk;
        Empadronador_Nombre = empadronador_Nombre;
        Empadronador_Apellido = empadronador_Apellido;
        Empadronador_DNI = empadronador_DNI;
        Empadronador_Usuario = empadronador_Usuario;
        Empadronador_Clave = empadronador_Clave;
        SectorClaveFR = sectorClaveFR;
    }

    public boolean isnull() {
        if (Empadronador_Nombre.equals("") || Empadronador_Apellido.equals("") || Empadronador_DNI.equals("") || Empadronador_Usuario.equals("") || Empadronador_Clave.equals("")) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Empadronador{" +
                "Empadronador_Pk=" + Empadronador_Pk +
                ", Empadronador_Nombre='" + Empadronador_Nombre + '\'' +
                ", Empadronador_Apellido='" + Empadronador_Apellido + '\'' +
                ", Empadronador_DNI='" + Empadronador_DNI + '\'' +
                ", Empadronador_Usuario='" + Empadronador_Usuario + '\'' +
                ", Empadronador_Clave='" + Empadronador_Clave + '\'' +
                ", SectorClaveFR=" + SectorClaveFR +
                '}';
    }

    public Long getSectorClaveFR() {
        return SectorClaveFR;
    }

    public void setSectorClaveFR(Long sectorClaveFR) {
        SectorClaveFR = sectorClaveFR;
    }

    public Long getEmpadronador_Pk() {
        return Empadronador_Pk;
    }

    public void setEmpadronador_Pk(Long empadronador_Pk) {
        Empadronador_Pk = empadronador_Pk;
    }

    public String getEmpadronador_Nombre() {
        return Empadronador_Nombre;
    }

    public void setEmpadronador_Nombre(String empadronador_Nombre) {
        Empadronador_Nombre = empadronador_Nombre;
    }

    public String getEmpadronador_Apellido() {
        return Empadronador_Apellido;
    }

    public void setEmpadronador_Apellido(String empadronador_Apellido) {
        Empadronador_Apellido = empadronador_Apellido;
    }

    public String getEmpadronador_DNI() {
        return Empadronador_DNI;
    }

    public void setEmpadronador_DNI(String empadronador_DNI) {
        Empadronador_DNI = empadronador_DNI;
    }

    public String getEmpadronador_Usuario() {
        return Empadronador_Usuario;
    }

    public void setEmpadronador_Usuario(String empadronador_Usuario) {
        Empadronador_Usuario = empadronador_Usuario;
    }

    public String getEmpadronador_Clave() {
        return Empadronador_Clave;
    }

    public void setEmpadronador_Clave(String empadronador_Clave) {
        Empadronador_Clave = empadronador_Clave;
    }
}
