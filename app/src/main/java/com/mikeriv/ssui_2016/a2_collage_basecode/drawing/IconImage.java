package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by adamgyee on 10/8/16.
 */

public class IconImage extends BaseVisualElement {

    Bitmap mBitmap;

    public void setBitmap(Bitmap newBitmap){
        this.mBitmap = newBitmap;
        this.mHeight = newBitmap.getHeight();
        this.mWidth = newBitmap.getWidth();
    }

    @Override
    public boolean sizeIsIntrinsic() {
        return true;
    }

    @Override
    public void draw(Canvas onCanvas){

        onCanvas.save();

        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint bitmapPaint = new Paint();
        if (mBitmap != null){
            onCanvas.drawBitmap(mBitmap,0,0,bitmapPaint);
        }

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public IconImage(float x, float y, Bitmap image){
        this.setPosition(x,y);
        this.setBitmap(image);
    }
}
