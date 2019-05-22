package cn.usho.jkj.view.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.usho.jkj.R;
import cn.usho.jkj.adapter.FolderAdapter;
import cn.usho.jkj.adapter.ListAdapter;
import cn.usho.jkj.adapter.PhotoAdapter;
import cn.usho.jkj.base.MyApplication;
import cn.usho.jkj.base.RecycleBaseAdapter;
import cn.usho.jkj.bean.PhotoFolder;
import cn.usho.jkj.bean.PhotoModel;
import cn.usho.jkj.utils.GlobalConstance;
import cn.usho.jkj.utils.OtherUtils;
import cn.usho.jkj.utils.PhotoUtils;
import cn.usho.jkj.utils.ToastUtils;

/**
 * 手机图片选择页面
 */
public class PhotoPickerActivity extends AppCompatActivity {

    RecyclerView mGridView;
    LinearLayout llFolderContainer;
    TextView tvPhotoNum;
    ViewStub btmFolderStub;
    private ProgressDialog mProgressDialog;
    private Map<String, PhotoFolder> mFolderMap;
    private ArrayList<PhotoModel> mPhotoLists = new ArrayList<>();
    private ArrayList<String> mSelectList = new ArrayList<>();
    private final static String ALL_PHOTO = "所有图片";
    public final static int REQUEST_CAMERA = 1;

    /**
     * 照片选择模式，默认是单选模式
     */
    private int mSelectMode = 0;

    private PhotoAdapter mPhotoAdapter;

    private int mMaxNum;
    private File mTmpFile;
    /**
     * 文件夹列表是否被初始化，确保只被初始化一次
     */
    boolean mIsFolderViewInit = false;
    private ListView mFolderListView;
    /**
     * 文件夹列表是否处于显示状态
     */
    boolean mIsFolderViewShow = false;

    private boolean isShowSelector;

    private boolean isShowCamera = true;

    /**
     * 单选
     */
    private final static int MODE_SINGLE = 0;
    /**
     * 多选
     */
    private final static int MODE_MULTI = 1;

    private final static int SELECT_MAX_NUM = 9;

    /**
     * 初始化文件夹列表的显示隐藏动画
     */
    AnimatorSet inAnimatorSet = new AnimatorSet();
    AnimatorSet outAnimatorSet = new AnimatorSet();
    private ArrayList<PhotoModel> photoList;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_picker);
        initView();
        initData();
    }


    protected void initView() {
        mGridView=findViewById(R.id.gv_photo);
        llFolderContainer=findViewById(R.id.ll_folder_container);
        tvPhotoNum=findViewById(R.id.photo_num);
        btmFolderStub=findViewById(R.id.btm_folder_stub);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mGridView.setLayoutManager(gridLayoutManager);

    }

    protected void initData() {
        Intent intent = getIntent();
        action = intent.getAction();
        mSelectMode = intent.getIntExtra(GlobalConstance.ACTION_PHOTO_SELECT_MODE, MODE_SINGLE);
        mMaxNum = intent.getIntExtra(GlobalConstance.ACTION_PHOTO_MAX_NUM, SELECT_MAX_NUM);

        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute();
    }




    /**
     * 获取照片的异步任务
     */
    private static class MyAsyncTask extends AsyncTask {

        private WeakReference<PhotoPickerActivity> reference;

        public MyAsyncTask(PhotoPickerActivity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            PhotoPickerActivity activity = reference.get();
            activity.mProgressDialog = ProgressDialog.show(activity, null, activity.getString(R.string.loading_text));
        }

        @Override
        protected Object doInBackground(Object[] params) {
            reference.get().mFolderMap = PhotoUtils.getPhotos(MyApplication.getContext());
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            reference.get().getPhotosSuccess();
        }
    }

    private void getPhotosSuccess() {
        mProgressDialog.dismiss();
        photoList = mFolderMap.get(ALL_PHOTO).getPhotoList();
        mPhotoLists.addAll(photoList);

        if (mSelectMode == MODE_SINGLE) {
            //单选
            isShowSelector = false;
        } else {
            //多选
            isShowSelector = true;
        }

        mPhotoLists.add(0, new PhotoModel("camera", isShowCamera, isShowSelector));
        setSelectMode(isShowSelector);

        tvPhotoNum.setText(OtherUtils.formatResourceString(getApplicationContext(),
                R.string.photos_num, mPhotoLists.size()));

        mPhotoAdapter = new PhotoAdapter(this, mPhotoLists);
        mPhotoAdapter.setSelectedList(mSelectList);
        mGridView.setAdapter(mPhotoAdapter);

        Set<String> keys = mFolderMap.keySet();
        final ArrayList<PhotoFolder> folders = new ArrayList<>();
        for (String key : keys) {
            if (ALL_PHOTO.equals(key)) {
                PhotoFolder folder = mFolderMap.get(key);
                folder.setIsSelected(true);
                folders.add(0, folder);
            } else {
                folders.add(mFolderMap.get(key));
            }
        }
        llFolderContainer.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                toggleFolderList(folders);
            }
        });

        mPhotoAdapter.setOnItemClickListener(new RecycleBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PhotoModel model = mPhotoLists.get(position);
                String pic_path = model.pic_path;

                if ("camera".equals(pic_path)) {
                    showCamera();
                } else {
                    if (isShowSelector) {
                        selectPhotos(position);
                    } else {
                        chooseSinglePhoto(position);
                    }
                }
            }
        });
    }

    /**
     * 添加单张图片
     *
     * @param position
     */
    private void chooseSinglePhoto(int position) {

        if (!mPhotoLists.isEmpty()) {

            PhotoModel model = mPhotoLists.get(position);
            mSelectList.add(model.pic_path);
            returnData();
        }

    }

    private void setSelectMode(boolean isShowSelector) {
        if (!mPhotoLists.isEmpty()) {
            mPhotoLists.get(0).isShowSelector = isShowSelector;
        }
//        titleBar.isHideTvRightByInvisible(isShowSelector);
    }

    private void initAnimation(View dimLayout) {
        ObjectAnimator alphaInAnimator, alphaOutAnimator, transInAnimator, transOutAnimator;
        //获取actionBar的高
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        /**
         * 这里的高度是，屏幕高度减去上、下tab栏，并且上面留有一个tab栏的高度
         * 所以这里减去3个actionBarHeight的高度
         */
        int height = OtherUtils.getHeightInPx(this) - 3 * actionBarHeight;
        alphaInAnimator = ObjectAnimator.ofFloat(dimLayout, "alpha", 0f, 0.7f);
        alphaOutAnimator = ObjectAnimator.ofFloat(dimLayout, "alpha", 0.7f, 0f);
        transInAnimator = ObjectAnimator.ofFloat(mFolderListView, "translationY", height, 0);
        transOutAnimator = ObjectAnimator.ofFloat(mFolderListView, "translationY", 0, height);

        LinearInterpolator linearInterpolator = new LinearInterpolator();

        inAnimatorSet.play(transInAnimator).with(alphaInAnimator);
        inAnimatorSet.setDuration(300);
        inAnimatorSet.setInterpolator(linearInterpolator);
        outAnimatorSet.play(transOutAnimator).with(alphaOutAnimator);
        outAnimatorSet.setDuration(300);
        outAnimatorSet.setInterpolator(linearInterpolator);
    }

    /**
     * 显示或者隐藏文件夹列表
     *
     * @param folders
     */
    private void toggleFolderList(final ArrayList<PhotoFolder> folders) {
        //初始化文件夹列表
        if (!mIsFolderViewInit) {
            View view = btmFolderStub.inflate();
            View dimLayout = view.findViewById(R.id.dim_layout);
            mFolderListView = view.findViewById(R.id.lv_folder);
            final FolderAdapter adapter = new FolderAdapter(this, folders);
            mFolderListView.setAdapter(adapter);
            mFolderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    for (PhotoFolder folder : folders) {
                        folder.setIsSelected(false);
                    }
                    PhotoFolder folder = folders.get(position);
                    folder.setIsSelected(true);
                    adapter.notifyDataSetChanged();

                    resetPhotoData(folder);

                    tvPhotoNum.setText(OtherUtils.formatResourceString(getApplicationContext(),
                            R.string.photos_num, mPhotoLists.size()));
                    tvPhotoNum.setText(folder.getName());
                    toggle();
                }
            });
            dimLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (mIsFolderViewShow) {
                        toggle();
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            initAnimation(dimLayout);
            mIsFolderViewInit = true;
        }
        toggle();
    }

    private void resetPhotoData(PhotoFolder folder) {
        mPhotoLists.clear();
        mSelectList.clear();
        mPhotoLists.addAll(resetListData(folder.getPhotoList()));
        if (ALL_PHOTO.equals(folder.getName())) {
            mPhotoLists.add(0, new PhotoModel("camera", true, isShowSelector));
        } else {
            if (!mPhotoLists.isEmpty()) {
                mPhotoLists.get(0).isShowSelector = isShowSelector;
            }
        }
        mPhotoAdapter.notifyDataSetChanged();
        if (!mPhotoLists.isEmpty()) {
            mGridView.requestFocusFromTouch();
            mGridView.smoothScrollToPosition(0);
        }
    }

    private List<PhotoModel> resetListData(List<PhotoModel> photoModelList) {

        for (PhotoModel model : photoModelList) {
            model.isSelected = false;
        }

        return photoModelList;
    }


    /**
     * 弹出或者收起文件夹列表
     */
    private void toggle() {
        if (mIsFolderViewShow) {
            outAnimatorSet.start();
            mIsFolderViewShow = false;
        } else {
            inAnimatorSet.start();
            mIsFolderViewShow = true;
        }
    }

//    /**
//     * 返回选择图片的路径
//     */
    private void returnData() {
        // 返回已选择的图片数据
        Intent data = new Intent();
        if (!TextUtils.isEmpty(action)) data.setAction(action);
        data.putStringArrayListExtra(GlobalConstance.PHOTO_RESULT_LIST_KEY, mSelectList);
        setResult(RESULT_OK, data);
        finish();
    }

    /**
     * 选择图片
     *
     * @param position
     */
    private void selectPhotos(int position) {

        PhotoModel photoModel = mPhotoLists.get(position);
        photoModel.isSelected = !photoModel.isSelected;

        //选中
        if (photoModel.isSelected) {

            if (mSelectList.size() < 9) {
                if (!mSelectList.contains(photoModel.pic_path)) {
                    mSelectList.add(photoModel.pic_path);
                }
            } else {
                photoModel.isSelected = !photoModel.isSelected;
            }

        } else {
            //未选中
            if (mSelectList.contains(photoModel.pic_path)) {
                mSelectList.remove(photoModel.pic_path);
            }
        }

        mPhotoAdapter.notifyDataSetChanged();
    }

    /**
     * 选择相机
     */
    private void showCamera() {
        // 跳转到系统照相机
        try {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                // 设置系统相机拍照后的输出路径
                // 创建临时文件
                mTmpFile = OtherUtils.createFile(getApplicationContext());
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mTmpFile));
                startActivityForResult(cameraIntent, REQUEST_CAMERA);
            } else {
                ToastUtils.showToast(getApplicationContext(), getString(R.string.not_found_camera_text));
            }
        } catch (Exception e) {
            ToastUtils.showToast(getApplicationContext(), getString(R.string.open_camera_permission_first_text));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 相机拍照完成后，返回图片路径
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {
                if (mTmpFile != null) {
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + mTmpFile.getAbsolutePath())));
                    mSelectList.add(mTmpFile.getAbsolutePath());
                    returnData();
                }
            } else {
                if (mTmpFile != null && mTmpFile.exists()) {
                    mTmpFile.delete();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPhotoLists!=null) {
            mPhotoLists.clear();
            mPhotoLists=null;
        }
        if (mSelectList!=null) {
            mSelectList.clear();
            mSelectList=null;
        }
        if (photoList!=null) {
            photoList.clear();
            photoList=null;
        }
        if (mFolderMap != null) {
            mFolderMap.clear();
            mFolderMap = null;
        }
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        if (inAnimatorSet != null) {
            inAnimatorSet.cancel();
        }
        if (outAnimatorSet != null) {
            outAnimatorSet.cancel();
        }
    }

}
