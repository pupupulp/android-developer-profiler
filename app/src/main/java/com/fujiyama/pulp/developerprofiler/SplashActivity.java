package com.fujiyama.pulp.developerprofiler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash_background);
        Bitmap blurredBitmap = ImageHandler.blur(this, originalBitmap);

        LinearLayout splashscreenView = (LinearLayout) findViewById(R.id.splashscreen);
        splashscreenView.setBackground(new BitmapDrawable(getResources(), blurredBitmap));
    }
}
