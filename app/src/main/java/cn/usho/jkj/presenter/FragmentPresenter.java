package cn.usho.jkj.presenter;

import android.content.Context;

import com.blankj.utilcode.util.GsonUtils;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import cn.usho.jkj.base.BasePresenter;
import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.Status;
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
public class FragmentPresenter extends BasePresenter<FragmentContract.View> implements FragmentContract.Presenter, HttpListener<String> {

    public FragmentPresenter(FragmentContract.View mView) {
        super(mView);
    }

    @Override
    public void getData(final String page, Context context) {
        Request<String> request = NoHttp.createStringRequest(GlobalConstance.getBaseUrl(GlobalConstance.URL_COMMUNITY), RequestMethod.GET);
        request.add("per_page", "15")
                .add("sort", "influence_num")
                .add("page", page);
        CallServer callServerInstance = CallServer.getRequestInstance();
        callServerInstance.add(context, GlobalConstance.TASK_ONE, request, this, true, false);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        switch (what) {
            case GlobalConstance.TASK_ONE:
                DataResultBean<Status> data = GsonUtils.fromJson(response.get(), GsonUtils.getType(DataResultBean.class, Status.class));
                mView.getDataListSucce(data);
                break;
        }

    }

    @Override
    public void onFailed(int what, Response<String> response) {
        mView.onError(response.getException());
    }

    @Override
    public void onFinish(int what) {
        mView.onFinish(what);
    }
}
