package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import gfx.Screen;
import input.Keyboard;
import level.Spawn_Level;


public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int billion = 1000000000;
	private final int sixty = 60;
	private Boolean isRunning;
	private JFrame frame;
	final static int WIDTH = 800;
	final static int HEIGHT = 400;
	private static Thread thread;
	private static Keyboard keyboard;
	private Spawn_Level spawnLevel;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	Screen screen;
	public Game(){
		isRunning = true;
		frame = new JFrame();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		screen = new Screen(WIDTH, HEIGHT);
		keyboard = new Keyboard();
		spawnLevel = new Spawn_Level(screen, keyboard);

		}

	public void update() {
		spawnLevel.update();
	}
	
	public void render() {
		screen.clear();
		spawnLevel.render(0,0);
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		for(int i = 0; i < pixels.length; i ++) {
			pixels[i] = screen.getPixel(i);
		}
		bs.show();
		
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
		thread.join();
	} catch (InterruptedException e) {
			e.printStackTrace ();
		}
	}
	
	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this, "display");
		thread.start();
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = billion / sixty;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		Long time;
	       requestFocus();
			while(isRunning) {
				time = System.nanoTime();
				delta += (time - lastTime) / ns;
				lastTime = time;
				while(delta >= 1) {
					update();
					updates++;
					delta--;
				}
				render();
				frames++;
				if (System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					System.out.println(updates + " UPS " + frames +" FPS");
					updates = 0;
					frames = 0;
				}
			}	
		
		}

	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setSize(WIDTH, HEIGHT);
		game.addKeyListener(keyboard);
		game.frame.setLocationRelativeTo(null);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setResizable(false);
		game.frame.requestFocus();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);
		game.start();
	}
}
