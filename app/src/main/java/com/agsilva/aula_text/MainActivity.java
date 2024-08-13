package com.agsilva.aula_text;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private EditText editSobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
    }

    public void limpar(View view){
        editNome.setText(null);
        editSobrenome.setText(null);

        editNome.requestFocus();

        Toast.makeText(this, "Campos limpos!", Toast.LENGTH_SHORT).show();
    }

    public void mostrarNomecompleto(View view){
        String nome = editNome.getText().toString();
        String sobrenome = editSobrenome.getText().toString();

        if (nome == null || nome.trim().isEmpty()){
            Toast.makeText(this, R.string.nome_vazio, Toast.LENGTH_SHORT).show();
            return;
        }

        if (sobrenome == null || sobrenome.trim().isEmpty()){
            Toast.makeText(this, R.string.sobrenome_vazio, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, nome + " " + sobrenome, Toast.LENGTH_LONG).show();
    }
}