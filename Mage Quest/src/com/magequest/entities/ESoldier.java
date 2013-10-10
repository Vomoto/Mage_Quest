/**
 * 
 */
package com.magequest.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 * <b>Enemy Soldier</b>
 * <p>Melee only enemy</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class ESoldier extends Enemy{

	public ESoldier(int x1, int y1) {
		health = 100;
		x = x1;
		y = y1;
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(((int)Math.ceil(x/1.0))-Reference.gamePanel.offX,((int)Math.ceil(y/1.0))-Reference.gamePanel.offY, width, height);
		g.setColor(Color.red);
		g.fillRect(x-(width/2), y+height+3, width*2, 5);
		g.setColor(Color.blue);
		g.fillRect(x-(width/2), y+height+3, (int)(((double)health/100)*width*2), 5);
		g.setColor(Color.black);
		g.drawRect((x-(width/2))-1, (y+height+3)-1, (width*2)+1, 5+1);
	}
	
	public void update(){
		if(health <= 0){
			Reference.gamePanel.removeEnemy(this);
		}
	}

}
