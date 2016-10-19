package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by adamgyee on 10/8/16.
 */

public class SimpleFrame extends BaseVisualElement {

    @Override
    public void draw(Canvas onCanvas){

        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.BLACK);
        rectPaint.setStyle(Paint.Style.STROKE);
        // Stroke size of 1 wasn't showing some lines, so I made it 2
        rectPaint.setStrokeWidth(2);
        onCanvas.drawRect(0,0,this.mWidth,this.mHeight,rectPaint);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public SimpleFrame(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }
}
