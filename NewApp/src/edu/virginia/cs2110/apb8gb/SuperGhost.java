package edu.virginia.cs2110.apb8gb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SuperGhost {
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
	private boolean truth;
	private int health;
	private boolean dangerous;

	
	public SuperGhost(Bitmap bitmap, int x, int y, MainGamePanel panel) {
	
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.panel = panel;
		health = 3;
		truth = true;
		dangerous = false;
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
	
	public void setTruth(boolean a){
		truth = a;
	}
	
	public boolean getTruth(){
		return truth;
	}

	public void update(){
		if (truth == true){
			rectangle = new Rect(x-getBitmap().getWidth() / 2, y - getBitmap().getHeight()/2, x+getBitmap().getWidth() / 2,  y + getBitmap().getHeight()/2);
			billMurray = panel.getRobot();
			
			if (rectangle.intersect(billMurray.getRect())){
				panel.pseudoEnd();
			}
			if (getY() > 800){
				panel.newGhost();
			}
			setxSpeed((int)(billMurray.getX() - getX()) / 80);
			setySpeed((int)(getY() - billMurray.getY()) / 80);
			x += xspeed;
			y -= yspeed;
			if (Math.sqrt((getX() - billMurray.getX())* (getX() - billMurray.getX()) + (getY() - billMurray.getY()) * (getY() - billMurray.getY())) < 400){
				dangerous = true;
			}
			
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
		if (dangerous){
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.red_triangle), 400, 20, null);
		}
		switch (panel.getKillcount() / 10){
			case 0:
				break;
			case 1:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.one), 20, 20, null);
				break;
			case 2:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.two), 20, 20, null);
				break;
			case 3:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.three), 20, 20, null);
				break;
			case 4:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.four), 20, 20, null);
				break;
			case 5:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.five), 20, 20, null);
				break;
			case 6:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.six), 20, 20, null);
				break;
			case 7:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.seven), 20, 20, null);
				break;
			case 8:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.eight), 20, 20, null);
				break;
			case 9:
				canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.nine), 20, 20, null);
				break;
		}
		switch (panel.getKillcount() % 10){
		case 0:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.zero), 45, 20, null);
			break;
		case 1:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.one), 45, 20, null);
			break;
		case 2:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.two), 45, 20, null);
			break;
		case 3:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.three), 45, 20, null);
			break;
		case 4:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.four), 45, 20, null);
			break;
		case 5:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.five), 45, 20, null);
			break;
		case 6:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.six), 45, 20, null);
			break;
		case 7:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.seven), 45, 20, null);
			break;
		case 8:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.eight), 45, 20, null);
			break;
		case 9:
			canvas.drawBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.nine), 45, 20, null);
			break;
	}
	}

	public void dropHealth() {
		health = health - 1;
		if (health == 0){
			panel.newGhost();
		}
		// TODO Auto-generated method stub
		
	}

	
}







