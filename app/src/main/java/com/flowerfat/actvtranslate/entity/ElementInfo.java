package com.flowerfat.actvtranslate.entity;

import android.graphics.Rect;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/26.
 *
 * the element's entity which two acts use
 */
public class ElementInfo{

    private Rect rect ;
    private int width ;
    private int height ;
    private int x ;
    private int y ;

    public ElementInfo(int x, int y){
        setX(x);
        setY(y);
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
