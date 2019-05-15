package cn.usho.jkj.presenter;

import cn.usho.jkj.base.BasePresenter;
import cn.usho.jkj.contract.FragmentContract;

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
}
