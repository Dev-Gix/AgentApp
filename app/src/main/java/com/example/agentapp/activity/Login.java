package com.example.agentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agentapp.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText EditText_Usuario;
    EditText EditText_Password;
    Button Btn_IniciarSeccion;
    Button Btn_Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText_Usuario = findViewById(R.id.EditText_Usuario);
        EditText_Password = findViewById(R.id.EditText_Password);
        Btn_IniciarSeccion = findViewById(R.id.Btn_IniciarSeccion);
        Btn_Registrarse = findViewById(R.id.Btn_Registrarse);

        Btn_IniciarSeccion.setOnClickListener(this);
        Btn_Registrarse.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == Btn_IniciarSeccion.getId()) {
            Intent Principal = new Intent(this, Principal_ADM.class);
            startActivity(Principal);

        }

        if (view.getId() == Btn_Registrarse.getId()) {
            Intent Registrar = new Intent(this, Registrarse.class);
            startActivity(Registrar);
            finish();


        }
    }
}