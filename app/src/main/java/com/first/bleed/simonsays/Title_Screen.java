package com.first.bleed.simonsays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by BLEED on 10/2/2016.
 */
//Create a Read Me layout
public class Title_Screen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);
        Button startButton = (Button) findViewById(R.id.bt_start_game);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Title_Screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
