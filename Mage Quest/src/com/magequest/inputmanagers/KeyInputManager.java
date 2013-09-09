/**
 * 
 */
package com.magequest.inputmanagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.magequest.main.Reference;

/**
 * <b>Key Input Manager</b>
 * <p>Handles all the key inputs</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class KeyInputManager implements KeyListener{

	public static boolean w = false;
	public static boolean s = false;
	public static boolean d = false;
	public static boolean a = false;
	
	public KeyInputManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			Reference.exit();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SHIFT){
			Reference.gamePanel.player.sprinting = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_1){
			if(!Reference.gamePanel.player.spellCastReady){
				Reference.gamePanel.player.spellCastReady = true;
			}else{
				Reference.gamePanel.player.spellCastReady = false;
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_W ){
			w = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S ){
			s = true;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_D ){
			d = true;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_A ){
			a = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SHIFT){
			Reference.gamePanel.player.sprinting = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_W ){
			w = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S ){
			s = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D ){
			d = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A ){
			a = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
