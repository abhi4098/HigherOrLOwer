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

import static android.R.attr.value;

public class GameOverActivity extends AppCompatActivity {
    int highScore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("intVariableName", 0);


        LoadHighScore();
        if(score > highScore)
        {
            highScore = score;
            SaveHighScore("high score", highScore);

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


}
