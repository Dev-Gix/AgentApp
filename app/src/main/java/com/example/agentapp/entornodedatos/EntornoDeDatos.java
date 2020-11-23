package com.example.agentapp.entornodedatos;



import java.util.ArrayList;
import java.util.List;

import com.example.agentapp.entidades.barrio.Barrio;
import com.example.agentapp.entidades.empadronador.Empadronador;
import com.example.agentapp.entidades.obrasocial.ObraSocial;
import com.example.agentapp.entidades.sector.Sector;

public class EntornoDeDatos {

    public static List<Empadronador> listEmpadronador = new ArrayList<Empadronador>();
    public static List<Sector> listSector = new ArrayList<Sector>();
    public static List<Barrio> listBarrio = new ArrayList<Barrio>();
    public static List<ObraSocial> listObraSocial = new ArrayList<ObraSocial>();
    public static List<String> listSpinnerSector = new ArrayList<String>();
}
