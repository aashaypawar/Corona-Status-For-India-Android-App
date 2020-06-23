package com.example.covid19status

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.KeyCharacterMap
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wv = findViewById<WebView>(R.id.wv)
        wv.webViewClient = WebViewClient()

        wv.loadUrl("https://covid19india.org")

        wv.settings.javaScriptEnabled = true
        wv.settings.allowContentAccess = true
        wv.settings.domStorageEnabled = true
        wv.settings.useWideViewPort = true
        wv.settings.setAppCacheEnabled(true)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()){
            wv.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}