package cn.usho.jkj.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：cn.usho.sosho.base
 * 类描述：  recyclerView的viewHolder
 * 作者：   admin .
 * 日期：   2018/8/9 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class RecycleBaseHolder extends RecyclerView.ViewHolder{
    protected final View click_item;

    public RecycleBaseHolder(View itemView) {
        super(itemView);
        click_item = itemView.findViewWithTag("click_item");
    }
}
