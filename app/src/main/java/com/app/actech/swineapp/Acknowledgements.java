package com.app.actech.swineapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Acknowledgements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgements);


        WebView myWebView = findViewById(R.id.ackvw);
        myWebView.loadUrl("file:///android_asset/SwineAppHTML/Developer and contacts.htm");
    }

    @Override
    public void onBackPressed() {
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(in);
    }
}
