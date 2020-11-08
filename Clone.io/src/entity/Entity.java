package entity;


import gfx.Sprite;
import level.Level;

public class Entity {
	public int x;
	protected int y;
	Level level;
	int xv, yv;
	public double speed;
	protected Sprite sprite;
	public Entity() {
		
	}
	
	public void update() {
		
	}
	public void render() {
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	

	public void move() {
		if(!collision(xv,yv)) {
			x+=xv;
			y+=yv;
		}
	}
	
	

	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void gravity() {
		if(!collision(0,4)) y+=4;
	}
	
	
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		for(int c =0; c < 4; c++){
			double xt = ((x+xa) +c%2 *16);
		    double yt = ((y+ya) +c/2 * 16);
		       int ix = (int) Math.ceil(xt);
			   int iy = (int) Math.ceil(yt);
			   if (level.getTile(ix, iy).getSolid()) solid = true;
		}
			
			
		return solid;
		}
	
	public void init(Level level){
		this.level = level;
	}
}
