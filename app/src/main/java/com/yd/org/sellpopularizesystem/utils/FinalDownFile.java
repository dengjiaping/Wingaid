package com.yd.org.sellpopularizesystem.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.myView.WebViewClientBase;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.DownloadProgressCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.getExternalStoragePublicDirectory;

/**
 * Created by e-dot on 2017/7/26.
 */

public class FinalDownFile {

    private String defaultPath = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
    private String saveName;
    private Activity mActivity;


    public FinalDownFile(Activity activity, final String url, final WebView tencent_webview,
                         final PDFView pdfView) {
        this.mActivity = activity;


        saveName = FileUtils.getSaveNameByUrl(url);
        EasyHttp.downLoad(url).cacheMode(CacheMode.DEFAULT).cacheDiskConverter(new
                SerializableDiskConverter())//默认使用的是 new SerializableDiskConverter();
                .timeStamp(true).savePath(defaultPath).saveName(saveName).execute(new DownloadProgressCallBack<String>() {

            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
                if (contentLength > 0) {
                    int progress = (int) (bytesRead * 100 / contentLength);
                    SVProgressHUD.getProgressBar(mActivity).setMax(100);
                    SVProgressHUD.getProgressBar(mActivity).setProgress(progress);
                    SVProgressHUD.setText(mActivity, progress + " %");

                }


            }

            @Override
            public void onStart() {
                SVProgressHUD.showWithProgress(mActivity, 0 + " %", SVProgressHUD
                        .SVProgressHUDMaskType.Black);

            }

            @Override
            public void onComplete(String path) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (SVProgressHUD.isShowing(mActivity)) {
                            SVProgressHUD.dismiss(mActivity);
                            String fileUrl = defaultPath + File.separator + saveName;
                            //加载图片
                            if (url.endsWith(".JPEG") || url.endsWith(".jpeg") || url.endsWith(""
                                    + ".jpg") || url.endsWith(".JPG") || url.endsWith(".png") ||
                                    url.endsWith(".PNG") || url.endsWith(".GIF") || url.endsWith
                                    (".gif")) {
                                pdfView.setVisibility(View.GONE);
                                tencent_webview.setVisibility(View.VISIBLE);
                                loadImageview(tencent_webview, mActivity, fileUrl);
                            } else {
                                //加载pdf文档
                                if (url.endsWith(".pdf") || url.endsWith(".PDF")) {
                                    pdfView.setVisibility(View.VISIBLE);
                                    tencent_webview.setVisibility(View.GONE);
                                    loadPDF(mActivity, pdfView, fileUrl);
                                    //其它Office文档
                                } else {
                                    pdfView.setVisibility(View.GONE);


                                    if (null != fileUrl && !TextUtils.isEmpty(fileUrl)) {
                                        File pptx = new File(fileUrl);


                                        if (pptx.exists()) {
                                            openFile(new File(fileUrl), mActivity);
                                        } else {
                                            ToasShow.showToastCenter(mActivity, "No File");
                                        }
                                    }


                                }

                            }
                        }
                    }
                });
            }

            @Override
            public void onError(ApiException e) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToasShow.showToastCenter(mActivity, "No File");
                        if (SVProgressHUD.isShowing(mActivity)) {
                            pdfView.setVisibility(View.GONE);
                            SVProgressHUD.dismiss(mActivity);
                        }
                    }
                });

            }
        });


    }


    private void loadImageview(WebView view, Activity activity, String path) {
        WebSettings webSettings = view.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setDomStorageEnabled(true);
        view.setWebViewClient(new WebViewClientBase(activity));
        view.loadUrl("file://" + path);
    }

    private void loadPDF(final Activity activity, PDFView pdfView, String fileUrl) {
        File pdf = new File(fileUrl);


        if (pdf.exists()) {

            pdfView.fromFile(pdf).defaultPage(0).onPageChange(new OnPageChangeListener() {
                @Override
                public void onPageChanged(int page, int pageCount) {
                }
            }).enableAnnotationRendering(true).onLoad(null).scrollHandle(new DefaultScrollHandle(activity)).spacing(0) // in dp
                    .load();

        } else {
            ToasShow.showToastCenter(mActivity, "No File");
        }


    }

    private boolean checkEndsWithInStringArray(String checkItsEnd,
                                               String[] fileEndings) {
        for (String aEnd : fileEndings) {
            if (checkItsEnd.endsWith(aEnd))
                return true;
        }
        return false;
    }

    private void openFile(File currentPath, Activity mActivity) {
        if (currentPath != null && currentPath.isFile()) {
            String fileName = currentPath.toString();
            Intent intent;
            if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingImage))) {
                intent = OpenFiles.getImageFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingWebText))) {
                intent = OpenFiles.getHtmlFileIntent(currentPath);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingPackage))) {
                intent = OpenFiles.getApkFileIntent(currentPath);
                mActivity.startActivity(intent);

            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingAudio))) {
                intent = OpenFiles.getAudioFileIntent(currentPath);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingVideo))) {
                intent = OpenFiles.getVideoFileIntent(currentPath);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingText))) {
                intent = OpenFiles.getTextFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingPdf))) {
                intent = OpenFiles.getPdfFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingWord))) {
                intent = OpenFiles.getWordFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingExcel))) {
                intent = OpenFiles.getExcelFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);
            } else if (checkEndsWithInStringArray(fileName, mActivity.getResources()
                    .getStringArray(R.array.fileEndingPPT))) {
                intent = OpenFiles.getPPTFileIntent(currentPath, mActivity);
                mActivity.startActivity(intent);


            }
            mActivity.finish();
        } else {

        }
    }

}
