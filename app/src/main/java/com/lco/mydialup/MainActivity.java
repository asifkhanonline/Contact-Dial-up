package com.lco.mydialup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b14,b15,b16,b18,b17;
    EditText ed;
    String phoneNo;
    String message;
    private static final int PHONECALL=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b14 = findViewById(R.id.b14);
        b15 = findViewById(R.id.b15);
        b17=findViewById(R.id.b17);
        b18 = findViewById(R.id.b18);
        ed = findViewById(R.id.res);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "9");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "*");
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "0");
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText(ed.getText() + "#");
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.setText("");
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCall();

            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num =ed.getText().toString();
                Uri uri=Uri.parse("smsto:"+num);
                Intent sendintent=new Intent(Intent.ACTION_SENDTO,uri);
                sendintent.putExtra(Intent.EXTRA_TEXT,"asif");
                sendintent.setPackage("com.whatsapp");
                startActivity(sendintent);

            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num =ed.getText().toString();
                Uri uri=Uri.parse("smsto:"+num);
                Intent sendintent=new Intent(Intent.ACTION_SENDTO,uri);
                sendintent.putExtra(Intent.EXTRA_TEXT,"asif");
                startActivity(sendintent);


            }
        });

    }

    protected void openCall()
    {
        String number=ed.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},PHONECALL);

            }
            else{
                String dial="tel:"+number;
                Intent i=new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse(dial));
                startActivity(i);


            }


        }
        else{
            Toast.makeText(MainActivity.this,"ENter phone number",Toast.LENGTH_SHORT).show();
        }

    }
}

