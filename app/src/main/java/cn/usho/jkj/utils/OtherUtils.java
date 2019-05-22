package cn.usho.jkj.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import cn.usho.jkj.base.MyApplication;

/**
 * @Class:
 * @Description: 工具类
 * @author: lling(www.liuling123.com)
 * @Date: 2015/11/4
 */
public class OtherUtils {

    /**
     * 判断外部存储卡是否可用
     *
     * @return
     */
    public static boolean isExternalStorageAvailable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    public static int getHeightInPx(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWidthInPx(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeightInDp(Context context) {
        final float height = context.getResources().getDisplayMetrics().heightPixels;
        return px2dip(context, height);
    }

    public static int getWidthInDp(Context context) {
        final float width = context.getResources().getDisplayMetrics().widthPixels;
        return px2dip(context, width);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据string.xml资源格式化字符串
     *
     * @param context
     * @param resource
     * @param args
     * @return
     */
    public static String formatResourceString(Context context, int resource, Object... args) {
        String str = context.getResources().getString(resource);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format(str, args);
    }

    /**
     * 获取拍照相片存储文件
     *
     * @param context
     * @return
     */
    public static File createFile(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(Environment.getExternalStorageDirectory() +
                    File.separator + timeStamp + ".jpg");
        } else {
            File cacheDir = context.getCacheDir();
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(cacheDir, timeStamp + ".jpg");
        }
        return file;
    }

    /**
     * 获取磁盘缓存文件
     *
     * @param context
     * @param uniqueName
     * @return
     */
    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    /**
     * 获取应用程序版本号
     *
     * @param context
     * @return
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 发送短信
     *
     * @param mobile
     */
    public static void sendSMS(String mobile) {
        if (TextUtils.isEmpty(mobile)) return;
        //"smsto:xxx" xxx是可以指定联系人的
        Uri smsToUri = Uri.parse("smsto:" + mobile);
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.getContext().startActivity(intent);
    }

    /**
     * 拨打电话
     *
     * @param mobile
     */
    public static void openCallWindow(String mobile) {
        if (TextUtils.isEmpty(mobile)) return;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobile));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.getContext().startActivity(intent);
    }

//    public static void openQQApplication(String number) {
//        if (checkApkExist("com.tencent.mobileqq")) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + number + "&version=1"));
//            MyApplication.getContext().startActivity(intent);
//        } else {
//            ToastUtils.showToast("未找到QQ应用");
//        }
//    }
//
//    public static boolean checkApkExist(String packageName) {
//        if (TextUtils.isEmpty(packageName))
//            return false;
//        try {
//            ApplicationInfo info = BaseApplicationLike.getMyApplicationContext().getPackageManager().getApplicationInfo(packageName,
//                    PackageManager.GET_UNINSTALLED_PACKAGES);
//            return true;
//        } catch (PackageManager.NameNotFoundException e) {
//            return false;
//        }
//    }

//    /**
//     * 发送邮件
//     *
//     * @param email
//     */
//    public static void sendEmail(String email) {
//        if (TextUtils.isEmpty(email)) return;
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        // i.setType("text/plain"); //模拟器请使用这行
//        intent.setType("message/rfc822"); // 真机上使用这行
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//        Intent startIntent = Intent.createChooser(intent, "请选择邮件类应用");
//        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        BaseApplicationLike.getMyApplicationContext().startActivity(startIntent);
//    }

    public static boolean isFileExists(String url) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getFileName(url));
        return file.exists();
    }

    public static String getFileName(String url) {
        String[] split = url.split("/");
        return split[split.length - 1];
    }

    //检查SD卡是否有足够的空间
    public static boolean isSDAvailable() {
        int minimum = 5; //要求sd卡最少可用空间已M为单位
        long size = minimum * 1024 * 1024;
        if (getSDFreeSpace() > size) {
            return true;
        } else {
            return false;
        }
    }

    private static long getSDFreeSpace() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        long blockSize = stat.getBlockSizeLong();
        long availableBlocks = stat.getAvailableBlocksLong();
        return availableBlocks * blockSize;
    }
}
