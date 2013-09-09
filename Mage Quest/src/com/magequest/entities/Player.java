/**
 * 
 */
package com.magequest.entities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.magequest.inputmanagers.KeyInputManager;
import com.magequest.magic.MagicRangeMarker;
import com.magequest.main.GameLoop;
import com.magequest.main.Reference;

/**
 * <b>Player Component</b>
 * <p>Class that draws/animates player and does stuff for player things</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class Player extends Component{

	private static final long serialVersionUID = 3320422621904168014L;
	
	public double x;
	public double y;
	public double centerX;
	public double centerY;
	public int width = 10;
	public int height = 10;
	
	public  int speed = Reference.playerSpeed;
	
	public  boolean sprinting = false;
	public  boolean spellCastReady = false;
	
	public  double hypoto;

	public Player(int startingX, int startingY) {
		x = startingX;
		y = startingY;
		centerX = x-(width/2);
		centerY = y-(height/2);
	}
	
	public void draw(Graphics g){
		if(spellCastReady){
			MagicRangeMarker.draw(g,100,MagicRangeMarker.CIRCLE);
		}else{
			
		}
		
		g.setColor(Color.blue);
		g.fillOval((int)Math.ceil(x/1.0),(int)Math.ceil(y/1.0), width, height);
	}
	
	public  void update(){
		if(sprinting){
			speed = Reference.playerSprintSpeed;
		}else{
			speed = Reference.playerSpeed;
		}
		if(KeyInputManager.s && KeyInputManager.d){
			y+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			x+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.a && KeyInputManager.w){
			y-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			x-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.w && KeyInputManager.d){
			y-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			x+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
		}else if(KeyInputManager.a && KeyInputManager.s){
			y+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			x-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
		}else{
			if(KeyInputManager.s){
				y+=speed * GameLoop.delta;
			}
			if(KeyInputManager.w){
				y-= speed * GameLoop.delta;
			}
			if(KeyInputManager.d){
				x+= speed * GameLoop.delta;
			}
			if(KeyInputManager.a){
			x-= speed * GameLoop.delta;
			}
		}
		centerX = x+(width/2);
		centerY = y+(height/2);
	}
}
