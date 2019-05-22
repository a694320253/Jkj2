package cn.usho.jkj.view.activity;

import android.Manifest;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.usho.jkj.R;
import cn.usho.jkj.adapter.ListAdapter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyActivity extends AppCompatActivity implements OnGetGeoCoderResultListener {
    private Button btn;
    private List<LocalMedia> selectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
    private int index = 0;
private ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(R.layout.list_item, selectList);
        recyclerView.setAdapter(adapter);
        bar=findViewById(R.id.bar);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });

        // 初始化搜索模块，注册事件监听
        mSearch = GeoCoder.newInstance();
//        mSearch.setOnGetGeoCodeResultListener(this);
    }

    private void requestPermissions() {
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureSelector.create(MyActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(9)
                            .minSelectNum(1)
                            .isCamera(false)// 是否显示拍照按钮
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                } else {
                    Toast.makeText(MyActivity.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (int i = 0; i < selectList.size(); i++) {
                        LocalMedia media = selectList.get(i);
                        String path = media.getPath();
                        Log.i("图片-----》", path);
//                        media.setPictureType(getInfo(path));
                    }
                    index=0;
                    getInfo();
//                    adapter.setNewData(selectList);
                    break;
            }
        }
    }

    private void getInfo() {
        try {
            bar.setVisibility(View.VISIBLE);
            final LocalMedia localMedia = selectList.get(index);
            String path=localMedia.getPath();
            final ExifInterface exifInterface = new ExifInterface(path);
            String latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
            final String latitude_ref = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
            final String longitude_ref = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
            final String longitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
            final double lat = convertRationalLatLonToFloat(latitude, latitude_ref);
            final double lon = convertRationalLatLonToFloat(longitude, longitude_ref);
//            String streetstreet = LocationUtils.getStreet(lat, lon);
            mSearch.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
                @Override
                public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

                }

                @Override
                public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                    String streetstreet = "";
                    if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                        Log.i("getAddress", "null");
                        streetstreet = "null";
                    } else {
                        ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                        if (!TextUtils.isEmpty(addressDetail.province) && !TextUtils.isEmpty(addressDetail.city) && !TextUtils.isEmpty(addressDetail.district)) {
                            Log.i("getAddress", addressDetail.province + addressDetail.city + addressDetail.district);
                            streetstreet = addressDetail.province + addressDetail.city + addressDetail.district;
                        } else {
                            Log.i("getAddress", "null");
                            streetstreet = "null";
                        }
                    }
                    String guangquan = exifInterface.getAttribute(ExifInterface.TAG_APERTURE);
                    String shijain = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
                    String baoguangshijian = exifInterface.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
                    String jiaoju = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
                    String chang = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
                    String kuan = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
                    String moshi = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
                    String zhizaoshang = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
                    String iso = exifInterface.getAttribute(ExifInterface.TAG_ISO);
                    String jiaodu = exifInterface.getAttribute(ExifInterface.TAG_ORIENTATION);
                    String baiph = exifInterface.getAttribute(ExifInterface.TAG_WHITE_BALANCE);
                    String altitude_ref = exifInterface.getAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF);
                    String altitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_ALTITUDE);
                    String timestamp = exifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP);
                    String processing_method = exifInterface.getAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("光圈 = " + guangquan + "\n")
                            .append("时间 = " + shijain + "\n")
                            .append("位置 = " + streetstreet + "\n")
                            .append("曝光时长 = " + baoguangshijian + "\n")
                            .append("焦距 = " + jiaoju + "\n")
                            .append("长 = " + chang + "\n")
                            .append("宽 = " + kuan + "\n")
                            .append("型号 = " + moshi + "\n")
                            .append("制造商 = " + zhizaoshang + "\n")
                            .append("ISO = " + iso + "\n")
                            .append("角度 = " + jiaodu + "\n")
                            .append("白平衡 = " + baiph + "\n")
                            .append("海拔高度 = " + altitude_ref + "\n")
                            .append("GPS参考高度 = " + altitude + "\n")
                            .append("GPS时间戳 = " + timestamp + "\n")
                            .append("GPS定位类型 = " + processing_method + "\n")
                            .append("GPS参考纬度 = " + latitude_ref + "\n")
                            .append("GPS参考经度 = " + longitude_ref + "\n")
                            .append("GPS纬度 = " + lat + "\n")
                            .append("GPS经度 = " + lon + "\n");
                    localMedia.setPictureType(stringBuilder.toString());
                    selectList.set(index,localMedia);
                    index++;
                    if (index<selectList.size()){
                        getInfo();
                    }else if (index==selectList.size()){
                        bar.setVisibility(View.GONE);
                        adapter.setNewData(selectList);
                    }
                }
            });
            CoordinateConverter converter = new CoordinateConverter().from(CoordinateConverter.CoordType.GPS).coord(new LatLng(lat, lon));
            LatLng desLatLng = converter.convert();
            mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(desLatLng).newVersion(0).radius(500));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double convertRationalLatLonToFloat(String rationalString, String ref) {
        if (!TextUtils.isEmpty(rationalString) && !TextUtils.isEmpty(ref)) {
            String[] parts = rationalString.split(",");

            String[] pair;
            pair = parts[0].split("/");
            double degrees = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            pair = parts[1].split("/");
            double minutes = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            pair = parts[2].split("/");
            double seconds = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            double result = degrees + (minutes / 60.0) + (seconds / 3600.0);
            if ((ref.equals("S") || ref.equals("W"))) {
                return -result;
            }
            return result;
        } else {
            return 0;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
        PictureFileUtils.deleteCacheDirFile(MyActivity.this);
    }

    @Override
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
            Log.i("getAddress", "null");
        } else {
            ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
            if (!TextUtils.isEmpty(addressDetail.province) && !TextUtils.isEmpty(addressDetail.city) && !TextUtils.isEmpty(addressDetail.district)) {
                Log.i("getAddress", addressDetail.province + addressDetail.city + addressDetail.district);
            } else {
                Log.i("getAddress", "null");
            }
        }
    }
}
