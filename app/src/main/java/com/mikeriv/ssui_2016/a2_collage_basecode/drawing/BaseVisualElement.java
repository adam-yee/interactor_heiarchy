/**
 *
 */
package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.Log;

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
public class BaseVisualElement extends PrebaseVisualElement {

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

		// Ignore external calls to set size if intrinsic
		if (!this.sizeIsIntrinsic())
			this.mWidth = w;
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#setH(float)
	 */
	@Override
	public void setH(float h){

		// Ignore external calls to set size if intrinsic
		if (!this.sizeIsIntrinsic())
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
		if (index < 0 || index >= this.mChildrenList.size()){
			return null;
		}
		return this.mChildrenList.get(index);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#findChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public int findChild(VisualElement child){
		if (child == null){
			return -1;
		}
		return this.mChildrenList.indexOf(child);
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#addChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void addChild(VisualElement child){

		// Don't add null children
		if (child != null) {

			// First remove the child from its existing parent
			if (child.getParent() != null){
				child.getParent().removeChild(child);
			}
			this.mChildrenList.add(child);
			child.setParent(this);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChildAt(int)
	 */
	@Override
	public void removeChildAt(int index){
		if (index > -1 && index < this.mChildrenList.size()) {
			this.mChildrenList.get(index).setParent(null);
			this.mChildrenList.remove(index);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#removeChild(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void removeChild(VisualElement child){

		if (this.mChildrenList.contains(child)) {
			child.setParent(null);
			this.mChildrenList.remove(child);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildFirst(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void moveChildFirst(VisualElement child){

		// Under the assumption that this method is only called after child has been inserted
		// To move child to front, remove it from list first and then re-insert to front
		if(this.mChildrenList.contains(child)){
			this.mChildrenList.remove(child);
			this.mChildrenList.add(0,child);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLast(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void moveChildLast(VisualElement child){

		// Under the assumption that this method is only called after child has been inserted
		// To move child to end, remove it from list first and then re-insert to back
		if(this.mChildrenList.contains(child)){
			this.mChildrenList.remove(child);
			this.mChildrenList.add(child);
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildEarlier(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void moveChildEarlier(VisualElement child){

		if (this.mChildrenList.contains(child)){
			int childStartingIndex = this.mChildrenList.indexOf(child);
			if (childStartingIndex > 0){
				this.mChildrenList.remove(child);
				this.mChildrenList.add(childStartingIndex-1,child);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#moveChildLater(com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement)
	 */
	@Override
	public void moveChildLater(VisualElement child){

		if (this.mChildrenList.contains(child)){
			int childStartingIndex = this.mChildrenList.indexOf(child);
			int childListSize = this.mChildrenList.size();
			if (childStartingIndex < childListSize - 1){
				this.mChildrenList.remove(child);
				this.mChildrenList.add(childStartingIndex+1,child);
			}
		}
	}


	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#doLayout()
	 */
	@Override
	public void doLayout(){
		if (!this.mChildrenList.isEmpty()){
			for (int i = 0; i < this.mChildrenList.size(); i++){
				this.mChildrenList.get(i).doLayout();
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas onCanvas){

		onCanvas.save();
		onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
		onCanvas.translate(this.mPosX,this.mPosY);

		if (!this.mChildrenList.isEmpty()){
			for (int i = 0; i < this.mChildrenList.size(); i++){
				this.mChildrenList.get(i).draw(onCanvas);
			}
		}

		onCanvas.restore();
	}

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
