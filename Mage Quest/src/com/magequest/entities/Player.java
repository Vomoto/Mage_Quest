/**
 * 
 */
package com.magequest.entities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.magequest.inputmanagers.KeyInputManager;
import com.magequest.main.GameLoop;

/**
 * <b>Player Component</b>
 * <p>Class that draws/animates player and does stuff for player things</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class Player extends Component{

	private static final long serialVersionUID = 3320422621904168014L;
	
	public static int x;
	public static int y;

	public Player(int startingX, int startingY) {
		x = startingX;
		y = startingY;
	}
	
	public static void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(x, y, 10, 10);
	}
	
	public static void update(){
		y+=KeyInputManager.s*GameLoop.delta;
		y-=KeyInputManager.w*GameLoop.delta;
		x+=KeyInputManager.d*GameLoop.delta;
		x-=KeyInputManager.a*GameLoop.delta;
	}

}
