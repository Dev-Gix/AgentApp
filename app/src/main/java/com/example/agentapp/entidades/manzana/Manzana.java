package com.example.agentapp.entidades.manzana;

public class Manzana {
    Long ManzanaPK;
    int NumeroManzana;
    Long Barrio_ClaveFR;

    public Manzana() {
    }

    public Manzana(Long manzanaPK, int numeroManzana, Long barrio_ClaveFR) {
        ManzanaPK = manzanaPK;
        NumeroManzana = numeroManzana;
        Barrio_ClaveFR = barrio_ClaveFR;
    }


    public Long getManzanaPK() {
        return ManzanaPK;
    }

    public void setManzanaPK(Long manzanaPK) {
        ManzanaPK = manzanaPK;
    }

    public int getNumeroManzana() {
        return NumeroManzana;
    }

    public void setNumeroManzana(int numeroManzana) {
        NumeroManzana = numeroManzana;
    }

    public Long getBarrio_ClaveFR() {
        return Barrio_ClaveFR;
    }

    public void setBarrio_ClaveFR(Long barrio_ClaveFR) {
        Barrio_ClaveFR = barrio_ClaveFR;
    }
}
