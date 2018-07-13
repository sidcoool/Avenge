package com.example.lenovo.avenge;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class InstructionsPage extends AppCompatActivity {
    MediaPlayer instructions_voice_mp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_page);

        instructions_voice_mp3 = MediaPlayer.create(InstructionsPage.this,R.raw.instruction_voice);
        instructions_voice_mp3.start();

        final CheckBox continue_quiz= findViewById(R.id.checkBox);
        continue_quiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(continue_quiz.isChecked())
                {
                    continue_quiz.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            instructions_voice_mp3.release();
                            Intent in = new Intent(InstructionsPage.this,Menu.class);
                            startActivity(in);
                        }
                    }, 500);
                }
            }
        });
    }
}
