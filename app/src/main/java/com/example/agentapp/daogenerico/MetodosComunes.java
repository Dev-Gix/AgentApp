package com.example.agentapp.daogenerico;

import java.util.List;

public interface MetodosComunes<Clase, ClavePrimaria, ClaseExtendida> {

    public Clase AddRecord(Clase ObjetoParaAgregar);

    public boolean UpdateRecord(Clase ObjetoParaActualizar);

    public boolean DeleteRecord(Clase ObjetoParaEliminar);

    public Clase LoadRecord(Long PK);

    public Clase LoadRecord(String ComandoSQL);

    public List<Clase> getAll(String ComandoSql);

    public List<ClaseExtendida> getJoinAll(String ComandoSql);
}
