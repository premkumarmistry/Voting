package prem.dev.voting1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Thread SplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    startActivity(new Intent(getApplicationContext(), MainScreen.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        SplashThread.start();

    }
}