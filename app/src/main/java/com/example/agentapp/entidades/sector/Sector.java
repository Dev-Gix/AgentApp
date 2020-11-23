package com.example.agentapp.entidades.sector;

public class Sector {
    Long SectorPk;
    String NombreSector;


    public Sector() {
        SectorPk = 0L;
        NombreSector = "";
    }

    public Sector(Long sectorPk, String nombreSector) {
        SectorPk = sectorPk;
        NombreSector = nombreSector;
    }

    public boolean isnull() {
        if (NombreSector.equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "SectorPk=" + SectorPk +
                ", NombreSector='" + NombreSector + '\'' +
                '}';
    }

    public Long getSectorPk() {
        return SectorPk;
    }

    public void setSectorPk(Long sectorPk) {
        SectorPk = sectorPk;
    }

    public String getNombreSector() {
        return NombreSector;
    }

    public void setNombreSector(String nombreSector) {
        NombreSector = nombreSector;
    }
}
