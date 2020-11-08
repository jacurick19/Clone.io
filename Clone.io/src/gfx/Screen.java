package gfx;

import entity.Entity;

public class Screen {
	public int pixels[];
	int width = 0;
	int height = 0;
	public Screen(int w, int h) {
		pixels = new int [w*h];
		width = w;
		height = h;
		for(int i = 0; i < w*h; i ++) {
			pixels[i] = 0;
		}
	}
	
	public int getPixel(int i){
		return pixels[i];
	}
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public void setPixel(int i, int color) {
		pixels[i] = color;
	}
	
	
	public void clear() {
		for(int i = 0; i < pixels.length; i ++) {
			pixels[i] = 0;
		}
	}
	public int getSize() {
		return pixels.length;
	}
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void renderEntity(Entity e, int xOffset, int yOffset) {

			Sprite sprite = e.getSprite();
			int spixels[] = sprite.getPixels();
			for(int i = 0; i < sprite.getWidth(); i++) {
				for(int j = 0; j < sprite.getHeight(); j++) {
					if((spixels[i+j*sprite.getHeight()] << 8 != 0xff00ff00)) {
						pixels[e.getX()+xOffset+i+(j+e.getY()+yOffset)*width] = spixels[i+j*sprite.getWidth()] ;
					}
				}
			}
		
	}


}
