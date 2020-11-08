package tiles;

import level.Tile;

public class Grass extends Tile{

	public Grass(int x, int y) {
		type = "Grass";
		this.x = x;
		this.y = y;
		solid = true;
		for(int i = 0; i < pixels.length; i ++) {
			pixels[i] = 0x00ff00;
		}
	}
	
	

}
