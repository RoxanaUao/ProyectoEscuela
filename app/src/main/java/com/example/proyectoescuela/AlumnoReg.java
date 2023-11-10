package com.example.proyectoescuela;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AlumnoReg extends AppCompatActivity {
    private EditText nombreEditText;
    private static final String TAG = "AlumnoReg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_reg);

        nombreEditText = findViewById(R.id.editTextNombre);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button RecogerButton = findViewById(R.id.buttonRecoger);
        Button SalirButton = findViewById(R.id.buttonSalir);
        Button CrearButton = findViewById(R.id.button4);

        SalirButton.setOnClickListener(v -> salir());
        CrearButton.setOnClickListener(v -> guardar());
        RecogerButton.setOnClickListener(v -> carril());

        //pendiente desplegar tabla
    }
    private void salir() {
        Intent intent = new Intent(AlumnoReg.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void registro() {
        Intent intent = new Intent(AlumnoReg.this, AlumnoReg.class);
        startActivity(intent);
        finish();
    }
    private void carril() {
        Intent intent = new Intent(AlumnoReg.this, Carril.class);
        startActivity(intent);
        finish();
    }
    private void guardar() {
        //pendiente meterle dato del padre
        String nombre = nombreEditText.getText().toString().trim();

        String grado ="";

        String padre ="";

        if ( nombre.isEmpty() || grado.isEmpty()) {
            Toast.makeText(this, "Ingrese todos los datos para el registro", Toast.LENGTH_SHORT).show();
            return;
        }else{
            // falta traer objeto del padre q se loguea
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("carril", "0");
            alumno.put("nombre", nombre);
            alumno.put("grado", grado);
            alumno.put("padre", "");

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            // Add a new document with a generated ID
            db.collection("alumnos")
                    .add(alumno)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Intent intent = new Intent(AlumnoReg.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
        }

        Intent intent = new Intent(AlumnoReg.this, Carril.class);
        startActivity(intent);
        finish();
    }

}