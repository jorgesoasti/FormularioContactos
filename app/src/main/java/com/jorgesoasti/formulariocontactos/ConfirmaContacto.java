package com.jorgesoasti.formulariocontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmaContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_contacto);

        Bundle parametros = getIntent().getExtras();

        TextView tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        TextView tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = findViewById(R.id.tvTelefono);

        int anio = parametros.getInt("Anio");
        int mes = parametros.getInt("Mes");
        int dia = parametros.getInt("Dia");
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");

        tvFechaNacimiento.setText("Fecha de Nacimiento: " + dia + "/" + mes + "/" + anio);
        tvNombreCompleto.setText(nombre);
        tvTelefono.setText(telefono);
    }
}
