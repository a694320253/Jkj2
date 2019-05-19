package cn.usho.jkj.base;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.squareup.leakcanary.LeakCanary;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;

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
        NoHttp.initialize(this);
        Logger.setDebug(true);// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setTag("NoHttpSample");// 打印Log的tag。
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
