package dam.pmdm.a02_login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import dam.pmdm.a02_login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {
    private TextView textView;
    private EditText etxEmail;
    private EditText etxPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        etxEmail = binding.etxEmail;
        etxPassword = binding.etxPassword;
        Button btnLogin = binding.btnLogin;
        textView = binding.textView;
        btnLogin.setOnClickListener(view -> {
            if (etxEmail.getText() == null || etxPassword.getText() == null){
                textView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.redRP));
                textView.setText(R.string.faltanDatos);
            }else{
                Intent i = new Intent(MainActivity.this, FinalActivity.class);
                i.putExtra("etxEmail", etxEmail.getText());
                startActivity(i);

            }
        });

    }
}