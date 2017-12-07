package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.myView.imageshow.TouchImageView;

import java.util.List;


/**
 * 图片浏览的PagerAdapter
 */
public class ImagePagerAdapter extends PagerAdapter {
    private Context context;
    private List<String> imgsUrl;
    private LayoutInflater inflater = null;
    private DisplayImageOptions options;
    private ImageLoader imageLoader;


    public ImagePagerAdapter(Context context, List<String> imgsUrl) {
        this.context = context;
        this.imgsUrl = imgsUrl;
        this.inflater = LayoutInflater.from(context);

        options = getSimpleOptions();
        imageLoader = ImageLoader.getInstance();
    }


    /**
     * 设置常用的设置项
     *
     * @return
     */
    private DisplayImageOptions getSimpleOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_full_image_failed) // 设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.ic_full_image_failed)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.ic_full_image_failed) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)// 设置图片以如何的编码方式显示
                .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型
                .build();// 构建完成
        return options;
    }


    // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
    @Override
    public int getCount() {
        return imgsUrl == null ? 0 : imgsUrl.size();
    }


    // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }


    // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View viewLayout = inflater.from(context).inflate(R.layout.details_imageshow_item, null);
        TouchImageView full_image = (TouchImageView) viewLayout.findViewById(R.id.full_image);
        final ProgressBar spinner = (ProgressBar) viewLayout.findViewById(R.id.loading);
        imageLoader.displayImage(imgsUrl.get(position), full_image, options,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        spinner.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        String message = null;
                        switch (failReason.getType()) { // 获取图片失败类型
                            case IO_ERROR: // 文件I/O错误
                                message = "Input/Output error";
                                break;
                            case DECODING_ERROR: // 解码错误
                                message = "Image can't be decoded";
                                break;
                            case NETWORK_DENIED: // 网络延迟
                                message = "Downloads are denied";
                                break;
                            case OUT_OF_MEMORY: // 内存不足
                                message = "Out Of Memory error";
                                break;
                            case UNKNOWN: // 原因不明
                                message = "Unknown error";
                                break;
                        }
                        Toast.makeText(context, message,
                                Toast.LENGTH_SHORT).show();

                        spinner.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri,
                                                  View view, Bitmap loadedImage) {
                        spinner.setVisibility(View.GONE); // 不显示圆形进度条
                    }
                });
        ((ViewPager) container).addView(viewLayout, 0); // 将图片增加到ViewPager // 将图片增加到ViewPager
        return viewLayout;
    }

}
