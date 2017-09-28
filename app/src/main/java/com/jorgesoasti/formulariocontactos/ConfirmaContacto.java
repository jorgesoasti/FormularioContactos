package com.jorgesoasti.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaContacto extends AppCompatActivity {

    //Declaración de Variables
    TextView tvNombreCompleto;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_contacto);

        //Bundle para recibir los datos de la primera Actividad
        Bundle parametros = getIntent().getExtras();

        tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDesc = findViewById(R.id.tvDescContacto);

        //Obtener datos enviados por la primera Actividad
        int anio = parametros.getInt("Anio");
        int mes = parametros.getInt("Mes");
        int dia = parametros.getInt("Dia");
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String desc = parametros.getString("DescripContacto");

        //Colocar datos obtenidos en los TextView
        tvFechaNacimiento.setText("Fecha de Nacimiento: " + dia + "/" + mes + "/" + anio);
        tvNombreCompleto.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        Button btnEditar = findViewById(R.id.btnBotonEditar);

        //Evento del Boton para editar los datos
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmaContacto.this, MainActivity.class);

                //Obtener valores de los TextView
                String nombre = tvNombreCompleto.getText().toString();
                String telefono = tvTelefono.getText().toString();
                String email = tvEmail.getText().toString();
                String descrip = tvDesc.getText().toString();

                //Colocar datos a enviar de vuelta a la primera Actividad
                intent.putExtra("NombreC", nombre);
                intent.putExtra("Telef", telefono);
                intent.putExtra("Mail", email);
                intent.putExtra("Des", descrip);

                setResult(RESULT_OK, intent);

                onBackPressed();
            }
        });
    }
}
