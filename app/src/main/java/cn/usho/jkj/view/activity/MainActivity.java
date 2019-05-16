package cn.usho.jkj.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.usho.jkj.R;
import cn.usho.jkj.base.BaseFragment;
import cn.usho.jkj.base.BaseMvpActivity;
import cn.usho.jkj.contract.MainContract;
import cn.usho.jkj.presenter.MainPresenter;
import cn.usho.jkj.view.customview.WechatRadioGroup;
import cn.usho.jkj.view.fragment.ActivityFragment;
import cn.usho.jkj.view.fragment.MyFragment;
import cn.usho.jkj.view.fragment.ShowFragment;
import cn.usho.jkj.view.fragment.TabFragment;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements View.OnClickListener, MainContract.View {

    private ViewPager mVp_main;
    private List<String> mTitles = new ArrayList<>(Arrays.asList("社群", "活动", "发现", "我的"));
    WechatRadioGroup radioGroup;


    private SparseArray<TabFragment> mFragments = new SparseArray<>();
    private List<BaseFragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPagerAdapter();
    }


    private void initViewPagerAdapter() {
        mVp_main.setOffscreenPageLimit(mTitles.size());
        mVp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
//                TabFragment fragment = TabFragment.newInstance(mTitles.get(i));
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

        });
        radioGroup.setViewPager(mVp_main);
    }


    private void initView() {
        mVp_main = findViewById(R.id.vp_main);
        radioGroup = findViewById(R.id.radiogroup);
        mPresenter = new MainPresenter(this);
        fragments.add(TabFragment.newInstance(mTitles.get(0)));
        fragments.add(ActivityFragment.newInstance(mTitles.get(1)));
        fragments.add(ShowFragment.newInstance(mTitles.get(2)));
        fragments.add(MyFragment.newInstance(mTitles.get(3)));
    }

    @Override
    public void onClick(View v) {
    }

}
