package cn.usho.jkj.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * 项目名称：cn.usho.sosho.utils
 * 类描述：
 * 作者：   admin .
 * 日期：   2016/9/2 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class DisplayImageUtils {


    public static void displayImageAsBitmapNormal(Context context, String url, ImageView view, int placeholder) {
//        Glide.with(context)
//                .asBitmap()
//                .load(url)
//                .placeholder(placeholder)
//                .error(placeholder)
//                .into(view);
    }

    public static void displayImageAsBitmap(Context context, String url, ImageView view, int placeholder) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                .error(placeholder);
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(options)
                .into(view);
    }


    public static void displayImage(Context context, String url, ImageView view, int placeholder) {

//        Glide.with(context)
//                .asGif()
//                .load(url)
//                .placeholder(placeholder)
//                .error(placeholder)
//                .centerCrop()
//                .into(view);
    }

    public static void displayAvatarPicture(Context context, String url, ImageView view) {
//        Glide.with(context)
//                .asBitmap()
//                .load(url)
//                .placeholder(R.drawable.avatar_placeholder)
//                .error(R.drawable.avatar_placeholder)
//                .transform(new CircleCrop())
//                .centerCrop()
//                .into(view);
    }


    public static void displayCirclePicture(Context context, String url, ImageView view) {

//        Glide.with(context)
//                .asBitmap()
//                .load(url)
//                .placeholder(R.drawable.circle_pic_placeholder)
//                .error(R.drawable.circle_pic_placeholder)
//                .transform(new CircleCrop())
//                .centerCrop()
//                .into(view);
    }


    public static void displayNormalPic(Context context, String url, ImageView view) {

//        Glide.with(context)
//                .asBitmap()
//                .load(url)
//                .placeholder(R.drawable.pic_load_fail2)
//                .error(R.drawable.pic_load_fail2)
//                .centerCrop()
//                .into(view);
    }


    public static void cleanImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
