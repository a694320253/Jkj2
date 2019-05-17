package cn.usho.jkj.presenter;

import com.blankj.utilcode.util.LogUtils;
import com.zhouyou.http.EasyHttp;

import cn.usho.jkj.base.BasePresenter;
import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.Status;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.network.DataResultCallback;

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
    public void getData(final String page) {
        EasyHttp.get("community")
                .baseUrl("http://test.api.sosho.cn/")
                .params("per_page", "15")
                .params("sort", "influence_num")
                .params("page", page)
                .execute(new DataResultCallback<DataResultBean<Status>>() {

                    @Override
                    public void onSuccess(DataResultBean<DataResultBean<Status>> dataResultBean, String stringResult) {
                        LogUtils.v("onSuccess--"+dataResultBean.items.size());
                    }

                    @Override
                    public void onFail(Throwable t) {
                        LogUtils.v("onFail--"+t.getMessage());
                    }

                    @Override
                    public void onError(String msg) {
                        LogUtils.v("onError--"+msg);
                    }
                });
    }
}
