package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;

/**
 * Created by adamgyee on 10/8/16.
 */

public class NinePartImage extends BaseVisualElement {

    NinePatch mNinePatch;

    public void setNinePatch(NinePatch newPatch){
        this.mNinePatch = newPatch;
    }

    @Override
    public void draw(Canvas onCanvas){

        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        //NinePatchDrawable drawable9 = new NinePatchDrawable(Resources.getSystem(), mNinePatch);
        RectF ninePatchRect = new RectF(0,0,this.mWidth,this.mHeight);
        this.mNinePatch.draw(onCanvas,ninePatchRect);


        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public NinePartImage(float x, float y, float w, float h, NinePatch patches){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.setNinePatch(patches);
    }
}
