package cn.usho.jkj.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;

import cn.usho.jkj.R;
import cn.usho.jkj.base.BaseMvpFragment;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.presenter.FragmentPresenter;
import cn.usho.jkj.view.activity.SecondActivity;


public class TabFragment extends BaseMvpFragment<FragmentPresenter> implements FragmentContract.View {

    public static final String BUNDLE_KEY_TITLE = "key_title";
    private String mTitle;
    private TextView mTv_title;


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
        LogUtils.v("onCreate");
    }


    @Override
    public void initData() {
        mPresenter=new FragmentPresenter(this);
        LogUtils.v("initData");
    }

    @Override
    protected void initView(View view) {
        LogUtils.v("initView");
        mTv_title = view.findViewById(R.id.tv_title);
        mTv_title.setText(mTitle);
        mTv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutId() {
        LogUtils.v("getLayoutId");
        return R.layout.fragment_tab;
    }
}