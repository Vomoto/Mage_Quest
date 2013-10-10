/**
 * 
 */
package com.magequest.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * <b>Enemy</b>
 * <p>Super class for enemies</p>
 * <p></p>
 * @author Cooper Mahring
 */
public abstract class Enemy {
	
	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	int health = 0;

	public Enemy() {
	}
	
	public void update(){
	}
	
	public void draw(Graphics g){
	}
	
	public void removeHealth(int h){
		health -= h;
	}
	
	public void addHealth(int h){
		health += h;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
