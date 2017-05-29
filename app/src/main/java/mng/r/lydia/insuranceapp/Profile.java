package mng.r.lydia.insuranceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity {

    ImageButton profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = (ImageButton) findViewById(R.id.profileImage);

        profileImage.setBackgroundResource(R.drawable.profile_icon);
    }
}
