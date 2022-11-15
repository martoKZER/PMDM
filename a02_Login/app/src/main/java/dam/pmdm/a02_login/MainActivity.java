package dam.pmdm.a02_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import dam.pmdm.a02_login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private TextView somethingNull;
    private EditText etxEmail;
    private EditText etxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        etxEmail = binding.etxEmail;
        etxPassword = binding.etxPassword;
        somethingNull = binding.txtSomethingNull;
        Button btnLogin = binding.btnLogin;
        btnLogin.setOnClickListener(v -> {
            if (etxEmail.getText().toString().equals("".trim()) || etxPassword.getText().toString().equals("".trim())) {
                somethingNull.setVisibility(View.VISIBLE);
            } else {
                Intent i = new Intent(MainActivity.this, FinalActivity.class);
                i.putExtra("etxEmail", etxEmail.getText().toString());
                startActivity(i);

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        somethingNull.setVisibility(View.INVISIBLE);

    }

}