package com.magequest.entities;

import java.awt.Component;
import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 * <b>Explosion</b>
 * <p>An explosion that is the effect of some spells</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class Explosion extends Component{

	private static final long serialVersionUID = -1602384226568071944L;
	
	private int a = 0;
	private int b = 0;
	
	private  int size = 5;
	private  int x = 0;
	private  int y = 0;
	
	boolean delay = true;
	
	public Explosion(int locx, int locy, int sizea) {
		super();
		size = sizea;
		x = locx+Reference.gamePanel.offX;
		y = locy+Reference.gamePanel.offY;
		setSize(size,size);
		setLocation(x,y);
		setVisible(true);
	}
	
	public void draw(Graphics g,Explosion expl){
		if(a<3){
			if(b>=9){
				a++;
				b=0;
			}else{
				g.drawImage(Reference.explosion[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
				b++;
			}
		g.drawImage(Reference.explosionCircle, (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
		}else{
			Reference.gamePanel.removeExplosion(this);
		}
	}

}
