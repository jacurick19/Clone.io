package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	int[] keys;
	public Keyboard() {
		keys = new int[3];
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) keys[0] = 1;
		if(arg0.getKeyCode() == KeyEvent.VK_UP) keys[1] = 1;
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) keys[2]=1;
	}
	
	public int[] getKeys() {
		return keys;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) keys[0] = 0;
		if(arg0.getKeyCode() == KeyEvent.VK_UP) keys[1] = 0;
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) keys[2]=0;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
