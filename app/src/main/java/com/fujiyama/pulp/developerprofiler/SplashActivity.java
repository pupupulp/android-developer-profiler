package com.fujiyama.pulp.developerprofiler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;

public class SplashActivity extends AppCompatActivity {

    LinearLayout splashScreen, splashHeader, splashBody;
    EditText githubUserField;
    Button viewProfileButton;


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
    }
}
