package edu.virginia.cs2110.apb8gb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Pot {
	private Bitmap bitmap;
	private int x;
	private int y;
	private boolean touched;
	private int xspeed;
	private int yspeed;
	private MainGamePanel panel;
	private int desiredposition;
	private Rect rectangle;
	private BillMurray billMurray;
	

	
	public Pot(Bitmap bitmap, int x, int y, MainGamePanel panel) {
	
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.panel = panel;
		
		rectangle = new Rect(x-getBitmap().getWidth() / 2, y - getBitmap().getHeight()/2, x+getBitmap().getWidth() / 2,  y + getBitmap().getHeight()/2);
	}

	public Bitmap getBitmap() {
		return bitmap;
	}
	
	public BillMurray getRobot(){
		return billMurray;
	}
	
	public void setRobot(BillMurray x){
		this.billMurray = x;
	}

	public void update(){
		rectangle = new Rect(x-getBitmap().getWidth() / 2, y - getBitmap().getHeight()/2, x+getBitmap().getWidth() / 2,  y + getBitmap().getHeight()/2);
		billMurray = panel.getRobot();
		
		if (rectangle.intersect(billMurray.getRect())){
			panel.setKillCount(panel.getKillCount() + 6);
			panel.fakePot();
		}
		
		
		if (getX() > 600 || getX() < 0){
			panel.fakePot();
		}
		
		
			
		else{
			x += xspeed;
			y -= yspeed;
		}
		
	}
	
	public void setDesiredPosition(int desiredposition){
		this.desiredposition = desiredposition;
	}
	public int getxSpeed(){
		return xspeed;
	}
	
	public void setxSpeed(int speed){
		xspeed = speed;
	}
	
	public Rect getRect(){
		return rectangle;
	}
	
	public int getySpeed(){
		return yspeed;
	}
	
	public void setySpeed(int yspeed){
		this.yspeed = yspeed;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2),
				y -(bitmap.getHeight() / 2), null);
		
	}

}





