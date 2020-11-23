package com.example.agentapp.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.agentapp.R;
import com.example.agentapp.entornodedatos.EntornoDeDatos;

import com.example.agentapp.entidades.empadronador.Empadronador;
import com.example.agentapp.entidades.empadronador.EmpadronadorDao;
import com.example.agentapp.entidades.sector.SectorDao;


public class Registrarse extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner_SectorEmp;
    EditText EditText_Nombre;
    EditText EditText_Apellido;
    EditText EditText_DNI;
    EditText EditText_Usuario;
    EditText EditText_Password;
    Button btn_Registrarse;
    Button btn_Cancelar;
    EmpadronadorDao MyEmpadronadorDao;
    SectorDao MySectorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse);

        EditText_Nombre = findViewById(R.id.EditText_Nombre);
        EditText_Apellido = findViewById(R.id.EditText_Apellido);
        EditText_DNI = findViewById(R.id.EditText_DNI);
        EditText_Usuario = findViewById(R.id.EditText_Usuario);
        EditText_Password = findViewById(R.id.EditText_Password);
        btn_Registrarse = findViewById(R.id.btn_Registrarse);
        btn_Cancelar = findViewById(R.id.btn_Cancelar);
        spinner_SectorEmp = findViewById(R.id.spinner_SectorEmp);

        btn_Registrarse.setOnClickListener(this);
        btn_Cancelar.setOnClickListener(this);


        MyEmpadronadorDao = new EmpadronadorDao(this);
        MySectorDao = new SectorDao(this);


        EntornoDeDatos.listSpinnerSector.clear();
        EntornoDeDatos.listSector = MySectorDao.getAll("Select * From Sector");
        ObtenerListaModificada();
        ArrayAdapter<CharSequence> Adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, EntornoDeDatos.listSpinnerSector);
        spinner_SectorEmp.setAdapter(Adaptador);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_Registrarse:
                Empadronador Agente = new Empadronador();

                Agente.setEmpadronador_Nombre(EditText_Nombre.getText().toString());
                Agente.setEmpadronador_Apellido(EditText_Apellido.getText().toString());
                Agente.setEmpadronador_DNI(EditText_DNI.getText().toString());
                Agente.setEmpadronador_Usuario(EditText_Usuario.getText().toString());
                Agente.setEmpadronador_Clave(EditText_Password.getText().toString());
                Agente.setSectorClaveFR(validarSpinner());

                if (Agente.isnull()) {
                    Toast.makeText(this, "ERROR:CAMPOS VACIOS.", Toast.LENGTH_SHORT).show();
                } else {

                    try {
                        if (!ExisteEmpadronador()) {

                            if (validarSpinner() != -1) {

                                MyEmpadronadorDao.AddRecord(Agente);
                                Toast.makeText(this, "REGISTRADO CON EXITO!!", Toast.LENGTH_SHORT).show();
                                MyEmpadronadorDao.CloseConnection();
                                Intent login1 = new Intent(this, Login.class);
                                startActivity(login1);
                                finish();
                            } else {
                                Toast.makeText(this, "INGRESA UN SECTOR", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(this, "ERROR CUENTA YA EXISTENTE!!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(this, "ERROR:" + e, Toast.LENGTH_LONG).show();

                    }

                }

                break;

            case R.id.btn_Cancelar:
                Intent login2 = new Intent(this, Login.class);
                startActivity(login2);
                finish();
                break;
        }
    }

    private boolean ExisteEmpadronador() {
        EntornoDeDatos.listEmpadronador = MyEmpadronadorDao.getAll("Select * From Empadronador");
        for (int i = 0; i < EntornoDeDatos.listEmpadronador.size(); i++) {
            if (EditText_DNI.getText().toString().equals(EntornoDeDatos.listEmpadronador.get(i).getEmpadronador_DNI()) || EditText_Usuario.getText().toString().equals(EntornoDeDatos.listEmpadronador.get(i).getEmpadronador_Usuario())) {


                return true;
            }

        }
        return false;
    }


    public long validarSpinner() {
        String DatoSpinner = spinner_SectorEmp.getSelectedItem().toString();
        for (int i = 0; i < EntornoDeDatos.listSector.size(); i++) {

            if (EntornoDeDatos.listSector.get(i).getNombreSector() == DatoSpinner) {
                return EntornoDeDatos.listSector.get(i).getSectorPk();
            }
        }
        return -1;
    }

    private void ObtenerListaModificada() {
        EntornoDeDatos.listSpinnerSector.add("Seleccionar"); // Nos permite Mostrar el primer elemento  en nuestro Spinner como Seleccionar
        for (int i = 0; i < EntornoDeDatos.listSector.size(); i++) {

            EntornoDeDatos.listSpinnerSector.add(EntornoDeDatos.listSector.get(i).getNombreSector()); //Permite cargar la lista para mostrar a gusto en nuestro Spinner
        }
    }
}