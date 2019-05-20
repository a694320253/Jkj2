package cn.usho.jkj.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.usho.jkj.bean.Status;

/**
 * 项目名称：cn.usho.jkj.adapter
 * 类描述：
 * 作者：   admin .
 * 日期：   2019/5/20 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class ListAdapter extends BaseQuickAdapter<Status,BaseViewHolder> {

    public ListAdapter(int layoutResId, @Nullable List<Status> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {

    }
}
