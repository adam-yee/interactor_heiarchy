package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

/**
 * Created by adamgyee on 10/8/16.
 */

public class ColumnLayout extends BaseVisualElement {

    @Override
    public void doLayout(){

        float runningCount = 0;

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null) continue;

                // Center children horizontally: parent width / 2 - child width / 2
                float childWidth = this.mChildrenList.get(i).getW();
                this.mChildrenList.get(i).setX(this.mWidth/2 - childWidth/2);

                // Keep running count of heights so children can be placed top to bottom
                this.mChildrenList.get(i).setY(runningCount);
                runningCount += this.mChildrenList.get(i).getH();

                this.mChildrenList.get(i).doLayout();
            }
        }

    }

    // constructor
    public ColumnLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }
}
