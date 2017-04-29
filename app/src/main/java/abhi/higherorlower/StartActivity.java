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

public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    Button newGamebutton;
    Button exitGameButton;
    Button tutorialButton;


    int highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        newGamebutton = (Button) findViewById(R.id.new_game);
        exitGameButton = (Button) findViewById(R.id.exit_game);
        tutorialButton = (Button) findViewById(R.id.tutorial);
        exitGameButton.setOnClickListener(this);
        newGamebutton.setOnClickListener(this);
        tutorialButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.new_game:
                LoadHighScore();
                Intent intent = new Intent(StartActivity.this, GameMainActivity.class);
                intent.putExtra("intVariableName", highScore);
                startActivity(intent);
                break;

            case R.id.exit_game:
                ExitGame();
                break;

            case R.id.tutorial:
                Intent intent1 = new Intent(StartActivity.this, TutorialActivity.class);
                startActivity(intent1);
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
    }


    @Override
    public void onBackPressed() {
        ExitGame();
    }

    public void LoadHighScore(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        highScore = sharedPreferences.getInt("high score", 0);
        Log.e("abhi", "LoadHighScore: " +highScore );
    }

    public void ExitGame()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                        //StartActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
