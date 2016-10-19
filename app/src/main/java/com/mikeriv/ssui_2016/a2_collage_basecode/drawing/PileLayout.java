package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by adamgyee on 10/8/16.
 */

public class PileLayout extends BaseVisualElement {

    @Override
    public void doLayout(){

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).setPosition(0,0);
                this.mChildrenList.get(i).doLayout();
            }
        }

    }

    // constructor
    public PileLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }
}
