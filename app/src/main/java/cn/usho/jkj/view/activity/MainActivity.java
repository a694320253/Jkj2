package cn.usho.jkj.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.usho.jkj.R;
import cn.usho.jkj.base.BaseMvpActivity;
import cn.usho.jkj.contract.MainContract;
import cn.usho.jkj.presenter.MainPresenter;
import cn.usho.jkj.view.customview.WechatRadioGroup;
import cn.usho.jkj.view.fragment.TabFragment;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements View.OnClickListener ,MainContract.View{

    private ViewPager mVp_main;
    private List<String> mTitles = new ArrayList<>(Arrays.asList("社群","活动","发现","我的"));
    WechatRadioGroup radioGroup;


    private SparseArray<TabFragment> mFragments = new SparseArray<>();



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
                TabFragment fragment = TabFragment.newInstance(mTitles.get(i));
                return fragment;
            }

            @Override
            public int getCount() {
                return mTitles.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                TabFragment tabFragment = (TabFragment) super.instantiateItem(container, position);
                mFragments.put(position,tabFragment);
                return tabFragment;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                mFragments.remove(position);
                super.destroyItem(container, position, object);
            }
            //这样我们就做到了界面上有几个Fragment，我们mFragments里就有几个，而且是一一对应的
        });
        radioGroup.setViewPager(mVp_main);
    }


    private void initView() {
        mVp_main = findViewById(R.id.vp_main);
        radioGroup=findViewById(R.id.radiogroup);
        mPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View v) {
    }

}
