package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Simple_Ghost_Sprite extends Sprite{
	BufferedImage img;
	int pixels[];
	public Simple_Ghost_Sprite() {
		try {
			img = ImageIO.read(new File("res/enemy/mob.png"));
			width = img.getRaster().getWidth();
			height = img.getRaster().getHeight();
			pixels = new int[height*width];

		}catch(IOException e) {
		}
		for(int i = 0; i < img.getRaster().getWidth(); i++) {
			for(int j = 0; j < img.getRaster().getHeight(); j++) {
				pixels[i+j*img.getRaster().getWidth()] = img.getRGB(i, j);
			}
		}
	}
	@Override
	public int getWidth() {
		return height;
	}

	@Override
	public int getHeight() {
		return width;
	}

	@Override
	public int[] getPixels() {
		return pixels;
	}

}
