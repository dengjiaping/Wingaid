package com.yd.org.sellpopularizesystem.viewpage;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.fragment.BaseFragmentView;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.FinalDownFile;

import uk.co.senab.photoview.PhotoView;

public class PhotoViewFragment extends BaseFragmentView {
    private PhotoView photoIm;
    private String url, title;
    private WebView pdfView;
    private PDFView pView;

    public static PhotoViewFragment getInstnce(String url, String title) {
        PhotoViewFragment photoViewFragment = new PhotoViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", title);
        photoViewFragment.setArguments(bundle);
        return photoViewFragment;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_photo_view);
        photoIm = getViewById(R.id.photoIm);
        pdfView = getViewById(R.id.pdfView);//webview
        pView = getViewById(R.id.pView);//pdf
        url = getArguments().getString("url");


        if (url.endsWith(".pdf") || url.endsWith(".ppt") || url.endsWith(".pptx") || url.endsWith(".PDF") || url.endsWith(".PPT") || url.endsWith(".PPTX")) {
            title = getArguments().getString("title");
            pdfView.setVisibility(View.VISIBLE);
            photoIm.setVisibility(View.GONE);


            new FinalDownFile(getActivity(),  url, pdfView,pView);


        } else if (url.endsWith(".png") || url.endsWith(".jpg")) {
            photoIm.setVisibility(View.VISIBLE);
            pdfView.setVisibility(View.GONE);
            pView.setVisibility(View.GONE);
            init();
        }


    }


    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    private void init() {
        BitmapUtil.loadImageView(getActivity(), url, photoIm);

    }


}


