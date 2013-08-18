/**
 * 
 */
package com.magequest.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.magequest.entities.Player;
import com.magequest.inputmanagers.KeyInputManager;

/**
 * <b>Game Panel Class</b>
 * <p>JPanel that holds the graphics for the game.</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = -9216362209081556437L;
	
	Component player = new Player(150,150);

	public GamePanel() {
		super();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
		Player.draw(g);
		g.setColor(Color.black);
		if(!Reference.devBuild){
			g.drawString(Reference.title + "  " + Reference.version + " - Dev Build",0,15);
		}else{
			g.drawString(Reference.title + "  " + Reference.version + " - Public Build",0,15);
		}
		g.drawString(Reference.fps, 0, 30);
	}
	
	public static void math(){
		
	}

}
