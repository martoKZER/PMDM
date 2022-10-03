package org.iesch.miedadcanina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // setContentView(R.layout.activity_main);

        //TODOS los elementos de la interfaz deben tener un ID en el activity_main.xml o en la activity que estén.
        EditText ageEdit = findViewById(R.id.etxt_AgeEdit);
        Button btnCalcular = findViewById(R.id.btn_Calcular);
        TextView txtDogAge = findViewById(R.id.txt_DogAge);
        EditText ageEdit = binding.YourAge;
       /* Button btnCalcular = findViewById(R.id.btn_Calcular);
        TextView txtDogAge = binding.resultText;*/
        // Verbose
        Log.v(  "DAM",  "MainActivity Cargada con exito");
        // Debug
        Log.d(  "DAM",  "MainActivity Cargada con exito");
        // Info
        Log.i(  "DAM",  "MainActivity Cargada con exito");
        // Warning
        Log.w(  "DAM",  "MainActivity Cargada con exito");
        // Error
        Log.e(  "DAM",  "MainActivity Cargada con exito");

        btnCalcular.setOnClickListener(view -> {
            // Control null o whitespace
            String age = ageEdit.getText().toString();
            if (!age.isEmpty()) {
                int ageInteger = Integer.parseInt(age);
                //Al hacer click queremos calcular el texto introducido
                int result = ageInteger * 7;
                String resultText = getString(R.string.resultFormat, result);
                txtDogAge.setText(resultText);
            }else{
                Log.d("MainActivity", "El campo Edad está vacío");
                Toast.makeText(this, getString(R.string.ageFieldEmpty), Toast.LENGTH_SHORT).show();
            }

        });
    }
}