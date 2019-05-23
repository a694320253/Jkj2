package cn.usho.jkj.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.usho.jkj.bean.PhotoFolder;
import cn.usho.jkj.bean.PhotoModel;

/**
 * @Class: PhotoUtils
 * @Description:
 * @author: lling(www.liuling123.com)
 * @Date: 2015/11/4
 */
public class PhotoUtils {


    public static Map<String, PhotoFolder> getPhotos(Context context) {
        Map<String, PhotoFolder> folderMap = new HashMap<>();

        String allPhotosKey = "所有图片";
        PhotoFolder allFolder = new PhotoFolder();
        allFolder.setName(allPhotosKey);
        allFolder.setDirPath(allPhotosKey);
        allFolder.setPhotoList(new ArrayList<PhotoModel>());
        folderMap.put(allPhotosKey, allFolder);

        Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context.getContentResolver();

        // 只查询jpeg和png的图片
        Cursor mCursor = mContentResolver.query(imageUri, null,
                MediaStore.Images.Media.MIME_TYPE + " in(?, ?)",
                new String[]{"image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_MODIFIED + " desc");

        int pathIndex = mCursor
                .getColumnIndex(MediaStore.Images.Media.DATA);
        int date_addedIndex = mCursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED);
        int date_modifiedIndex = mCursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED);
        int latitudeIndex = mCursor.getColumnIndex(MediaStore.Images.Media.LATITUDE);
        int longitudeIndex = mCursor.getColumnIndex(MediaStore.Images.Media.LONGITUDE);
        int DATE_TAKENIndex = mCursor.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN);
//        Log.i("PhotoUtils", "getCount " + mCursor.getCount() + "        length " + mCursor.getColumnNames().length);
//        for (int i = 0; i < mCursor.getColumnNames().length; i++) {
//            Log.i("PhotoUtils", mCursor.getColumnNames()[i]);
//        }
//        Log.i("PhotoUtils", "当前时间" + System.currentTimeMillis() + "  " + TimeUtils.millis2String(System.currentTimeMillis()));
        if (mCursor.moveToFirst()) {
            do {
                // 获取图片的路径
                String path = mCursor.getString(pathIndex);
//                long date_modified = mCursor.getLong(date_modifiedIndex);
//                long date_added = mCursor.getLong(date_addedIndex);
//                long datetaken = mCursor.getLong(DATE_TAKENIndex);
//                double latitude = mCursor.getDouble(latitudeIndex);
//                double longitude = mCursor.getDouble(longitudeIndex);
//                String addTime = TimeUtils.millis2String(date_added);
//                String modifiedTime = TimeUtils.millis2String(date_modified);
//                String datetakenTime = TimeUtils.millis2String(datetaken);
//                Log.i("PhotoUtils", path + "  date_added>" + date_added +" "+ addTime + "  date_modified>" + date_modified +" "+modifiedTime+ "  latitude>" + latitude
//                        + "  longitude>" + longitude+" datetaken>"+datetaken+"  datetakenTime>"+datetakenTime);
                // 获取该图片的父路径名
                File parentFile = new File(path).getParentFile();
                if (parentFile == null) {
                    continue;
                }
                String dirPath = parentFile.getAbsolutePath();

                if (folderMap.containsKey(dirPath)) {
                    PhotoModel photo = new PhotoModel(path);
                    PhotoFolder photoFolder = folderMap.get(dirPath);
                    photoFolder.getPhotoList().add(photo);
                    folderMap.get(allPhotosKey).getPhotoList().add(photo);
                    continue;
                } else {
                    // 初始化imageFolder
                    PhotoFolder photoFolder = new PhotoFolder();
                    ArrayList<PhotoModel> photoList = new ArrayList<>();
                    PhotoModel photo = new PhotoModel(path);
                    photoList.add(photo);
                    photoFolder.setPhotoList(photoList);
                    photoFolder.setDirPath(dirPath);
                    photoFolder.setName(dirPath.substring(dirPath.lastIndexOf(File.separator) + 1, dirPath.length()));
                    folderMap.put(dirPath, photoFolder);
                    folderMap.get(allPhotosKey).getPhotoList().add(photo);
                }
            } while (mCursor.moveToNext());
        }
        mCursor.close();
        return folderMap;
    }

}
