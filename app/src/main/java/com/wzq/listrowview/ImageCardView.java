package com.wzq.listrowview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wzq on 2018/3/23.
 */

public class ImageCardView extends CardView {
    public ImageCardView(@NonNull Context context) {
        this(context, null);
    }

    public ImageCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    ImageView img;

    private void init(){
        setCardElevation(5f);
        setFocusable(true);



        img = new ImageView(getContext());
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        img.setLayoutParams(layoutParams);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(img);
    }

    public void setImageUrl(@DrawableRes int id){
        img.setImageResource(id);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        customAnimator(gainFocus);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

    }

    private void customAnimator(boolean b){
        clearAnimation();
        float elevationValue = (b) ? 16f : 3f ;
        float scaleValue = (b) ? 1.1f : 1f;
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("scaleX", scaleValue);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("scaleY", scaleValue);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("cardElevation", elevationValue);
        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(this, p1, p2, p3);
        anim.start();
    }

    @Override
    public boolean hasOverlappingRendering(){
        return false;
    }
}

