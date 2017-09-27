package com.jorgesoasti.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_contacto);

        Bundle parametros = getIntent().getExtras();

        final TextView tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        TextView tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        final TextView tvTelefono = findViewById(R.id.tvTelefono);
        final TextView tvEmail = findViewById(R.id.tvEmail);
        final TextView tvDesc = findViewById(R.id.tvDescContacto);

        int anio = parametros.getInt("Anio");
        int mes = parametros.getInt("Mes");
        int dia = parametros.getInt("Dia");
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        final String desc = parametros.getString("DescripContacto");

        tvFechaNacimiento.setText("Fecha de Nacimiento: " + dia + "/" + mes + "/" + anio);
        tvNombreCompleto.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        Button btnEditar = findViewById(R.id.btnBotonEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmaContacto.this, MainActivity.class);
                String nombre = tvNombreCompleto.getText().toString();
                String telefono = tvTelefono.getText().toString();
                String email = tvEmail.getText().toString();
                String descrip = tvDesc.getText().toString();

                intent.putExtra("NombreC", nombre);
                intent.putExtra("Telef", telefono);
                intent.putExtra("Mail", email);
                intent.putExtra("Des", descrip);

                startActivity(intent);
            }
        });
    }
}
