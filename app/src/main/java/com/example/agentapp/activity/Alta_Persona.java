package com.example.agentapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.agentapp.R;
import com.example.agentapp.entidades.barrio.BarrioDao;
import com.example.agentapp.entidades.historiaclinica.HistoriaClinica;
import com.example.agentapp.entidades.obrasocial.ObraSocialDao;
import com.example.agentapp.entidades.persona.Persona;
import com.example.agentapp.entornodedatos.EntornoDeDatos;

public class Alta_Persona extends AppCompatActivity implements View.OnClickListener {

    EditText EditTextNombrePersona;
    EditText EditTextApellidoPersona;
    EditText EditTextDNIPersona;
    EditText EditTextOcupacionPersona;
    DatePicker DatePicker_FechaNacimientoPersona;
    EditText EditTextNumeroManzanaPersona;
    EditText EditTextNumeroCasaPersona;
    EditText EditTextObservacionPersona;

    Spinner Spinner_EstadoCivilPersona;
    Spinner Spinner_NacionalidadPersona;
    Spinner spinner_BarrioPersona;
    Spinner Spinner_ObraSocialPersona;

    Button btn_Cargar_Persona;
    Button btn_Cancelar_Persona;

    Persona MyPersona;
    HistoriaClinica MyHistoriaClinica;
    ObraSocialDao MyObraSocialDao;
    BarrioDao MyBarrioDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_persona);

        EditTextNombrePersona = findViewById(R.id.EditTextNombrePersona);
        EditTextApellidoPersona = findViewById(R.id.EditTextApellidoPersona);
        EditTextDNIPersona = findViewById(R.id.EditTextApellidoPersona);
        EditTextOcupacionPersona = findViewById(R.id.EditTextOcupacionPersona);
        DatePicker_FechaNacimientoPersona = findViewById(R.id.DatePicker_FechaNacimientoPersona);
        EditTextNumeroManzanaPersona = findViewById(R.id.EditTextNumeroManzanaPersona);
        EditTextNumeroCasaPersona = findViewById(R.id.EditTextNumeroCasaPersona);
        EditTextObservacionPersona = findViewById(R.id.EditTextObservacionPersona);

        Spinner_EstadoCivilPersona = findViewById(R.id.Spinner_EstadoCivilPersona);
        Spinner_NacionalidadPersona = findViewById(R.id.Spinner_NacionalidadPersona);
        spinner_BarrioPersona = findViewById(R.id.spinner_BarrioPersona);
        Spinner_ObraSocialPersona = findViewById(R.id.Spinner_ObraSocialPersona);

        btn_Cargar_Persona = findViewById(R.id.btn_Cargar_Persona);
        btn_Cancelar_Persona = findViewById(R.id.btn_Cancelar_Persona);

        btn_Cargar_Persona.setOnClickListener(this);
        btn_Cancelar_Persona.setOnClickListener(this);

        MyPersona = new Persona();
        MyHistoriaClinica = new HistoriaClinica();
        MyObraSocialDao = new ObraSocialDao(this);
        MyBarrioDao = new BarrioDao(this);




        //Spinner Estado Civil
        ArrayAdapter<CharSequence> EstadoCivilSpinner = ArrayAdapter.createFromResource(this,
                R.array.EstadoCivil, android.R.layout.simple_spinner_item);
        EstadoCivilSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_EstadoCivilPersona.setAdapter(EstadoCivilSpinner);

        //Spinner Nacionalidad
        ArrayAdapter<CharSequence> NacionalidadSpinner = ArrayAdapter.createFromResource(this,
                R.array.Nacionalidad, android.R.layout.simple_spinner_item);
        NacionalidadSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_NacionalidadPersona.setAdapter(NacionalidadSpinner);


        //Spinner Barrio

        ArrayAdapter<CharSequence> BarrioSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, EntornoDeDatos.listSpinnerBarrio);
        ObtenerListaModificadaBarrio();
        spinner_BarrioPersona.setAdapter(BarrioSpinner);

        //Spinner Obra Social
        EntornoDeDatos.listObraSocial.clear();
        EntornoDeDatos.listObraSocial = MyObraSocialDao.getAll("Select * From ObraSocial");
        ArrayAdapter<CharSequence> ObraSocialSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, EntornoDeDatos.listObraSocial);
        Spinner_ObraSocialPersona.setAdapter(ObraSocialSpinner);
        MyObraSocialDao.CloseConnection();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cargar_Persona:

                //FECHA
                int dia = DatePicker_FechaNacimientoPersona.getDayOfMonth();
                int mes = DatePicker_FechaNacimientoPersona.getMonth() + 1;
                int anio = DatePicker_FechaNacimientoPersona.getYear();
                String fechaNacimiento = dia + "/" + mes + "/" + anio;

                //PERSONA
                MyPersona.setNombrePersona(EditTextNombrePersona.getText().toString());
                MyPersona.setApellidoPersona(EditTextApellidoPersona.getText().toString());
                MyPersona.setEstadoCivil(Spinner_EstadoCivilPersona.getSelectedItem().toString());
                MyPersona.setDNI(EditTextDNIPersona.getText().toString());
                MyPersona.setFNACPersona(fechaNacimiento);
                MyPersona.setOcupacion(EditTextOcupacionPersona.getText().toString());
                MyPersona.setNacionalidad(Spinner_NacionalidadPersona.getSelectedItem().toString());
                MyPersona.setObservacion(EditTextObservacionPersona.getText().toString());
                //MyPersona.setCasa_ClaveFR();

                //HISTORIA CLINICA
                MyHistoriaClinica.setNumeroDeHistoriaClinica(EditTextDNIPersona.getText().toString());
                //MyHistoriaClinica.setObraSocial_ClaveFR();


                // MyPersona.setHistoriaClinica_ClaveFR();
                // MyPersona.setEmpadronador_ClaveFR(RecibirDatos());


                break;
            case R.id.btn_Cancelar_Persona:
                break;
        }
    }

    public Long RecibirDatos() { //Recibe datos de otra activity
        Bundle Extra = getIntent().getExtras();
        Long PK = Extra.getLong("pkEmpadronador");
        return PK;

    }

    private void ObtenerListaModificadaObraSocial() {


        EntornoDeDatos.listSpinnerObraSocial.add("Seleccione"); // Nos permite Mostrar el primer elemento  en nuestro Spinner como Seleccionar
        for (int i = 0; i < EntornoDeDatos.listObraSocial.size(); i++) {

            EntornoDeDatos.listSpinnerObraSocial.add(EntornoDeDatos.listObraSocial.get(i).getNombreObraSocial()); //Permite cargar la lista para mostrar a gusto en nuestro Spinner
        }
    }

    private void ObtenerListaModificadaBarrio() {

        EntornoDeDatos.listBarrio=MyBarrioDao.getAll("Select * From Barrio");
        EntornoDeDatos.listSpinnerBarrio.add("Seleccione"); // Nos permite Mostrar el primer elemento  en nuestro Spinner como Seleccionar
        for (int i = 0; i <EntornoDeDatos.listBarrio.size(); i++) {

            EntornoDeDatos.listSpinnerBarrio.add(EntornoDeDatos.listBarrio.get(i).getNombreBarrio()); //Permite cargar la lista para mostrar a gusto en nuestro Spinner
        }
    }
}