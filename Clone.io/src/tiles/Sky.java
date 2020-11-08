package tiles;

import level.Tile;

public class Sky extends Tile{

	public Sky(int x, int y) {
		this.x = x;
		this.y = y;
		type = "Sky";
		solid = false;
		for(int i = 0; i < pixels.length; i ++) {
			pixels[i] = 0x0000ff;
		}
	}
	
	

}
