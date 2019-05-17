package cn.usho.jkj.network;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.exception.ApiException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.ResultInfo;

/**
 * 项目名称：cn.usho.sosho.network
 * 类描述：  网络请求回调,解析数据为javaBean
 * 这玩意儿不是唯一的解决方法
 * 你也可以使用GsonConverterFactory
 * 作者：   Even_for .
 * 日期：   2018/4/17 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public abstract class DataResultCallback<T> extends CallBack<String> {

    @Override
    public void onStart() {
    }

    @Override
    public void onCompleted() {

    }
    @Override
    public void onError(ApiException e) {
        onFail(e);
    }

    @Override
    public void onSuccess(String s) {
        parseStringResult(s);
    }

    private Class<?> clazz;
    private static final String TAG = "DataResultCallBack";
    private Gson gson;


    protected DataResultCallback() {
        List<Class<?>> list = new ArrayList<>();
        getGenericType(getClass(), list, 0);
        clazz = list.size() > 0 ? list.get(0) : Object.class;
        gson = new Gson();
    }

    protected DataResultCallback(Class<?> clazz) {
        this.clazz = clazz;
        gson = new Gson();
    }

//    @Override
//    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
//        if (response.isSuccessful()) {
//            parseStringResult(response);
//        } else {
//            onError("服务器出错了");
//        }
//    }
//
//    @Override
//    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
//        onFail(t);
//        LogUtils.i(TAG, "onFailure : " + t.getMessage());
//    }

    /**
     * 解析数据转换为与服务器约定的格式
     * (此方法不是唯一实现方法,也可以直接自定义converterFactory)
     *
//     * @param response
     */
    private void parseStringResult(  String stringResult ) {
//        String stringResult = response.body();
        try {
            //获取数据模型类型
            ResultModuleType<T> responseResult = (ResultModuleType<T>) new ResultModuleType<>(clazz);
            //解析数据为公共数据bean
            DataResultBean<T> data = gson.fromJson(stringResult, responseResult);
            checkData(data, stringResult,stringResult);
        } catch (JsonSyntaxException e) {
            onParseException(stringResult, stringResult);
        }
    }


    // 获取泛型类型
    private void getGenericType(Class<?> clazz, List<Class<?>> clazzList, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            getGenericType((Class<?>) genType, clazzList, index);
        } else {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (index >= params.length || index < 0) {
                throw new RuntimeException("Index outof bounds");
            }
            if ((params[index] instanceof Class)) {
                clazzList.add((Class<?>) params[index]);
                return;
            }
        }
    }


    private void checkData(DataResultBean<T> data, String stringResult, String resString) {
        if (data != null) {
            ResultInfo result = data.result;
            if (result != null && !TextUtils.isEmpty(result.message)) {
                onError(result.message);
            } else {
                onSuccess(data, stringResult);
            }
        } else {
            onParseException(stringResult, resString);
        }
    }

    /**
     * gson解析数据异常
     */
    private void onParseException(String stringResult, String resString) {
        //ToastUtils.showToast(BaseApplication.getMyApplicationContext(), "数据异常");
        onError("数据异常");
        LogUtils.i(TAG, "ExceptionResult : " + stringResult);
        LogUtils.i(TAG, "ResponseString : " + resString);
    }

    /**
     * 返回指定泛型数据模型
     *
     * @param <T>
     */
    private static class ResultModuleType<T> implements ParameterizedType {
        //这里的class为定义的泛型
        //最终返回的bean按此泛型的bean返回具体数据
        private Class<T> type;

        public ResultModuleType(Class<T> type) {
            this.type = type;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{type};
        }

        //返回最外层response的bean类型
        public Type getRawType() {
            return DataResultBean.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }


    /**
     * 请求成功
     *
     * @param dataResultBean javaBean类型response.body
     * @param stringResult   string类型response.body
     */
    public abstract void onSuccess(DataResultBean<T> dataResultBean, String stringResult);

    /**
     * 请求失败
     *
     * @param t 失败异常
     */
    public abstract void onFail(Throwable t);

    /**
     * 请求返回错误
     *
     * @param msg 错误提示
     */
    public abstract void onError(String msg);

}
