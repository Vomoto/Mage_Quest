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
	
	int lastKeyCode = -1;
	
	public KeyInputManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			Reference.save.SaveWolrd(Reference.gamePanel.mainWorld.map, Reference.gamePanel.mainWorld.save);
			Reference.exit();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SHIFT){
			Reference.gamePanel.player.sprinting = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_F1){
			Reference.gamePanel.offX = (int) Reference.gamePanel.player.x-(Reference.windowWidth/2);
			Reference.gamePanel.offY = (int) Reference.gamePanel.player.y-(Reference.windowHeight/2);
			if(!(Reference.gamePanel.offX>-200)){
				Reference.gamePanel.offX = -199;
			}
			if(!(Reference.gamePanel.offX<((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowWidth-200)))){
				Reference.gamePanel.offX = ((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowWidth-201));
			}
			if(!(Reference.gamePanel.offY>-200)){
				Reference.gamePanel.offY = -199;
				
			}
			if(!(Reference.gamePanel.offY<((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowHeight-200)))){
				Reference.gamePanel.offY = ((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowWidth-201));
				
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(Reference.gamePanel.following){
				Reference.gamePanel.following = false;
			}else{
				Reference.gamePanel.following = true;
			}
		}
		if(KeyEvent.VK_1==e.getKeyCode()){
			if(e.getKeyCode()!=lastKeyCode){
				Reference.gamePanel.spellSelector.active = true;
				Reference.gamePanel.spellSelector.spellSet = Reference.gamePanel.spellSelector.TERRAFORM;
				lastKeyCode = e.getKeyCode();
			}else{
				Reference.gamePanel.spellSelector.active = false;
				Reference.gamePanel.player.spellCast = 0;
				lastKeyCode = -1;
			}
		if(e.getKeyCode()==KeyEvent.VK_2){
			if(e.getKeyCode()!=lastKeyCode){
				Reference.gamePanel.player.spellCast = 1;
				lastKeyCode = e.getKeyCode();
			}else{
				Reference.gamePanel.player.spellCast = 0;
				lastKeyCode = -1;
			}
			
		}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_F){
		}
		
		if(e.getKeyCode()==KeyEvent.VK_E){
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
