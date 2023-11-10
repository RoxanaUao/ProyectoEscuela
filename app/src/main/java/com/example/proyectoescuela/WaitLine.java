package com.example.proyectoescuela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WaitLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_line);

        Button SalirButton = findViewById(R.id.buttonSalir);
        Button ListoButton = findViewById(R.id.buttonListo);
        Button RegistroButton = findViewById(R.id.buttonAlumnos);

        SalirButton.setOnClickListener(v -> salir());
        ListoButton.setOnClickListener(v -> listo());
        RegistroButton.setOnClickListener(v -> registro());
    }
    private void salir() {
        Intent intent = new Intent(WaitLine.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void listo() {
        //Pendiente editar para que actualice carril a 0

        Intent intent = new Intent(WaitLine.this, Carril.class);
        startActivity(intent);
        finish();
    }
    private void registro() {
        Intent intent = new Intent(WaitLine.this, AlumnoReg.class);
        startActivity(intent);
        finish();
    }


}