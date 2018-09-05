package com.app.actech.swineapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * Created by ACTECH on 8/20/2018.
 */

@SuppressLint("ValidFragment")
public class ImportFragment extends Fragment  {
    String FNAME="";
    WebView myWebView;
    @SuppressLint("ValidFragment")
    public ImportFragment(String fname) {
        FNAME=fname;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_global,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myWebView=view.findViewById(R.id.refwv);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("file:///android_asset/proj-html/"+FNAME);
        Log.d("ImportFragment ","Loading Url...");
        myWebView.setWebViewClient(new WebViewClient());

    }


}
