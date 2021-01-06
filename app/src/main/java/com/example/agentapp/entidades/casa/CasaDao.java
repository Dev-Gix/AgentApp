package com.example.agentapp.entidades.casa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;
import com.example.agentapp.entidades.barrio.Barrio;

import java.util.ArrayList;
import java.util.List;

public class CasaDao extends DaoGenerico implements MetodosComunes<Casa,Long,Casa> {
    public CasaDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Casa AddRecord(Casa ObjetoParaAgregar) {
        Casa ObjAuxiliar = new Casa();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NumeroDeCasa", ObjetoParaAgregar.getNumeroDeCasa());
        MyContentValues.put("Direccion", ObjetoParaAgregar.getDireccion());
        MyContentValues.put("Manzana_ClaveFR", ObjetoParaAgregar.getManzana_ClaveFR());


        Long PK = getConnection().insertOrThrow("Casa", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setCasaPK(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }

    @Override
    public boolean UpdateRecord(Casa ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Casa ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Casa LoadRecord(Long PK) {
        return null;
    }

    @Override
    public Casa LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Casa> getAll(String ComandoSql) {
        Casa Auxiliar = new Casa();
        List<Casa> List = new ArrayList<Casa>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {

            int NumeroDeCasa = myCursor.getInt(1);
            String Direccion = myCursor.getString(2);
            Long Manzana_ClaveFR = myCursor.getLong(3);


            Auxiliar.setNumeroDeCasa(NumeroDeCasa);
            Auxiliar.setDireccion(Direccion);
            Auxiliar.setManzana_ClaveFR(Manzana_ClaveFR);


            List.add(Auxiliar);
        }
        return List;
    }

    @Override
    public List<Casa> getJoinAll(String ComandoSql) {
        return null;
    }
}
