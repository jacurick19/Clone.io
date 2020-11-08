package level;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import gfx.Screen;
import tiles.Grass;
import tiles.Sky;

public class Level {
	int xSize, ySize;
	int[] pixels;
	int height;
	int width;
	int tHeight;
	int tWidth;
	Screen screen;
	ArrayList<Entity> entity;
	Tile[] tiles;
	public Level(Screen screen) {
		this.screen = screen;
		height = this.screen.getHeight();
		width = this.screen.getWidth();
		
	} 
	public void addTile(int x, int y, Tile t) {
		for(int i = 0; i< Tile.SIZE; i++) {
			for(int j = 0; j < Tile.SIZE; j ++) {
				pixels[x+i+(y+j)*xSize ] = t.getPixel(i+j*Tile.SIZE);
			}
			
		}
	}
	
	protected void addEntity(Entity e) {
		entity.add(e);
		e.init(this);
	}
	
	public void collisionWithMap(Entity e) {
		
	}
	

	public void render(int xOffset, int yOffset) {
		
	}
	
	public List<Entity> getEntitys(Entity e, int radius){
		
		List<Entity> result = new ArrayList<Entity>();	
		int ex = (int)e.getX();
		int ey = (int)e.getY();

		for(int i=0; i< entity.size(); i++){
			Entity mob = entity.get(i);
			int x = (int)mob.getX();
			int y = (int)mob.getY();
			int dx = Math.abs(x-ex);
			int dy = Math.abs(y-ey);
			double distance = Math.sqrt((dx*dx) + (dy*dy));
			if(distance <= radius) result.add(mob);
		
		}
		return result;
	}
	
	public void update() {
		
	}
	
	
	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return new Grass(x,y);
		}else {
			if (pixels[x+y*xSize] ==  0x00ff00) return new Grass(x,y);
				return new Sky(x,y);
		}
		
		
	}
	


	protected void renderEntity(int xOffset, int yOffset) {
		for(Entity e : entity) {
			screen.renderEntity(e, xOffset, yOffset);
		}
		
	}



	protected void renderMap(int xOffset, int yOffset) {
		for(int i = 0; i < screen.getWidth(); i++) {
			for(int j = 0; j < screen.getHeight(); j++) {
				screen.setPixel(i+j*screen.getWidth(), pixels[i+j*xSize]);
			}
		}
	}

	
	

}
