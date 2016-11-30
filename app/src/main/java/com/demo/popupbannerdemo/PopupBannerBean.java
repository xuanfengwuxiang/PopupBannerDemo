package com.demo.popupbannerdemo;

/**
 * Created by xuanfengwuxiang on 2016/11/29.
 */

public class PopupBannerBean {
    private String content;
    private int contentColor;
    private int backgroundColor;
    private int contentMarginLeft;
    private int contentMarginRight;
    private int contentMarginTop;

    public int getContentMarginBottom() {
        return contentMarginBottom;
    }

    public void setContentMarginBottom(int contentMarginBottom) {
        this.contentMarginBottom = contentMarginBottom;
    }

    public int getContentMarginRight() {
        return contentMarginRight;
    }

    public void setContentMarginRight(int contentMarginRight) {
        this.contentMarginRight = contentMarginRight;
    }

    public int getContentMarginTop() {
        return contentMarginTop;
    }

    public void setContentMarginTop(int contentMarginTop) {
        this.contentMarginTop = contentMarginTop;
    }

    private int contentMarginBottom;
    private String imageUrl;
    private boolean hasCloseX;
    private int animationTime;
    private int showTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getContentMarginLeft() {
        return contentMarginLeft;
    }

    public void setContentMarginLeft(int contentMarginLeft) {
        this.contentMarginLeft = contentMarginLeft;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isHasCloseX() {
        return hasCloseX;
    }

    public void setHasCloseX(boolean hasCloseX) {
        this.hasCloseX = hasCloseX;
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(int animationTime) {
        this.animationTime = animationTime;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }
}
