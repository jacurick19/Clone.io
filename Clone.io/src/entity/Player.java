package entity;

import gfx.PlayerSprite;
import input.Keyboard;

public class Player extends Entity{
	Keyboard keyboard;
	boolean collision;
	int xv;
	int yv;
	int jv;
	int oldY;
	public Player(int x, int y, Keyboard keyboard) {
		sprite = new PlayerSprite();
		this.x = x;
		this.y = y;
		oldY = y;
		this.keyboard = keyboard;
	}
	
	public void getMovement(int[] dir) {
		if(dir[0] == 1) xv = -2;
		if(dir[1] == 1 && jv == 0 && yv == 0) jv = -15;
		if(dir[2] == 1) xv = 2;
	}
	
	@Override
	public void update(){

		getMovement(keyboard.getKeys());
		gravity();
		if(!collision(xv,yv)) { 
		move();
		}
		xv=0;
		yv=0;
	}
	
	
	@Override
	public void move() {
		oldY = y;
		x+=xv;
		y+=yv;
		y+=jv;
		if(jv < 0) jv++;
	}

	@Override
	public void render() {
		
	}
	

	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
