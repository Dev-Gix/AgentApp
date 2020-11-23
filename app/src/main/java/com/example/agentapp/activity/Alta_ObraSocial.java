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
import com.example.agentapp.entidades.obrasocial.ObraSocial;
import com.example.agentapp.entidades.obrasocial.ObraSocialDao;
import com.example.agentapp.entornodedatos.EntornoDeDatos;

public class Alta_ObraSocial extends AppCompatActivity implements View.OnClickListener {

    EditText editText_Alta_ObraSocial;
    Button btn_Cargar_ObraSocial;
    Button btn_Cancelar;
    ObraSocialDao MyObraSocialDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_obrasocial);

        editText_Alta_ObraSocial = findViewById(R.id.editText_Alta_ObraSocial);
        btn_Cargar_ObraSocial= findViewById(R.id.btn_Cargar_ObraSocial);
        btn_Cancelar = findViewById(R.id.btn_Cancelar_Persona);

        btn_Cargar_ObraSocial.setOnClickListener(this);
        btn_Cancelar.setOnClickListener(this);
        MyObraSocialDao = new  ObraSocialDao(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Cargar_ObraSocial:
                ObraSocial MyObraSocial = new ObraSocial();
                MyObraSocial.setNombreObraSocial(editText_Alta_ObraSocial.getText().toString());

                if (!ExisteLaObraSocial()) {

                    try {
                        MyObraSocialDao.AddRecord(MyObraSocial);
                        MyObraSocialDao.CloseConnection();
                        editText_Alta_ObraSocial.setText("");
                        Toast.makeText(this, "OBRA SOCIAL CARGADA CON EXITO!!", Toast.LENGTH_SHORT).show();

                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(this, "ERROR:" + e, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "ERROR: OBRA SOCIAL YA EXISTENTE!!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_Cancelar_Persona:
                Intent Alta_Principal = new Intent(this, Alta_Principal.class);
                startActivity(Alta_Principal);
                finish();
                break;
        }
    }
    private boolean ExisteLaObraSocial() {
        EntornoDeDatos.listObraSocial = MyObraSocialDao.getAll("Select * From ObraSocial");

        for (int i = 0; i < EntornoDeDatos.listObraSocial.size(); i++) {
            if (editText_Alta_ObraSocial.getText().toString().equals(EntornoDeDatos.listObraSocial.get(i).getNombreObraSocial())) {

                return true;
            }

        }
        return false;
    }
}