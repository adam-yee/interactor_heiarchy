package com.mikeriv.ssui_2016.a2_collage_basecode;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.CircleLayout;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.ColumnLayout;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.IconImage;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.OvalClip;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.RowLayout;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.SimpleFrame;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.SolidBackDrop;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.TextVisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.tests.CollageViewTestHelper;
import com.mikeriv.ssui_2016.a2_collage_basecode.views.CollageView;

public class CollageActivity extends AppCompatActivity {

    public static final String TAG = "SSUI-MOBILE-COLLAGE-TESTS";

    // The toolbar with the settings icon
    private Toolbar mSupportActionBar;
    // The container holding out collage view
    private FrameLayout mCollageFrame;
    // The host view that holds a reference to our custom view hierarchy
    private CollageView mCollageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Magic for creating the settings icon/choices
        setContentView(R.layout.activity_collage);
        mSupportActionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mSupportActionBar);

        // Grab "Frame" then create basic view to hold the collage
        mCollageFrame = (FrameLayout) findViewById(R.id.frame_collage);
        if (mCollageFrame != null) {
            mCollageView = new CollageView(this);
            mCollageFrame.addView(mCollageView);
            // TODO create the root visual element of your collage view
            // using your created BaseVisualElement class and set it
            // mCollageView.setChildVisualElement(rootVisualElement);

            initCustomCollage();
            refreshViewHierarchy();
        }

    }

    /**
     * Gets called every time the user presses the menu button.
     * Use if your menu is dynamic.
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        // Adds out test options to the menu bar
        CollageViewTestHelper.createTestMenuItems(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        boolean didHandleAction = CollageViewTestHelper.onTestItemSelected(
                item,
                mCollageView,
                this);
        if (didHandleAction) {
            refreshViewHierarchy();
        }
        return didHandleAction;
    }

    /**
     * Function to put your custom collage into
     * You may create additional methods like this to test
     * functionality
     */
    private void initCustomCollage() {
        Resources res = getApplicationContext().getResources();
        // TODO: Part 2: Implement a Custom Collage
        SolidBackDrop rootVisualElement = new SolidBackDrop(0, 0, 2000, 2000, Color.LTGRAY);
        mCollageView.setChildVisualElement(rootVisualElement);
        ColumnLayout colLayout = new ColumnLayout(0,0,1000,2000);
        RowLayout rowElementMain = new RowLayout(10, 10, 605, 100);
        RowLayout rowElementSub = new RowLayout(10, 10, 430, 100);
        colLayout.addChild(rowElementMain);
        rootVisualElement.addChild(colLayout);

        TextVisualElement mainText = new TextVisualElement(0, 0, getString(R.string.phara), Typeface.DEFAULT, 50f);
        mainText.setSize(30,200); // Shouldn't change anything because Text has intrinsic size
        rowElementMain.addChild(mainText);

        rowElementSub.addChild(new TextVisualElement(0, 0, getString(R.string.overwatch), Typeface.DEFAULT, 50f));
        colLayout.addChild(rowElementSub);

        RowLayout rowElementRepeat1 = new RowLayout(0,0,1000,50);
        for (int i = 0; i < 40; i++){
            rowElementRepeat1.addChild(new SolidBackDrop(0,0,50,50, i % 2 == 1 ? Color.BLUE : Color.DKGRAY ));
        }
        colLayout.addChild(rowElementRepeat1);

        RowLayout rowElementRepeat2 = new RowLayout(0,0,1000,50);
        for (int i = 0; i < 40; i++){
            rowElementRepeat2.addChild(new SolidBackDrop(0,0,50,50, i % 2 == 1 ? Color.DKGRAY : Color.YELLOW ));
        }
        colLayout.addChild(rowElementRepeat2);

        OvalClip ovalClip = new OvalClip(0, 500, 2000, 2000);
        ovalClip.addChild(new SolidBackDrop(0,0,1000,1000,Color.CYAN));
        rootVisualElement.addChild(ovalClip);

        IconImage pharah = new IconImage(-300, 200, BitmapFactory.decodeResource(res, R.drawable.pharah_icon));
        pharah.setSize(0,50); // Shouldn't change anything because Icons have intrinsic size
        rootVisualElement.addChild(pharah);

        CircleLayout c = new CircleLayout(0, 0, 2000, 2000, 550, 850, 400);
        rootVisualElement.addChild(c);
        for(int i = 0; i < 9; i++){
            c.addChild(new IconImage(0,0,BitmapFactory.decodeResource(res, R.drawable.rocket)));
        }

        // Finish off by refreshing the view Hierarchy
        refreshViewHierarchy();
    }

    /**
     * Helper method to refresh the custom drawing hierarchy
     */
    private void refreshViewHierarchy() {
        if (mCollageView == null) {
            return;
        }
        mCollageView.requestLayout();
        mCollageView.invalidate();
    }

}
