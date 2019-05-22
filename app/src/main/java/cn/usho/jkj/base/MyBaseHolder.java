package cn.usho.jkj.base;

import android.view.View;


/**
 * 项目名称：cn.sosho.admin2
 * 类描述：  一个非常简单的对ViewHolder做抽取的基类
 * 作者：   admin .
 * 日期：   2017/6/26 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */

public abstract class MyBaseHolder {
    private View convertView;
    public View clickView;

    public MyBaseHolder(View convertView) {
        this.convertView = convertView;
        clickView = convertView.findViewWithTag("click_item");
    }

    public View getConvertView() {
        return convertView;
    }

}
