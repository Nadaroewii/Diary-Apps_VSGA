package com.lat1.proyek_3_vsga_nada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.File;

public class SplashScreen extends AppCompatActivity {
        public static final String FILENAME = "login";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isLogin()) {
                        startActivity(new Intent(
                                SplashScreen.this,
                                MainActivity.class));
                    } else {
                        startActivity(new Intent(
                                SplashScreen.this,
                                LoginActivity.class));
                    }

                    finish();
                }
            }, 2000);
        }

        boolean isLogin() {
            File sdcard = getFilesDir();
            File file = new File(sdcard, FILENAME);
            if (file.exists()) {
                return true;
            } else {
                return false;
            }
        }
}