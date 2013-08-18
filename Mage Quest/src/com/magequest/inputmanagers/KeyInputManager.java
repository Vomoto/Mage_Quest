/**
 * 
 */
package com.magequest.inputmanagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.magequest.main.GameLoop;

/**
 * <b>Class Name</b>
 * <p>Description</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class KeyInputManager implements KeyListener{

	public static double w = 0;
	public static double s = 0;
	public static double d = 0;
	public static double a = 0;
	
	public KeyInputManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W ){
			w = 5;
		}
		if(e.getKeyCode()==KeyEvent.VK_S ){
			s = 5;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_D ){
			d = 5;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_A ){
			a = 5;
		}
		System.out.println(GameLoop.delta);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W ){
			w = 0;
		}
		if(e.getKeyCode()==KeyEvent.VK_S ){
			s = 0;
		}
		if(e.getKeyCode()==KeyEvent.VK_D ){
			d = 0;
		}
		if(e.getKeyCode()==KeyEvent.VK_A ){
			a = 0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
