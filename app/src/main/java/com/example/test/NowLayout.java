package com.example.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;


public class NowLayout extends LinearLayout implements OnGlobalLayoutListener {

    boolean flag = false;

	public NowLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initLayoutObserver();

	}

	public NowLayout(Context context) {
		super(context);
		initLayoutObserver();
	}

	private void initLayoutObserver() {
		setOrientation(LinearLayout.VERTICAL);
		getViewTreeObserver().addOnGlobalLayoutListener(this);
	}
    final int heightPx = getContext().getResources().getDisplayMetrics().heightPixels;
	@Override
	public void onGlobalLayout() {
		getViewTreeObserver().removeGlobalOnLayoutListener(this);





		boolean inversed = false;

		final int childCount = getChildCount();
        int j=0;
        doanimation(j,childCount);

		}

    void doanimation (final int j, final int childCount){

        if(j==childCount)
            return;
        final View child = getChildAt(j);
        int[] location = new int[2];

        child.getLocationOnScreen(location);

        if (location[1] > heightPx) {
            return;
        }


        Animation anim = AnimationUtils.loadAnimation(getContext(),R.anim.slide_up);

        child.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                child.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                doanimation(j+1,childCount);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }
}



