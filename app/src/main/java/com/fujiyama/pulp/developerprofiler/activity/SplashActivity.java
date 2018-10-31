package com.fujiyama.pulp.developerprofiler.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.config.DeveloperProfiler;
import com.fujiyama.pulp.developerprofiler.rest.APIClient;
import com.fujiyama.pulp.developerprofiler.rest.config.Constants;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.GistService;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.RepoService;
import com.fujiyama.pulp.developerprofiler.rest.endpoint.UserService;
import com.fujiyama.pulp.developerprofiler.rest.model.Commit;
import com.fujiyama.pulp.developerprofiler.rest.model.Gist;
import com.fujiyama.pulp.developerprofiler.rest.model.Repo;
import com.fujiyama.pulp.developerprofiler.rest.model.User;
import com.fujiyama.pulp.developerprofiler.utility.ImageHandler;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SplashActivity.class.getSimpleName();

    private Bitmap originalBitmap;
    private Bitmap blurredBitmap;

    private LinearLayout splashScreen, splashHeader, splashBody;
    private EditText githubUserField;
    private Button viewProfileButton;

    private Animation uptodown, downtoup;

    private ProgressDialog progress;
    private boolean retrievedUser = false, retrievedRepos = false, retrievedGists = false, retrievedCommits = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash_background);
        blurredBitmap = ImageHandler.blur(this, originalBitmap);

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

            progress = new ProgressDialog(SplashActivity.this);
            progress.setMessage("Retrieving user details...");
            progress.setCancelable(false);
            progress.show();

            getUserDetails();
        }
    }

    private void getUserDetails() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                UserService userService = APIClient.createService(UserService.class, Constants.TOKEN);
                Call<User> callUser = userService.getUser(githubUserField.getText().toString());

                try {
                    DeveloperProfiler.setUser(callUser.execute().body());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                RepoService repoService = APIClient.createService(RepoService.class);
                Call<ArrayList<Repo>> callRepo = repoService.getRepos(githubUserField.getText().toString());

                try {
                    DeveloperProfiler.setRepos(callRepo.execute().body());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (Repo repo: DeveloperProfiler.getRepos()) {
                    Call<ArrayList<Commit>> callRepoCommits = repoService.getRepoCommits(githubUserField.getText().toString(), repo.getName());
                    try {

                        repo.setCommits(callRepoCommits.execute().body());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                GistService gistService = APIClient.createService(GistService.class);
                Call<ArrayList<Gist>> callGist = gistService.getGists(githubUserField.getText().toString());

                try {
                    DeveloperProfiler.setGists(callGist.execute().body());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startProfile();
            }
        }, 1000);
    }

    private synchronized void startProfile() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }
}
