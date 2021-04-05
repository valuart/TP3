package com.example.trabajopractico3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText etDolares, etEuros, etCambio;
    private RadioButton rbA, rbB;
    private Button btnConvertir;
    private MainActivityViewModel vm ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        inicializarVista();

        vm.getDolares().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDolares.setEnabled(aBoolean);
                etDolares.requestFocus();
            }
        });

        vm.getEuros().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etEuros.setEnabled(aBoolean);
                etEuros.requestFocus();
            }
        });

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etCambio.setText(s);
            }
        });


    }

    public void EstadoA(View v) {
        vm.cambiar(v.getId(), rbA.getId(), rbB.getId());
    }

    public void conversion(View v) {
        vm.convirtiendo(rbA.isChecked(), etDolares.getText().toString(), etEuros.getText().toString());
    }

    private void inicializarVista() {
        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etCambio = findViewById(R.id.etCambio);
        rbA = findViewById(R.id.rbA);
        rbB = findViewById(R.id.rbB);
        btnConvertir= findViewById(R.id.btnConvertir);

        etDolares.setText("");
        etEuros.setText("");
        etCambio.setText("");




    }

}