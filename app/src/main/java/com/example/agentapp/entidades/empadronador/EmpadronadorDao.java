package com.example.agentapp.entidades.empadronador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agentapp.daogenerico.DaoGenerico;
import com.example.agentapp.daogenerico.MetodosComunes;

import java.util.ArrayList;
import java.util.List;


public class EmpadronadorDao extends DaoGenerico implements MetodosComunes<Empadronador, Long, Empadronador> {


    public EmpadronadorDao(Context myContext) {
        super(myContext);

    }

    @Override
    public Empadronador AddRecord(Empadronador ObjetoParaAgregar) {
        Empadronador ObjAuxiliar = new Empadronador();
        ContentValues MyContentValues = new ContentValues();

        MyContentValues.put("Nombre", ObjetoParaAgregar.getEmpadronador_Nombre());
        MyContentValues.put("Apellido", ObjetoParaAgregar.getEmpadronador_Apellido());
        MyContentValues.put("DNI", ObjetoParaAgregar.getEmpadronador_DNI());
        MyContentValues.put("Usuario", ObjetoParaAgregar.getEmpadronador_Usuario());
        MyContentValues.put("Clave", ObjetoParaAgregar.getEmpadronador_Clave());
        MyContentValues.put("SectorClaveFR", ObjetoParaAgregar.getSectorClaveFR());

        Long PK = getConnection().insertOrThrow("Empadronador", null, MyContentValues);

        if (PK > 0) {
            ObjAuxiliar = ObjetoParaAgregar;
            ObjAuxiliar.setEmpadronador_Pk(PK);
            return (ObjAuxiliar);
        }

        return (ObjAuxiliar);
    }


    @Override
    public boolean UpdateRecord(Empadronador ObjetoParaActualizar) {
        return false;
    }

    @Override
    public boolean DeleteRecord(Empadronador ObjetoParaEliminar) {
        return false;
    }

    @Override
    public Empadronador LoadRecord(Long PK) {
        Empadronador EmpadronadorAux = new Empadronador();
        Cursor MyCursor = null;
        MyCursor = getConnection().rawQuery("Select * from Empadronador where idEmpadronadorPk =" + PK, null);

        while (MyCursor.moveToNext()) {
            String Nombre = MyCursor.getString(1);
            String Apellido = MyCursor.getString(2);
            String DNI = MyCursor.getString(3);
            String Usuario = MyCursor.getString(4);
            String Clave = MyCursor.getString(5);
            Long SectorClaveFR = MyCursor.getLong(6);


            EmpadronadorAux.setEmpadronador_Nombre(Nombre);
            EmpadronadorAux.setEmpadronador_Apellido(Apellido);
            EmpadronadorAux.setEmpadronador_DNI(DNI);
            EmpadronadorAux.setEmpadronador_Usuario(Usuario);
            EmpadronadorAux.setEmpadronador_Clave(Clave);
            EmpadronadorAux.setSectorClaveFR(SectorClaveFR);
            return (EmpadronadorAux);
        }
        return (EmpadronadorAux);
    }

    @Override
    public Empadronador LoadRecord(String ComandoSQL) {
        return null;
    }

    @Override
    public List<Empadronador> getAll(String ComandoSql) {
        List<Empadronador> List = new ArrayList<Empadronador>();
        Cursor myCursor = null;
        myCursor = getConnection().rawQuery(ComandoSql, null);

        while (myCursor.moveToNext()) {
            Long Empadronador_Pk = myCursor.getLong(0);
            String Empadronador_Nombre = myCursor.getString(1);
            String Empadronador_Apellido = myCursor.getString(2);
            String Empadronador_DNI = myCursor.getString(3);
            String Empadronador_Usuario = myCursor.getString(4);
            String Empadronador_Clave = myCursor.getString(5);
            Long SectorClaveFR = myCursor.getLong(6);


            Empadronador Auxiliar = new Empadronador(Empadronador_Pk, Empadronador_Nombre, Empadronador_Apellido, Empadronador_DNI, Empadronador_Usuario, Empadronador_Clave, SectorClaveFR);

            List.add(Auxiliar);
        }
        return List;

    }

    @Override
    public List<Empadronador> getJoinAll(String ComandoSql) {
        return null;
    }
}
