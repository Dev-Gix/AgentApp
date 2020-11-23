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

import com.example.agentapp.entidades.barrio.Barrio;
import com.example.agentapp.entidades.barrio.BarrioDao;
import com.example.agentapp.entidades.sector.SectorDao;

public class Alta_Barrio extends AppCompatActivity implements View.OnClickListener {

    EditText editText_Alta_Barrio;
    Button btn_Cargar_Barrio;
    Button btn_Cancelar;
    SectorDao MySectorDao;
    BarrioDao MyBarrioDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_barrio);

        editText_Alta_Barrio = findViewById(R.id.editText_Alta_Barrio);
        btn_Cargar_Barrio = findViewById(R.id.btn_Cargar_Barrio);
        btn_Cancelar = findViewById(R.id.btn_Cancelar);

        btn_Cargar_Barrio.setOnClickListener(this);
        btn_Cancelar.setOnClickListener(this);
        MyBarrioDao = new BarrioDao(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cargar_Barrio:

                Barrio MyBarrio = new Barrio();
                MyBarrio.setNombreBarrio(editText_Alta_Barrio.getText().toString());

                if (!ExisteElBarrio()) {

                    try {
                        MyBarrioDao.AddRecord(MyBarrio);
                        MyBarrioDao.CloseConnection();
                        editText_Alta_Barrio.setText("");
                        Toast.makeText(this, "BARRIO CARGADO CON EXITO!!", Toast.LENGTH_SHORT).show();

                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(this, "ERROR:" + e, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "ERROR: BARRIO YA EXISTENTE!!", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btn_Cancelar:
                Intent Alta_Principal = new Intent(this, Alta_Principal.class);
                startActivity(Alta_Principal);
                finish();
                break;

        }
    }


    private boolean ExisteElBarrio() {
        EntornoDeDatos.listBarrio = MyBarrioDao.getAll("Select * From Barrio");

        for (int i = 0; i < EntornoDeDatos.listBarrio.size(); i++) {
            if (editText_Alta_Barrio.getText().toString().equals(EntornoDeDatos.listBarrio.get(i).getNombreBarrio())) {

                return true;
            }

        }
        return false;
    }

}

