package cn.usho.jkj.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.usho.jkj.R;
import cn.usho.jkj.base.MyApplication;
import cn.usho.jkj.base.MyBaseAdapter;
import cn.usho.jkj.base.MyBaseHolder;
import cn.usho.jkj.bean.PhotoFolder;
import cn.usho.jkj.utils.DisplayImageUtils;


/**
 * 项目名称：cn.usho.sosho.adapter
 * 类描述：
 * 作者：   admin .
 * 日期：   2018/8/27 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class FolderAdapter extends MyBaseAdapter<PhotoFolder, FolderAdapter.MyViewHolder> {

    public FolderAdapter(Context context, ArrayList<PhotoFolder> list) {
        super(context, list);
    }

    @Override
    public int createView() {
        return R.layout.item_folder;
    }

    @Override
    public MyViewHolder bindMyHolder(View convertView, ArrayList<PhotoFolder> list) {
        return new MyViewHolder(convertView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convertData(MyViewHolder holder, PhotoFolder model, int position) {
        boolean selected = model.isSelected();
        if(selected) {
            holder.ivSelect.setVisibility(View.VISIBLE);
        }else {
            holder.ivSelect.setVisibility(View.GONE);
        }
        holder.tvName.setText(model.getName());
        holder.tvNum.setText(model.getPhotoList().size()+"张");
        DisplayImageUtils.displayImageAsBitmap(MyApplication.getContext(),model.getPhotoList().get(0).pic_path,
                holder.ivPic,R.drawable.ic_photo_loading);
    }

    static class MyViewHolder extends MyBaseHolder {

        ImageView ivPic;
        TextView tvName;
        TextView tvNum;
        ImageView ivSelect;

        public MyViewHolder(View convertView) {
            super(convertView);
            ivPic=convertView.findViewById(R.id.iv_pic);
            tvName=convertView.findViewById(R.id.tv_name);
            tvNum=convertView.findViewById(R.id.tv_num);
            ivSelect=convertView.findViewById(R.id.iv_select);
        }
    }
}
