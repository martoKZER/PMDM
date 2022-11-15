package dam.pmdm.a02_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import dam.pmdm.a02_login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button btnLogin;
    private EditText etxEmail;
    private EditText etxPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        etxEmail = binding.etxEmail;
        etxPassword = binding.etxPassword;
        btnLogin = binding.btnLogin;
        textView = binding.textView;
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (etxEmail.getText() == null || etxPassword.getText() == null){
            textView.setTextColor(ContextCompat.getColor(this, R.color.redRP));
            textView.setText(R.string.faltanDatos);
        }else{
            Intent i = new Intent(this, FinalActivity.class);
            i.putExtra("etxEmail", etxEmail.getText());
            startActivity(i);

        }

    }
}