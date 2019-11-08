package com.example.mycall;

import android.os.Bundle;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private static int REQUEST_CALL = 1;
    private static int REQUEST_SMS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonCall);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:4158060437"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                }
                startActivity(call);
            }
        });

        button2 = (Button) findViewById(R.id.buttonText);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Uri textUri = Uri.parse("tel:0123456789");
                Intent text = new Intent(Intent.ACTION_SENDTO, textUri);

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.SEND_SMS}, REQUEST_SMS);

                }

                startActivity(text);

            }
        });


    }

}
