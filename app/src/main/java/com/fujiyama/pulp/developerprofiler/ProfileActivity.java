package com.fujiyama.pulp.developerprofiler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.fujiyama.pulp.developerprofiler.model.User;
import com.fujiyama.pulp.developerprofiler.utilities.ImageHandler;
import com.fujiyama.pulp.developerprofiler.utilities.ImageTransform;
import com.squareup.picasso.Picasso;

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

    }
}
