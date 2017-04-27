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
    int highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        newGamebutton = (Button) findViewById(R.id.new_game);
        exitGameButton = (Button) findViewById(R.id.exit_game);
        exitGameButton.setOnClickListener(this);
        newGamebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.new_game:
                LoadHighScore();
                Log.e("abhi", "onClick: start game high score" + highScore);
                Intent intent = new Intent(StartActivity.this, GameMainActivity.class);
                intent.putExtra("intVariableName", highScore);
                startActivity(intent);
                break;

            case R.id.exit_game:
                ExitGame();
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
                        StartActivity.this.finish();
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
