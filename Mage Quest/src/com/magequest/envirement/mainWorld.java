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
	
	public String world = "mainWorld";
	public String save = "mainWorld";
	
	

	public MainWorld() {
		map = Reference.load.LoadWorld("mainworld");
		
		}
	
	public void draw(Graphics g){
		for(int x=0;x<1000;x++){
			for(int y = 0;y<1000;y++){
				if(((x*squareSize)-Reference.gamePanel.offX)>-squareSize&&((x*squareSize)-Reference.gamePanel.offX)<Reference.windowWidth&&((y*squareSize)-Reference.gamePanel.offY)>-squareSize&&((y*squareSize)-Reference.gamePanel.offY)<Reference.windowHeight){
					if((map[x][y]/100)%100==1){
						g.drawImage(Reference.terrain[(map[x][y]/10)%10][map[x][y]%10], ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
					}
				}
			}
		}
	}
	
	public void setBlock(int blockNum, int x, int y){
		map[x][y] = blockNum;
	}

}
