/**
 * 
 */
package com.magequest.envirement;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

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
	
	AffineTransform tx;
	AffineTransformOp op;
	double rotation;
	double rotationX;
	double rotationY;
	

	public MainWorld() {
		map = Reference.load.LoadSave(save);
		
		}
	
	public void draw(Graphics g){
		for(int x=0;x<1000;x++){
			for(int y = 0;y<1000;y++){
				if(((x*squareSize)-Reference.gamePanel.offX)>-squareSize&&((x*squareSize)-Reference.gamePanel.offX)<Reference.windowWidth&&((y*squareSize)-Reference.gamePanel.offY)>-squareSize&&((y*squareSize)-Reference.gamePanel.offY)<Reference.windowHeight){
					if((map[x][y]/100)%10==1){
						g.drawImage(Reference.terrain[(map[x][y]/10)%10][map[x][y]%10], ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
					}else if((map[x][y]/100)%10<=4){
						System.out.println(map[x][y]+"  "+x+"  "+y);
						rotation = Math.toRadians((((map[x][y]/100)%10)-1)*90);
						if((map[x][y]/100)%10==2){
							
						}
						if((map[x][y]/100)%10==3){
							
						}
						if((map[x][y]/100)%10==4){
							
						}
						tx = AffineTransform.getRotateInstance(Math.toRadians(rotation));
						op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
						g.drawImage(op.filter(Reference.terrain[(map[x][y]/10)%10][map[x][y]%10],null), ((x)*squareSize)-Reference.gamePanel.offX, ((y)*squareSize)-Reference.gamePanel.offY, squareSize, squareSize, null);
						
					}
				}
			}
		}
	}
	
	public void setBlock(int blockNum, int x, int y){
		map[x][y] = blockNum;
	}

}
