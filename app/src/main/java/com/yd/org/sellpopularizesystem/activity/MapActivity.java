package com.yd.org.sellpopularizesystem.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.util.ArrayList;
import java.util.List;



public class MapActivity extends BaseActivity implements AMap.OnMarkerClickListener,
        AMap.OnInfoWindowClickListener, AMap.OnMarkerDragListener, AMap.OnMapLoadedListener,
        View.OnClickListener, AMap.InfoWindowAdapter {
    private MapView mMapView;
    //private BaiduMap mBaiduMap;
    private AMap aMap;
    //private InfoWindow mInfoWindow;
    private MarkerOptions markerOption;
    private View mMakerView;
    private TextView tvDes;
    public LinearLayout parent_container;
    private List<ProductListBean.ResultBean> productData=new ArrayList<>();
    BitmapDescriptor bd= BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
    private ImageView ivPhoto;
    private String proName;
    private int proId;
    private String flag;
//    private BitmapDescriptor getBitmapDescriptor(int i) {
//        tvDes.setText( productData.get(i).getProduct_name());
//        //启用绘图缓存
//        mMakerView.setDrawingCacheEnabled(true);
//        //调用下面这个方法非常重要，如果没有调用这个方法，得到的bitmap为null
//        mMakerView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        //这个方法也非常重要，设置布局的尺寸和位置
//        //LogUtils.e("测量后的尺寸：" + mViewInflater.getMeasuredWidth() + "....." + mViewInflater.getMeasuredHeight());
//        mMakerView.layout(0, 0, mMakerView.getMeasuredWidth(), mMakerView.getMeasuredHeight());
//        //获得绘图缓存中的Bitmap
//        mMakerView.buildDrawingCache();
//        Bitmap mCacheBitmap = mMakerView.getDrawingCache();
//        Bitmap mBitmap = Bitmap.createBitmap(mCacheBitmap);
//        BitmapDescriptor bdBitMap= BitmapDescriptorFactory.fromBitmap(mBitmap);
//        return bdBitMap;
//    }

    @Override
    protected int setContentView() {
        hideRightImagview();
        return R.layout.activity_map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        //setBackImageView(R.mipmap.wback_1);
        //setTitle(R.string.home_scale);
        setTitle("");
        setColor(Color.BLACK);
        //setBaseLayoutBackground(Color.BLACK);
        parent_container=getViewById(R.id.parent_container);
        productData= (List<ProductListBean.ResultBean>) getIntent().getSerializableExtra("data");
        Log.e("TAG", "initView: "+ productData.size());
        mMakerView= LayoutInflater.from(this).inflate(R.layout.map_maker_view,null);
        tvDes= (TextView) mMakerView.findViewById(R.id.tvDescription);
        mMapView=  getViewById(R.id.mv_bmap);
        //可以显示世界地图
        MapsInitializer.loadWorldGridMap(true);
        /*mBaiduMap=mMapView.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(mBaiduMap.getMinZoomLevel());
        mBaiduMap.setMapStatus(msu);
        initOverlay();*/
        if (aMap == null) {
            aMap = mMapView.getMap();
            UiSettings uiSettings=aMap.getUiSettings();
            uiSettings.setCompassEnabled(true);
            uiSettings.setLogoPosition(AMapOptions.LOGO_POSITION_BOTTOM_CENTER);
            setUpMap();
        }
        //showView();

    }

    public void jumpToScaleActivity() {
        Intent in = new Intent();
        in.setClass(this, ScaleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("map", "map");
        in.putExtras(bundle);
        startActivity(in);
        finish();
    }

    private void setUpMap() {
        aMap.setOnMarkerDragListener(this);// 设置marker可拖拽事件监听器
        aMap.setOnMapLoadedListener(this);// 设置amap加载成功事件监听器
        aMap.setOnMarkerClickListener(this);// 设置点击marker事件监听器
        aMap.setOnInfoWindowClickListener(this);// 设置点击infoWindow事件监听器
        aMap.setInfoWindowAdapter(this);// 设置自定义InfoWindow样式
        addMarkersToMap();// 往地图上添加marker
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap() {
        // 定义Maker坐标点
        for (int i = 0; i < productData.size(); i++) {
            LatLng lat=new LatLng(productData.get(i).getLatitude(),productData.get(i).getLongitude());
            ///构建MarkerOption，用于在地图上添加
            MarkerOptions mo=new MarkerOptions().position(lat).anchor(0.5f, 0.5f)
                    .title(productData.get(i).getProduct_name())
                    .snippet(productData.get(i).getState()+getString(R.string.single_blank_space)+productData.get(i).getAddress_suburb()
                            +"\n"+productData.get(i).getStreet_address_1()+
                            productData.get(i).getStreet_address_2()+getString(R.string.single_blank_space)+"\n"+
                            productData.get(i).getPostcode())
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location))
                    .zIndex(9).draggable(true);
            aMap.addMarker(mo);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void setListener() {
        //右上角图标点击
        /*clickRightImageView(R.mipmap.maplist, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.reverse_anim);
                *//*rotateHelper = new RotationHelper(MapActivity.this,
                        ExtraName.KEY_SECOND_CLOCKWISE);
                rotateHelper.applyFirstRotation(parent_container, 0, 90);*//*
            }
        });*/

    }

    @Override
    protected void onResume() {
        // MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        // MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        // MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
        super.onDestroy();
        mMapView.onDestroy();
        //bd.recycle();
    }

    @Override
    public void onClick(View v) {
        if (proName!=null){
            for (int i = 0; i <productData.size() ; i++) {
               String productName = productData.get(i).getProduct_name();
                if(productName.equals(proName)){
                    proId=productData.get(i).getProduct_id();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("bean", productData.get(i));
                    ActivitySkip.forward(MapActivity.this,ProductItemDetailActivity.class,bundle);
                }
            }

        }
    }

    /**
     * 监听自定义infowindow窗口的infowindow事件回调
     */
    @Override
    public View getInfoWindow(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);
        ivPhoto = (ImageView) infoWindow.findViewById(R.id.badge);
        ivPhoto.setVisibility(View.GONE);
        ivPhoto.setOnClickListener(this);
        infoWindow.setOnClickListener(this);
        render(marker, infoWindow);
        return infoWindow;
    }

    private void render(Marker marker, View view) {
        ImageView iv= (ImageView) view.findViewById(R.id.badge);
        for (int i = 0; i <productData.size(); i++) {
            if (marker.getTitle().equals(productData.get(i).getProduct_name())){
                BitmapUtil.loadImageView(this,Contants.DOMAIN + "/" + productData.get(i).getThumb(),iv);

            }
        }
        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.title));
        if (title != null) {
            SpannableString titleText = new SpannableString(title);
            titleText.setSpan(new ForegroundColorSpan(Color.WHITE), 0,
                    titleText.length(), 0);
            titleUi.setTextSize(15);
            titleUi.setText(titleText);

        } else {
            titleUi.setText("");
        }
        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
        if (snippet != null) {
            SpannableString snippetText = new SpannableString(snippet);
            snippetText.setSpan(new ForegroundColorSpan(Color.WHITE), 0,
                    snippetText.length(), 0);
            snippetUi.setTextSize(15);
            snippetUi.setText(snippetText);
        } else {
            snippetUi.setText("");
        }

    }

    /**
     * 监听自定义infowindow窗口的infocontents事件回调
     */
    @Override
    public View getInfoContents(Marker marker) {
        View infoContent = getLayoutInflater().inflate(
                R.layout.custom_info_contents, null);
        ivPhoto= (ImageView) infoContent.findViewById(R.id.badge);
        ivPhoto.setVisibility(View.GONE);
        ivPhoto.setOnClickListener(this);
        infoContent.setOnClickListener(this);
        render(marker, infoContent);
        return infoContent;
    }

    /**
     * 监听点击infowindow窗口事件回调
     */
    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    /**
     * 监听amap地图加载成功事件回调
     */
    @Override
    public void onMapLoaded() {
        // 设置所有maker显示在当前可视区域地图中
        LatLngBounds.Builder bounds = new LatLngBounds.Builder();
                /*.include(Constants.XIAN).include(Constants.CHENGDU)
                .include(latlng).include(Constants.ZHENGZHOU).include(Constants.BEIJING).build();*/
        for (int i = 0; i < productData.size(); i++) {
            LatLng lat=new LatLng(productData.get(i).getLatitude(),productData.get(i).getLongitude());
            bounds=bounds.include(lat);
        }
        LatLngBounds latlngBounds = bounds.build();
        //MapStatusUpdate mapStatusUpdate= MapStatusUpdateFactory.newLatLngBounds();
        aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, 10));
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.86759, 151.2088),13));
        aMap.invalidate();// 刷新地图

    }

    /**
     * 对marker标注点点击响应事件
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
        proName = marker.getTitle();
        return false;
    }

    /**
     * 监听开始拖动marker事件回调
     */
    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    /**
     * 监听拖动marker时事件回调
     */
    @Override
    public void onMarkerDrag(Marker marker) {

    }

    /**
     * 监听拖动marker结束事件回调
     */
    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}
