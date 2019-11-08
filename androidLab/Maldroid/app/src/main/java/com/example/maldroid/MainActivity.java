package com.example.maldroid;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonLaunch);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent launchIntent = getPackageManager().
                        getLaunchIntentForPackage("com.example.mycall");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }

            }
        });
    }
}
