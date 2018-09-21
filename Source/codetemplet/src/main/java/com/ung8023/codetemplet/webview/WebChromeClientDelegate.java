package com.ung8023.codetemplet.webview;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

public interface WebChromeClientDelegate {

    /**
     * @see WebChromeClient#onProgressChanged(WebView, int)
     */
    void onProgressChanged(WebView view, int newProgress);

    /**
     * @see WebChromeClient#onReceivedTitle(WebView, String)
     */
    void onReceivedTitle(WebView view, String title);

    /**
     * @see WebChromeClient#onReceivedIcon(WebView view, Bitmap icon)
     */
    void onReceivedIcon(WebView view, Bitmap icon);

    /**
     * @see WebChromeClient#onReceivedTouchIconUrl(WebView view, String url, boolean precomposed)
     */
    void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed);

    /**
     * @see WebChromeClient#onShowCustomView(View view, WebChromeClient.CustomViewCallback callback)
     */
    void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback);
    /**
     * @see WebChromeClient#onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback)
     */
    void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback);
    /**
     * @see WebChromeClient#onHideCustomView()
     */
    void onHideCustomView();
    /**
     * @see WebChromeClient#onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg)
     */
    boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg);
    /**
     * @see WebChromeClient#onRequestFocus(WebView view)
     */
    void onRequestFocus(WebView view);
    /**
     * @see WebChromeClient#onCloseWindow(WebView window)
     */
    void onCloseWindow(WebView window);
    /**
     * @see WebChromeClient#onJsAlert(WebView view, String url, String message, JsResult result)
     */
    boolean onJsAlert(WebView view, String url, String message, JsResult result);
    /**
     * @see WebChromeClient#onJsConfirm(WebView view, String url, String message, JsResult result)
     */
    boolean onJsConfirm(WebView view, String url, String message, JsResult result);
    /**
     * @see WebChromeClient#onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result)
     */
    boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result);
    /**
     * @see WebChromeClient#onJsBeforeUnload(WebView view, String url, String message, JsResult result)
     */
    boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result);
    /**
     * @see WebChromeClient#onExceededDatabaseQuota(String, String, long, long, long, WebStorage.QuotaUpdater)
     */
    void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater);
    /**
     * @see WebChromeClient#onReachedMaxAppCacheSize(long, long, WebStorage.QuotaUpdater)
     */
    void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater);
    /**
     * @see WebChromeClient#onGeolocationPermissionsShowPrompt(String, GeolocationPermissions.Callback)
     */
    void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback);
    /**
     * @see WebChromeClient#onGeolocationPermissionsHidePrompt()
     */
    void onGeolocationPermissionsHidePrompt();
    /**
     * @see WebChromeClient#onPermissionRequest(PermissionRequest)
     */
    void onPermissionRequest(PermissionRequest request);
    /**
     * @see WebChromeClient#onPermissionRequestCanceled(PermissionRequest)
     */
    void onPermissionRequestCanceled(PermissionRequest request);
    /**
     * @see WebChromeClient#onJsTimeout()
     */
    boolean onJsTimeout();
    /**
     * @see WebChromeClient#onConsoleMessage(String, int, String)
     */
    void onConsoleMessage(String message, int lineNumber, String sourceID);
    /**
     * @see WebChromeClient#onConsoleMessage(ConsoleMessage)
     */
    boolean onConsoleMessage(ConsoleMessage consoleMessage);
    /**
     * @see WebChromeClient#getDefaultVideoPoster()
     */
    Bitmap getDefaultVideoPoster();
    /**
     * @see WebChromeClient#getVideoLoadingProgressView()
     */
    View getVideoLoadingProgressView();
    /**
     * @see WebChromeClient#getVisitedHistory(ValueCallback)
     */
    void getVisitedHistory(ValueCallback<String[]> callback);
    /**
     * @see WebChromeClient#onShowFileChooser(WebView, ValueCallback, WebChromeClient.FileChooserParams)
     */
    boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams);


}
