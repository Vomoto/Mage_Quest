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
		type = "soldier";
	}
	
	public ESoldier(int x1, int y1, int h){
		health = h;
		x = x1;
		y = y1;
		width = 10;
		height = 10;
		type = "soldier";
	}
	
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(((int)Math.ceil(x/1.0)-Reference.gamePanel.offX),((int)Math.ceil(y/1.0))-Reference.gamePanel.offY, width, height);
		g.setColor(Color.red);
		g.fillRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+3, width*3, height/2);
		g.setColor(Color.blue);
		g.fillRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+3,(int)(((double)health/100)*width*3), height/2);
		g.setColor(Color.black);
		g.drawRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+2, (width*3), (height/2)+1);
	}
	
	public void update(float delta){
		if(Reference.gamePanel.player.x>x){
			x+=delta*Reference.playerSpeed/2;
		}
		if(Reference.gamePanel.player.x<x){
			x-=delta*Reference.playerSpeed/2;
		}
		if(Reference.gamePanel.player.y>y){
			y+=delta*Reference.playerSpeed/2;
		}
		if(Reference.gamePanel.player.y<y){
			y-=delta*Reference.playerSpeed/2;
		}
		if(health <= 0){
			Reference.gamePanel.removeEnemy(this);
		}
		if(Math.pow(((int)(Reference.gamePanel.player.centerX - x))-Reference.gamePanel.offX,2)+Math.pow(((int)(Reference.gamePanel.player.centerY - y))-Reference.gamePanel.offY,2)<=500){
			Reference.gamePanel.player.health--;
		}
	}

}
