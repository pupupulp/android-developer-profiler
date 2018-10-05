package com.fujiyama.pulp.developerprofiler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout splashScreen, splashHeader, splashBody;
    EditText githubUserField;
    Button viewProfileButton;

    Animation uptodown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash_background);
        Bitmap blurredBitmap = ImageHandler.blur(this, originalBitmap);

        splashScreen = (LinearLayout) findViewById(R.id.splashScreen);
        splashScreen.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        splashHeader = (LinearLayout) findViewById(R.id.splashHeader);
        splashBody = (LinearLayout) findViewById(R.id.splashBody);

        githubUserField = (EditText) findViewById(R.id.githubUserField);
        viewProfileButton = (Button) findViewById(R.id.viewProfileButton);

        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);

        splashHeader.setAnimation(uptodown);
        splashBody.setAnimation(downtoup);

        viewProfileButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);

        if(githubUserField.getText().toString().equals("")) {
            Toast.makeText(SplashActivity.this, "Please input a user", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(intent);
        }
    }
}
