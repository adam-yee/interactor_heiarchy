package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by adamgyee on 10/16/16.
 */

public class OvalClip extends BaseVisualElement {

    @Override
    public void draw(Canvas onCanvas){

        onCanvas.save();
        // Using path to create oval shape
        Path oval = new Path();
        RectF rectOval = new RectF(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        oval.addOval(rectOval, Path.Direction.CCW);
        onCanvas.clipPath(oval);
        onCanvas.translate(this.mPosX,this.mPosY);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public OvalClip(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }
}
