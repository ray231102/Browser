package com.example.farras23.browser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.okedroid.mysimplebrowser.R;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    String url = " ";
    public WebView myWebView;
    //    deklarasi var mywebview tipe data object WebView
//Ste
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {
            // Ignore

            /*
            Kode untuk mengakses icon menu yang tidak tampil di perangkat android layar kecil


             */
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//    inisialisasi webview ke dalam resource id webview di layout
        myWebView = (WebView) findViewById(R.id.webView);
//menseting tampilan url ke dalam tampilan webview
        myWebView.setWebViewClient(new WebViewClient());
//mengaktifkan javascript (secara default disable)


        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //method untuk mengaktifkan java script

    }


    public void goToURL(View view) {
        //Menginisialisasi object editext di dalam resoure id layout
        EditText editText = (EditText) findViewById(R.id.urlText);
        //mengassign atau menentukan nilai url ke dalam bentuk editext string
        url = editText.getText().toString();
        //meload url berdasarkan editext
        myWebView.loadUrl(url);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //konten di menu item
            case R.id.action_settings:
                return true;
            case R.id.tombol_goback:
                myWebView.goBack();
                return true;
            case R.id.tombol_gofoward:
                myWebView.goForward();
                return true;
            case R.id.tombol_refresh:
                myWebView.reload();
                return true;
            case R.id.tombol_stop:
                myWebView.stopLoading();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}