package cn.usho.jkj.utils;

import android.content.Context;
import android.widget.Toast;

import cn.usho.jkj.base.MyApplication;

/**
 * Toast工具类,优化Toast
 * Created by HDL on 2016/7/26.
 */
public class ToastUtils {
    private static Toast mToast;


    public static void showToast(String content) {
        showToast(MyApplication.getContext(), content);
    }

    /**
     * 显示对话框
     *
     * @param content 要显示的内容
     */
    public static void showToast(Context context, String content) {

        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        mToast.show();
    }

    public static void cancel() {

        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * 销毁Toast
     */
    public static void clearToast() {
        if (mToast != null) {
            mToast = null;
        }
    }
}
