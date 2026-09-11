package com.example.naturelife;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // WebView එකක් සාදා Layout එක ලෙස set කිරීම
        webView = new WebView(this);
        setContentView(webView);

        // WebView Settings සැකසීම
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // App එක ඇතුලෙන්ම Web page එක open වීමට
        webView.setWebViewClient(new WebViewClient());

        // assets/index.html එක Load කිරීම
        webView.loadUrl("file:///android_asset/index.html");
    }

    // Back Button එක එබූ විට WebView එක පිටුපසට යාමට
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
