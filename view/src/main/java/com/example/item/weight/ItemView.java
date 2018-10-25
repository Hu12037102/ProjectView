package com.example.item.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.item.R;
import com.example.item.util.ScreenUtils;

public class ItemView extends RelativeLayout {

    public TextView mTvLeft;
    public TextView mTvRight;
    private ViewGroup mRootView;
    public View mTopLine;
    public View mBottomLine;

    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAttrs(attrs);
    }


    private void initView() {
        View viewInflate = View.inflate(getContext(), R.layout.view_item, this);
        mRootView = viewInflate.findViewById(R.id.root_view);
        mTvLeft = viewInflate.findViewById(R.id.tv_left);
        mTvRight = viewInflate.findViewById(R.id.tv_right);
        mTopLine = viewInflate.findViewById(R.id.top_line);
        mBottomLine = viewInflate.findViewById(R.id.bottom_line);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ItemView);
        if (typedArray != null && typedArray.getIndexCount() > 0) {
            mTvLeft.setCompoundDrawablesWithIntrinsicBounds(typedArray.getDrawable(R.styleable.ItemView_title_left_icon),
                    typedArray.getDrawable(R.styleable.ItemView_title_top_icon), typedArray.getDrawable(R.styleable.ItemView_title_right_icon),
                    typedArray.getDrawable(R.styleable.ItemView_title_bottom_icon));
            mTvLeft.setText(typedArray.getString(R.styleable.ItemView_title_data));
            mTvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(R.styleable.ItemView_title_text_size, (int) mTvLeft.getTextSize()));
            mTvLeft.setTextColor(typedArray.getColor(R.styleable.ItemView_title_text_color, mTvLeft.getPaint().getColor()));
            mTvLeft.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(R.styleable.ItemView_title_drawable_padding, 0));
            mTopLine.setVisibility(typedArray.getBoolean(R.styleable.ItemView_show_top_line, false) ? VISIBLE : GONE);

            mTvRight.setCompoundDrawablesWithIntrinsicBounds(typedArray.getDrawable(R.styleable.ItemView_content_left_icon),
                    typedArray.getDrawable(R.styleable.ItemView_content_top_icon), typedArray.getDrawable(R.styleable.ItemView_content_right_icon),
                    typedArray.getDrawable(R.styleable.ItemView_content_bottom_icon));
            mTvRight.setText(typedArray.getString(R.styleable.ItemView_content_data));
            mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(R.styleable.ItemView_content_text_size, (int) mTvRight.getTextSize()));
            mTvRight.setTextColor(typedArray.getColor(R.styleable.ItemView_content_text_color, ContextCompat.getColor(getContext(), R.color.colorFF333333)));
            mTvRight.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(R.styleable.ItemView_content_drawable_padding, 0));
            if (typedArray.getDrawable(R.styleable.ItemView_selector_drawable) != null) {
                mRootView.setBackgroundDrawable(typedArray.getDrawable(R.styleable.ItemView_selector_drawable));
            }
            mBottomLine.setVisibility(typedArray.getBoolean(R.styleable.ItemView_show_bottom_line, false) ? VISIBLE : GONE);
            typedArray.recycle();

        }
    }

    public void setTitleText(@NonNull String text) {
        mTvLeft.setText(text);
    }

    public void setTitleText(@StringRes int resString) {
        mTvLeft.setText(resString);
    }

    public void setContentText(@NonNull String text) {
        mTvRight.setText(text);
    }

    public void setContentText(@StringRes int resString) {
        mTvRight.setText(resString);
    }

    public void setTitleIcon(@DrawableRes int leftDrawableRes, @DrawableRes int topDrawableRes,
                             @DrawableRes int rightDrawableRes, @DrawableRes int bottomDrawableRes) {
        mTvLeft.setCompoundDrawablesWithIntrinsicBounds(leftDrawableRes, topDrawableRes, rightDrawableRes, bottomDrawableRes);
    }

    public void setTitleIcon(@Nullable Drawable leftDrawable, @Nullable Drawable topDrawable, @Nullable Drawable rightDrawable, @Nullable Drawable bottomDrawable) {
        mTvLeft.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, topDrawable, rightDrawable, bottomDrawable);
    }

    public void setContentIcon(@DrawableRes int leftDrawableRes, @DrawableRes int topDrawableRes,
                               @DrawableRes int rightDrawableRes, @DrawableRes int bottomDrawableRes) {
        mTvRight.setCompoundDrawablesWithIntrinsicBounds(leftDrawableRes, topDrawableRes, rightDrawableRes, bottomDrawableRes);
    }

    public void setContentIcon(@Nullable Drawable leftDrawable, @Nullable Drawable topDrawable, @Nullable Drawable rightDrawable, @Nullable Drawable bottomDrawable) {
        mTvRight.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, topDrawable, rightDrawable, bottomDrawable);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int measureHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        int resultHeight = ScreenUtils.dp2px(getContext(), 45);
        switch (measureHeightMode) {
            case MeasureSpec.UNSPECIFIED:
                ScreenUtils.dp2px(getContext(),45);
                ScreenUtils.setDefaultRootViewSize(getContext(),mRootView);
                break;
            case MeasureSpec.AT_MOST:
                ScreenUtils.dp2px(getContext(),45);
                ScreenUtils.setDefaultRootViewSize(getContext(),mRootView);
                break;
            case MeasureSpec.EXACTLY:
                resultHeight = measureHeightSize;
                break;
            default:
                break;
        }
        setMeasuredDimension(ScreenUtils.screenWidth(getContext()), resultHeight);
    }

}
