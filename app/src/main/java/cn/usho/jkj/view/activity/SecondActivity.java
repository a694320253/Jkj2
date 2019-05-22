package cn.usho.jkj.view.activity;

import android.Manifest;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import cn.usho.jkj.utils.LocationUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SecondActivity extends AppCompatActivity {
    private ImageView image_view;
    private Button btn;
    private TextView textview;
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        image_view = findViewById(R.id.image_view);
        btn = findViewById(R.id.btn);
        textview = findViewById(R.id.textview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });
    }

    private void requestPermissions() {
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureSelector.create(SecondActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(1)
                            .minSelectNum(1)
                            .isCamera(false)// 是否显示拍照按钮
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                } else {
                    Toast.makeText(SecondActivity.this,
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
                    for (LocalMedia media : selectList) {
                        String path = media.getPath();
                        Log.i("图片-----》", path);
                    }
                    if (selectList.size() != 0) {
                        String path = selectList.get(0).getPath();
                        Glide.with(SecondActivity.this).load(path).into(image_view);
                        getInfo(path);
                    }
                    break;
            }
        }
    }

    /**
     * @param path 图片路径
     */
    private void getInfo(String path) {
        try {

            ExifInterface exifInterface = new ExifInterface(path);

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
            String altitude_ref = exifInterface.getAttribute(ExifInterface
                    .TAG_GPS_ALTITUDE_REF);
            String altitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_ALTITUDE);
            String latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
            String latitude_ref = exifInterface.getAttribute(ExifInterface
                    .TAG_GPS_LATITUDE_REF);
            String longitude_ref = exifInterface.getAttribute(ExifInterface
                    .TAG_GPS_LONGITUDE_REF);
            String longitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
            String timestamp = exifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP);
            String processing_method = exifInterface.getAttribute(ExifInterface
                    .TAG_GPS_PROCESSING_METHOD);

            //转换经纬度格式
            double lat = score2dimensionality(latitude);
            double lon = score2dimensionality(longitude);
            String locality = LocationUtils.getLocality(lat, lon);
            String streetstreet = LocationUtils.getStreet(lat, lon);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("光圈 = " + guangquan + "\n")
                    .append("时间 = " + shijain + "\n")
                    .append("位置 = " + locality + "\n")
                    .append("街道 = " + streetstreet + "\n")
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

            //将获取的到的信息设置到TextView上
            textview.setText(stringBuilder.toString());

//            /**
//             * 将wgs坐标转换成百度坐标
//             * 就可以用这个坐标通过百度SDK 去获取该经纬度的地址描述
//             */
//            double[] wgs2bd = GpsUtil.wgs2bd(lat, lon);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将 112/1,58/1,390971/10000 格式的经纬度转换成 112.99434397362694格式
     *
     * @param string 度分秒
     * @return 度
     */
    private double score2dimensionality(String string) {
        double dimensionality = 0.0;
        if (null == string) {
            return dimensionality;
        }

        //用 ，将数值分成3份
        String[] split = string.split(",");
        for (int i = 0; i < split.length; i++) {

            String[] s = split[i].split("/");
            //用112/1得到度分秒数值
            double v = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
            //将分秒分别除以60和3600得到度，并将度分秒相加
            dimensionality = dimensionality + v / Math.pow(60, i);
        }
        return dimensionality;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PictureFileUtils.deleteCacheDirFile(SecondActivity.this);
    }
}
