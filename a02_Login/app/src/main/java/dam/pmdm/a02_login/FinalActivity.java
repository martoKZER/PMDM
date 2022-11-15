package dam.pmdm.a02_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        String email = getIntent().getStringExtra("etxEmail");
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        String bienvenida = getString(R.string.bienvenido) + " " + email;
        txtWelcome.setText(bienvenida);
    }
}