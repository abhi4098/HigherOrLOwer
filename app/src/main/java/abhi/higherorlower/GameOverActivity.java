package abhi.higherorlower;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.attr.value;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {
    int highScore =0;
    TextView tvFinalScore;
    TextView tvHighScore;
    ImageButton ibtnReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("intVariableName", 0);

        tvFinalScore = (TextView) findViewById(R.id.final_score);
        tvHighScore = (TextView) findViewById(R.id.high_score);
        ibtnReplay = (ImageButton) findViewById(R.id.replay_button);
        ibtnReplay.setOnClickListener(this);

        tvFinalScore.setText("Score : " +score);
        LoadHighScore();
        if(score > highScore)
        {
            highScore = score;
            SaveHighScore("high score", highScore);
            tvHighScore.setText("High Score : " +highScore);

        }
        else
        {
            tvHighScore.setText("High Score : " +highScore);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(GameOverActivity.this , StartActivity.class);
        startActivity(intent);
        finish();

    }



    public void SaveHighScore(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void LoadHighScore(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        highScore = sharedPreferences.getInt("high score", 0);
    }


    @Override
    public void onClick(View view) {
        Intent intent= new Intent(GameOverActivity.this , StartActivity.class);
        startActivity(intent);
        finish();
    }
}
