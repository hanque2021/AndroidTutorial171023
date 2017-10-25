package com.example.a.t13_webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog dlg;
    ProgressBar progressBar;

    class MyWebViewClient extends WebViewClient{


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //dlg.show();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //dlg.dismiss();
            progressBar.setVisibility(View.GONE);
        }
    }

    class  MyChromeCliet extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlg = new ProgressDialog(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyChromeCliet());
        webView.loadUrl("http://www.daum.net");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();  //back키 누를 경우 앱 종료되는것 막기위해 주석 처리
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }
}
