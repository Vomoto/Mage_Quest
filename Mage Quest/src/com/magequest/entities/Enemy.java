/**
 * 
 */
package com.magequest.entities;

import java.awt.Graphics;

/**
 * <b>Enemy</b>
 * <p>Super class for enemies</p>
 * <p></p>
 * @author Cooper Mahring
 */
public abstract class Enemy {
	
	float x = 0;
	float y = 0;
	int width = 0;
	int height = 0;
	int health = 0;
	String type = "";

	public Enemy() {
	}
	
	public void update(float delta){
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
		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
	public String getType(){
		return type;
	}

}
