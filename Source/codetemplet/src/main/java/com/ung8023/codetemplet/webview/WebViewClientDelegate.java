package com.ung8023.codetemplet.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public interface WebViewClientDelegate {

    /**
     * @see WebViewClient#shouldOverrideUrlLoading(WebView, String)
     */
    boolean shouldOverrideUrlLoading(WebView view, String url);

    /**
     * @see WebViewClient#shouldOverrideUrlLoading(WebView, WebResourceRequest)
     */
    boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request);

    /**
     * @see WebViewClient#onPageStarted(WebView, String, Bitmap)
     */
    void onPageStarted(WebView view, String url, Bitmap favicon);

    /**
     * @see WebViewClient#onPageFinished(WebView, String)
     */
    void onPageFinished(WebView view, String url);

    /**
     * @see WebViewClient#onLoadResource(WebView, String)
     */
    void onLoadResource(WebView view, String url);

    /**
     * @see WebViewClient#onPageCommitVisible(WebView, String)
     */
    void onPageCommitVisible(WebView view, String url);

    /**
     * @see WebViewClient#shouldInterceptRequest(WebView, String)
     */
    WebResourceResponse shouldInterceptRequest(WebView view, String url);

    /**
     * @see WebViewClient#shouldInterceptRequest(WebView, WebResourceRequest)
     */
    WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request);

    /**
     * @see WebViewClient#onTooManyRedirects(WebView, Message, Message)
     */
    void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg);

    /**
     * @see WebViewClient#onReceivedError(WebView, int, String, String)
     */
    void onReceivedError(WebView view, int errorCode, String description, String failingUrl);
    /**
     * @see WebViewClient#onReceivedError(WebView, WebResourceRequest, WebResourceError)
     */
    void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error);

    /**
     * @see WebViewClient#onReceivedHttpError(WebView, WebResourceRequest, WebResourceResponse)
     */
    void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse);

    /**
     * @see WebViewClient#onFormResubmission(WebView, Message, Message)
     */
    void onFormResubmission(WebView view, Message dontResend, Message resend);

    /**
     * @see WebViewClient#doUpdateVisitedHistory(WebView, String, boolean)
     */
    void doUpdateVisitedHistory(WebView view, String url, boolean isReload);

    /**
     * @see WebViewClient#onReceivedSslError(WebView, SslErrorHandler, SslError)
     */
    void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error);

    /**
     * @see WebViewClient#onReceivedClientCertRequest(WebView, ClientCertRequest)
     */
    void onReceivedClientCertRequest(WebView view, ClientCertRequest request);

    /**
     * @see WebViewClient#onReceivedHttpAuthRequest(WebView, HttpAuthHandler, String, String)
     */
    void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm);

    /**
     * @see WebViewClient#shouldOverrideKeyEvent(WebView, KeyEvent)
     */
    boolean shouldOverrideKeyEvent(WebView view, KeyEvent event);

    /**
     * @see WebViewClient#onUnhandledKeyEvent(WebView, KeyEvent)
     */
    void onUnhandledKeyEvent(WebView view, KeyEvent event);

    /**
     * @see WebViewClient#onScaleChanged(WebView, float, float)
     */
    void onScaleChanged(WebView view, float oldScale, float newScale);

    /**
     * @see WebViewClient#onReceivedLoginRequest(WebView, String, String, String)
     */
    void onReceivedLoginRequest(WebView view, String realm, String account, String args);

    /**
     * @see WebViewClient#onRenderProcessGone(WebView, RenderProcessGoneDetail)
     */
    boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail);
}
