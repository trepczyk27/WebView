package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private WebView webView;
Button powieksz,zmiejsz,odswiez,przywroc,cofnij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powieksz=findViewById(R.id.bPow);
        zmiejsz=findViewById(R.id.bZmiej);
        odswiez=findViewById(R.id.bOds);
        przywroc=findViewById(R.id.bPrzywroc);
        cofnij=findViewById(R.id.bCofnij);
        webView=findViewById(R.id.web);
        webView.loadUrl("https://google.com/");
        webView.setWebViewClient(new WebViewClient());

        powieksz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.zoomIn();
            }
        });
        zmiejsz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.zoomOut();
            }
        });
        odswiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

        przywroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webView.goForward();
            }
        });
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();

        }else{
            super.onBackPressed();
        }


    }
}