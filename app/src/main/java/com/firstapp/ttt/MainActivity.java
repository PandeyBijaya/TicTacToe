package com.firstapp.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, reset;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);
        reset= findViewById(R.id.reset);

        reset();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


    }

    public void reset()
    {
        btn1.setText(" ");
        btn2.setText(" ");
        btn3.setText(" ");
        btn4.setText(" ");
        btn5.setText(" ");
        btn6.setText(" ");
        btn7.setText(" ");
        btn8.setText(" ");
        btn9.setText(" ");
        count=0;
        start();
    }

    public void start()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set(btn9);
            }
        });
    }
    public void set(Button button)
    {
        if(button.getText().toString().equals(" "))
        {
            if (count%2==0) {
                button.setText("X");
                button.setTextColor(Color.BLUE);
                count++;
            }
            else {
                button.setText("O");
                count++;
                button.setTextColor(Color.GREEN);
            }

        }
        check();
    }

    public void check()
    {
        String a1= btn1.getText().toString();
        String a2= btn2.getText().toString();
        String a3= btn3.getText().toString();
        String a4= btn4.getText().toString();
        String a5= btn5.getText().toString();
        String a6= btn6.getText().toString();
        String a7= btn7.getText().toString();
        String a8= btn8.getText().toString();
        String a9= btn9.getText().toString();

        if(a1.equals(a2) && a2.equals(a3) && !a2.equals(" "))
            output(a1);
        else if(a6.equals(a4) && a6.equals(a5) && !a6.equals(" "))
            output(a6);
        else if(a7.equals(a8) && a8.equals(a9) && !a7.equals(" "))
            output(a7);
        else if(a1.equals(a4) && a4.equals(a7) && !a1.equals(" "))
            output(a4);
        else if(a2.equals(a5) && a5.equals(a8) && !a5.equals(" "))
            output(a2);
        else if(a3.equals(a6) && a3.equals(a9) && !a3.equals(" "))
            output(a3);
        else if(a1.equals(a5) && a5.equals(a9) && !a5.equals(" "))
            output(a1);
        else if(a3.equals(a5) && a5.equals(a7) && !a7.equals(" "))
            output(a3);
        else if(count%9==0) {
            Toast.makeText(this, "The game was a draw", Toast.LENGTH_SHORT).show();
            reset();
        }
        else
            start();
    }

    public void output(String n)
    {
        Intent iNext= new Intent(MainActivity.this, Winner.class);

        iNext.putExtra("winner",n);
        startActivity(iNext);
        finish();
            }
}