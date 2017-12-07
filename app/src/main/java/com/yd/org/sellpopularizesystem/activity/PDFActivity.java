package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.yd.org.sellpopularizesystem.utils.FinalDownFile;

public class PDFActivity extends BaseActivity {
    private WebView pdfView;
    private ProductDetailBean.ResultBean.FileContentBean fileContent;
    private String sale_advice_url, orderId;
    private String fileType;
    private PDFView pView;

    @Override
    protected int setContentView() {
        return R.layout.activity_pdf;
    }

    @Override
    public void initView() {
        hideRightImagview();
        pdfView = getViewById(R.id.pdfView);
        pView = getViewById(R.id.pView);
        Bundle bundle = getIntent().getExtras();
        orderId = bundle.getString("orderId");
        sale_advice_url = bundle.getString("sale_advice_url");


        Log.e("", "");
        if (orderId == null || sale_advice_url == null) {
            fileContent = (ProductDetailBean.ResultBean.FileContentBean) getIntent().getSerializableExtra("pdf");
            setTitle(fileContent.getDetail_name());
             new FinalDownFile(this, Contants.DOMAIN + "/" + fileContent.getUrl(), pdfView, pView);

        } else {
            setTitle(getString(R.string.sale_notice));
             new FinalDownFile(this, Contants.DOMAIN + "/" + sale_advice_url, pdfView, pView);

        }


    }


    @Override
    public void setListener() {

    }



}
