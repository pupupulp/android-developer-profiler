package com.fujiyama.pulp.developerprofiler.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.config.DeveloperProfiler;
import com.fujiyama.pulp.developerprofiler.fragment.GistsFragment;
import com.fujiyama.pulp.developerprofiler.fragment.ReposFragment;
import com.fujiyama.pulp.developerprofiler.model.User;
import com.fujiyama.pulp.developerprofiler.utility.FragmentViewPagerAdapter;
import com.fujiyama.pulp.developerprofiler.utility.ImageHandler;
import com.fujiyama.pulp.developerprofiler.utility.ImageTransform;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private AppBarLayout profileBar;

    private TabLayout profileTabs;
    private ViewPager profilePager;

    private ImageView profileImage;
    private TextView profileName;
    private TextView profileUser;
    private TextView profileFollowers;
    private TextView profileFollowing;
    private TextView profileBio;
    private TextView profileLocation;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileBar = (AppBarLayout) findViewById(R.id.profileBar);
        profileTabs = (TabLayout) findViewById(R.id.profileTabs);
        profilePager = (ViewPager) findViewById(R.id.profilePager);

        user = (User) DeveloperProfiler.getUser();

        profileImage = (ImageView) findViewById(R.id.profilePicture);
        Picasso.get()
                .load(user.getAvatarUrl().toString())
                .transform(new ImageTransform())
                .into(profileImage);

        profileName = (TextView) findViewById(R.id.profileName);
        profileName.setText(user.getFullName());

        profileUser = (TextView) findViewById(R.id.profileUser);
        profileUser.setText(user.getUsername());

        profileFollowers = (TextView) findViewById(R.id.profileFollowers);
        profileFollowers.setText(user.getFollowers().toString());

        profileFollowing = (TextView) findViewById(R.id.profileFollowing);
        profileFollowing.setText(user.getFollowing().toString());

        profileBio = (TextView) findViewById(R.id.profileBio);
        profileBio.setText(user.getBio());

        profileLocation = (TextView) findViewById(R.id.profileLocation);
        profileLocation.setText(user.getLocation());

        profileLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getLocation() != null) {
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);
                }
            }
        });

        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReposFragment(), "Repos\n" + user.getPublicRepos());
        adapter.addFragment(new GistsFragment(), "Gists\n" + user.getPublicGists());

        profilePager.setAdapter(adapter);
        profileTabs.setupWithViewPager(profilePager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final AppBarLayout profileBar = (AppBarLayout) findViewById(R.id.profileBar);
        profileBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int availableHeight = profileBar.getMeasuredHeight();

                Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash_background);
                originalBitmap = Bitmap.createScaledBitmap(originalBitmap, profileBar.getMeasuredWidth(), profileBar.getMeasuredHeight(), true);

                Bitmap blurredBitmap = ImageHandler.blur(ProfileActivity.this, originalBitmap);

                profileBar.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

                if(availableHeight>0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        profileBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        //noinspection deprecation
                        profileBar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });


    }


}
