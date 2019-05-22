package cn.usho.jkj.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


/**
 * 项目名称：cn.sosho.admin2
 * 类描述：  一个比较简单的对BaseAdapter做公共抽取的基类
 * 若要增删功能可在此类中操作
 * 作者：   admin .
 * 日期：   2017/6/26 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */

public abstract class MyBaseAdapter<T, H extends MyBaseHolder> extends BaseAdapter {

    public Context context;
    public ArrayList<T> list;

    private final static int TYPE_NORMAL = 1;

    public MyBaseAdapter(Context context, ArrayList<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size() + getCustomItemTypeCount();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int itemType = getItemType(position);

        if (itemType == TYPE_NORMAL) {
            H holder;
            T dataInfo = getItem(position);

            if (convertView == null) {
                convertView = View.inflate(context, createView(), null);

                holder = bindMyHolder(convertView, list);

                convertView.setTag(holder);

            } else {
                holder = (H) convertView.getTag();
            }

            convertData(holder, dataInfo, position);
            if (holder.clickView != null) {
                final int currentPosition = position;
                holder.clickView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(view, currentPosition);
                        }
                    }
                });
            }
        } else {
            setCustomView(position, convertView, parent);
        }

        return convertView;
    }


    public abstract int createView();

    public abstract H bindMyHolder(View convertView, ArrayList<T> list);

    public abstract void convertData(H holder, T model, int position);

    public void setCustomView(int position, View convertView, ViewGroup parent) {

    }

    public int getItemType(int position) {
        return TYPE_NORMAL;
    }

    public int getCustomItemTypeCount() {
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void add(T t) {
        list.add(t);
        notifyDataSetChanged();
    }

    public void remove(T t) {
        list.remove(t);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<T> t) {
        list.remove(t);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }
}
