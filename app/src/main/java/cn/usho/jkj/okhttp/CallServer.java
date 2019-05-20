package cn.usho.jkj.okhttp;

import android.content.Context;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * Created by l on 2017/5/24.
 */

public class CallServer {

    private static CallServer callServer;

    /**
     * 通过类名调用,获取CallServer对象
     */
    public synchronized static CallServer getRequestInstance() {
        if (callServer == null) {
            callServer = new CallServer();
        }
        return callServer;
    }

    /**
     * 创建一个NoHttp请求队列的对象
     */
    private RequestQueue requestQueue;

    private CallServer() {
        requestQueue = NoHttp.newRequestQueue();
    }

    //添加一个请求到请求队列

    /**
     *
     * @param context   上下文,用来实例化自定义的对话框
     * @param what      标识,用来标志请求,当多个请求使用同一个时,在回调方法中
     * @param callback  网络请求的监听器
     * @param request   请求对象
     * @param canCancle 是否允许用户请求取消
     * @param isLoading 是否显示进度条对话框
     * @param <T>
     */
    public <T> void add(Context context, int what, Request<String> request, HttpListener<T> callback, boolean canCancle, boolean isLoading){
//        request.addHeader(GlobalConstance.PARAM_KEY, GlobalConstance.PARAM_KEY_VALUE);//添加请求头
        requestQueue.add(what,request,new HttpResponseListener<T>(context,request,callback,canCancle,isLoading));
    }


}
