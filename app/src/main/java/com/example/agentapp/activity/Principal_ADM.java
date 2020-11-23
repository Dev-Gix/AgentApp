package com.example.agentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agentapp.R;

public class Principal_ADM extends AppCompatActivity implements View.OnClickListener {

    Button btn_Alta;
    Button btn_Consultar;
    Button btn_Eliminar;
    Button btn_Modificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_adm);

        btn_Alta = findViewById(R.id.btn_Alta);
        btn_Consultar = findViewById(R.id.btn_Consultar);
        btn_Eliminar = findViewById(R.id.btn_Eliminar);
        btn_Modificar = findViewById(R.id.btn_Modificar);

        btn_Alta.setOnClickListener(this);
        btn_Consultar.setOnClickListener(this);
        btn_Eliminar.setOnClickListener(this);
        btn_Modificar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Alta:
                Intent AltaPrincipal = new Intent(this, Alta_Principal.class);
                startActivity(AltaPrincipal);
                finish();
                break;
            case R.id.btn_Consultar:
                break;
            case R.id.btn_Eliminar:
                break;
            case R.id.btn_Modificar:
                break;
        }
    }
}