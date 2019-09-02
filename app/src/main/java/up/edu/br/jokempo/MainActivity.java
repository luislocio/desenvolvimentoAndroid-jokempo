package up.edu.br.jokempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(final View view) {
        final ImageButton btnJogador = findViewById(R.id.escolhaJogador);
        final ImageButton btnComputador = findViewById(R.id.escolhaComputador);
        final TextView txtResultadoValue = findViewById(R.id.txtResultado);
        final TextView scoreComputador = findViewById(R.id.scoreComputador);
        final TextView scoreJogador = findViewById(R.id.scoreJogador);
        final ConstraintLayout tudo = findViewById(R.id.tudo);

        view.startAnimation(buttonClick);
        btnJogador.setVisibility(View.VISIBLE);
        btnComputador.setVisibility(View.VISIBLE);
        int escolhaJogador = -1;
        int countComputador = Integer.parseInt(scoreComputador.getText().toString());
        int countJogador = Integer.parseInt(scoreJogador.getText().toString());

        if (view.getId() == R.id.btnPedra) {
            btnJogador.setImageResource(R.drawable.ic_pedra_jogador);
            escolhaJogador = 0;
        }
        if (view.getId() == R.id.btnPapel) {
            btnJogador.setImageResource(R.drawable.ic_papel_jogador);
            escolhaJogador = 1;
        }
        if (view.getId() == R.id.btnTesoura) {
            btnJogador.setImageResource(R.drawable.ic_tesoura_jogador);
            escolhaJogador = 2;
        }

        int escolhaComputador = new Random().nextInt(3);
        switch (escolhaComputador) {
            case 0:
                btnComputador.setImageResource(R.drawable.ic_pedra_computador);
                break;
            case 1:
                btnComputador.setImageResource(R.drawable.ic_papel_computador);
                break;
            case 2:
                btnComputador.setImageResource(R.drawable.ic_tesoura_computador);
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
                txtResultadoValue.setTextColor(0xffff8800);
            } else if (escolhaComputador == 1) {
                txtResultadoValue.setText(derrota);
                txtResultadoValue.setTextColor(0xffcc0000);
                countComputador++;
            } else if (escolhaComputador == 2) {
                txtResultadoValue.setText(vitoria);
                txtResultadoValue.setTextColor(0xff669900);
                countJogador++;

            }
        } else if (escolhaJogador == 1) {
            if (escolhaComputador == 1) {
                txtResultadoValue.setText(empate);
                txtResultadoValue.setTextColor(0xffff8800);
            } else if (escolhaComputador == 2) {
                txtResultadoValue.setText(derrota);
                txtResultadoValue.setTextColor(0xffcc0000);
                countComputador++;
            } else if (escolhaComputador == 0) {
                txtResultadoValue.setText(vitoria);
                txtResultadoValue.setTextColor(0xff669900);
                countJogador++;
            }
        } else if (escolhaJogador == 2) {
            if (escolhaComputador == 2) {
                txtResultadoValue.setText(empate);
                txtResultadoValue.setTextColor(0xffff8800);
            } else if (escolhaComputador == 0) {
                txtResultadoValue.setText(derrota);
                txtResultadoValue.setTextColor(0xffcc0000);
                countComputador++;
            } else if (escolhaComputador == 1) {
                txtResultadoValue.setText(vitoria);
                txtResultadoValue.setTextColor(0xff669900);
                countJogador++;
            }
        }

        txtResultadoValue.setVisibility(View.VISIBLE);
        scoreComputador.setText(String.valueOf(countComputador));
        scoreJogador.setText(String.valueOf(countJogador));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        txtResultadoValue.postDelayed(new Runnable() {
            public void run() {
                txtResultadoValue.setVisibility(View.INVISIBLE);
                btnJogador.setVisibility(View.INVISIBLE);
                btnComputador.setVisibility(View.INVISIBLE);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }, 2000);
    }
}
