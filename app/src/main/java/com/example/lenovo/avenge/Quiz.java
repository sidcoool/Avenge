package com.example.lenovo.avenge;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    int counter1=2,counter2=0;
    boolean encounter=true;
    MediaPlayer instructions_voice_mp3;

    //CAPTAIN AMERICA
    String [] captain_america_questions;
    String [][] captain_america_options;
    int [] captain_america_correct_ans;


    // IRON MAN
    String [] iron_man_questions ;
    String [][] iron_man_options;
    int [] iron_man_correct_ans;


     TextView captain_quiz;
     ImageView hero_img;
     RadioButton option1;
     RadioButton option2;
     RadioButton option3;
     RadioButton option4;
     RadioGroup radioGroup;

    private void  ques_and_ans() {
        //CAPTAIN AMERICA
        captain_america_questions = new String[]{
                "What is Cap's shield made from?",
                "In Marvels Civil War Storyline, Steve Rogers fought for what?",
                "This Pic is from which Marvel movie?",
                "What group of superheroes did Captain America team up with before the Avengers?"

        };

        captain_america_options = new String[][]{
                {"Vibranium", "Titanium", "Iron", "Adamantium"},
                {"Unifying of heroes under one advanced military unit", "The US Govenment's registration of masked heroes identities", "The freedom of heroes to keep thier identies secret, as had been tradition", "Charges imposed by Government on Avengers"},
                {"Captin Amerca - Civil War", "Captain America - Winter Soldier", "Avengers - Age of Ultron", "Captain America - The First Avenger"},
                {"The Invaders", "The Justice League", "The Hailors", "None of These"}
        };

        captain_america_correct_ans = new int [] {2,1,3,2,1};





        // IRON MAN
        iron_man_questions = new String[]{
                "First name of Iron Man?",
                "Who plays Iron Man?",
                "What is Pepper full name?",
                "What is \"Pepper\" allergic to?",
                "What does Tony use in the cave to prevent shrapnel from entering his heart?",
                "How many tons can Iron Man's suit lift when fully powered?",
                "Who helped Iron Man escape captivity?",
                "In the above pic what is Iron Man carrying?"
        };

        iron_man_options = new String[][]{
                {"Tony","John","Peter","Stark"},
                {"Robert Downey Jr.","Jeff Bridges"," Howard Stark" ,"Samuel L. Jackson"},
                {"Gwyneth \"Pepper\" Potts" , "Mary \"Pepper\" Potts" , "Virginia \"Pepper\" Potts" , "Mandy\"Pepper\" Potts"},
                {"Apples", "Strawberries","Iron" ,"Tony's humour"},
                {"Hydro technology" , "Wind power" , "Arc Reactor technology" , "Avengers Reactor technology"},
                {"70-75 tons","over 1000 tons","exactly 150 tons","over 100 tons"},
                {"Tio Minosin","Ho Yinsen","Bin Yinsen","None of these"},
                {"Rocket","Nuclear Missile","Electric Pole","Space Ship"}
        };

        iron_man_correct_ans = new int[] {1,1,3,2,3,2,2,2};

    }
    private void findviewID(){
        captain_quiz  = (TextView)findViewById(R.id.captain_quiz);
        hero_img = (ImageView) findViewById(R.id.hero_img);
        option1 = (RadioButton)findViewById(R.id.option1);
        option2 = (RadioButton)findViewById(R.id.option2);
        option3 = (RadioButton)findViewById(R.id.option3);
        option4 = (RadioButton)findViewById(R.id.option4);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
    }

    public void right(TextView option) {
        option.setBackgroundColor(Color.GREEN);
        if(encounter)
        {
            counter2=counter2+4;
            encounter=false;
        }
    }
    public void wrong(final TextView option) {
        option.setBackgroundColor(Color.RED);
        option.postDelayed(new Runnable() {

            @Override
            public void run() {
                option.setBackgroundColor(Color.parseColor("#E4E7D0"));
            }
        }, 1000);
        if(encounter)
        {
            counter2=counter2-1;
            encounter=false;
        }
    }
    public void set(int j,int k,TextView option) {
        if(j==k)
            right(option);
        else
            wrong(option);
    }

    public void large_view(int index1,String[] hero_q,String[][] hero_o) {
        counter1=counter1+1;
        encounter=true;
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
        captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28f);
        option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
        captain_quiz.setText(hero_q[index1]);
        option1.setText(hero_o[index1][0]);
        option2.setText(hero_o[index1][1]);
        option3.setText(hero_o[index1][2]);
        option4.setText(hero_o[index1][3]);
    }
    public void medium_view(int index1,String [] hero_q,String [][] hero_o) {
        counter1=counter1+1;
        encounter=true;
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
        captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f);
        option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
        captain_quiz.setText(hero_q[index1]);
        option1.setText(hero_o[index1][0]);
        option2.setText(hero_o[index1][1]);
        option3.setText(hero_o[index1][2]);
        option4.setText(hero_o[index1][3]);
    }
    public void medium2_view(int index1,String [] hero_q,String [][] hero_o) {
        counter1=counter1+1;
        encounter=true;
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f);
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f);
        captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
        option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
        captain_quiz.setText(hero_q[index1]);
        option1.setText(hero_o[index1][0]);
        option2.setText(hero_o[index1][1]);
        option3.setText(hero_o[index1][2]);
        option4.setText(hero_o[index1][3]);
    }
    public void small_view(int index1,String [] hero_q,String [][] hero_o) {
        counter1=counter1+1;
        encounter=true;
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
        option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
        captain_quiz.setText(hero_q[index1]);
        option1.setText(hero_o[index1][0]);
        option2.setText(hero_o[index1][1]);
        option3.setText(hero_o[index1][2]);
        option4.setText(hero_o[index1][3]);
    }
    public void small2_view(int index1,String [] hero_q,String [][] hero_o) {
        counter1=counter1+1;
        encounter=true;
        option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
        option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
        option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
        option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
        captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 23f);
        option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
        option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
        captain_quiz.setText(hero_q[index1]);
        option1.setText(hero_o[index1][0]);
        option2.setText(hero_o[index1][1]);
        option3.setText(hero_o[index1][2]);
        option4.setText(hero_o[index1][3]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ques_and_ans();
        findviewID();

       LayoutInflater lf = getLayoutInflater();
        final View instruct = lf.inflate(R.layout.activity_instructions, (ViewGroup)findViewById(R.id.instructions_inflate));
         final RelativeLayout r = (RelativeLayout)findViewById(R.id.quiz_relative_layout);
        r.addView(instruct);

        instructions_voice_mp3 = MediaPlayer.create(Quiz.this,R.raw.instruction_voice);
        instructions_voice_mp3.start();


        final CheckBox continue_quiz= (CheckBox)findViewById(R.id.checkBox);
        continue_quiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(continue_quiz.isChecked())
                {
                    continue_quiz.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            instructions_voice_mp3.release();
                            r.removeView(instruct);
                        }
                    }, 500);
                }
            }
        });

        final Intent i = new Intent(Quiz.this,Score.class);



        ImageButton next = (ImageButton)findViewById(R.id.next);
        final Intent in = getIntent();
        String stringVal = in.getStringExtra("hero_name");

        switch (stringVal) {
            case "1":
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i)
                        {
                            case R.id.option1:
                                set(1,captain_america_correct_ans[0],option1);
                                break;

                            case R.id.option2:
                                set(2,captain_america_correct_ans[0],option2);
                                break;

                            case R.id.option3:
                                set(3,captain_america_correct_ans[0],option3);
                                break;

                            case R.id.option4:
                                set(4,captain_america_correct_ans[0],option4);
                                break;

                        }
                    }
                });

             next.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     switch (counter1)
                     {
                         case 2:
                             //question2 = "What is Cap's shield made from?";
                             radioGroup.clearCheck();
                             large_view(0,captain_america_questions,captain_america_options);
                             hero_img.setImageResource(R.drawable.captain_shied);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             set(1,captain_america_correct_ans[1],option1);
                                             break;

                                         case R.id.option2:
                                             set(2,captain_america_correct_ans[1],option2);
                                             break;

                                         case R.id.option3:
                                             set(3,captain_america_correct_ans[1],option3);
                                             break;

                                         case R.id.option4:
                                             set(4,captain_america_correct_ans[1],option4);
                                             break;
                                     }
                                 }
                             });

                             break;

                         case 3:
                             //question3 = "In Marvels Civil War Storyline, Steve Rogers fought for what?";
                             radioGroup.clearCheck();
                             small_view(1,captain_america_questions,captain_america_options);
                             hero_img.setImageResource(R.drawable.captain);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             set(1,captain_america_correct_ans[2],option1);
                                             break;

                                         case R.id.option2:
                                             set(2,captain_america_correct_ans[2],option2);
                                             break;

                                         case R.id.option3:
                                             set(3,captain_america_correct_ans[2],option3);
                                             break;

                                         case R.id.option4:
                                             set(4,captain_america_correct_ans[2],option4);
                                             break;
                                     }
                                 }
                             });
                             break;

                         case 4:
                             //question4 = "This Pic is from which Marvel movie?";
                             radioGroup.clearCheck();
                             small2_view(2,captain_america_questions,captain_america_options);
                         hero_img.setImageResource(R.drawable.captain_helicopter);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             set(1,captain_america_correct_ans[3],option1);
                                             break;

                                         case R.id.option2:
                                             set(2,captain_america_correct_ans[3],option2);
                                             break;

                                         case R.id.option3:
                                             set(3,captain_america_correct_ans[3],option3);
                                             break;

                                         case R.id.option4:
                                             set(4,captain_america_correct_ans[3],option4);
                                             break;
                                     }
                                 }
                             });
                         break;

                         case 5:
                            //question5 = "What group of superheroes did Captain America team up with before the Avengers?";
                             radioGroup.clearCheck();
                             small2_view(3,captain_america_questions,captain_america_options);
                             hero_img.setImageResource(R.drawable.captian4);
                             radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                 @Override
                                 public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                     switch (i)
                                     {
                                         case R.id.option1:
                                             set(1,captain_america_correct_ans[4],option1);
                                             break;

                                         case R.id.option2:
                                             set(2,captain_america_correct_ans[4],option2);
                                             break;

                                         case R.id.option3:
                                             set(3,captain_america_correct_ans[4],option3);
                                             break;

                                         case R.id.option4:
                                             set(4,captain_america_correct_ans[4],option4);
                                             break;
                                     }
                                 }
                             });
                             break;


                         case 6:
                             i.putExtra("final_score",counter2);
                             startActivity(i);
                             break;

                     }

                 }
             });

            break;




























            case "2":
                //First name of Iron Man?
                hero_img.setImageResource(R.drawable.iron_man2);
                counter1=2;
                counter2=0;
                encounter=true;
                option1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
                option2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
                option3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
                option4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27f);
                captain_quiz.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28f);
                option1.setBackgroundColor(Color.parseColor("#E4E7D0"));
                option2.setBackgroundColor(Color.parseColor("#E4E7D0"));
                option3.setBackgroundColor(Color.parseColor("#E4E7D0"));
                option4.setBackgroundColor(Color.parseColor("#E4E7D0"));
                captain_quiz.setText(iron_man_questions[0]);
                option1.setText(iron_man_options[0][0]);
                option2.setText(iron_man_options[0][1]);
                option3.setText(iron_man_options[0][2]);
                option4.setText(iron_man_options[0][3]);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i)
                        {
                            case R.id.option1:
                                set(1,iron_man_correct_ans[0],option1);
                                break;

                            case R.id.option2:
                                set(2,iron_man_correct_ans[0],option2);
                                break;

                            case R.id.option3:
                                set(3,iron_man_correct_ans[0],option3);
                                break;

                            case R.id.option4:
                                set(4,iron_man_correct_ans[0],option4);
                                break;

                        }
                    }
                });

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        switch (counter1)
                        {
                            case 2:
                                //Who plays Iron Man?
                                radioGroup.clearCheck();
                                large_view(1,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.iron_man5);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {

                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[1],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[1],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[1],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[1],option4);
                                                break;
                                        }
                                    }
                                });

                                break;

                            case 3:
                                //What is Pepper full name?
                                radioGroup.clearCheck();
                                counter1=counter1+1;
                                encounter=true;
                                large_view(2,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.pepper1);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {
                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[2],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[2],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[2],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[2],option4);
                                                break;
                                        }
                                    }
                                });
                                break;

                            case 4:
                                //What is "Pepper" allergic to?
                                radioGroup.clearCheck();
                                counter1=counter1+1;
                                encounter=true;
                                large_view(3,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.pepper2);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {
                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[3],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[3],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[3],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[3],option4);
                                                break;
                                        }
                                    }
                                });
                                break;

                            case 5:
                                //What does Tony use in the cave to prevent shrapnel from entering his heart?
                                radioGroup.clearCheck();
                                small2_view(4,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.arc_reactor);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {
                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[4],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[4],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[4],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[4],option4);
                                                break;
                                        }
                                    }
                                });
                                break;

                            case 6:
                                //How many tons can Iron Man's suit lift when fully powered?
                                radioGroup.clearCheck();
                                medium_view(5,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.iron_man3);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {

                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[5],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[5],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[5],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[5],option4);
                                                break;
                                        }
                                    }
                                });
                                break;

                            case 7:
                                //Who helped Iron Man escape captivity?
                                radioGroup.clearCheck();
                                large_view(6,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.iron_man_old);
                                captain_quiz.setText(iron_man_questions[6]);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {

                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[6],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[6],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[6],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[6],option4);
                                                break;
                                        }
                                    }
                                });
                                break;

                            case 8:
                                //In the above pic what is Iron Man carrying?
                                radioGroup.clearCheck();
                                large_view(7,iron_man_questions,iron_man_options);
                                hero_img.setImageResource(R.drawable.iron_man6);
                                captain_quiz.setText(iron_man_questions[7]);
                                option1.setText(iron_man_options[7][0]);
                                option2.setText(iron_man_options[7][1]);
                                option3.setText(iron_man_options[7][2]);
                                option4.setText(iron_man_options[7][3]);
                                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                        switch (i)
                                        {

                                            case R.id.option1:
                                                set(1,iron_man_correct_ans[7],option1);
                                                break;

                                            case R.id.option2:
                                                set(2,iron_man_correct_ans[7],option2);
                                                break;

                                            case R.id.option3:
                                                set(3,iron_man_correct_ans[7],option3);
                                                break;

                                            case R.id.option4:
                                                set(4,iron_man_correct_ans[7],option4);
                                                break;
                                        }
                                    }
                                });
                                break;



                            case 9:
                                i.putExtra("final_score",counter2);
                                startActivity(i);
                                break;

                        }

                    }
                });

                break;

        }

        }

}
