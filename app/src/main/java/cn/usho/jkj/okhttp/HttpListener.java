package cn.usho.jkj.okhttp;

import com.yanzhenjie.nohttp.rest.Response;

/**
 * Created by l on 2017/5/24.
 */

public interface HttpListener<T> {
    //请求网络成功回调的方法
    void onSucceed(int what, Response<String> response);
    //请求网络失败回调的监听方法
    void onFailed(int what, Response<String> response);
}
