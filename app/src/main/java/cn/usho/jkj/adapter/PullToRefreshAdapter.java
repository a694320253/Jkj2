package cn.usho.jkj.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.usho.jkj.base.Status;

public class PullToRefreshAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {


    public PullToRefreshAdapter(int layoutResId, @Nullable List<Status> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {

    }
}
