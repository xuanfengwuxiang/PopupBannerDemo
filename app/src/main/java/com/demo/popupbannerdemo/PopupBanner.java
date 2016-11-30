package com.demo.popupbannerdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;



/**
 * Created by xuanfengwuxiang on 2016/11/29.
 */

public class PopupBanner extends LinearLayout{
    private Context mContext;
    private String mJsonString;
    private ImageView mIv_popupbanner;
    private TextView mTv_popupbanner;
    private ImageView mIv_close;
    private LinearLayout mRl_parent;
    private PopupBannerBean mPopupBannerBean;
    private int mRl_parent_height;

    //构造方法初始化
    public PopupBanner(Context context,String jsonString) {
        super(context);
        mContext = context;
        mJsonString = jsonString;
        View popupView = View.inflate(context,R.layout.layout_popupbanner,null);
        initView(popupView);
        initData();
        addView(popupView);
    }

    public PopupBanner(Context context, PopupBannerBean popupBannerBean) {
        super(context);
        mContext = context;
        mPopupBannerBean = popupBannerBean;
        View popupView = View.inflate(context,R.layout.layout_popupbanner,null);
        initView(popupView);
        initData();
        addView(popupView);
    }

    private void initView(View popupView) {
        mIv_popupbanner = (ImageView) popupView.findViewById(R.id.iv_popupbanner);
        mTv_popupbanner = (TextView) popupView.findViewById(R.id.tv_popupbanner);
        mIv_close = (ImageView) popupView.findViewById(R.id.iv_close);
        mRl_parent = (LinearLayout) popupView.findViewById(R.id.rl_parent);
        mRl_parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                mRl_parent_height = mRl_parent.getMeasuredHeight();
                mRl_parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }
        });
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        mRl_parent.setLayoutParams(params);
    }


    private void initData() {
        Gson gson = new Gson();
        //mPopupBannerBean = gson.fromJson(mJsonString,PopupBannerBean.class);
        if (mPopupBannerBean ==null){
            Log.i("PopupBanner","传过来的json字符串为空");
            return;
        }
        mTv_popupbanner.setText(mPopupBannerBean.getContent());
        mTv_popupbanner.setTextColor(mPopupBannerBean.getContentColor());
        mRl_parent.setBackgroundColor(mPopupBannerBean.getBackgroundColor());
        //设置TextView上下左右边距
        LayoutParams paramContent = (LayoutParams) mTv_popupbanner.getLayoutParams();
        paramContent.leftMargin = mPopupBannerBean.getContentMarginLeft();
        paramContent.rightMargin = mPopupBannerBean.getContentMarginRight();
        paramContent.topMargin = mPopupBannerBean.getContentMarginTop();
        paramContent.bottomMargin = mPopupBannerBean.getContentMarginBottom();
        if(!mPopupBannerBean.isHasCloseX()){
            mIv_close.setVisibility(GONE);
        }
        mTv_popupbanner.setLayoutParams(paramContent);
        //测试imageView
        mIv_popupbanner.setImageResource(R.mipmap.ic_launcher);
        //Picasso.with(mContext).load(mPopupBannerBean.getImageUrl()).into(mIv_popupbanner);

        mIv_close.setOnClickListener(new click());
        //关闭动画定时
        TimeCount timeCount = new TimeCount(mPopupBannerBean.getShowTime(), 1000,"close");
        timeCount.start();
        //打开动画定时
        TimeCount timeCount1 = new TimeCount(150, 1000,"open");
        timeCount1.start();
    }

    //点击X符号，关闭popupBanner
    public class click implements OnClickListener{
        public void onClick(View v) {
            showOrCloseAnimation(false);
            Log.i("PopupBanner","点击关闭按钮了！");
        }
    }

    public void showOrCloseAnimation(boolean isShow) {
        ValueAnimator animation = null;
        if (isShow) {
            animation = ValueAnimator.ofInt(0, mRl_parent_height);
        } else {
            animation = ValueAnimator.ofInt(mRl_parent_height, 0);
        }
        animation.setDuration(mPopupBannerBean.getAnimationTime());
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int tempHeight = (int) animation.getAnimatedValue();
                LayoutParams params = new LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
                params.height = tempHeight;
                mRl_parent.setLayoutParams(params);
            }
        });
    }

    /**
     *  自定义计时器
     */
    private class TimeCount extends CountDownTimer {
        private String mOpenOrClose;
        public TimeCount(long millisInFuture, long countDownInterval,String openOrClose) {
            super(millisInFuture, countDownInterval); //millisInFuture总计时长，countDownInterval时间间隔(一般为1000ms)
            mOpenOrClose = openOrClose;
        }

        public void onTick(long millisUntilFinished) {

        }

        public void onFinish() {
            if ("open".equals(mOpenOrClose)){
                showOrCloseAnimation(true);
            }
            if ("close".equals(mOpenOrClose)){
                showOrCloseAnimation(false);
            }
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
