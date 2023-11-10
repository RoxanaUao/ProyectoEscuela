package com.example.proyectoescuela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Carril extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carril);


        Button SalirButton = findViewById(R.id.buttonSalir);
        Button RegistroButton = findViewById(R.id.buttonAlumnos);
        Button Carril1Button = findViewById(R.id.buttonCarril1);
        Button Carril2Button = findViewById(R.id.buttonCarril2);
        Button Carril3Button = findViewById(R.id.buttonCarril3);

        SalirButton.setOnClickListener(v -> salir());
        RegistroButton.setOnClickListener(v -> registro());
        Carril1Button.setOnClickListener(v -> seleccionarCarril1());
        Carril2Button.setOnClickListener(v -> seleccionarCarril2());
        Carril3Button.setOnClickListener(v -> seleccionarCarril3());
    }
    private void salir() {
        Intent intent = new Intent(Carril.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void registro() {
        Intent intent = new Intent(Carril.this, AlumnoReg.class);
        startActivity(intent);
        finish();
    }

    private void seleccionarCarril1() {
        //pendiente actualizar dato de carril en padre y en todos sus hijos
        Intent intent = new Intent(Carril.this, WaitLine.class);
        startActivity(intent);
        finish();
    }
    private void seleccionarCarril2() {
        //pendiente actualizar dato de carril en padre y en todos sus hijos
        Intent intent = new Intent(Carril.this, WaitLine.class);
        startActivity(intent);
        finish();
    }
    private void seleccionarCarril3() {
        //pendiente actualizar dato de carril en padre y en todos sus hijos
        Intent intent = new Intent(Carril.this, WaitLine.class);
        startActivity(intent);
        finish();
    }
}