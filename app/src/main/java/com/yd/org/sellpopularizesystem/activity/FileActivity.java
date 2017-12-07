package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.github.barteksc.pdfviewer.PDFView;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.FileAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.FinalDownFile;

import java.util.ArrayList;
import java.util.List;

public class FileActivity extends BaseActivity {
    private ListView listView;
    private ProductDetailBean.ResultBean prs;
    private List<ProductDetailBean.ResultBean.FileContentBean> file_content = new ArrayList<>();
    private List<ProductDetailBean.ResultBean.FileContentBean> fileDate = new ArrayList<>();
    private FileAdapter fileAdapter;
    private String key;
    //合同
    private WebView pdfView;
    private PDFView pView;


    @Override
    protected int setContentView() {
        return R.layout.activity_file;
    }

    @Override
    public void initView() {
        hideRightImagview();
        key = getIntent().getStringExtra("key");
        prs = (ProductDetailBean.ResultBean) getIntent().getSerializableExtra("file");
        listView = getViewById(R.id.fileListView);
        pdfView = getViewById(R.id.pdfView);
        pView = getViewById(R.id.pView);
        if (key.equals("File")) {
            setTitle(getString(R.string.file_act));
            pdfView.setVisibility(View.GONE);
            pView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);

            file_content = prs.getFile_content();
            for (int i = 0; i < file_content.size(); i++) {
                if (file_content.get(i).getFile_type() == 2) {
                    fileDate.add(file_content.get(i));
                }
            }
            fileAdapter = new FileAdapter(this, fileDate);
            listView.setAdapter(fileAdapter);
        } else {
            setTitle(getString(R.string.contract));
            pdfView.setVisibility(View.VISIBLE);
            pView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            new FinalDownFile(this, Contants.DOMAIN + "/" + prs.getContract_url(), pdfView, pView);
        }

    }

    @Override
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FileAdapter.ViewHolder viewHolder = (FileAdapter.ViewHolder) view.getTag();
                ProductDetailBean.ResultBean.FileContentBean fileContent = viewHolder.fileContent;
                Bundle bundle = new Bundle();
                bundle.putSerializable("pdf", fileContent);
                ActivitySkip.forward(FileActivity.this, PDFActivity.class, bundle);


            }
        });

    }


}
