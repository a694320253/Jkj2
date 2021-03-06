package cn.usho.jkj.base;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public  class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected T mPresenter;



    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter=null;
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onFinish(int what) {

    }

//    /**
//     * 绑定生命周期 防止MVP内存泄漏
//     *
//     * @param <T>
//     * @return
//     */
//    @Override
//    public <T> AutoDisposeConverter<T> bindAutoDispose() {
//        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
//                .from(this, Lifecycle.Event.ON_DESTROY));
//    }
}
