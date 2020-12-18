package com.ducluanxutrieu.htpuit

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView

class AppWebViewClient(
    private val lottieLoading: ConstraintLayout,
    private val noInternet: ConstraintLayout
) : WebViewClient() {
    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        lottieLoading.visibility = View.VISIBLE
        noInternet.visibility = View.GONE
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        //Page load finished
        super.onPageFinished(view, url)
        lottieLoading.visibility = View.GONE
    }

    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String,
        failingUrl: String
    ) {
        Toast.makeText(view.context, description, Toast.LENGTH_LONG).show()
        noInternet.visibility = View.VISIBLE
        super.onReceivedError(view, errorCode, description, failingUrl)
    }
}