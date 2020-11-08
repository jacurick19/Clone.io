package level;

import tiles.Grass;
import tiles.Sky;

public class Tile {
	protected final static int SIZE = 16;
	public int pixels[] = new int[SIZE*SIZE];
	protected boolean solid;
	protected int x;
	protected int y;
	protected String type;
	public Tile() {
		
	}

	public int getPixel(int i) {
		return pixels[i];
	}

	public static Tile getTile(int col, int x, int y) {
		//Note: due to the alpha value, this is left shifted by 8

		if(col == 0xff0000) {

			return new Grass(x,y);
		}else {
			return new Sky(x,y);
			
		}
		
	}
	
	public boolean getSolid() {
		return solid;
	}
	
	public String getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
