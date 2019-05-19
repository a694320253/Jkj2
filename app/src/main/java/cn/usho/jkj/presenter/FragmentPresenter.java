package cn.usho.jkj.presenter;

import android.content.Context;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import cn.usho.jkj.base.BasePresenter;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.okhttp.CallServer;
import cn.usho.jkj.okhttp.HttpListener;
import cn.usho.jkj.utils.GlobalConstance;

/**
 * 项目名称：cn.usho.jkj.presenter
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/15 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class FragmentPresenter extends BasePresenter<FragmentContract.View> implements FragmentContract.Presenter {

    public FragmentPresenter(FragmentContract.View mView) {
        super(mView);
    }

    @Override
    public void getData(final String page, Context context) {
        Request<String> request = NoHttp.createStringRequest("http://test.api.sosho.cn/community", RequestMethod.GET);
        request.addHeader(GlobalConstance.PARAM_KEY, GlobalConstance.PARAM_KEY_VALUE);
        request.add("per_page", "15")
                .add("sort", "influence_num")
                .add("page", page);
        CallServer callServerInstance = CallServer.getRequestInstance();
        callServerInstance.add(context, 0, request, new HttpListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {

            }

            @Override
            public void onFailed(int what, Response<String> response) {

            }
        }, true, true);
    }
}
