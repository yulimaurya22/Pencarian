package com.virnanda.candiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    //initialize variable
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //menetapkan variabel
        textView = findViewById(R.id.textView);

        //initialize text animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transisi_turun);
        textView.setAnimation(animation);

        //setting tampilan full screen
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.SYSTEM_UI_FLAG_FULLSCREEN);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide(); //menghilangkan actionbar
        }

        //Membuat handler untuk mendelay sejenak selama 2000ms / 2 detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //mengalihkan ke activity utama
                startActivity(new Intent(SplashScreen.this, MainActivity.class ));
                //menyelesaikan activity
                finish();
            }
        }, 2000);
    }
}