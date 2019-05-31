package com.gel.ratioimage.widget

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View.MeasureSpec.EXACTLY
import com.gel.ratioimage.R

class RatioImageView : AppCompatImageView {
    private var mDomaint: Int = Domaint.NORMAL.value
    private var mRatioWidth: Int = 0
    private var mRatioHeight: Int = 0

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        intRatio(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        intRatio(context, attrs)
    }

    private fun intRatio(context: Context, attrs: AttributeSet) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView)
        this.mDomaint = typedArray.getInt(R.styleable.RatioImageView_ratio_dominant, Domaint.NORMAL.value)
        this.mRatioWidth = typedArray.getInt(R.styleable.RatioImageView_ratio_width, 0)
        this.mRatioHeight = typedArray.getInt(R.styleable.RatioImageView_ratio_height, 0)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var measureWidth: Int = measuredWidth
        var measureHeight: Int = measuredHeight
        if (this.mDomaint == 0
            || this.mRatioWidth == 0 || this.mRatioHeight == 0
            || measureWidth == 0 || measureHeight == 0
        ) {
            return
        }
        if (this.mDomaint == Domaint.HEIGHT.value) {
            measureWidth = measuredHeight * mRatioWidth / mRatioHeight
        } else {
            measureHeight = measuredWidth * mRatioHeight / mRatioWidth;
        }
        val widthSpec: Int = MeasureSpec.makeMeasureSpec(measureWidth, EXACTLY)
        val heightSpec: Int = MeasureSpec.makeMeasureSpec(measureHeight, EXACTLY)
        setMeasuredDimension(widthSpec, heightSpec)
    }
}