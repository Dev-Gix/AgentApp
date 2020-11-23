package com.example.agentapp.entidades.historiaclinica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;
import com.example.agentapp.entidades.obrasocial.ObraSocial;

import java.util.ArrayList;
import java.util.List;

public class HistoriaClinicaDao extends DaoGenerico implements MetodosComunes<HistoriaClinica,Long,HistoriaClinica> {

    public HistoriaClinicaDao(Context myContext) {
        super(myContext);
    }

    @Override
    public HistoriaClinica AddRecord(HistoriaClinica ObjetoParaAgregar) {
        HistoriaClinica ObjAuxiliar = new HistoriaClinica();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NumeroDeHistoriaClinica", ObjetoParaAgregar.NumeroDeHistoriaClinica);
        MyContentValues.put("ObraSocial_ClaveFR", ObjetoParaAgregar.ObraSocial_ClaveFR);


        Long PK = getConnection().insertOrThrow("HistoriaClinica", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setHistoriaClinicaPk(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(HistoriaClinica ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(HistoriaClinica ObjetoParaEliminar) {
        return false;
    }

    @Override
    public HistoriaClinica LoadRecord(Long PK) {
        return null;
    }

    @Override
    public HistoriaClinica LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<HistoriaClinica> getAll(String ComandoSql) {
        HistoriaClinica Auxiliar = new HistoriaClinica();
        List<HistoriaClinica> List = new ArrayList<HistoriaClinica>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {

            String NumeroDeHistoriaClinica = myCursor.getString(1);
            Long ObraSocial_ClaveFR = myCursor.getLong(2);


            Auxiliar.setNumeroDeHistoriaClinica(NumeroDeHistoriaClinica);
            Auxiliar.setObraSocial_ClaveFR(ObraSocial_ClaveFR);


            List.add(Auxiliar);
        }
        return List;
    }

    @Override
    public List<HistoriaClinica> getJoinAll(String ComandoSql) {
        return null;
    }
}
