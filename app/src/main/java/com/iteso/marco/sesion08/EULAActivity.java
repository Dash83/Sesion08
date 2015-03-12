package com.iteso.marco.sesion08;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by marco on 3/11/15.
 */
public class EULAActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
        WebView webView = (WebView)findViewById(R.id.webEula);
        webView.loadUrl("file:///android_asset/eula.html");
    }
}
