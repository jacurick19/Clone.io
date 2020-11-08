package level;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entity.Entity;
import gfx.Screen;
import input.Keyboard;
import entity.Player;
import entity.Simple_Ghost;
public class Spawn_Level  extends Level {

	
	BufferedImage img;
	int[] imagePixels;
	int col;
	public Spawn_Level(Screen screen, Keyboard keyboard) {
		super(screen);
		entity = new ArrayList<Entity>();
		Player player = new Player(50,50, keyboard);
		Simple_Ghost ghost = new Simple_Ghost(200,50);
		addEntity(player);
		addEntity(ghost);
		try {
			img = ImageIO.read(new File("res/levels/spawn.png"));
			xSize = img.getRaster().getWidth()*Tile.SIZE;
			ySize = img.getRaster().getHeight()*Tile.SIZE;
			pixels = new int[xSize*ySize];
			tiles = new Tile[img.getRaster().getWidth()*img.getRaster().getHeight()];
			tWidth = img.getRaster().getWidth();
		}catch(IOException e) {
		}
		for(int i = 0; i < img.getRaster().getWidth(); i++) {
			for(int j = 0; j < img.getRaster().getHeight(); j++) {
				col = img.getRGB(i, j);
				col = col << 8;
				Tile temp = Tile.getTile(col,i*Tile.SIZE,j*Tile.SIZE);
				tiles[i+j*img.getRaster().getWidth()] = temp;
				addTile(i*Tile.SIZE,j*Tile.SIZE,temp);
			}
		}
	}
	
	
	
	@Override
	public void render(int xOffset, int yOffset) {
		renderMap(xOffset, yOffset);
		renderEntity(xOffset, yOffset);
	}
	
	@Override
	public void update() {
		updateEntity();
	}
	
	private void updateEntity() {
		for(Entity e : entity) {
			e.update();
		}
		
	}


	

	

}
