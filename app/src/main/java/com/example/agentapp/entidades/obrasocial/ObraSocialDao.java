package com.example.agentapp.entidades.obrasocial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;

import java.util.ArrayList;
import java.util.List;

public class ObraSocialDao extends DaoGenerico implements MetodosComunes<ObraSocial, Long, ObraSocial> {

    public ObraSocialDao(Context myContext) {
        super(myContext);
    }

    @Override
    public ObraSocial AddRecord(ObraSocial ObjetoParaAgregar) {
        ObraSocial ObjAuxiliar = new ObraSocial();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NombreObraSocial", ObjetoParaAgregar.NombreObraSocial);


        Long PK = getConnection().insertOrThrow("ObraSocial", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setObraSocialPK(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }

    @Override
    public boolean UpdateRecord(ObraSocial ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(ObraSocial ObjetoParaEliminar) {
        return false;
    }

    @Override
    public ObraSocial LoadRecord(Long PK) {
        return null;
    }

    @Override
    public ObraSocial LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<ObraSocial> getAll(String ComandoSql) {
        ObraSocial Auxiliar = new ObraSocial();
        List<ObraSocial> List = new ArrayList<ObraSocial>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {

            String NombreObraSocial = myCursor.getString(1);


            Auxiliar.setNombreObraSocial(NombreObraSocial);


            List.add(Auxiliar);
        }
        return List;

    }

    @Override
    public List<ObraSocial> getJoinAll(String ComandoSql) {
        return null;
    }
}
