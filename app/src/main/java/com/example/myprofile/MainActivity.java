package com.example.myprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); navigationBar();

        final EditText editText = (EditText) findViewById(R.id.TextName);
        Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener()
        {@Override public void onClick(View v) {String string = editText.getText().toString(); NextView(string);}});

        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit ??");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener()
                {@Override public void onClick(DialogInterface dialog, int which) {finish();}});

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                {@Override public void onClick(DialogInterface dialog, int which)
                {dialog.dismiss();}});

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

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
    
    public void NextView(String string)
    {Intent intent = new Intent(this, Profile.class); intent.putExtra("name", string); startActivity(intent);}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}