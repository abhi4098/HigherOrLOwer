package abhi.higherorlower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        enterButton = (Button) findViewById(R.id.enter_button);
        enterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(SplashActivity.this , StartActivity.class);
        startActivity(intent);
        finish();

    }
}
