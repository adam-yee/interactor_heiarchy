/**
 *
 */
package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.ArrayList;

/**
 * This base class provides a partial implementation of the VisualElement interface.
 * You are to provide the rest of this implementation to create a full base
 * class called BaseVisualElement (which must inherit from this class).
 *
 * @see BaseVisualElement
 * @author Scott Hudson
 * @author Michael Rivera (modified 10/16/2016)
 *
 */
public abstract class BaseVisualElement extends PrebaseVisualElement {

	float mPosX;
	float mPosY;
	float mWidth;
	float mHeight;

	VisualElement mParent;
	ArrayList<VisualElement> mChildrenList = new ArrayList<>();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setPosition(android.graphics.PointF)
	 */
	@Override
    public void setPosition(PointF pos) {
		if (pos != null) {
			setPosition(pos.x, pos.y);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setPosition(float, float)
	 */
	@Override
	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setX(float)
	 */
	@Override
	public void setX(float x){
		this.mPosX = x;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setY(float)
	 */
	@Override
	public void setY(float y){
		this.mPosY = y;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getPosition()
	 */
	@Override
	public PointF getPosition() {
		return new PointF(getX(),getY());
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getX()
	 */
	@Override
	public float getX(){
		return this.mPosX;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getY()
	 */
	@Override
	public float getY(){
		return this.mPosY;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#sizeIsIntrinsic()
	 */
	@Override
	public boolean sizeIsIntrinsic() {
		// default value -- override in subclasses that need to...
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setSize(android.graphics.PointF)
	 */
	@Override
	public void setSize(PointF size) {
		if (size != null) {
			setSize(size.x,size.y);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setSize(float, float)
	 */
	@Override
	public void setSize(float w, float h) {
		setW(w);
		setH(h);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setW(float)
	 */
	@Override
	public void setW(float w){
		this.mWidth = w;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setH(float)
	 */
	@Override
	public void setH(float h){
		this.mHeight = h;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getSize()
	 */
	@Override
	public PointF getSize() {
		return new PointF(getW(),getH());
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getW()
	 */
	@Override
	public float getW(){
		return this.mWidth;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getH()
	 */
	@Override
	public float getH(){
		return this.mHeight;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getParent()
	 */
	@Override
	public VisualElement getParent(){
		return this.mParent;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setParent()
	 */
	@Override
	public void setParent(VisualElement newParent){
		this.mParent = newParent;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getNumChildren()
	 */
	@Override
	public int getNumChildren(){
		return this.mChildrenList.size();
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#getChildAt(int)
	 */
	@Override
	public VisualElement getChildAt(int index){
		return this.mChildrenList.get(index);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#findChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public int findChild(VisualElement child){
		return this.mChildrenList.indexOf(child);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#addChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void addChild(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChildAt(int)
	 */
	@Override
	public void removeChildAt(int index){
		//does this need to be .removeAll?
		//will there ever be the same child twice in my heiarchy tree?
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void removeChild(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildFirst(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildFirst(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLast(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildLast(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildEarlier(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildEarlier(VisualElement child);

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLater(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	abstract public void moveChildLater(VisualElement child);


	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#doLayout()
	 */
	@Override
	abstract public void doLayout();

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#draw(android.graphics.Canvas)
	 */
	@Override
	abstract public void draw(Canvas onCanvas);

	/**
	 * Default constructor.
	 */
	public BaseVisualElement() {
		// do default initialization at an odd size so its easy to see when
		// the size is never set up.
		this(0,0);
	}

	/**
	 * Constructor with position only.
	 */
	public BaseVisualElement(float xLoc, float yLoc) {
		// do default initialization at an odd size so its easy to see when
		// the size is never set up.
		this(xLoc,yLoc,13.7f, 17.9f);
	}

	/**
	 * Full constructor giving position and size.
	 */
	public BaseVisualElement(float xLoc, float yLoc, float width, float height) {
		setPosition(xLoc,yLoc);
		setSize(width,height);
	}
}
