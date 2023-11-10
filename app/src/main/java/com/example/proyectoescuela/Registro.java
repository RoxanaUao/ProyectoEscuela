package com.example.proyectoescuela;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.DocumentReference;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;
import androidx.annotation.NonNull;

public class Registro extends AppCompatActivity {
    private static final String TAG = "Registro";
    private EditText  passwordEditText, cedulaEditText,nombreEditText, correoEditText, telefonoEditText;
    //private Button RegistroButton, VolverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        correoEditText = findViewById(R.id.correoEditText1);
        passwordEditText = findViewById(R.id.passwordEditText);
        cedulaEditText = findViewById(R.id.editTextCedula);
        nombreEditText = findViewById(R.id.nombreEditText1);
        telefonoEditText = findViewById(R.id.telefonoEditText1);

        Button RegistroButton = findViewById(R.id.buttonRegistrar);
        Button VolverButton = findViewById(R.id.buttonVolver);
        RegistroButton.setOnClickListener(v -> registrar());
        VolverButton.setOnClickListener(v -> volver());


    }
    private void registrar() {
        String email = correoEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String nombre = nombreEditText.getText().toString().trim();
        String cedula = cedulaEditText.getText().toString().trim();
        String telefono = telefonoEditText.getText().toString().trim();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (email.isEmpty() || password.isEmpty() || nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Ingrese todos los datos para el registro", Toast.LENGTH_SHORT).show();
            return;
        }else{
            // Create a new user with a first and last name
            Map<String, Object> padre = new HashMap<>();
            padre.put("carril", "0");
            padre.put("cedula", cedula);
            padre.put("contraseña", password);
            padre.put("correo", email);
            padre.put("nombre", nombre);
            padre.put("telefono", telefono);

            // Add a new document with a generated ID
            db.collection("padres")
                    .add(padre)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Intent intent = new Intent(Registro.this, MainActivity.class);
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

    }
    private void volver() {
        Intent intent = new Intent(Registro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}