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
		x = x1+Reference.gamePanel.offX;
		y = y1+Reference.gamePanel.offY;
		size = size1;
		circleSize = (int)(size/1.25);
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
						g.drawImage(Reference.ACBomb[a][b], (x-(circleSize/2))-Reference.gamePanel.offX, (y-(circleSize/2))-Reference.gamePanel.offY, circleSize, circleSize, null);
						b++;
					}else{
						a++;
						g.drawImage(Reference.ACBomb[5][2], (x-(circleSize/2))-Reference.gamePanel.offX, (y-(circleSize/2))-Reference.gamePanel.offY, circleSize, circleSize, null);
					}
				}else{
					g.drawImage(Reference.ACBomb[a][b], (x-(circleSize/2))-Reference.gamePanel.offX, (y-(circleSize/2))-Reference.gamePanel.offY, circleSize, circleSize, null);
					b++;
				}
			}else{
				a++;
				b=0;
				g.drawImage(Reference.ACBomb[a][b], (x-(circleSize/2))-Reference.gamePanel.offX, (y-(circleSize/2))-Reference.gamePanel.offY, circleSize, circleSize, null);
			}
		}else if(c==65){
			a = 0;
			b = 0;
		}
		if(c>=58&&c<110){
			g.drawImage(Reference.ACBomb[5][2], (x-(circleSize/2))-Reference.gamePanel.offX, (y-(circleSize/2))-Reference.gamePanel.offY, circleSize, circleSize, null);
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
				Reference.gamePanel.removeSpell(this);
			}
		}
		c++;
	}
	
	public void update(){
		if(c == 110){
			Reference.gamePanel.doDamageToEnemies(x, y);
		}
	}

}
