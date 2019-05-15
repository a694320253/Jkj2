package cn.usho.jkj.view.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.blankj.utilcode.util.ConvertUtils;

import cn.usho.jkj.R;


public class WechatRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    private static final int DEFAULT_ICON_WIDTH = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30.0f, Resources.getSystem().getDisplayMetrics());

    private Paint mFocusPaint;
    private Paint mTextPaint;
    private Paint mDefocusPaint;
    private Paint mDotPaint;
    private Paint mDotTextPaint;

    private int iconWidth;
    private int iconPadding;
    private int iconHeight;
    private int dotRedius;

    private Bitmap mDefocusBitmap;
    private Bitmap mFocusBitmap;
    private Drawable mFocusDrawable;
    private Drawable mDefocusDrawable;

    private int mAlpha;
    private int mColor;
    private float mFontHeight;
    private float mTextWidth;
    private int mDotColor;

    private boolean isShowDot;
    private int pointTextColor;
    private int pointTextSize;

    private String dotText = "";

    public boolean isShowDot() {
        return isShowDot;
    }

    public void setShowDot(boolean showDot) {
        isShowDot = showDot;
        invalidate();
    }

    public WechatRadioButton(Context context) {
        this(context, null);
    }

    public WechatRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mFocusPaint = new Paint();
        mTextPaint = new Paint();
        mDefocusPaint = new Paint();
        mFocusPaint.setAntiAlias(true);
        mTextPaint.setAntiAlias(true);
        mDefocusPaint.setAntiAlias(true);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WechatRadioButton);
        mFocusDrawable = ta.getDrawable(R.styleable.WechatRadioButton_focus_icon);
        mDefocusDrawable = ta.getDrawable(R.styleable.WechatRadioButton_defocus_icon);
        iconWidth = ta.getDimensionPixelOffset(R.styleable.WechatRadioButton_icon_width, DEFAULT_ICON_WIDTH);
        iconHeight = ta.getDimensionPixelOffset(R.styleable.WechatRadioButton_icon_height, DEFAULT_ICON_WIDTH);
        mColor = ta.getColor(R.styleable.WechatRadioButton_focus_color, Color.BLUE);
        isShowDot = ta.getBoolean(R.styleable.WechatRadioButton_isShowDot, false);
        pointTextColor = ta.getColor(R.styleable.WechatRadioButton_dotTextColor, getResources().getColor(R.color.white));
        pointTextSize = ta.getColor(R.styleable.WechatRadioButton_dotTextSize, 10);
        dotRedius = ConvertUtils.dp2px(4);
        mDotColor = ta.getColor(R.styleable.WechatRadioButton_dotColor, Color.RED);
        if (isShowDot) {
            dotRedius = ta.getDimensionPixelOffset(R.styleable.WechatRadioButton_dotRedius, dotRedius);
            mDotPaint = new Paint();
            mDotPaint.setAntiAlias(true);
            mDotPaint.setColor(mDotColor);
        }
        ta.recycle();

        setButtonDrawable(null);
        if (mDefocusDrawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(null, mDefocusDrawable, null, null);
            mDefocusDrawable = getCompoundDrawables()[1];
        }

        if (mFocusDrawable == null || mDefocusDrawable == null) {
            throw new RuntimeException("'focus_icon' and 'defocus_icon' attribute should be defined");
        }

        mDefocusDrawable.setBounds(0, 0, iconWidth, iconHeight);
        mFocusDrawable.setBounds(0, 0, iconWidth, iconHeight);

        iconPadding = getCompoundDrawablePadding();

        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        mFontHeight = (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        mTextWidth = StaticLayout.getDesiredWidth(getText(), getPaint());

        mDefocusBitmap = getBitmapFromDrawable(mDefocusDrawable);
        mFocusBitmap = getBitmapFromDrawable(mFocusDrawable);

        if (isChecked()) {
            mAlpha = 255;
        }
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(iconWidth, iconHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (drawable instanceof BitmapDrawable) {
            drawable.draw(canvas);
            return bitmap;
        } else {
            throw new RuntimeException("The Drawable must be an instance of BitmapDrawable");
        }
    }

    private void setDotRedius(int redius) {
        this.dotRedius = redius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawDefocusIcon(canvas);
        drawFocusIcon(canvas);
        drawDefocusText(canvas);
        drawFocusText(canvas);
    }

    private void drawDefocusIcon(Canvas canvas) {
        mDefocusPaint.setAlpha(255 - mAlpha);
        canvas.drawBitmap(mDefocusBitmap, (getWidth() - iconWidth) / 2, getPaddingTop(), mDefocusPaint);
        if (isShowDot) {
            if (mDotPaint == null) {
                mDotPaint = new Paint();
                mDotPaint.setAntiAlias(true);
                mDotPaint.setColor(mDotColor);
            }

            /*if (mDotTextPaint == null) {
                mDotTextPaint = new Paint();
                mDotTextPaint.setAntiAlias(true);
                mDotTextPaint.setColor(pointTextColor);
                mDotTextPaint.setTextSize(pointTextSize);
                mDotTextPaint.setTextAlign(Paint.Align.CENTER);
                mDotTextPaint.setTypeface(Typeface.MONOSPACE);
                Rect bounds = new Rect();
                mDotTextPaint.getTextBounds(dotText, 0, dotText.length(), bounds);
            }*/
            int cx = (getWidth() + iconWidth) / 2;
            int cy = getTop() + getPaddingTop() * 2;

            canvas.drawCircle(cx, cy, dotRedius, mDotPaint);
           /* Paint.FontMetrics fontMetrics = mDotTextPaint.getFontMetrics();
            float baseLine = cx - fontMetrics.top / 2;
            canvas.drawText(dotText, getWidth() / 2, baseLine, mDotTextPaint);*/
        }
    }

    public void setDotText(String text) {
        dotText = text;
    }

    private void drawFocusIcon(Canvas canvas) {
        mFocusPaint.setAlpha(mAlpha);
        canvas.drawBitmap(mFocusBitmap, (getWidth() - iconWidth) / 2, getPaddingTop(), mFocusPaint);
        if (isShowDot) {
            if (mDotPaint == null) {
                mDotPaint = new Paint();
                mDotPaint.setAntiAlias(true);
                mDotPaint.setColor(mDotColor);
            }
            canvas.drawCircle((getWidth() + iconWidth) / 2, getTop() + getPaddingTop() * 2, dotRedius, mDotPaint);
        }
    }

    private void drawDefocusText(Canvas canvas) {
        mTextPaint.setColor(getCurrentTextColor());
        mTextPaint.setAlpha(255 - mAlpha);
        mTextPaint.setTextSize(getTextSize());
        canvas.drawText(getText().toString(), getWidth() / 2 - mTextWidth / 2
                , iconHeight + iconPadding + getPaddingTop() + mFontHeight, mTextPaint);
    }

    private void drawFocusText(Canvas canvas) {
        mTextPaint.setColor(mColor);
        mTextPaint.setAlpha(mAlpha);
        canvas.drawText(getText().toString(), getWidth() / 2 - mTextWidth / 2
                , iconHeight + iconPadding + getPaddingTop() + mFontHeight, mTextPaint);
    }


    public void updateAlpha(float alpha) {
        mAlpha = (int) alpha;
        invalidate();
    }

    public void setRadioButtonChecked(boolean isChecked) {
        setChecked(isChecked);
        if (isChecked) {
            mAlpha = 255;
        } else {
            mAlpha = 0;
        }
        invalidate();
    }

}
