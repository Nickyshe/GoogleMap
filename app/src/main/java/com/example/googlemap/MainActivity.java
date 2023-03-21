package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText source, destination;
    Button openNav;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        openNav = findViewById(R.id.open_nav);

        openNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String xSource = source.getText().toString();
                String yDestination = destination.getText().toString();
                if(xSource.equals("") && yDestination.equals("")){
                    Toast.makeText(MainActivity.this, "Enter both source and destination", Toast.LENGTH_SHORT).show();
                }else{
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + xSource + "/" + yDestination);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }
        });
    }
}