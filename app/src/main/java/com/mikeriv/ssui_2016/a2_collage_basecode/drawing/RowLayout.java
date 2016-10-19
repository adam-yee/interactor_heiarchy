package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

/**
 * Created by adamgyee on 10/8/16.
 */

public class RowLayout extends BaseVisualElement {

    @Override
    public void doLayout(){

        float runningCount = 0;

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null) continue;

                // center children vertically: parent height / 2 - child height / 2
                float childHeight = this.mChildrenList.get(i).getH();
                this.mChildrenList.get(i).setY(this.mHeight/2 - childHeight/2);

                // keep running count of widths so children can be placed side by side
                this.mChildrenList.get(i).setX(runningCount);
                runningCount += this.mChildrenList.get(i).getW();

                this.mChildrenList.get(i).doLayout();
            }
        }

    }

    // constructor
    public RowLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }

}
