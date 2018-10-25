package com.example.item.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.item.R;
import com.example.item.util.ScreenUtils;

public class TitleView extends RelativeLayout {

    private TextView mTvBack;
    private TextView mTvCenter;
    private TextView mTvSure;
    private ViewGroup mViewRoot;

    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAttrs(attrs);

    }

    private void initView() {
        View inflate = View.inflate(getContext(), R.layout.view_title, this);
        mViewRoot = inflate.findViewById(R.id.root_view);
        mTvBack = inflate.findViewById(R.id.tv_back);
        mTvCenter = inflate.findViewById(R.id.tv_center);
        mTvSure = inflate.findViewById(R.id.tv_sure);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TitleView);
        if (typedArray != null && typedArray.getIndexCount() > 0) {
            mViewRoot.setBackgroundColor(typedArray.getColor(R.styleable.TitleView_group_color, ContextCompat.getColor(getContext(), R.color.color00000000)));
            mTvBack.setText(typedArray.getString(R.styleable.TitleView_back_data));
            mTvBack.setCompoundDrawablesWithIntrinsicBounds(typedArray.getDrawable(R.styleable.TitleView_back_left_drawable), typedArray.getDrawable(R.styleable.TitleView_back_top_drawable),
                    typedArray.getDrawable(R.styleable.TitleView_back_right_drawable), typedArray.getDrawable(R.styleable.TitleView_back_bottom_drawable));
            mTvBack.setCompoundDrawablePadding(R.styleable.TitleView_back_drawable_padding);
            mTvBack.setTextSize(TypedValue.COMPLEX_UNIT_PX,typedArray.getDimensionPixelSize(R.styleable.TitleView_back_text_size, ScreenUtils.dp2px(getContext(), 14)));
            mTvBack.setTextColor(typedArray.getColor(R.styleable.TitleView_back_text_color, ContextCompat.getColor(getContext(), R.color.colorFFEFEFEF)));
            mTvCenter.setText(typedArray.getString(R.styleable.TitleView_center_data));
            mTvCenter.setTextColor(typedArray.getColor(R.styleable.TitleView_center_text_color, ContextCompat.getColor(getContext(), R.color.colorFFFFFFFF)));
            mTvCenter.setTextSize(TypedValue.COMPLEX_UNIT_PX,typedArray.getDimensionPixelSize(R.styleable.TitleView_center_text_size, ScreenUtils.dp2px(getContext(), 14)));
            mTvSure.setText(typedArray.getString(R.styleable.TitleView_center_data));
            mTvSure.setCompoundDrawablesWithIntrinsicBounds(typedArray.getDrawable(R.styleable.TitleView_sure_left_drawable), typedArray.getDrawable(R.styleable.TitleView_sure_top_drawable),
                    typedArray.getDrawable(R.styleable.TitleView_sure_right_drawable), typedArray.getDrawable(R.styleable.TitleView_sure_bottom_drawable));
            mTvSure.setTextSize(TypedValue.COMPLEX_UNIT_PX,typedArray.getDimension(R.styleable.TitleView_sure_text_size, ScreenUtils.dp2px(getContext(), 14)));
            mTvSure.setTextColor(typedArray.getColor(R.styleable.TitleView_sure_text_color, ContextCompat.getColor(getContext(), R.color.colorFFE1E1E1)));
            mTvSure.setCompoundDrawablePadding(R.styleable.TitleView_sure_drawable_padding);
            typedArray.recycle();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
        int resultHeightSize = ScreenUtils.dp2px(getContext(), 45);
        switch (heightMeasureMode) {
            case MeasureSpec.UNSPECIFIED:
                ScreenUtils.setDefaultRootViewSize(getContext(),mViewRoot);
                break;
            case MeasureSpec.AT_MOST:
                ScreenUtils.setDefaultRootViewSize(getContext(),mViewRoot);
                break;
            case MeasureSpec.EXACTLY:
                resultHeightSize = heightMeasureSize;
                break;
            default:
                break;
        }
        setMeasuredDimension(widthMeasureSpec, resultHeightSize);
    }

}
