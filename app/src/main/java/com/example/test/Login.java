package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et1 = (EditText) findViewById(R.id.editText);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final LinearLayout ll = (LinearLayout) findViewById(R.id.control);
        final TextView tv = (TextView) findViewById(R.id.centerText);
        final Animation anim  = AnimationUtils.loadAnimation(Login.this, R.anim.down);
        final Animation anim1 = AnimationUtils.loadAnimation(Login.this, R.anim.up);
        final Animation anim2 = AnimationUtils.loadAnimation(Login.this, R.anim.fadein);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        tv.setTypeface(font);
        ll.setVisibility(View.GONE);
        tv.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                tv.startAnimation(anim1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) findViewById(R.id.root).getBackground();
                transitionDrawable.startTransition(800);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv.setVisibility(View.GONE);
                ll.startAnimation(anim2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ll.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ViewGroup root = (ViewGroup) findViewById(R.id.root);
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(v.getId() == R.id.root){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return false;
            }
        });

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equals("a") && et2.getText().toString().equals("a") ){
                    finish();
                    startActivity(new Intent(Login.this, MainActivity.class));
                }else {
                    et1.getText().clear();
                    et2.getText().clear();
                }
            }
        });

    }


}
