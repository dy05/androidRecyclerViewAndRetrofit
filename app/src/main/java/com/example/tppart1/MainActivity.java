package com.example.tppart1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView iconGoogle;
    ImageView iconApple;
    ImageView iconFacebook;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        iconGoogle = findViewById(R.id.googleIcon);
        iconFacebook = findViewById(R.id.facebookIcon);
        iconApple = findViewById(R.id.appleIcon);

        iconGoogle.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Google ID", Toast.LENGTH_SHORT).show());
        iconFacebook.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Facebook ID", Toast.LENGTH_SHORT).show());
        iconApple.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Apple ID", Toast.LENGTH_SHORT).show());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonnageActivity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(MainActivity.this,"Click on login to view the other tp", Toast.LENGTH_SHORT).show();
    }
}
