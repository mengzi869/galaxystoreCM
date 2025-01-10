package com.clean888.cleansuper.cleaner.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.clean888.cleansuper.cleaner.databinding.ActivityWebviewBinding;
import com.clean888.cleansuper.cleaner.utils.AboutMe.ri;

public class AgreemenUrlActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityWebviewBinding binding;

    class LoadUrlWebViewClient extends WebViewClient {
        LoadUrlWebViewClient() {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    class ProgressLoadWChromeCt extends WebChromeClient {
        ProgressLoadWChromeCt() {
        }

        @Override
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                AgreemenUrlActivity.this.binding.progressBar.setVisibility(View.GONE);
            } else {
                if (AgreemenUrlActivity.this.binding.progressBar.getVisibility() == View.GONE) {
                    AgreemenUrlActivity.this.binding.progressBar.setVisibility(View.VISIBLE);
                }
                AgreemenUrlActivity.this.binding.progressBar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }
    }

    public static void goAgreementUrl(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, (Class<?>) AgreemenUrlActivity.class);
        intent.putExtra("URL", str);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        finish();
    }

     @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityWebviewBinding inflate = ActivityWebviewBinding.inflate(LayoutInflater.from(this));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        String agreementUrl = getIntent().getStringExtra("URL");
        if (TextUtils.isEmpty(agreementUrl)) {
            finish();
            return;
        }
        this.binding.webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        this.binding.webview.getSettings().setJavaScriptEnabled(true);
        ri.a(this.binding.webview);
        this.binding.back.setOnClickListener(this);
        this.binding.webview.setWebViewClient(new LoadUrlWebViewClient());
        this.binding.webview.setWebChromeClient(new ProgressLoadWChromeCt());
        this.binding.webview.loadUrl(agreementUrl);
        this.binding.webview.requestFocus();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.binding.webview.canGoBack()) {
            this.binding.webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
