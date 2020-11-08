package entity;

import gfx.Simple_Ghost_Sprite;

public class Simple_Ghost extends Entity{
	
	int tracker1;
	int tracker2;

	
	public Simple_Ghost(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = new Simple_Ghost_Sprite();
	}
	
	public void render() {
		
	}
	
	@Override
	public void move() {
		if(!collision(xv,yv)) {
			x+=xv;
			y+=yv;
			yv=0;
			xv=0;
		}else {
			yv = -9;
		}
	}
	
	
	public void update() {
		if(tracker1 < 60) {
			tracker2 =0;
			xv = 2;
			tracker1++;
		}
		else if(tracker2 < 60){
			xv = -2;
			tracker2++;
		}else {
			tracker1 = 0;
		}
		gravity();
		move();
	}
	
	
}
