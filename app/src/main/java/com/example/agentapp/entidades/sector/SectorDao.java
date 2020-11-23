package com.example.agentapp.entidades.sector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;

import java.util.ArrayList;
import java.util.List;

public class SectorDao extends DaoGenerico implements MetodosComunes<Sector, Long, Sector> {

    public SectorDao(Context myContext) {
        super(myContext);
    }

    @Override
    public Sector AddRecord(Sector ObjetoParaAgregar) {
        Sector ObjAuxiliar = new Sector();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("NombreSector", ObjetoParaAgregar.getNombreSector());

        Long PK = getConnection().insertOrThrow("Sector", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setSectorPk(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(Sector ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Sector ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Sector LoadRecord(Long PK) {
        Sector SectorAux = new Sector();
        Cursor MyCursor = null;
        MyCursor = getConnection().rawQuery("Select * from Sector where SectorPk =" + PK, null);

        while (MyCursor.moveToNext()) {
            String NombreSector = MyCursor.getString(1);

            SectorAux.setNombreSector(NombreSector);

            return (SectorAux);
        }
        return (SectorAux);
    }


    @Override
    public Sector LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Sector> getAll(String ComandoSql) {
        List<Sector> List = new ArrayList<Sector>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {
            Long SectorPk = myCursor.getLong(0);
            String NombreSector = myCursor.getString(1);

            Sector Auxiliar = new Sector(SectorPk, NombreSector);

            List.add(Auxiliar);
        }
        return List;
    }

    @Override
    public List<Sector> getJoinAll(String ComandoSql) {
        return null;
    }
}
