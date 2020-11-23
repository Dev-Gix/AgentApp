package com.example.agentapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.agentapp.R;
import com.example.agentapp.entidades.empadronador.Empadronador;
import com.example.agentapp.entidades.empadronador.EmpadronadorDao;

public class Principal_Empadronador extends AppCompatActivity implements View.OnClickListener {

    TextView TextView_SesionActiva;
    Button btn_RegistroPersona;
    Button btn_ConsultaPersona;
    Button btn_CerrarSesion;

    Empadronador MyEmpadronador;
    EmpadronadorDao MyEmpadronadorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_empadronador);

        TextView_SesionActiva = findViewById(R.id.TextView_SesionActiva);
        btn_RegistroPersona = findViewById(R.id.btn_RegistroPersona);
        btn_ConsultaPersona = findViewById(R.id.btn_ConsultaPersona);
        btn_CerrarSesion = findViewById(R.id.btn_CerrarSesion);

        btn_RegistroPersona.setOnClickListener(this);
        btn_ConsultaPersona.setOnClickListener(this);
        btn_CerrarSesion.setOnClickListener(this);

        MyEmpadronador = new Empadronador();
        MyEmpadronadorDao = new EmpadronadorDao(this);

        MyEmpadronador = MyEmpadronadorDao.LoadRecord(RecibirDatos());
        TextView_SesionActiva.setText("Empadronador: "+MyEmpadronador.getEmpadronador_Nombre() + "-"+ MyEmpadronador.getEmpadronador_Apellido()+" "+MyEmpadronador.getEmpadronador_DNI());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_RegistroPersona:
                Intent irRegistrarPersona = new Intent(this,Alta_Persona.class);
                irRegistrarPersona.putExtra("pkEmpadronador",MyEmpadronador.getEmpadronador_Pk());
                startActivity(irRegistrarPersona);
                break;

            case R.id.btn_ConsultaPersona:
                break;
            case R.id.btn_CerrarSesion:
                break;
        }

    }
    public Long RecibirDatos(){ //Recibe datos de otra activity
        Bundle Extra = getIntent().getExtras();
        Long PK = Extra.getLong("pkEmpadronador");
        return PK;

    }
}