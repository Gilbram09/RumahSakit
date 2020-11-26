package com.gilbram.rs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        final int WelcomeScreenDisplay = 3000;
        Thread WelcomeThread = new Thread() {

            int wait = 0;
            @Override
            public void run (){
                try {
                    super.run();
                    while (wait< WelcomeScreenDisplay) {
                        sleep(100);
                        wait +=100;
                    }
                } catch (Exception e) {
                    System.out.println("EXc=" + e);


                }finally {
                    Intent intent= new Intent(Screen.this,MainActivity.class);
                    finish();
                    startActivity(intent);

                }
            }
        };
        WelcomeThread.start();
    }
}

