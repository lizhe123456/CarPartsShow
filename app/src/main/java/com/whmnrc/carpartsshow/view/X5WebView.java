package com.whmnrc.carpartsshow.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class X5WebView extends WebView {

	private OnWebViewListener onWebViewListener;

	private WVClient client = new WVClient();

	@SuppressLint("SetJavaScriptEnabled")
	public X5WebView(Context arg0, AttributeSet arg1) {
		super(arg0, arg1);
		this.setWebViewClient(client);
		this.setWebChromeClient(new WVChromeClient());
		initWebViewSettings();
		this.getView().setClickable(false);
	}

	public void setOnWebViewListener(OnWebViewListener onWebViewListener) {
		this.onWebViewListener = onWebViewListener;
	}

	private void initWebViewSettings() {
		WebSettings webSetting = this.getSettings();
		webSetting.setJavaScriptEnabled(true);
		webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
		webSetting.setAllowFileAccess(true);
		webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webSetting.setSupportZoom(true);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setUseWideViewPort(true);
		webSetting.setSupportMultipleWindows(true);
		// webSetting.setLoadWithOverviewMode(true);
		webSetting.setAppCacheEnabled(true);
		// webSetting.setDatabaseEnabled(true);
		webSetting.setDomStorageEnabled(true);
		webSetting.setGeolocationEnabled(true);
		webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
		// webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
		webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
		// webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

		// this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
		// settings 的设计
	}

	private class WVClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			//在当前Activity打开
			view.loadUrl(url);

			return true;
		}

		@Override
		public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
			//https忽略证书问题
			handler.proceed();
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			if (onWebViewListener != null) {
				onWebViewListener.onPageFinish(view);
			}
			super.onPageFinished(view, url);

		}

	}

	private class WVChromeClient extends WebChromeClient {

		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				if (onWebViewListener != null) {
					onWebViewListener.onProgressChange(view);
				}
			}
			super.onProgressChanged(view, newProgress);
		}

	}


	//进度回调接口
	public interface OnWebViewListener {
		void onProgressChange(WebView view);

		void onPageFinish(WebView view);
	}

}
