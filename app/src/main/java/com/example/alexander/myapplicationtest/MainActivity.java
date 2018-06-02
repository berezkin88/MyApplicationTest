package com.example.alexander.myapplicationtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        set up the second activity button
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener((view) -> {

//            creating an intent and passing text to the second activity
            Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
            startIntent.putExtra("com.example.alexander.myapplicationtest.SOMETHING", "HELLO WORLD!");
            startActivity(startIntent);
        });

//        attempt to launch the activity outside of our app (Google button)
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener((view) -> {

            String google = "https://www.dou.ua";
            Uri googleAdress = Uri.parse(google);

            Intent goToGoogle = new Intent(Intent.ACTION_VIEW, googleAdress);
            if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                startActivity(goToGoogle);
            }
        });
    }
}
