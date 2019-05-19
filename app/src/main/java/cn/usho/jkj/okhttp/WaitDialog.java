package cn.usho.jkj.okhttp;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import cn.usho.jkj.R;
import cn.usho.jkj.view.customview.LVCircularRing;


/**
 * Created by l on 2017/5/24.
 */

public class WaitDialog extends Dialog {
    private static WaitDialog waitDialog=null;
    public LVCircularRing lv_circularring;

    public   static WaitDialog getInstance(Context context){
        if (waitDialog==null){
            waitDialog=new WaitDialog(context);
        }
        return  waitDialog;
    }

    public WaitDialog(Context context) {
        super(context);
        //设置当前的Activity无Title,并且全屏(点用这个方法必须在setContentView之前)
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.waitdialog, null);// 得到加载view

//
//        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
//        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
//        // 加载动画
//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
//                context, R.anim.load_animation);
//        // 使用ImageView显示动画
//        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
//        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        lv_circularring = (LVCircularRing) v.findViewById(R.id.lv_circularring);

        //设置对话框的外面点击,是否让对话框消失,false是可以取消
        setCanceledOnTouchOutside(false);
        //设置对话框的样式
//        setProgressStyle(STYLE_SPINNER);
//        //设置进度条显示的内容
//        setMessage("正在请求网络,请稍候...");
        setContentView(v);
    }

    public WaitDialog(Context context, int theme) {
        super(context, theme);
        //设置当前的Activity无Title,并且全屏(点用这个方法必须在setContentView之前)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.waitdialog, null);// 得到加载view
        lv_circularring = (LVCircularRing) v.findViewById(R.id.lv_circularring);
        //设置对话框的外面点击,是否让对话框消失,false是可以取消
        setCanceledOnTouchOutside(false);
        setContentView(v);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lv_circularring.stopAnim();
        Log.i("LOGLOG","停止动画");
    }

    @Override
    public void onStart() {
        super.onStart();
        lv_circularring.startAnim();
        Log.i("LOGLOG","启动动画");
    }
}
