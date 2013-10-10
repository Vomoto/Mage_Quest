/**
 * 
 */
package com.magequest.magic;

import java.awt.Graphics;

/**
 * <b>Spell</b>
 * <p>spells that the player or enemies cast will extend this class</p>
 * <p></p>
 * @author Cooper Mahring
 */
public abstract class Spell {
	
	int a = 0;
	int b = 0;
	int c = 0;
	int x = 0;
	int y = 0;
	
	int size = 0;
	int circleSize = 0;

	public Spell() {
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g){
		
	}
	
	public void update(){
		
	}

}
