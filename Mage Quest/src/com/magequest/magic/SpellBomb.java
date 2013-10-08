/**
 * 
 */
package com.magequest.magic;

import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 * <b>Spell Bomb</b>
 * <p>Spell that creates an explosion</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class SpellBomb extends Spell{

	public SpellBomb(int x1, int y1, int size1) {
		x = x1;
		y = y1;
		size = size1;
	}
	
	/*
	 * Alchemist circle needs to be orange!
	 * 
	 * 
	 * 
	 * */
	
	public void draw(Graphics g){
		g.drawImage(Reference.explosionCircle, (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
		if(c>100){
			if(a<3){
				if(b<=9){
					g.drawImage(Reference.explosion[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
					b++;
				}else{
					a++;
					b=0;
					g.drawImage(Reference.explosion[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
				}
			}else{
				Reference.gamePanel.removeExplosion(this);
			}
		}
		c++;
	}

}
