package up.edu.br.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int countComputador = 0;
    int countJogador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(View view) {
        ImageButton btnJogador = findViewById(R.id.btnJogador);
        ImageButton btnComputador = findViewById(R.id.btnComputador);
        TextView txtResultadoValue = findViewById(R.id.txtResultado);
        int escolhaJogador = -1;

        if (view.getId() == R.id.btnPedra) {
            btnJogador.setImageResource(R.drawable.pedra);
            escolhaJogador = 0;
        }
        if (view.getId() == R.id.btnPapel) {
            btnJogador.setImageResource(R.drawable.papel);
            escolhaJogador = 1;
        }
        if (view.getId() == R.id.btnTesoura) {
            btnJogador.setImageResource(R.drawable.tesoura);
            escolhaJogador = 2;
        }

        int escolhaComputador = new Random().nextInt(3);
        switch (escolhaComputador) {
            case 0:
                btnComputador.setImageResource(R.drawable.pedra);
                break;
            case 1:
                btnComputador.setImageResource(R.drawable.papel);
                break;
            case 2:
                btnComputador.setImageResource(R.drawable.tesoura);
                break;
            default:
                break;
        }

        String vitoria = "Você venceu!";
        String derrota = "Você perdeu!";
        String empate = "Empate!";

        if (escolhaJogador == 0) {
            if (escolhaComputador == 0) {
                txtResultadoValue.setText(empate);
            } else if (escolhaComputador == 1) {
                txtResultadoValue.setText(derrota);
            } else if (escolhaComputador == 2) {
                txtResultadoValue.setText(vitoria);
            }
        } else if (escolhaJogador == 1) {
            if (escolhaComputador == 1) {
                txtResultadoValue.setText(empate);
            } else if (escolhaComputador == 2) {
                txtResultadoValue.setText(derrota);
            } else if (escolhaComputador == 0) {
                txtResultadoValue.setText(vitoria);
            }
        } else if (escolhaJogador == 2) {
            if (escolhaComputador == 2) {
                txtResultadoValue.setText(empate);
            } else if (escolhaComputador == 0) {
                txtResultadoValue.setText(derrota);
            } else if (escolhaComputador == 1) {
                txtResultadoValue.setText(vitoria);
            }
        }
    }
}
