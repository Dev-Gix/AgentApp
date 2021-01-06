package com.example.agentapp.entidades.persona;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;
import com.example.agentapp.entidades.empadronador.Empadronador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDao extends DaoGenerico implements MetodosComunes<Persona,Long,Persona> {
    public PersonaDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Persona AddRecord(Persona ObjetoParaAgregar) {
        Persona ObjAuxiliar = new Persona();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NombrePersona", ObjetoParaAgregar.getNombrePersona());
        MyContentValues.put("ApellidoPersona", ObjetoParaAgregar.getApellidoPersona());
        MyContentValues.put("FNACPersona", ObjetoParaAgregar.getFNACPersona());
        MyContentValues.put("DNI", ObjetoParaAgregar.getDNI());
        MyContentValues.put("Observacion", ObjetoParaAgregar.getObservacion());
        MyContentValues.put("EstadoCivil", ObjetoParaAgregar.getEstadoCivil());
        MyContentValues.put("Nacionalidad", ObjetoParaAgregar.getNacionalidad());
        MyContentValues.put("Ocupacion", ObjetoParaAgregar.getOcupacion());
        MyContentValues.put("HistoriaClinica_ClaveFR", ObjetoParaAgregar.getHistoriaClinica_ClaveFR());
        MyContentValues.put("Empadronador_ClaveFR", ObjetoParaAgregar.getEmpadronador_ClaveFR());
        MyContentValues.put("Casa_ClaveFR", ObjetoParaAgregar.getCasa_ClaveFR());

        Long PK = getConnection().insertOrThrow("Persona", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setPersonaPK(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(Persona ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Persona ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Persona LoadRecord(Long PK) {
        return null;
    }

    @Override
    public Persona LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Persona> getAll(String ComandoSql) {
        List<Persona> List = new ArrayList<Persona>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {
            Long PersonaPK = myCursor.getLong(0);
            String NombrePersona = myCursor.getString(1);
            String ApellidoPersona = myCursor.getString(2);
            String FNACPersona = myCursor.getString(3);
            String DNI = myCursor.getString(4);
            String Observacion = myCursor.getString(5);
            String EstadoCivil = myCursor.getString(6);
            String Nacionalidad = myCursor.getString(7);
            String Ocupacion = myCursor.getString(8);
            Long HistoriaClinica_ClaveFR = myCursor.getLong(9);
            Long Empadronador_ClaveFR = myCursor.getLong(10);
            Long Casa_ClaveFR = myCursor.getLong(11);


            Persona Auxiliar = new Persona(PersonaPK, NombrePersona, ApellidoPersona, FNACPersona, DNI, Observacion, EstadoCivil,Nacionalidad,Ocupacion,HistoriaClinica_ClaveFR,Empadronador_ClaveFR,Casa_ClaveFR);

            List.add(Auxiliar);
        }
        return List;
    }

    @Override
    public List<Persona> getJoinAll(String ComandoSql) {
        return null;
    }
}
