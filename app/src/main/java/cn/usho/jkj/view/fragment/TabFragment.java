package cn.usho.jkj.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.usho.jkj.R;
import cn.usho.jkj.base.BaseMvpFragment;
import cn.usho.jkj.contract.FragmentContract;
import cn.usho.jkj.presenter.FragmentPresenter;
import cn.usho.jkj.view.activity.SecondActivity;


public class TabFragment extends BaseMvpFragment<FragmentPresenter> implements FragmentContract.View {

    public static final String BUNDLE_KEY_TITLE = "key_title";
    protected View mView;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_tab, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    private void initView() {
        mPresenter=new FragmentPresenter(this);
        mTv_title = mView.findViewById(R.id.tv_title);
        mTv_title.setText(mTitle);
        mTv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public void changeTitle(String title) {
        if (!isAdded())
            return;
        mTv_title.setText(title);
    }
}