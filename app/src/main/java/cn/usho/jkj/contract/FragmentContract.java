package cn.usho.jkj.contract;

import android.content.Context;

import cn.usho.jkj.base.BaseView;
import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.Status;

/**
 * 项目名称：cn.usho.jkj.contract
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/15 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public interface FragmentContract {

    interface View  extends BaseView{
        void  getDataListSucce(DataResultBean<Status> data);
    }

    interface Presenter {


        void getData(String page, Context context);
    }
}
