package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by adamgyee on 10/8/16.
 */

public class TextVisualElement extends BaseVisualElement {

    String mText;
    Typeface mTypeFace;
    Float mTextSize;

    public void setTextString(String text){
        this.mText = text;
    }
    public void setTextTypeface(Typeface face){
        this.mTypeFace = face;
    }
    public void setTextSize(float textSize){
        this.mTextSize = textSize;
    }
    public void setText(String text, Typeface face, float textSize){
        this.setTextString(text);
        this.setTextTypeface(face);
        this.setTextSize(textSize);

        // Calculate text height and width
        Paint textPaint = new Paint();
        Rect bounds = new Rect();
        textPaint.setTextSize(textSize);
        textPaint.getTextBounds(text,0,text.length(),bounds);
        //this.mHeight = bounds.height();
        this.mHeight = textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent + textPaint.getFontMetrics().leading;
        //this.mWidth = bounds.width();
        this.mWidth = textPaint.measureText(text);
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

        Paint textPaint = new Paint();
        textPaint.setTypeface(this.mTypeFace);
        textPaint.setTextSize(this.mTextSize);
        textPaint.setTextAlign(Paint.Align.LEFT);

        // getFontMetrics().ascent is the recommended distance above the baseline for singled spaced text
        // and this value is negative, so we want to invert it
        onCanvas.drawText(this.mText,0,-textPaint.getFontMetrics().ascent,textPaint);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    // constructor
    public TextVisualElement(float x, float y, String text, Typeface face, float textSize){
        this.setPosition(x,y);
        this.setText(text,face,textSize);
    }
}
