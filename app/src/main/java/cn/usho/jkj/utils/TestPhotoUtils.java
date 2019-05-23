package cn.usho.jkj.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.blankj.utilcode.util.SPUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * @Class: PhotoUtils
 * @Description:
 * @author: lling(www.liuling123.com)
 * @Date: 2015/11/4
 */
public class TestPhotoUtils {


    public static void getPhotos(Context context) {

        Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context.getContentResolver();
        long time = SPUtils.getInstance().getLong(GlobalConstance.CURRENT_TIME);
        // 只查询jpeg和png的图片
        Cursor mCursor = mContentResolver.query(imageUri, null,
                MediaStore.Images.Media.MIME_TYPE + " in(?, ?) and " + MediaStore.Images.Media.DATE_TAKEN + ">" + time,
                new String[]{"image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_MODIFIED + " desc");
//        int pathIndex = mCursor.getColumnIndex(MediaStore.Images.Media.DATA);
//        Log.i("TAGTAG",+mCursor.getCount()+"====="+mCursor.moveToNext()+"time"+time);
        boolean b = mCursor.moveToNext();
        mCursor.close();
        EventBus.getDefault().post(b);
    }

}
