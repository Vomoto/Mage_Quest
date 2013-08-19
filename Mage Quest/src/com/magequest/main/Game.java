/**
 * 
 */
package com.magequest.main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.magequest.entities.Player;

/**
 * @author Cooper Mahring
 *
 */
public class Game extends JPanel{
	
	Player player;
	String fpsString = "0";
	

	public Game() {
		super(null);
		setSize(Reference.windowWidth,Reference.windowHeight);
		setVisible(true);
		
		player = new Player(100,100);
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
		Player.draw(g);
		g.drawString(fpsString, 50, 50);
		g.dispose();
	}
	
	public void update(){
		
		StringBuilder sb = new StringBuilder();
		sb.append(Reference.gl.fps);
		fpsString = sb.toString();
	}
	
}
