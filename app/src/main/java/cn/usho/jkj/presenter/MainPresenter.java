package cn.usho.jkj.presenter;

import cn.usho.jkj.base.BasePresenter;
import cn.usho.jkj.contract.MainContract;

/**
 * 项目名称：cn.usho.jkj.presenter
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/15 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View mView) {
        super(mView);
    }
}
