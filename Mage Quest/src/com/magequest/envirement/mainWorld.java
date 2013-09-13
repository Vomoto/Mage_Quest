/**
 * 
 */
package com.magequest.envirement;

import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 *<b>Main World</b>
 *<p>Holds information about the main world</p>
 *<p></p>
 * @author Cooper Mahring
 */
public class MainWorld {
	
	public int[][] map = new int[1000][1000];
	
	public int offX = 0;
	public int offY = 0;

	public MainWorld() {
		
		
		
		}
	
	public void draw(Graphics g){
		for(int x=0;x<(Reference.windowWidth/32)+15;x++){
			for(int y = 0;y<(Reference.windowHeight/32)+15;y++){
				g.drawImage(Reference.terrain[0][0], ((x-5)*32)+offX, ((y-15)*32)+offY, 32, 32, null);
				//g.setColor(Color.black);
				//g.drawRect((x-5)*32,(y-5)*32,32,32);
				//g.drawRect((x-5)*32,(y-5)*32,32,32);
			}
		}
	}

}
