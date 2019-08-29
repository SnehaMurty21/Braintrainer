package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answer=new ArrayList<Integer>();

    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score=0;
    int numberofQuestion=0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;


    public void playAgain(View view){
        score=0;
        numberofQuestion=0;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestion));
        timerTextView.setText("30s");
        resultTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        randomQuestion();
        gameLayout.setVisibility(View.VISIBLE);


        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + "s" );
            }

            @Override
            public void onFinish() {

                gameLayout.setVisibility(View.INVISIBLE);
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText("Done!! Your Score is " + Integer.toString(score)+"/"+Integer.toString(numberofQuestion));
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void choseAnswer(View view){
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
           resultTextView.setText("Correct Answer");
           score++;
        }else{
           resultTextView.setText("Wrong answer!! try again");
        }
        numberofQuestion++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestion));
        randomQuestion();
    }

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView));

    }

    public void randomQuestion(){

        Random random=new Random();

        int numberOfMethods=4;

        switch (random.nextInt(numberOfMethods)){
            case 0:
                newQuestionAdd();
                break;
            case 1:
                newQuestionSubstract();
                break;
            case 2:
                newQuestionMultiply();
                break;
             default:
                 newQuestionAdd();
        }
    }

    public void newQuestionAdd(){
        Random rand= new Random();

        int a=rand.nextInt(21);

        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();

        for(int i=0; i<4; i++)
        {
            if(i==locationOfCorrectAnswer)
            {
                answer.add(a+b);
            }else
            {
                int wrongAnswer=rand.nextInt(41);

                while(wrongAnswer==a+b)
                {
                    wrongAnswer=rand.nextInt(41);
                }

                answer.add(wrongAnswer);

            }


        }

        button0.setText(Integer.toString(answer.get(0)));

        button1.setText(Integer.toString(answer.get(1)));

        button2.setText(Integer.toString(answer.get(2)));

        button3.setText(Integer.toString(answer.get(3)));


    }

    public void newQuestionSubstract(){
        Random rand= new Random();

        int a=rand.nextInt(21);

        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "-" + Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();

        for(int i=0; i<4; i++)
        {
            if(i==locationOfCorrectAnswer)
            {
                answer.add(a-b);
            }else
            {
                int wrongAnswer=rand.nextInt(41);

                while(wrongAnswer==a-b)
                {
                    wrongAnswer=rand.nextInt(41);
                }

                answer.add(wrongAnswer);

            }


        }

        button0.setText(Integer.toString(answer.get(0)));

        button1.setText(Integer.toString(answer.get(1)));

        button2.setText(Integer.toString(answer.get(2)));

        button3.setText(Integer.toString(answer.get(3)));


    }



    public void newQuestionMultiply(){
        Random rand= new Random();

        int a=rand.nextInt(21);

        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "*" + Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();

        for(int i=0; i<4; i++)
        {
            if(i==locationOfCorrectAnswer)
            {
                answer.add(a*b);
            }else
            {
                int wrongAnswer=rand.nextInt(81);

                while(wrongAnswer==a*b)
                {
                    wrongAnswer=rand.nextInt(81);
                }

                answer.add(wrongAnswer);

            }


        }

        button0.setText(Integer.toString(answer.get(0)));

        button1.setText(Integer.toString(answer.get(1)));

        button2.setText(Integer.toString(answer.get(2)));

        button3.setText(Integer.toString(answer.get(3)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumTextView= findViewById(R.id.sumTextView);
        button0= findViewById(R.id.button0);
        button1= findViewById(R.id.button1);
        button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        goButton = findViewById(R.id.goButton);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView= findViewById(R.id.scoreTextView);
        timerTextView= findViewById(R.id.timerTextView);
        playAgainButton= findViewById(R.id.playAgainButton);
        gameLayout=findViewById(R.id.gameLayout);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);




    }
}
