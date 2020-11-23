package com.example.agentapp.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.agentapp.R;
import com.example.agentapp.entornodedatos.EntornoDeDatos;

import com.example.agentapp.entidades.sector.Sector;
import com.example.agentapp.entidades.sector.SectorDao;


public class Alta_Sector extends AppCompatActivity implements View.OnClickListener {

    EditText editText_Alta_Sector;
    Button btn_Cargar_Sector;
    Button btn_Cancelar;
    SectorDao MySectorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_sector);

        editText_Alta_Sector = findViewById(R.id.editText_Alta_Sector);
        btn_Cargar_Sector = findViewById(R.id.btn_Cargar_Sector);
        btn_Cancelar = findViewById(R.id.btn_Cancelar_Persona);

        btn_Cargar_Sector.setOnClickListener(this);
        btn_Cancelar.setOnClickListener(this);

        MySectorDao = new SectorDao(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cargar_Sector:

                Sector MySector = new Sector();
                MySector.setNombreSector(editText_Alta_Sector.getText().toString());

                if (MySector.isnull()) {
                    Toast.makeText(this, "ERROR:CAMPOS VACIOS", Toast.LENGTH_LONG).show();

                } else {
                    if (!ExisteElSector()) {
                        try {
                            MySectorDao.AddRecord(MySector);
                            Toast.makeText(this, "REGISTRADO CON EXITO!!", Toast.LENGTH_LONG).show();
                            MySectorDao.CloseConnection();

                        } catch (SQLiteConstraintException ex) {
                            Toast.makeText(this, "ERROR: " + ex, Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "ERROR: SECTOR YA EXISTENTE", Toast.LENGTH_LONG).show();
                    }
                    editText_Alta_Sector.setText("");
                }

                break;
            case R.id.btn_Cancelar_Persona:
                Intent Alta_Principal = new Intent(this, Alta_Principal.class);
                startActivity(Alta_Principal);
                finish();
                break;

        }
    }

    private boolean ExisteElSector() {
        EntornoDeDatos.listSector = MySectorDao.getAll("Select * From Sector");
        for (int i = 0; i < EntornoDeDatos.listSector.size(); i++) {
            if (editText_Alta_Sector.getText().toString().equals(EntornoDeDatos.listSector.get(i).getNombreSector())) {


                return true;
            }

        }
        return false;
    }
}