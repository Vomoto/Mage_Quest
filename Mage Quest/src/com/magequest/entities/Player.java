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
	
	public static double x;
	public static double y;
	
	public static double hypoto;

	public Player(int startingX, int startingY) {
		x = startingX;
		y = startingY;
	}
	
	public static void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillOval((int)Math.ceil(x/1.0),(int)Math.ceil(y/1.0), 10, 10);
	}
	
	public static void update(){
		if(KeyInputManager.s != 0 &&KeyInputManager.d != 0){
			y+=(double)(KeyInputManager.s * GameLoop.delta)/Math.sqrt(2.0);
			x+=(double)(KeyInputManager.d * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.a != 0 &&KeyInputManager.w != 0){
			y-=(double)(KeyInputManager.w * GameLoop.delta)/Math.sqrt(2.0);
			x-=(double)(KeyInputManager.a * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.w != 0 &&KeyInputManager.d != 0){
			y-=(double)(KeyInputManager.w * GameLoop.delta)/Math.sqrt(2.0);
			x+=(double)(KeyInputManager.d * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.a != 0 &&KeyInputManager.s != 0){
			y+=(double)(KeyInputManager.s * GameLoop.delta)/Math.sqrt(2.0);
			x-=(double)(KeyInputManager.a * GameLoop.delta)/Math.sqrt(2.0);
		}else{
			y+=(double)(KeyInputManager.s * GameLoop.delta);
			y-=(double)KeyInputManager.w * GameLoop.delta;
			x+=(double)(KeyInputManager.d * GameLoop.delta);
			x-=(double)KeyInputManager.a * GameLoop.delta;
		}
	}
}
