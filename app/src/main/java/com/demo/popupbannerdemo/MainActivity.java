package com.demo.popupbannerdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private PopupBanner mPopupBanner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout activity_main = (LinearLayout) findViewById(R.id.activity_main);
        PopupBannerBean popupBannerBean = new PopupBannerBean();
        popupBannerBean.setBackgroundColor(Color.GREEN);
        popupBannerBean.setAnimationTime(3000);
        popupBannerBean.setContent("大王叫我来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡来巡大王叫我来巡大王叫我来巡来巡");
        popupBannerBean.setContentColor(Color.RED);
        popupBannerBean.setContentMarginLeft(10);
        popupBannerBean.setContentMarginRight(10);
        popupBannerBean.setContentMarginTop(10);
        popupBannerBean.setContentMarginBottom(10);
        popupBannerBean.setHasCloseX(true);
        popupBannerBean.setShowTime(5000);
        mPopupBanner = new PopupBanner(getBaseContext(),popupBannerBean);
        activity_main.addView(mPopupBanner);

    }

}
