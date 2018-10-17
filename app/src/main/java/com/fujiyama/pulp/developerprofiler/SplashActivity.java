package com.fujiyama.pulp.developerprofiler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fujiyama.pulp.developerprofiler.model.Repo;
import com.fujiyama.pulp.developerprofiler.model.User;
import com.fujiyama.pulp.developerprofiler.rest.APIClient;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.RepoService;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.UserService;
import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SplashActivity.class.getSimpleName();

    LinearLayout splashScreen, splashHeader, splashBody;
    EditText githubUserField;
    Button viewProfileButton;

    Animation uptodown, downtoup;

    User user;
    List<Repo> repo;

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

                    user = response.body();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(SplashActivity.this, "Failed to get user.", Toast.LENGTH_SHORT).show();
                }
            });

            RepoService repoService = APIClient.createService(RepoService.class);
            Call<List<Repo>> callRepo = repoService.getRepos(githubUserField.getText().toString());

            callRepo.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    Toast.makeText(SplashActivity.this, "Successfully retrieved user.", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    repo = response.body();
                    Bundle userData = new Bundle();

                    userData.putSerializable("user", user);
//                    userData.putSerializable("user", repo);
                    intent.putExtras(userData);

                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    Toast.makeText(SplashActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
