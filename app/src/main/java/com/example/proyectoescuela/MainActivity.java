package com.example.proyectoescuela;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.editTextCedula);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button loginButton = findViewById(R.id.buttonRegistrar);
        Button signUpButton = findViewById(R.id.buttonVolver);

        loginButton.setOnClickListener(v -> entrar());
        signUpButton.setOnClickListener(v -> signUp());
    }
    private void entrar(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        if (emailEditText.getText().toString().trim().isEmpty() || passwordEditText.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese todos los datos para el ingreso", Toast.LENGTH_SHORT).show();
            return;
        }

        db.collection("padres")
                .whereEqualTo("cedula", emailEditText.getText().toString())
                .whereEqualTo("contraseña", passwordEditText.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (!task.getResult().isEmpty()) {
                            // Existe un documento que coincide con cedula y email
                            Intent intent = new Intent(MainActivity.this, Carril.class);
                            startActivity(intent);
                            finish(); // Cierra la actividad actual
                            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                        } else {
                            // No existe un documento que coincida con cedula y email
                            // Navegar hacia la actividad Carril
                            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Log.e(TAG, "Error al realizar la consulta: ", task.getException());
                    }
                });
    }


    private void signUp() {
        Intent intent = new Intent(MainActivity.this, Registro.class);
        startActivity(intent);
        finish();
    }
}