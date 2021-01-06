package com.example.agentapp.daogenerico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DriverDB extends SQLiteOpenHelper {

    public static String DB_Name = "BaseDeDatos.sqLite";
    public static int DB_VERSION = 1;
    Context MyContext;

    public DriverDB(Context context) {
        super(context, DB_Name, null, DB_VERSION);
        MyContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Empadronador(idEmpadronadorPk integer primary key autoincrement,Nombre text not null,Apellido text not null,DNI text not null,Usuario text not null,Clave text not null,SectorClaveFR integer )");
        sqLiteDatabase.execSQL("create table Sector(SectorPk integer primary key autoincrement,NombreSector text not null)");
        sqLiteDatabase.execSQL("create table Manzana(ManzanaPK integer primary key autoincrement,NumeroManzana integer not null,Barrio_ClaveFR integer)"); //Prueba
        sqLiteDatabase.execSQL("create table Barrio(BarrioPK integer primary key autoincrement,NombreBarrio text not null)");
        sqLiteDatabase.execSQL("create table ObraSocial(ObraSocial_PK integer primary key autoincrement,NombreObraSocial text not null)");
        sqLiteDatabase.execSQL("create table HistoriaClinica(HistoriaClinicaPk integer primary key autoincrement,NumeroDeHistoriaClinica text not null,ObraSocial_ClaveFR integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
