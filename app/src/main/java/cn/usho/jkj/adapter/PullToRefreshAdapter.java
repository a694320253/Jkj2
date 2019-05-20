package cn.usho.jkj.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.usho.jkj.R;
import cn.usho.jkj.bean.Status;
import cn.usho.jkj.utils.DisplayImageUtils;

public class PullToRefreshAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {


    public PullToRefreshAdapter(int layoutResId, @Nullable List<Status> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.setText(R.id.name_tv, item.getName());
        DisplayImageUtils.displayImageAsBitmap(mContext,item.getLogo_path(), (ImageView) helper.getView(R.id.profile_image),R.drawable.circle_pic_placeholder);
    }
}
