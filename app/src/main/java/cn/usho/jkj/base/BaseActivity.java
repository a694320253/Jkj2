package cn.usho.jkj.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(this.getLayoutId());
//        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
//
//    /**
//     * 设置布局
//     *
//     * @return
//     */
//    public abstract int getLayoutId();
//
//    /**
//     * 初始化视图
//     */
//    public abstract void initView();


}
