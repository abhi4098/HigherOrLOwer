package abhi.higherorlower;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameMainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button highButton;
    private Button lowButton;
    private ImageView cardImage;
    int startingCard = 7;
    int randomCard;
    int nextCard;
    int score = 0;
    int highScore = 0;
    TextView tvScore;
    TextView tvHighScore;
    TextView tvResult;
    TextView tvTitle;




    // Random object
    private final static Random random = new Random();

    // The card deck
    private final static int[] cardDeck = new int[] {
            R.drawable.d1, R.drawable.d2,
            R.drawable.d3, R.drawable.d4,
            R.drawable.d5, R.drawable.d6,
            R.drawable.d7, R.drawable.d8,
            R.drawable.d9, R.drawable.d10,
            R.drawable.d11, R.drawable.d12,
            R.drawable.d13, R.drawable.d14,
            R.drawable.d15, R.drawable.d16,
            R.drawable.d17, R.drawable.d18,
            R.drawable.d19, R.drawable.d20,
            R.drawable.d21, R.drawable.d22,
            R.drawable.d23, R.drawable.d24,
            R.drawable.d25, R.drawable.d26,
            R.drawable.d27, R.drawable.d28,
            R.drawable.d29, R.drawable.d30,
            R.drawable.d31, R.drawable.d32,
            R.drawable.d33, R.drawable.d34,
            R.drawable.d35, R.drawable.d36,
            R.drawable.d37, R.drawable.d38,
            R.drawable.d39, R.drawable.d40,
            R.drawable.d41, R.drawable.d42,
            R.drawable.d43, R.drawable.d44,
            R.drawable.d45, R.drawable.d46,
            R.drawable.d47, R.drawable.d48,
            R.drawable.d49, R.drawable.d50,
            R.drawable.d51, R.drawable.d52
    }; // K card resource

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        ((TextView) findViewById(R.id.main_toolbar_title)).setText(R.string.higher_or_lower);
        Intent mIntent = getIntent();
        highScore = mIntent.getIntExtra("intVariableName", 0);


        highButton  = (Button)findViewById(R.id.highButton);
        lowButton   = (Button) findViewById(R.id.lowButton);
        cardImage   = (ImageView)findViewById(R.id.playingCard);
        tvScore   = (TextView) findViewById(R.id.tvscore);
        tvHighScore = (TextView) findViewById(R.id.highest_score);
        tvResult = (TextView) findViewById(R.id.result);



        highButton.setOnClickListener(this);
        lowButton.setOnClickListener(this);
        String highScr = String.valueOf(highScore);
        tvHighScore.setText(highScr);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.highButton:
                drawCard();
                score = score + 1;
                String scr1 = String.valueOf(score);
                tvScore.setText(scr1);
                tvResult.setText(R.string.result_high1);
                if (highScore < score)
                {
                    highScore =score;
                    String highScr = String.valueOf(highScore);
                    tvHighScore.setText(highScr);
                }
                else
                {
                    String highScr = String.valueOf(highScore);
                    tvHighScore.setText(highScr);
                }


               /* if (nextCard > startingCard)
                {
                    score = score + 1;
                    String scr = String.valueOf(score);
                    tvScore.setText(scr);
                    tvResult.setText(R.string.result_high1);
                    if (highScore < score)
                    {
                        highScore =score;
                        String highScr = String.valueOf(highScore);
                        tvHighScore.setText(highScr);
                    }
                    else
                    {
                        String highScr = String.valueOf(highScore);
                        tvHighScore.setText(highScr);
                    }


                }

                else if (nextCard == startingCard )
                         tvResult.setText(R.string.result_same);

                else if (nextCard == 1)
                         tvResult.setText(R.string.result_ace);

                else

                {
                    tvResult.setText(R.string.result_low);
                    Intent intent = new Intent(GameMainActivity.this, GameOverActivity.class);
                    intent.putExtra("intVariableName", score);
                    score =0;
                    tvScore.setText(" 0");
                    startActivity(intent);
                    finish();

                }

                    startingCard = nextCard;*/
                break;



            case R.id.lowButton:
                   drawCard();

                if (nextCard < startingCard)
                {
                    score = score + 1;
                    String scr = String.valueOf(score);
                    tvScore.setText(scr);
                    tvResult.setText(R.string.result_low);

                    if (highScore < score)
                    {
                        highScore =score;
                        String highScr = String.valueOf(highScore);
                        tvHighScore.setText(highScr);
                    }
                    else
                    {
                        String highScr = String.valueOf(highScore);
                        tvHighScore.setText(highScr);
                    }

                }


                else if (nextCard == startingCard )
                        tvResult.setText(R.string.result_same);

                else if (nextCard == 1)
                        tvResult.setText(R.string.result_ace);


                else {
                    tvResult.setText(R.string.result_high1);
                    Intent intent = new Intent(GameMainActivity.this, GameOverActivity.class);
                    intent.putExtra("intVariableName", score);
                    score =0;
                    tvScore.setText(" 0");
                    startActivity(intent);
                    finish();
                }

                startingCard = nextCard;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }







    private void drawCard() {
        randomCard = random.nextInt(cardDeck.length);
        cardImage.setImageResource(cardDeck[randomCard]);
        nextCard = randomCard + 1;
        if (nextCard==1||nextCard ==2||nextCard ==3||nextCard ==4 )
            nextCard =1;
        else if (nextCard==5||nextCard ==6||nextCard ==7||nextCard ==8 )
            nextCard =2;
        else if (nextCard==9||nextCard ==10||nextCard ==11||nextCard ==12 )
            nextCard =3;
        else if (nextCard==13||nextCard ==14||nextCard ==15||nextCard ==16 )
            nextCard =4;
        else if (nextCard==17||nextCard ==18||nextCard ==19||nextCard ==20 )
            nextCard =5;
        else if (nextCard==21||nextCard ==22||nextCard ==23||nextCard ==24 )
            nextCard =6;
        else if (nextCard==25||nextCard ==26||nextCard ==27||nextCard ==28 )
            nextCard =7;
        else if (nextCard==29||nextCard ==30||nextCard ==31||nextCard ==32 )
            nextCard =8;
        else if (nextCard==33||nextCard ==34||nextCard ==35||nextCard ==36 )
            nextCard =9;
        else if (nextCard==37||nextCard ==38||nextCard ==39||nextCard ==40 )
            nextCard =10;
        else if (nextCard==41||nextCard ==42||nextCard ==43||nextCard ==44 )
            nextCard =11;
        else if (nextCard==45||nextCard ==46||nextCard ==47||nextCard ==48 )
            nextCard =12;
        else
            nextCard =13;
        Log.e("abhi", "next card "+nextCard );


    }
}
