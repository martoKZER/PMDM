package org.iesch.a04_marcador_de_baloncesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.a04_marcador_de_baloncesto.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int localScore = 0;
    private int visitorScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setupButtons() {
        // 4 - Me creo un método para restar la puntuación local
        binding.localMinusButton.setOnClickListener(v -> {
            if (localScore > 0) {
                localScore--;
                binding.localScoreText.setText(String.valueOf(localScore));
            }
        });
        binding.visitorMinusButton.setOnClickListener(v -> {
            if (visitorScore > 0) {
                visitorScore--;
                binding.visitorScoreText.setText(String.valueOf(visitorScore));
            }

        });

        // 6 - Me creo un método para restar la puntuación visitante
        binding.localSumarButton.setOnClickListener(v -> {
            addPointsToScore(1, true);
        });
        binding.localSumarDosButton.setOnClickListener(v -> {
            addPointsToScore(1, true);
        });
        binding.visitorSumarButton.setOnClickListener(v -> {
            addPointsToScore(1, false);
        });
        binding.visitorSumarDosButton.setOnClickListener(v -> {
            addPointsToScore(2, false);
        });
        binding.restartButton.setOnClickListener(view -> {
            resetScores();
        });
        binding.resultButton.setOnClickListener(view -> {
            endGame();
        });
    }
    // termina el jogo, vamos a la otra activity ACUERDATE DE ESTA MIERDA XFABO
    private void endGame() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("localScore", localScore);
        intent.putExtra("visitorScore", visitorScore);
        startActivity(intent);
    }

    private void addPointsToScore(int points, boolean isLocal) {
        if (isLocal) {
            localScore += points;
            binding.localScoreText.setText(String.valueOf(localScore));
        } else {
            visitorScore += points;
            binding.visitorScoreText.setText(String.valueOf(localScore));
        }
    }
    // 7 - Un botón para resetear los marcadores y pintarlos
    private void resetScores(){
        localScore = 0;
        visitorScore = 0;
        binding.visitorScoreText.setText(String.valueOf(visitorScore));
        binding.localScoreText.setText(String.valueOf(localScore));
    }
}