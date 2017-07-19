package com.blankj.androidutilcode.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.androidutilcode.R;
import com.blankj.androidutilcode.base.BaseBackActivity;

public class AnimationActivity extends BaseBackActivity {
    private TextView mTextView1;
    private TextView mTextView2;
    private ImageView mImageView;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_animation;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getSupportActionBar().setTitle(getString(R.string.demo_animation));
        mTextView1 = (TextView) view.findViewById(R.id.textView);
        mTextView2 = (TextView) view.findViewById(R.id.textView2);
        mImageView = (ImageView) view.findViewById(R.id.imageView);
        view.findViewById(R.id.button).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        view.findViewById(R.id.button4).setOnClickListener(this);
        view.findViewById(R.id.button5).setOnClickListener(this);
        view.findViewById(R.id.button6).setOnClickListener(this);
        view.findViewById(R.id.button7).setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context context) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_tween_1);
                animation.setDuration(1000);
                animation.setRepeatCount(2);
                animation.setRepeatMode(Animation.REVERSE);
                mTextView1.startAnimation(animation);
                break;

            case R.id.button2:
                /*ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,360);
                valueAnimator.setDuration(1000);
                valueAnimator.setInterpolator(new AccelerateInterpolator());
                valueAnimator.setRepeatCount(1);
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        mImageView.setRotationY(value);
                    }
                });
                valueAnimator.start();*/
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView,"rotationY",0,359);
                objectAnimator.setDuration(1000);
                objectAnimator.setRepeatCount(1);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.start();
                break;

            case R.id.button3:
                ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0,2000);
                valueAnimator2.setDuration(1000);
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value2 = (float) animation.getAnimatedValue();
                        mTextView2.setText(String.valueOf(value2));
                    }
                });
                valueAnimator2.start();
                break;

            case R.id.button4:
//                Intent explodeIntent = new Intent(this, ExplodeActivity.class);
//                startActivity(explodeIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case R.id.button5:
                break;

            case R.id.button6:
                break;

            case R.id.button7:
                break;
        }
    }
}
