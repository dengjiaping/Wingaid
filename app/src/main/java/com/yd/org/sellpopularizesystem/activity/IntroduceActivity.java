package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.webkit.WebView;
import com.github.barteksc.pdfviewer.PDFView;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.utils.FinalDownFile;

/**
 * Created by e-dot on 2017/6/16.
 */

public class IntroduceActivity extends BaseActivity {
    private WebView pdfView;
    private String sale_advice_url, type = "";
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
        sale_advice_url = bundle.getString("introduce");
        type = bundle.getString("type");

        if (type.equals("1")) {
            setTitle(R.string.floorphoto);

        } else {
            setTitle(R.string.jieshao);

        }

        new FinalDownFile(this, Contants.DOMAIN + "/" + sale_advice_url, pdfView,pView);

    }

    @Override
    public void setListener() {

    }
}
