
package com.example.myprofile;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Profile extends AppCompatActivity {

    Button btnMyProfile, btnFacebook, btnInstagram, btnGithub, btnYoutube, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView textView = (TextView) findViewById(R.id.textWelcome); Intent intent = getIntent();
        String string = intent.getStringExtra("name");
        textView.setText("You're logged in as: " + string);

        navigationBar();

        btnMyProfile = (Button) findViewById(R.id.myProfile);
        btnMyProfile.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {openMyProfile();}});
        btnFacebook = (Button) findViewById(R.id.facebook);
        btnFacebook.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {openFacebook();}});
        btnInstagram = (Button) findViewById(R.id.instagram);
        btnInstagram.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {openInstagram();}});
        btnGithub = (Button) findViewById(R.id.github);
        btnGithub.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {openGithub();}});
        btnYoutube = (Button) findViewById(R.id.youtube);
        btnYoutube.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {openYoutube();}});
        btnReturn = (Button) findViewById(R.id.btnBack);
        btnReturn.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {returnToMain();}});
    }

    public void openMyProfile()
    {Intent intent = new Intent(this, MyProfile.class); startActivity(intent);}

    public void returnToMain()
    {Intent intent = new Intent(this, MainActivity.class); startActivity(intent);}

    public void openFacebook()
    {
        //{Uri uri = Uri.parse("fb://profile/rozsAMraven"); Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);}
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/rozsAMraven"));
            startActivity(intent);
            Log.e("Status", "Successful intent - Facebook");
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/rozsAMraven")));
            Log.e("Status", "No application found, open browser.");
        }
    }
    public void openInstagram()
    {Uri uri = Uri.parse("https://www.instagram.com/rozsraven/"); Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);}

    public void openGithub()
    {Uri uri = Uri.parse("https://github.com/rrTio"); Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);}

    public void openYoutube()
    {Uri uri = Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);}

    public void navigationBar()
    {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationBar();
    }
}