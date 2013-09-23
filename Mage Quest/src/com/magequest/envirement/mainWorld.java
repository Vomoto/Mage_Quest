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
	
	public int squareSize = 32;
	
	

	public MainWorld() {
		for(int a = 0; a<map.length;a++){
			for(int b = 0; b<map.length;b++){
				map[a][b] = 0;
			}
		}
		Reference.save.SaveWolrd(map);
		
		}
	
	public void draw(Graphics g){
		for(int x=0;x<1000;x++){
			for(int y = 0;y<1000;y++){
				if(((x*squareSize)-Reference.gamePanel.offX)>-squareSize&&((x*squareSize)-Reference.gamePanel.offX)<Reference.windowWidth&&((y*squareSize)-Reference.gamePanel.offY)>-squareSize&&((y*squareSize)-Reference.gamePanel.offY)<Reference.windowHeight){
					g.drawImage(Reference.terrain[0][0], ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
				}
			}
		}
	}

}
