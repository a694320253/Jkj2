package cn.usho.jkj.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.usho.jkj.R;
import cn.usho.jkj.base.MyApplication;
import cn.usho.jkj.base.RecycleBaseAdapter;
import cn.usho.jkj.base.RecycleBaseHolder;
import cn.usho.jkj.bean.PhotoModel;
import cn.usho.jkj.utils.DisplayImageUtils;


/**
 * 项目名称：cn.usho.sosho.adapter
 * 类描述：
 * 作者：   admin .
 * 日期：   2018/8/27 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class PhotoAdapter extends RecycleBaseAdapter<PhotoModel,PhotoAdapter.MyViewHolder> {
    private Drawable normalShape;
    private Drawable selectedShape;
    private ArrayList<String> selectedList;

    public PhotoAdapter(Context context, ArrayList<PhotoModel> list) {
        super(context, list);
        normalShape = context.getResources().getDrawable(R.drawable.photo_normal_shape);
        selectedShape = context.getResources().getDrawable(R.drawable.photo_selected_shape);
    }

    @Override
    protected void onBindChildViewHolder(@NonNull MyViewHolder holder, PhotoModel model, int position) {

        boolean isShowSelector = list.get(0).isShowSelector;
        boolean isSelected = model.isSelected;
        String pic_path = model.pic_path;

        if ("camera".equals(pic_path)) {
            holder.ivPic.setVisibility(View.INVISIBLE);
            holder.tvSelector.setVisibility(View.GONE);
            if (model.isShowCamera) {
                holder.tvCamera.setVisibility(View.VISIBLE);
            } else {
                holder.tvCamera.setVisibility(View.GONE);
            }

        } else {
            holder.ivPic.setVisibility(View.VISIBLE);
            holder.tvCamera.setVisibility(View.GONE);

            DisplayImageUtils.displayImageAsBitmap(MyApplication.getContext()
                    , pic_path, holder.ivPic, R.drawable.ic_photo_loading);

            if (isShowSelector) {
                holder.tvSelector.setVisibility(View.VISIBLE);
            } else {
                holder.tvSelector.setVisibility(View.GONE);
            }

            if (isSelected) {
                holder.tvSelector.setBackground(selectedShape);
            } else {
                holder.tvSelector.setBackground(normalShape);
            }

            int selectedIndex = selectedList.indexOf(pic_path);

            if (selectedIndex != -1) {
                holder.tvSelector.setText(String.valueOf(selectedIndex + 1));
            } else {
                holder.tvSelector.setText("");
            }
        }

    }

    public void setSelectedList(ArrayList<String> selectedList) {
        this.selectedList = selectedList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_photo,parent,false));
    }

    static class MyViewHolder extends RecycleBaseHolder {

        ImageView ivPic;
        TextView tvSelector;
        TextView tvCamera;

        public MyViewHolder(View convertView) {
            super(convertView);
            ivPic=convertView.findViewById(R.id.iv_pic);
            tvSelector=convertView.findViewById(R.id.tv_selector);
            tvCamera=convertView.findViewById(R.id.tv_camera);
        }
    }
}
