package cn.usho.jkj.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

/**
 * 项目名称：cn.usho.sosho.base
 * 类描述：  对RecyclerView的adapter做公共抽取的基类
 * 作者：   admin .
 * 日期：   2018/8/9 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public abstract class RecycleBaseAdapter<T, H extends RecycleBaseHolder> extends RecyclerView.Adapter<H> {

    protected Context context;
    protected ArrayList<T> list;
    protected LayoutInflater inflater;

    public RecycleBaseAdapter(Context context, ArrayList<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void addNewData(ArrayList<T> list) {
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size() - list.size(), list.size());
    }

    public void clearData() {
        list.clear();
        notifyDataSetChanged();
    }

    public ArrayList<T> getList() {
        return list;
    }

    @Override
    public int getItemCount() {
        return list.size() + getOtherItemCount();
    }

    /**
     * 返回itemCount,默认为list.size
     * 子类可重写
     *
     * @return
     */
    public int getOtherItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull H holder, int position) {
        if (position < list.size()) {
            T model = list.get(position);
            final int cPosition = position;
            onBindChildViewHolder(holder, model, position);
            if (holder.click_item != null) {
                holder.click_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(v, cPosition);
                        }
                    }
                });
            }
        } else {
            onBindChildViewHolder(holder, null, position);
        }
    }

    protected abstract void onBindChildViewHolder(@NonNull H holder, T model, int position);

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
