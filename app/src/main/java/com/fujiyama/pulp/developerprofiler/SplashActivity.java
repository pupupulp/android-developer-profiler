package com.fujiyama.pulp.developerprofiler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fujiyama.pulp.developerprofiler.model.User;
import com.fujiyama.pulp.developerprofiler.rest.APIClient;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.UserService;
import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SplashActivity.class.getSimpleName();

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
        if(githubUserField.getText().toString().equals("")) {
            Toast.makeText(SplashActivity.this, "Please input a user", Toast.LENGTH_SHORT).show();
        } else {
            UserService userService = APIClient.createService(UserService.class);
            Call<User> call = userService.getUser(githubUserField.getText().toString());

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(SplashActivity.this, "Successfully retrieved user.", Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    User user = response.body();
                    Bundle userData = new Bundle();

                    userData.putSerializable("user", user);
                    intent.putExtras(userData);

                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(SplashActivity.this, "Failed to get user.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
