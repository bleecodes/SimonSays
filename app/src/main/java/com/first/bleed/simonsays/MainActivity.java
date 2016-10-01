package com.first.bleed.simonsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button greenButton;
    Button yellowButton;
    Button redButton;
    Button blueButton;
    Button startButton;
    String TAG = "MainActivity";
    int timeToWait = 1*1000;
    Timer waitTimer;
    TimerTask greenTimerTask;
    List<colors> colorSequence;
    private colors currentColor;
    private List<colors> userColorSequence;
    private boolean userturn = false;
    TimerTask yellowTimerTask;

    //NEEDS TO START THE GAME
    //USER NEEDS TO CLICK THE SAME NUMBER OF COLORS THAT WERE SHOWN
    //RESTART THE GAME

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFindView();
        initListeners();
        timerTasks();
        waitTimer = new Timer();
        colorSequence = new ArrayList<>();
        userColorSequence = new ArrayList<>();


    }
    public void initFindView(){
        greenButton = (Button) findViewById(R.id.bn_green);
        yellowButton = (Button) findViewById(R.id.bn_yellow);
        redButton = (Button) findViewById(R.id.bn_red);
        blueButton = (Button) findViewById(R.id.bn_blue);
        startButton = (Button) findViewById(R.id.bn_start);
    }
    public void initListeners(){
        startButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startColorSequence();
               userturn = true;
            }
        }));
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor = colors.GREEN;
                userPlaysSequence();

            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor = colors.YELLOW;
                userPlaysSequence();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor = colors.RED;
                userPlaysSequence();
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor = colors.BLUE;
                userPlaysSequence();
            }
        });

    }

    public void timerTasks(){

//        yellowTimerTask = new TimerTask() {
    }

    private void userPlaysSequence() {
        if (userturn) {
            userColorSequence.add(currentColor);
            if(userColorSequence.size() == colorSequence.size())
            {userturn = false;
            Log.d(TAG, "made it through turn");
            resetUserSequence();}
        }
    }
    public void startColorSequence(){


        Random rnd = new Random();

                int nextColor = rnd.nextInt(4);
                colorSequence.add(choiceColor(1));

                for(int i = 0; i < colorSequence.size(); i++)
                {

//                    SystemClock.sleep(500);
                    //PUT SWITCH INTO A TIMER TO SPACE OUT TIMERS?
                    switch (colorSequence.get(i)) {

                        case GREEN:

                            greenTimerTask = new TimerTask(){
                                @Override
                                public void run() {

                                    greenButton.setBackgroundColor(getResources().getColor(R.color.dullgreen));
//                                    android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
                                }


                            };

                            runOnUiThread(greenTimerTask);
                            //waitTimer.schedule(greenTimerTask,timeToWait);
                            greenButton.setBackgroundColor(getResources().getColor(R.color.green));
//                            greenButton.startAnimation(mAnimation);
//                            greenButton.clearAnimation();

                            break;

                        case YELLOW:
//                            yellowButton.startAnimation(mAnimation);
//                            yellowButton.clearAnimation();
                            break;

                        case RED:
//                            redButton.startAnimation(mAnimation);
//                            redButton.clearAnimation();
                            break;

                        case BLUE:
//                            blueButton.startAnimation(mAnimation);
//                            blueButton.clearAnimation();
//                            blueButton.setBackgroundColor(getResources().getColor(R.color.blue));
//                            taskWaitTimer = new TimerTask() {
//                                @Override
//                                public void run() {
//                                    blueButton.setBackgroundColor(getResources().getColor(R.color.dullblue));
//                                    //blueButton.setBackgroundResource(R.drawable.on_click_blue);
//                                }
//                            };waitTimer.schedule(taskWaitTimer,1000);
                            //blueButton.setBackgroundResource(R.drawable.bg_blue);
                            //blueColorChange();

//                            blueButton.setBackgroundColor(getResources().getColor(R.color.blue));
                            break;

                    }
                }

    }

    private void blueColorChange() {

    }

//    private void redColorChange() {
//        redButton.setBackgroundResource(R.drawable.bg_red);
////        SystemClock.sleep(1000);
//        redButton.setBackgroundResource(R.drawable.on_click_red);
//    }
//
//    private void yellowColorChange() {
//        yellowButton.setBackgroundResource(R.drawable.bg_yellow);
////        SystemClock.sleep(1000);
//        yellowButton.setBackgroundResource(R.drawable.on_click_yellow);
//    }
//    public void greenColorChange(){
//        greenButton.setBackgroundResource(R.drawable.bg_green);
//        Log.d(TAG, "onTick: ");
////        SystemClock.sleep(1000);
//        greenButton.setBackgroundResource(R.drawable.on_click_green);
//
//    }
    public void resetUserSequence(){
        userColorSequence.clear();
    }
    public void resetColorSequence(){
        colorSequence.clear();
    }
    public colors choiceColor(int nextColor){
        if(nextColor == 1)
            return currentColor = colors.GREEN;
        else if(nextColor == 2)
            return currentColor = colors.YELLOW;
        else if(nextColor == 3)
            return currentColor = colors.RED;
        else
            return currentColor = colors.BLUE;
    }
    public enum colors{
        GREEN,
        YELLOW,
        RED,
        BLUE,
        DULLGREEN,
        DULLYELLOW,
        DULLRED,
        DULLBLUE

    }
}
