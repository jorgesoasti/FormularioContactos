package com.jorgesoasti.formulariocontactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente = findViewById(R.id.btnBotonSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ConfirmaContacto.class);

                final DatePicker dpFechaNacimiento = findViewById(R.id.dpFechaNacimiento);
                final EditText edtNombreCompleto = findViewById(R.id.edtNombreCompleto);
                final EditText edtTelefono = findViewById(R.id.edtTelefono);

                String nombre = edtNombreCompleto.getText().toString();
                String telefono = edtTelefono.getText().toString();

                int anio = dpFechaNacimiento.getYear();
                int mes = dpFechaNacimiento.getMonth() + 1;
                int dia = dpFechaNacimiento.getDayOfMonth();

                intent.putExtra("Anio", anio);
                intent.putExtra("Mes", mes);
                intent.putExtra("Dia", dia);
                intent.putExtra("Nombre", nombre);
                intent.putExtra("Telefono", telefono);
                startActivity(intent);
            }
        });


    }
}
