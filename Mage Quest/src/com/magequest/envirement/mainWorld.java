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
		map = Reference.load.LoadSave(save);
		
		}
	
	public void draw(Graphics g){
		for(int x=0;x<1000;x++){
			for(int y = 0;y<1000;y++){
				if(((x*squareSize)-Reference.gamePanel.offX)>-squareSize&&((x*squareSize)-Reference.gamePanel.offX)<Reference.windowWidth&&((y*squareSize)-Reference.gamePanel.offY)>-squareSize&&((y*squareSize)-Reference.gamePanel.offY)<Reference.windowHeight){
					if((map[x][y]/100)%10==1){
						g.drawImage(Reference.terrain[(map[x][y]/10)%10][map[x][y]%10], ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
					}
					if((map[x][y]/100)%10==2){
						g.drawImage(Reference.terrainModerates[(map[x][y]/10)%10][map[x][y]%10], ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
					}
				}
			}
		}
	}
	
	public void setBlock(int blockNum, int x, int y){
		if(blockNum == 100){
			if(map[x+1][y]>=110&&map[x+1][y]<=113){
				map[x][y] = 200+Reference.randomGenerator.nextInt(2);
			}else if(map[x-1][y]>=110&&map[x-1][y]<=113){
				map[x][y] = 202+Reference.randomGenerator.nextInt(2);
			}else{
				map[x][y] = blockNum+Reference.randomGenerator.nextInt(3);
			}
		}else if(blockNum == 110){
			if(map[x+1][y]>=100&&map[x+1][y]<=103){
				map[x+1][y] = 202+Reference.randomGenerator.nextInt(2);
			}
			if(map[x-1][y]>=100&&map[x-1][y]<=103){
				map[x-1][y] = 200+Reference.randomGenerator.nextInt(2);
			}
			if(map[x][y+1]>=100&&map[x][y+1]<=103){
				map[x][y+1] = 204+Reference.randomGenerator.nextInt(2);
			}
			if(map[x][y-1]>=100&&map[x][y-1]<=103){
				map[x][y-1] = 206+Reference.randomGenerator.nextInt(2);
			}
			if(map[x+1][y+1]>=100&&map[x+1][y+1]<=103){
				map[x+1][y+1] = 219;
			}
			if(map[x+1][y-1]>=100&&map[x+1][y-1]<=103){
				map[x+1][y-1] = 209;
			}
			if(map[x-1][y+1]>=100&&map[x-1][y+1]<=103){
				map[x-1][y+1] = 218;
			}
			if(map[x-1][y-1]>=100&&map[x-1][y-1]<=103){
				map[x-1][y-1] = 208;
			}
			if(map[x][y+1]==218||map[x][y+1]==219){
				map[x][y+1] = 204+Reference.randomGenerator.nextInt(2);
			}
			if(map[x][y-1]==209||map[x][y-1]==208){
				map[x][y-1] = 206+Reference.randomGenerator.nextInt(2);
			}
			if(map[x+1][y]==218||map[x+1][y]==219){
				map[x+1][y] = 204+Reference.randomGenerator.nextInt(2);
			}
			if(map[x-1][y]==209||map[x-1][y]==208){
				map[x-1][y] = 206+Reference.randomGenerator.nextInt(2);
			}
				//map[x][y] = blockNum+Reference.randomGenerator.nextInt(3);
			map[x][y] = blockNum+Reference.randomGenerator.nextInt(3);
		}else if(blockNum == 130){
			map[x][y] = blockNum+Reference.randomGenerator.nextInt(3);
			
		}else{
			map[x][y] = blockNum;
		}
	}

}
