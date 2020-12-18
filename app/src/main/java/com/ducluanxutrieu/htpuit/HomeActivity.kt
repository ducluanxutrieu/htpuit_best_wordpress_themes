package com.ducluanxutrieu.htpuit

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class HomeActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)


        val myWebView = findViewById<WebView>(R.id.wv_container)
        val noInternet = findViewById<ConstraintLayout>(R.id.cl_no_internet)
        val loading = findViewById<ConstraintLayout>(R.id.cl_loading)
        val buttonReload = findViewById<MaterialButton>(R.id.btn_reload)
        myWebView.webViewClient = AppWebViewClient(loading, noInternet)
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://apitech.com.vn")
        buttonReload.setOnClickListener {
            myWebView.loadUrl("https://apitech.com.vn")
        }
    }
}