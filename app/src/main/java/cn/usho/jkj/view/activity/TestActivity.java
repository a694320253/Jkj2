package cn.usho.jkj.view.activity;

import android.Manifest;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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
import cn.usho.jkj.adapter.GridImageAdapter;
import cn.usho.jkj.bean.TestLocalMedia;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestActivity extends AppCompatActivity {
    private List<LocalMedia> selectList = new ArrayList<>();
    private List<TestLocalMedia> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private GridImageAdapter adapter;
    private int maxSelectNum = 9;
    //    private int themeId;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        themeId = R.style.picture_default_style;
        checkbox = findViewById(R.id.checkbox);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager manager = new GridLayoutManager(TestActivity.this, 2);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(TestActivity.this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
//                            PictureSelector.create(TestActivity.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(TestActivity.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(TestActivity.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }
        });

        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(TestActivity.this);
                } else {
                    Toast.makeText(TestActivity.this,
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

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            boolean mode = checkbox.isChecked();
            if (!mode) {
                PictureSelector.create(TestActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            } else {
                // 单独拍照
                PictureSelector.create(TestActivity.this)
                        .openCamera(PictureMimeType.ofImage())// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
//                        .theme(themeId)// 主题样式设置 具体参考 values/styles
                        .maxSelectNum(maxSelectNum)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
//                        .selectionMode(cb_choose_mode.isChecked() ?
//                                PictureConfig.MULTIPLE : PictureConfig.SINGLE)// 多选 or 单选
//                        .previewImage(cb_preview_img.isChecked())// 是否可预览图片
//                        .previewVideo(cb_preview_video.isChecked())// 是否可预览视频
                        .enablePreviewAudio(false) // 是否可播放音频
                        .isCamera(false)// 是否显示拍照按钮
                        .enableCrop(false)// 是否裁剪
                        .compress(false)// 是否压缩
//                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                        .withAspectRatio(aspect_ratio_x, aspect_ratio_y)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                        .hideBottomControls(cb_hide.isChecked() ? false : true)// 是否显示uCrop工具栏，默认不显示
//                        .isGif(cb_isGif.isChecked())// 是否显示gif图片
//                        .freeStyleCropEnabled(cb_styleCrop.isChecked())// 裁剪框是否可拖拽
//                        .circleDimmedLayer(false))// 是否圆形裁剪
//                        .showCropFrame(cb_showCropFrame.isChecked())// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
//                        .showCropGrid(cb_showCropGrid.isChecked())// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
//                        .openClickSound(cb_voice.isChecked())// 是否开启点击声音
                        .selectionMedia(selectList)// 是否传入已选图片
                        .previewEggs(false)//预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.cropCompressQuality(90)// 裁剪压缩质量 默认为100
//                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled() // 裁剪是否可旋转图片
                        //.scaleEnabled()// 裁剪是否可放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()////显示多少秒以内的视频or音频也可适用
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
            }
        }

    };

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
                    list.clear();
                    for (LocalMedia media : selectList) {
                        String path = media.getPath();
                        Log.i("图片-----》", path);
                        try {
                            TestLocalMedia media1 = new TestLocalMedia();
                            ExifInterface exifInterface = new ExifInterface(path);
                            String datetime = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);// 拍摄时间
                            String deviceName = exifInterface.getAttribute(ExifInterface.TAG_MAKE);// 设备品牌
                            String deviceModel = exifInterface.getAttribute(ExifInterface.TAG_MODEL); // 设备型号
                            String latValue = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
                            String lngValue = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
                            String latRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
                            String lngRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
                            media1.setDatetime(datetime);
                            media1.setDeviceName(deviceName);
                            media1.setDeviceModel(deviceModel);
                            media1.setLatValue(latValue);
                            media1.setLngValue(lngValue);
                            list.add(media1);
                            Log.i("图片-----》","拍摄时间"+datetime);
                            Log.i("图片-----》","设备品牌"+deviceName);
                            Log.i("图片-----》","设备型号"+deviceModel);
                            Log.i("图片-----》","拍摄纬度"+latValue);
                            Log.i("图片-----》","拍摄经度"+lngValue);
                            Log.i("图片-----》","拍摄纬度REF"+latRef);
                            Log.i("图片-----》","拍摄经度REF"+lngRef);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                    if (list.size()==selectList.size()){
                        adapter.setSxList(list);
                        adapter.setList(selectList);
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //包括裁剪和压缩后的缓存，要在上传成功后调用，注意：需要系统sd卡权限
        PictureFileUtils.deleteCacheDirFile(TestActivity.this);
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

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("光圈 = " + guangquan+"\n")
                    .append("时间 = " + shijain+"\n")
                    .append("曝光时长 = " + baoguangshijian+"\n")
                    .append("焦距 = " + jiaoju+"\n")
                    .append("长 = " + chang+"\n")
                    .append("宽 = " + kuan+"\n")
                    .append("型号 = " + moshi+"\n")
                    .append("制造商 = " + zhizaoshang+"\n")
                    .append("ISO = " + iso+"\n")
                    .append("角度 = " + jiaodu+"\n")
                    .append("白平衡 = " + baiph+"\n")
                    .append("海拔高度 = " + altitude_ref+"\n")
                    .append("GPS参考高度 = " + altitude+"\n")
                    .append("GPS时间戳 = " + timestamp+"\n")
                    .append("GPS定位类型 = " + processing_method+"\n")
                    .append("GPS参考纬度 = " + latitude_ref+"\n")
                    .append("GPS参考经度 = " + longitude_ref+"\n")
                    .append("GPS纬度 = " + lat+"\n")
                    .append("GPS经度 = " + lon+"\n");

            //将获取的到的信息设置到TextView上
//            mText.setText(stringBuilder.toString());
//
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
     * @param string 度分秒
     * @return 度
     */
    private double score2dimensionality(String string) {
        double dimensionality = 0.0;
        if (null==string){
            return dimensionality;
        }

        //用 ，将数值分成3份
        String[] split = string.split(",");
        for (int i = 0; i < split.length; i++) {

            String[] s = split[i].split("/");
            //用112/1得到度分秒数值
            double v = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
            //将分秒分别除以60和3600得到度，并将度分秒相加
            dimensionality=dimensionality+v/Math.pow(60,i);
        }
        return dimensionality;
    }
}
