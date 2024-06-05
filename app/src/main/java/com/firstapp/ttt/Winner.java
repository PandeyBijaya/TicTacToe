package com.firstapp.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Winner extends AppCompatActivity {

    LinearLayout LL;
    Button restart;
    TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        restart= findViewById(R.id.restart);
        winner= findViewById(R.id.winner);
        LL= findViewById(R.id.LL);


        Intent iNext= new Intent(Winner.this, MainActivity.class);
        Intent getIntent= getIntent();


        String a= getIntent.getStringExtra("winner");

        winner.setText("Winner: Player "+a);
        Toast.makeText(this, "Click Restart to play again", Toast.LENGTH_SHORT).show();

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNext);
                finish();
            }
        });

    }
}