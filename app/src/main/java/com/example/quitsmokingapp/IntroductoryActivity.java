package com.example.quitsmokingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.quitsmokingapp.R;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView appName,splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        appName = findViewById(R.id.appname);
        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-1900).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        Intent intent = new Intent(IntroductoryActivity.this, Login.class);
        startActivity(intent);
    }

//    void navigateToSecondActivity(){
//        finish();
//        Intent intent = new Intent(IntroductoryActivity.this, Login.class);
//        startActivity(intent);
//    }

}