package cn.usho.jkj.base;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.squareup.leakcanary.LeakCanary;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.model.HttpHeaders;

import cn.usho.jkj.utils.GlobalConstance;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：cn.usho.jkj.bean
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/15 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EasyHttp.init(this);
        //全局设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.put(GlobalConstance.PARAM_KEY, GlobalConstance.PARAM_KEY_VALUE);
        headers.put("version", "v2.5.6");
        headers.put("uid", "1662951");
        headers.put("model", "MIX 2S");
        headers.put("access-token", "e85abe0b971cd0276eb074a6652e1dc5");
        headers.put("expire-timestamp", "1589506145");
        EasyHttp.getInstance().addCommonHeaders(headers).debug("EasyHttp", true).addConverterFactory(GsonConverterFactory.create());
        LogUtils.getConfig().setLogSwitch(true).setBorderSwitch(false).
                setLogHeadSwitch(false).setLog2FileSwitch(false).setGlobalTag("TAGTAG");
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
