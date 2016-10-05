package com.first.bleed.simonsays;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button greenButton;
    Button yellowButton;
    Button redButton;
    Button blueButton;
    Button startButton;
    String TAG = "MainActivity";
    int dullWaitTime = 1*1500;
    int lightWaitTime = 1000;
    List<colors> colorSequence;
    private colors currentColor;
    private List<colors> userColorSequence;
    private boolean userturn = false;
    Handler delayHandler = new Handler();
    Runnable dullGreenRunnable;
    Runnable dullYellowRunnable;
    Runnable dullRedRunnable;
    Runnable dullBlueRunnable;
    Runnable greenRunnable;
    Runnable blueRunnable;
    Runnable yellowRunnable;
    Runnable redRunnable;

    //NEEDS TO START THE GAME
    //Title Screen Start Game Read me
    //Toast to display the round
    //menu has restart, title screen?
    // change buttons into cooler buttons
    //user shouldnt be able to cause multiple button presses to start round
    //better splash
    //RESTART THE GAME

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFindView();
        initListeners();
       initRunnables();
        colorSequence = new ArrayList<>();
        userColorSequence = new ArrayList<>();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.game_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.bt_reset){
            resetColorSequence();
            resetUserSequence();
            return true;
        }
//        if(id == R.id.bt_menu){
//            Toast.makeText(this,"Menu",Toast.LENGTH_LONG).show();
//            return true;
//        }
        return super.onOptionsItemSelected(item);
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
    public void initRunnables(){
        greenRunnable = new Runnable() {
            @Override
            public void run() {
                greenButton.setBackgroundResource(R.drawable.bg_green);

            }
        };
        dullGreenRunnable = new Runnable() {
            @Override
            public void run() {
                greenButton.setBackgroundResource(R.drawable.on_click_green);
            }
        };
        yellowRunnable = new Runnable() {
            @Override
            public void run() {
                yellowButton.setBackgroundResource(R.drawable.bg_yellow);

            }
        };
        dullYellowRunnable = new Runnable() {
            @Override
            public void run() {
                yellowButton.setBackgroundResource(R.drawable.on_click_yellow);
            }
        };
        redRunnable = new Runnable() {
            @Override
            public void run() {
                redButton.setBackgroundResource(R.drawable.bg_red);

            }
        };
        dullRedRunnable = new Runnable() {
            @Override
            public void run() {
                redButton.setBackgroundResource(R.drawable.on_click_red);
            }
        };
        blueRunnable = new Runnable() {
            @Override
            public void run() {
                blueButton.setBackgroundResource(R.drawable.bg_blue);

            }
        };
        dullBlueRunnable = new Runnable() {
            @Override
            public void run() {
                blueButton.setBackgroundResource(R.drawable.on_click_blue);
            }
        };
    }

    private void userPlaysSequence() {
        if (userturn) {
            userColorSequence.add(currentColor);
            for(int i = 0; i < userColorSequence.size(); i ++){
                if( userColorSequence.get(i) != colorSequence.get(i)){
                    startButton.setText("You Lost");
                    resetUserSequence();
                    resetColorSequence();}
            }
            if(userColorSequence.size() == colorSequence.size() && userColorSequence.size() != 0) {
                userturn = false;
                startButton.setText("round"+colorSequence.size());
                Log.d(TAG, "made it through turn");
                resetUserSequence();}


        }
    }
    public void startColorSequence(){


        Random rnd = new Random();

                int nextColor = rnd.nextInt(4);
                colorSequence.add(choiceColor(nextColor));

                for(int i = 0 ; i < colorSequence.size(); i++){
                    switch (colorSequence.get(i)) {

                        case GREEN:
                            Log.d(TAG, "green");
                            greenButtonChange(dullWaitTime,lightWaitTime);


                            break;

                        case YELLOW:
                            yellowButtonChange(dullWaitTime,lightWaitTime);
////
                            break;

                        case RED:
                            redButtonChange(dullWaitTime,lightWaitTime);
////
                            break;

                        case BLUE:
                            blueButtonChange(dullWaitTime,lightWaitTime);
//
                            break;

                    }
                    dullWaitTime+=1000;
                    lightWaitTime+=1000;
                    //System.out.println(dullWaitTime);

                }

        dullWaitTime = 1500;
        lightWaitTime = 1000;

    }
    public void resetUserSequence(){
        userColorSequence.clear();
    }
    public void resetColorSequence(){
        colorSequence.clear();
    }

    private void greenButtonChange(int dullWaitTime, int lightWaitTime) {
        delayHandler.postDelayed(dullGreenRunnable,dullWaitTime);
      delayHandler.postDelayed(greenRunnable,lightWaitTime);
    }
    private void yellowButtonChange(int dullWaitTime, int lightWaitTime) {
        delayHandler.postDelayed(dullYellowRunnable,dullWaitTime);
        delayHandler.postDelayed(yellowRunnable,lightWaitTime);

    }
    private void redButtonChange(int dullWaitTime, int lightWaitTime) {
        delayHandler.postDelayed(dullRedRunnable,dullWaitTime);
        delayHandler.postDelayed(redRunnable,lightWaitTime);
    }
    private void blueButtonChange(int dullWaitTime, int lightWaitTime) {
        delayHandler.postDelayed(dullBlueRunnable,dullWaitTime);
        delayHandler.postDelayed(blueRunnable,lightWaitTime);
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
