package com.example.lenovo.avenge;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.LayoutInflater;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button takequiz = (Button)findViewById(R.id.takequiz);
        Button instu = (Button)findViewById(R.id.instru);
        Button highscore = (Button)findViewById(R.id.highscore);

        takequiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Menu.this,Hero_List.class);
                startActivity(in);
            }
        });

        instu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Menu.this,HighScores2.class);
                startActivity(in);
            }
        });
    }
}
