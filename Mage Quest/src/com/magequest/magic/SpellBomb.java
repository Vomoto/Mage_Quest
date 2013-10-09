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
		if(a<6&&c<63){
			if(b<10){
				if(a==5){
					if(b<2){
						g.drawImage(Reference.ACBomb[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
						b++;
					}else{
						a++;
						g.drawImage(Reference.ACBomb[5][2], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
					}
				}else{
					g.drawImage(Reference.ACBomb[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
					b++;
				}
			}else{
				a++;
				b=0;
				g.drawImage(Reference.ACBomb[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
			}
		}else if(c==65){
			a = 0;
			b = 0;
		}
		if(c>=58){
			g.drawImage(Reference.ACBomb[5][2], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
		}
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
