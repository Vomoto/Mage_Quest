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
	
	private  int size = 0;
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
		if(a<=7){
			if(b>=9){
				b=0;
				if(delay){
					delay = false;
				}else{
					a++;
					delay = false;
				}
			}else{
				size = 50;
				g.drawImage(Reference.explosion[a][b], (x-(size/2))-Reference.gamePanel.offX, (y-(size/2))-Reference.gamePanel.offY, size, size, null);
				b++;
			}
		}else{
			Reference.gamePanel.removeExplosion(this);
		}
	}

}
