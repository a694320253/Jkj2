package cn.usho.jkj.base;



/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface BaseView {

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 数据获取失败
     * @param throwable
     */
    void onError(Throwable throwable);


    void onFinish(int what);
//    /**
//     * 绑定Android生命周期 防止RxJava内存泄漏
//     *
//     * @param <T>
//     * @return
//     */
//    <T> AutoDisposeConverter<T> bindAutoDispose();

}
