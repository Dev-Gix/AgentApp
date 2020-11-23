package com.example.agentapp.entidades.barrio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;

import java.util.ArrayList;
import java.util.List;

public class BarrioDao extends DaoGenerico implements MetodosComunes<Barrio, Long, Barrio> {

    public BarrioDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Barrio AddRecord(Barrio ObjetoParaAgregar) {

        Barrio ObjAuxiliar = new Barrio();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NombreBarrio", ObjetoParaAgregar.getNombreBarrio());


        Long PK = getConnection().insertOrThrow("Barrio", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setBarrioPK(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(Barrio ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Barrio ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Barrio LoadRecord(Long PK) {
        return null;
    }

    @Override
    public Barrio LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Barrio> getAll(String ComandoSql) {
        Barrio Auxiliar = new Barrio();
        List<Barrio> List = new ArrayList<Barrio>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {

            String NombreBarrio = myCursor.getString(1);


            Auxiliar.setNombreBarrio(NombreBarrio);


            List.add(Auxiliar);
        }
        return List;

    }


    @Override
    public List<Barrio> getJoinAll(String ComandoSql) {
        return null;
    }
}
