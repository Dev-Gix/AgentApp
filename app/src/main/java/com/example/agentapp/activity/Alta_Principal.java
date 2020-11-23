package com.example.agentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agentapp.R;

public class Alta_Principal extends AppCompatActivity implements View.OnClickListener {

    Button btn_Alta_Sector;
    Button btn_Alta_Barrio;
    Button btn_Alta_ObraSocial;
    Button btn_Alta_Patologia;
    Button btn_Alta_Medicamentos;
    Button btn_Alta_Vacunas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_principal);

        btn_Alta_Sector = findViewById(R.id.btn_Alta_Sector);
        btn_Alta_Barrio = findViewById(R.id.btn_Alta_Barrio);
        btn_Alta_ObraSocial = findViewById(R.id.btn_Alta_ObraSocial);
        btn_Alta_Patologia = findViewById(R.id.btn_Alta_Patologia);
        btn_Alta_Medicamentos = findViewById(R.id.btn_Alta_Medicamentos);
        btn_Alta_Vacunas = findViewById(R.id.btn_Alta_Vacunas);

        btn_Alta_Sector.setOnClickListener(this);
        btn_Alta_Barrio.setOnClickListener(this);
        btn_Alta_ObraSocial.setOnClickListener(this);
        btn_Alta_Patologia.setOnClickListener(this);
        btn_Alta_Medicamentos.setOnClickListener(this);
        btn_Alta_Vacunas.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Alta_Sector:
                Intent Alta_sector = new Intent(this, Alta_Sector.class);
                startActivity(Alta_sector);
                break;
            case R.id.btn_Alta_Barrio:
                Intent Alta_Barrio = new Intent(this, Alta_Barrio.class);
                startActivity(Alta_Barrio);
                break;
            case R.id.btn_Alta_ObraSocial:
                Intent Alta_ObraSocial = new Intent(this, Alta_ObraSocial.class);
                startActivity(Alta_ObraSocial);
                break;
            case R.id.btn_Alta_Patologia:
                break;
            case R.id.btn_Alta_Medicamentos:
                break;
            case R.id.btn_Alta_Vacunas:
                break;
        }
    }
}