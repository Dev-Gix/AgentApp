package com.example.agentapp.entidades.manzana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;
import com.example.agentapp.entidades.barrio.Barrio;

import java.util.ArrayList;
import java.util.List;

public class ManzanaDao extends DaoGenerico implements MetodosComunes<Manzana,Long,Manzana> {

    public ManzanaDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Manzana AddRecord(Manzana ObjetoParaAgregar) {
        Manzana ObjAuxiliar = new Manzana();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NumeroManzana", ObjetoParaAgregar.getNumeroManzana());
        MyContentValues.put("Barrio_ClaveFR", ObjetoParaAgregar.getBarrio_ClaveFR());

        Long PK = getConnection().insertOrThrow("Manzana", null, MyContentValues);


        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setManzanaPK(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(Manzana ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Manzana ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Manzana LoadRecord(Long PK) {
        return null;
    }

    @Override
    public Manzana LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Manzana> getAll(String ComandoSql) {
        Manzana Auxiliar = new Manzana();
        List<Manzana> List = new ArrayList<Manzana>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {

            int NumeroManzana = myCursor.getInt(1);
            Long Barrio_ClaveFR = myCursor.getLong(2);

            Auxiliar.setNumeroManzana(NumeroManzana);
            Auxiliar.setBarrio_ClaveFR(Barrio_ClaveFR);


            List.add(Auxiliar);
        }
        return List;
    }

    @Override
    public List<Manzana> getJoinAll(String ComandoSql) {
        return null;
    }
}
