package com.example.agentapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.agentapp.R;
import com.example.agentapp.entidades.persona.Persona;

public class Alta_Persona extends AppCompatActivity implements View.OnClickListener {

    EditText EditTextNombrePersona;
    EditText EditTextApellidoPersona;
    EditText EditTextDNIPersona;
    EditText EditTextOcupacionPersona;
    EditText EditTextFechaNacimientoPersona;
    EditText EditTextNumeroManzanaPersona;
    EditText EditTextNumeroCasaPersona;
    EditText EditTextObservacionPersona;

    Spinner Spinner_EstadoCivilPersona;
    Spinner Spinner_NacionalidadPersona;
    Spinner Spinner_BarrioPersona;

    Button btn_Cargar_Persona;
    Button btn_Cancelar_Persona;

    Persona MyPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_persona);

        EditTextNombrePersona = findViewById(R.id.EditTextNombrePersona);
        EditTextApellidoPersona = findViewById(R.id.EditTextApellidoPersona);
        EditTextDNIPersona = findViewById(R.id.EditTextApellidoPersona);
        EditTextOcupacionPersona = findViewById(R.id.EditTextOcupacionPersona);
        EditTextFechaNacimientoPersona = findViewById(R.id.EditTextFechaNacimientoPersona);
        EditTextNumeroManzanaPersona = findViewById(R.id.EditTextNumeroManzanaPersona);
        EditTextNumeroCasaPersona = findViewById(R.id.EditTextNumeroCasaPersona);
        EditTextObservacionPersona = findViewById(R.id.EditTextObservacionPersona);

        Spinner_EstadoCivilPersona = findViewById(R.id.Spinner_EstadoCivilPersona);
        Spinner_NacionalidadPersona = findViewById(R.id.Spinner_NacionalidadPersona);
        Spinner_BarrioPersona = findViewById(R.id.Spinner_BarrioPersona);

        btn_Cargar_Persona = findViewById(R.id.btn_Cargar_Persona);
        btn_Cancelar_Persona = findViewById(R.id.btn_Cancelar_Persona);

        btn_Cargar_Persona.setOnClickListener(this);
        btn_Cancelar_Persona.setOnClickListener(this);

        MyPersona = new Persona();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Cargar_Persona:

                MyPersona.setNombrePersona(EditTextNombrePersona.getText().toString());
                MyPersona.setApellidoPersona(EditTextApellidoPersona.getText().toString());
                MyPersona.setFNACPersona(EditTextFechaNacimientoPersona.getText().toString());
                MyPersona.setDNI(EditTextDNIPersona.getText().toString());
                MyPersona.setObservacion(EditTextObservacionPersona.getText().toString());
                MyPersona.setEstadoCivil(Spinner_EstadoCivilPersona.getSelectedItem().toString());
                MyPersona.setNacionalidad(Spinner_NacionalidadPersona.getSelectedItem().toString());
                MyPersona.setOcupacion(EditTextOcupacionPersona.getText().toString());

               // MyPersona.setHistoriaClinica_ClaveFR();
               // MyPersona.setEmpadronador_ClaveFR(RecibirDatos());
                //MyPersona.setBarrio_ClaveFR();



                break;
            case R.id.btn_Cancelar_Persona:
                break;
        }
    }
    public Long RecibirDatos(){ //Recibe datos de otra activity
        Bundle Extra = getIntent().getExtras();
        Long PK = Extra.getLong("pkEmpadronador");
        return PK;

    }
}