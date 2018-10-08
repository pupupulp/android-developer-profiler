package com.fujiyama.pulp.developerprofiler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fujiyama.pulp.developerprofiler.model.User;
import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;
import com.fujiyama.pulp.developerprofiler.utilities.ImageTransform;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle userData = getIntent().getExtras();
        User user = (User) userData.getSerializable("user");

        ImageView profileImage = (ImageView) findViewById(R.id.profileImage);
        Picasso.get()
                .load(user.getAvatarUrl().toString())
                .transform(new ImageTransform())
                .into(profileImage);

        TextView profileName = (TextView) findViewById(R.id.profileName);
        profileName.setText(user.getFullName());

        TextView profileBio = (TextView) findViewById(R.id.profileBio);
        profileBio.setText(user.getBio());

        TextView profileRepos = (TextView) findViewById(R.id.profileRepos);
        profileRepos.setText(user.getPublicRepos().toString());

        TextView profileGists = (TextView) findViewById(R.id.profileGists);
        profileGists.setText(user.getPublicGists().toString());

        TextView profileFollowers = (TextView) findViewById(R.id.profileFollowers);
        profileFollowers.setText(user.getFollowers().toString());

    }
}
