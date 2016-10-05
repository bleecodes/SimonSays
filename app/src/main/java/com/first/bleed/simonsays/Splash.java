package com.first.bleed.simonsays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by BLEED on 10/2/2016.
 */

public class Splash extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,Title_Screen.class);
        startActivity(intent);
        finish();
    }
}
