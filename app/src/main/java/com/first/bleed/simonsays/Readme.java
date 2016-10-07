package com.first.bleed.simonsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by BLEED on 10/5/2016.
 */
public class Readme extends AppCompatActivity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_me);
        ImageView backButton = (ImageView) findViewById(R.id.iv_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Readme.this, Title_Screen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
