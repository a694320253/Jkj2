package cn.usho.jkj.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;

import cn.usho.jkj.R;
import cn.usho.jkj.adapter.PullToRefreshAdapter;
import cn.usho.jkj.base.BaseMvpFragment;
import cn.usho.jkj.bean.DataResultBean;
import cn.usho.jkj.bean.Status;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.presenter.FragmentPresenter;


public class ActivityFragment extends BaseMvpFragment<FragmentPresenter> implements FragmentContract.View {

    public static final String BUNDLE_KEY_TITLE = "key_title";
    private String mTitle;
    private TextView mTv_title;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private int mNextRequestPage = 1;
    private PullToRefreshAdapter adapter;
    public static ActivityFragment newInstance(String mTitle) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_TITLE, mTitle);
        ActivityFragment tabFragment = new ActivityFragment();
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
        LogUtils.v("ActivityFragment------"+"onCreate");
    }


    @Override
    public void initData() {
        mPresenter=new FragmentPresenter(this);
        LogUtils.v("ActivityFragment------"+"initData");
        refresh();
    }
    private void refresh() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
        if (adapter!=null){
            adapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        }
        mNextRequestPage = 1;
        mPresenter.getData(String.valueOf(mNextRequestPage), mContext);
    }
    @Override
    protected void initView(View view) {
        LogUtils.v("ActivityFragment------"+"initView");
        mTv_title = view.findViewById(R.id.tv_title);
        mTv_title.setText(mTitle);
        mRecyclerView = view.findViewById(R.id.rv_list);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtils.v("onRefresh----------");
                refresh();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        LogUtils.v("ActivityFragment------"+"getLayoutId");
        return R.layout.fragment_tab;
    }

    @Override
    public void getDataListSucce(DataResultBean<Status> data) {
//        mSwipeRefreshLayout.setRefreshing(false);
        if (data != null && data.items != null) {
            if (mNextRequestPage == 1) {
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                adapter = new PullToRefreshAdapter(R.layout.adapter_layout, data.items);
                adapter.setLoadMoreView(new SimpleLoadMoreView());
                adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        loadMore();
                    }
                });
//                adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                mRecyclerView.setAdapter(adapter);
            } else if (adapter != null) {
                adapter.addData(data.items);
            }
        }
    }

    private void loadMore() {
        mNextRequestPage++;
        mPresenter.getData(String.valueOf(mNextRequestPage), mContext);
    }


    @Override
    public void onFinish(int what) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (adapter != null) {
            adapter.setEnableLoadMore(true);
            adapter.loadMoreComplete();
        }
    }
}