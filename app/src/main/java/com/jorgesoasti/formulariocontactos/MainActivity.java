package com.jorgesoasti.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declaración de Variables
    private int REQUEST_CODE = 1;
    DatePicker dpFechaNacimiento;
    EditText edtNombreCompleto;
    EditText edtTelefono;
    EditText edtEmail;
    EditText edtDescrip;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSiguiente = findViewById(R.id.btnBotonSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creacion del Intent
                Intent intent = new Intent(MainActivity.this, ConfirmaContacto.class);

                dpFechaNacimiento = findViewById(R.id.dpFechaNacimiento);
                edtNombreCompleto = findViewById(R.id.edtNombreCompleto);
                edtTelefono = findViewById(R.id.edtTelefono);
                edtEmail = findViewById(R.id.edtEmail);
                edtDescrip = findViewById(R.id.edtDescripcionContacto);

                //Obtener el valor de los EditText
                String nombre = edtNombreCompleto.getText().toString();
                String telefono = edtTelefono.getText().toString();
                String email = edtEmail.getText().toString();
                String descrip = edtDescrip.getText().toString();

                //Obtener los valores del DatePicker
                int anio = dpFechaNacimiento.getYear();
                int mes = dpFechaNacimiento.getMonth() + 1;
                int dia = dpFechaNacimiento.getDayOfMonth();

                //Preparar los valores para el paso de informacion
                intent.putExtra("Anio", anio);
                intent.putExtra("Mes", mes);
                intent.putExtra("Dia", dia);
                intent.putExtra("Nombre", nombre);
                intent.putExtra("Telefono", telefono);
                intent.putExtra("Email", email);
                intent.putExtra("DescripContacto", descrip);

                //Iniciar la otra Actividad en espera de Resultados
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    //Método para recibir el resultado de la otra Actividad
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            //Obtener datos recibidos
            String nombreC = data.getStringExtra("NombreC");
            String telefono = data.getStringExtra("Telef");
            String email = data.getStringExtra("Mail");
            String descrip = data.getStringExtra("Des");

            //Colocar los datos obtenidos en los EditText
            edtNombreCompleto.setText(nombreC);
            edtTelefono.setText(telefono);
            edtEmail.setText(email);
            edtDescrip.setText(descrip);
        }
    }
}
