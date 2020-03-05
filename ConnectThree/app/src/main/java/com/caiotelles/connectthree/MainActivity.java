package com.caiotelles.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    0 = red
    1 = yellow
     */
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2) {

            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 0;
            } else
                activePlayer = 1;

            counter.setTranslationY(-1000f);
            counter.animate().alpha(1f).translationYBy(1000f).setDuration(300);
            gameState[tappedCounter] = activePlayer;
        } else
            Toast.makeText(this,"Position already used",Toast.LENGTH_SHORT).show();

        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
            gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
            gameState[winningPosition[0]] != 2) {

                GridLayout gridLayout = findViewById(R.id.gridLayout);
                for (int i = 0; i < gridLayout.getChildCount(); i++) {
                    ((ImageView) gridLayout.getChildAt(i)).setClickable(false);
                }

                String winnerColor = "";
                if (gameState[winningPosition[0]] == 1)
                    winnerColor = "Red";
                else
                    winnerColor = "Yellow";

                String winner = winnerColor + " has won the match!";

                LinearLayout winnerCard = findViewById(R.id.winnerCard);
                TextView winnerText = findViewById(R.id.winnerText);

                winnerCard.setVisibility(View.VISIBLE);
                winnerText.setText(winner);

            } else {
                boolean gameIsOver = true;
                for (int counterState : gameState) {
                    if (counterState == 2)
                        gameIsOver = false;
                }
                if (gameIsOver) {
                    String winner = "It's a draw!";

                    LinearLayout winnerCard = findViewById(R.id.winnerCard);
                    TextView winnerText = findViewById(R.id.winnerText);

                    winnerCard.setVisibility(View.VISIBLE);
                    winnerText.setText(winner);
                }
            }
        }
    }

    public void setNewMatch(View view) {

        LinearLayout winnerCard = findViewById(R.id.winnerCard);
        winnerCard.setVisibility(View.GONE);

        activePlayer = 0;
        int[] newGameState = {2,2,2,2,2,2,2,2,2};
        gameState = newGameState;

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(R.drawable.red);
            ((ImageView) gridLayout.getChildAt(i)).setAlpha(0f);
        }


    }

}
