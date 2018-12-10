package com.example.samira.testapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonsave=findViewById(R.id.btnsave);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("name","Samira");
                String s=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name","not save");
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });



        Button button=findViewById(R.id.btnexit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Warning");
                alertDialog.setMessage("Exit from  Program?");
                alertDialog.setButton(alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    }
                });
                alertDialog.show();
            }
        });
    }
}
