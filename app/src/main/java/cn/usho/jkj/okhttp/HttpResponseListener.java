package cn.usho.jkj.okhttp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import cn.usho.jkj.R;
import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.ResultInfo;
import cn.usho.jkj.view.customview.LoadingDialog;

/**
 * Created by l on 2017/5/24.
 */

public class HttpResponseListener<T> implements OnResponseListener {

    //使用自定义的一个进度条对话框
//    private WaitDialog waitDialog;
    Dialog waitDialog;
    //使用自定义的监听方法的接口类
    private HttpListener<T> callback;
    //定义一个标识,看是否在加载
    private boolean isLoading;
    //一个NoHttp队列
    private Request<?> request;
    private LoadingDialog dialog;

    /**
     * @param context   上下文
     * @param request   NoHttp的队列对象
     * @param canCancle 判断进度条对话框是否可以取消
     * @param callback  我们自定义的一个接口对象,就是那个复写NoHttp成功失败的类
     * @param isLoading 判断进度条对话框是否正在加载状态
     */
    public HttpResponseListener(Context context, Request<?> request, HttpListener<T> callback, boolean canCancle, boolean isLoading) {
        this.callback = callback;
        this.request = request;
        this.isLoading = isLoading;
        //对上下文进行非空判断及判断进度条对话框是否显示
        if (context != null && isLoading) {
//            dialog = new LoadingDialog(context, "正在请求网络,请稍候...");
//            waitDialog = dialog.mLoadingDialog;
            waitDialog = new WaitDialog(context, R.style.loading_dialog);
            waitDialog.setCancelable(canCancle);
            //当对话框点击外面可以取消,那么就让它取消掉逻辑代码
            waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    Log.i("setOnCancelListener", "setOnCancelListener");
                    HttpResponseListener.this.request.cancel();
                }
            });
        }
    }

    //请求开始时回调,进度条对话框显示
    @Override
    public void onStart(int what) {
        //判断进度条对话框是否处于加载状态,进度条对话框对象是否存在,进度条对话框是否显示
        if (isLoading && waitDialog != null && !waitDialog.isShowing()) {
            waitDialog.show();
//            dialog.show();
        }
    }

    //网络请求成功时回调,代码直接运行在主线程
    @Override
    public void onSucceed(int what, Response response) {
        //使用的是自己定义的接口,先判断接口对象是否为null,不为null,执行
        LogUtils.i("服务器数据：" + response.get());
        if (callback != null) {
            try {
                DataResultBean data = GsonUtils.fromJson(response.get().toString(), DataResultBean.class);
                if (data != null) {
                    ResultInfo result = data.result;
                    if (result != null && !TextUtils.isEmpty(result.message)) {
                        ToastUtils.showShort(result.message);
                    } else {
                        callback.onSucceed(what, response);
                    }
                } else {
                    ToastUtils.showShort("服务器出错了");
                }
            } catch (Exception e) {
                ToastUtils.showShort("数据解析错误");
            }

        }
    }

    //网络请求失败时回调,代码直接运行在主线程
    @Override
    public void onFailed(int what, Response response) {
        if (callback != null) {
            callback.onFailed(what, response);
        }
    }

    //请求网络结束时回调,进度条对话框隐藏
    @Override
    public void onFinish(int what) {
        if (callback!=null)callback.onFinish(what);
        if (isLoading && waitDialog != null && waitDialog.isShowing()) {
            waitDialog.dismiss();
//            dialog.close();
        }
    }
}
