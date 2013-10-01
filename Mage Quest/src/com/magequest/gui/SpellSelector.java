/**
 * 
 */
package com.magequest.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 * <b>Tile Selector</b>
 * <p>A GUI used to select a tile from a set</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class SpellSelector extends Component{

	private static final long serialVersionUID = 1576686919449472525L;
	
	public int currentX = Reference.windowWidth/16;
	public float currentY = 1500;
	
	public float targetY = currentY;
	
	public int width = 0;
	public int height = 0;
	
	public boolean active = false;
	public boolean hasBeenActivated = false;
	
	int speed = 500;
	
	public int tileSize = 75;
	
	public int spellSet = 0;
	
	
	public int TERRAFORM = 1;
	public int DESTRUCTIVESPELLS = 2;
	

	public SpellSelector() {
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(0,0,0,150));
		g.fillRect(currentX, (int)currentY, width, height);
		if(spellSet == 1){
			for(int i = 0; i<=10;i++){
				try{
					g.drawImage(Reference.terrain[i][0], (int)(((i+1)*(width/11.5))+currentX), (int)(currentY+( Reference.windowHeight/32)),tileSize,tileSize, null);
				}catch(Exception e){
					
				}
			}
		}

		if(spellSet == 2){
			try{
				g.drawImage(Reference.explosion[0][8], (int)(((width/11.5))+currentX), (int)(currentY+( Reference.windowHeight/32)),tileSize,tileSize, null);
			}catch(Exception e){
			}
		}
	}
	
	public void update(float interpolation){
		currentX = Reference.windowWidth/16;
		width = Reference.windowWidth-(int)((Reference.windowWidth/16)*2);
		height = Reference.windowHeight/8;
		if(active){
			targetY = 1+Reference.windowHeight-(Reference.windowHeight/8);
			hasBeenActivated = true;
		}else{
			targetY = Reference.windowHeight+1;
			if(!hasBeenActivated){
				currentY = targetY;
			}
		}
		if(targetY!=currentY){
			if(targetY>currentY){
				currentY+=speed*interpolation;
			}
			if(targetY<currentY){
				currentY-=speed*interpolation;
			}
		}
	}

}
