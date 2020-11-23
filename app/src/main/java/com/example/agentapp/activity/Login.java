package com.example.agentapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agentapp.R;
import com.example.agentapp.entidades.empadronador.Empadronador;
import com.example.agentapp.entidades.empadronador.EmpadronadorDao;
import com.example.agentapp.entornodedatos.EntornoDeDatos;

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

            if(Usuario() != -1){
                    Intent ir_Principal_Empadronador = new Intent(this,Principal_Empadronador.class);
                    ir_Principal_Empadronador.putExtra("pkEmpadronador",Usuario());
                    startActivity(ir_Principal_Empadronador);
            }else{
               if(EditText_Usuario.getText().toString().equals("Admin") && EditText_Password.getText().toString().equals("Admin")) {
                   Intent Principal = new Intent(this, Principal_ADM.class);
                   startActivity(Principal);
               }else{
                   Toast.makeText(this, "ERROR:USUARIO NO VALIDO", Toast.LENGTH_SHORT).show();
               }
            }

        }

        if (view.getId() == Btn_Registrarse.getId()) {
            Intent Registrar = new Intent(this, Registrarse.class);
            startActivity(Registrar);
            finish();


        }
    }

    public long Usuario() { //Extrae los datos del Empadronador de la BD.
        EmpadronadorDao MyEmpadronadorDao = new EmpadronadorDao(this);
        EntornoDeDatos.listEmpadronador =  MyEmpadronadorDao.getAll("Select * From Empadronador");

        String usuario = EditText_Usuario.getText().toString();
        String password = EditText_Password.getText().toString();
        for (int i = 0; i < EntornoDeDatos.listEmpadronador.size(); i++) {

            if (EntornoDeDatos.listEmpadronador.get(i).getEmpadronador_Usuario().equals(usuario) && EntornoDeDatos.listEmpadronador.get(i).getEmpadronador_Clave().equals(password) ) {

                    return EntornoDeDatos.listEmpadronador.get(i).getEmpadronador_Pk();
            }
        }

        return -1;

    }
}