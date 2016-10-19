package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

/**
 * Created by adamgyee on 10/9/16.
 */

public class CircleLayout extends BaseVisualElement {

    float mLayoutCenterX;
    float mLayoutCenterY;
    float mLayoutRadius;

    public void setCircleSize(float layoutCenterX, float layoutCenterY, float layoutRadius){
        this.mLayoutCenterX = layoutCenterX;
        this.mLayoutCenterY = layoutCenterY;
        this.mLayoutRadius = layoutRadius;
    }

    @Override
    public void doLayout(){

        if (!this.mChildrenList.isEmpty()){

            // Determine angle between children
            int numChildren = this.mChildrenList.size();
            double degreesBetweenChildren = 2*Math.PI/numChildren;
            double newX = 0;
            double newY = 0;
            double angle = 0;

            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null) continue;

                // Determine x,y coordinates using cos, sin and angle
                angle = degreesBetweenChildren * i;
                newX = (int)(this.mLayoutCenterX + this.mLayoutRadius * Math.cos(angle));
                newY = (int)(this.mLayoutCenterY + this.mLayoutRadius * Math.sin(angle));

                float childHeight = this.mChildrenList.get(i).getH();
                float childWidth = this.mChildrenList.get(i).getW();
                float childCenterX = childWidth/2;
                float childCenterY = childHeight/2;

                newX = newX - childCenterX;
                newY = newY - childCenterY;

                this.mChildrenList.get(i).setX((float)newX);
                this.mChildrenList.get(i).setY((float)newY);

                this.mChildrenList.get(i).doLayout();
            }
        }

    }

    // constructor
    public CircleLayout(float x, float y, float w, float h,
                        float layoutCenterX, float layoutCenterY,
                        float layoutRadius){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.setCircleSize(layoutCenterX,layoutCenterY,layoutRadius);

    }
}
