package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by adamgyee on 10/8/16.
 */

public class SolidBackDrop extends BaseVisualElement {

    int mColor;

    public void setColor(int newColor){
        this.mColor = newColor;
    }

    @Override
    public void draw(Canvas onCanvas){

        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint fillPaint = new Paint();
        fillPaint.setColor(this.mColor);
        onCanvas.drawRect(0,0,this.mWidth,this.mHeight,fillPaint);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public SolidBackDrop(float x, float y, float w, float h, int color){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.setColor(color);
    }
}
