package cn.usho.jkj.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;

import cn.usho.jkj.R;
import cn.usho.jkj.adapter.PullToRefreshAdapter;
import cn.usho.jkj.base.BaseMvpFragment;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.presenter.FragmentPresenter;


public class TabFragment extends BaseMvpFragment<FragmentPresenter> implements FragmentContract.View {

    public static final String BUNDLE_KEY_TITLE = "key_title";
    private String mTitle;
    private TextView mTv_title;
    private static final int PAGE_SIZE = 6;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PullToRefreshAdapter mAdapter;
    private int mNextRequestPage = 1;

    public static TabFragment newInstance(String mTitle) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_TITLE, mTitle);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mTitle = arguments.getString(BUNDLE_KEY_TITLE, "");
        }
        LogUtils.v("TabFragment------" + "onCreate");
    }


    @Override
    public void initData() {
        mPresenter = new FragmentPresenter(this);
//        mSwipeRefreshLayout.setRefreshing(true);
        LogUtils.v("TabFragment------" + "initData");
        refresh();
    }

    private void refresh() {
//        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.getData(String.valueOf(mNextRequestPage));

    }

    @Override
    protected void initView(View view) {
        LogUtils.v("TabFragment------" + "initView");
        mTv_title = view.findViewById(R.id.tv_title);
        mTv_title.setText(mTitle);
        mRecyclerView = view.findViewById(R.id.rv_list);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeLayout);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtils.v("onRefresh----------");
                refresh();
                new Handler().postDelayed(new Runnable() {//模拟耗时操作
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);//取消刷新

                    }
                }, 2000);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        LogUtils.v("TabFragment------" + "getLayoutId");
        return R.layout.fragment_tab;
    }
}