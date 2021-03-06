/**
 * 
 */
package com.magequest.entities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.magequest.inputmanagers.KeyInputManager;
import com.magequest.magic.MagicRangeMarker;
import com.magequest.main.GameLoop;
import com.magequest.main.Reference;

/**
 * <b>Player Component</b>
 * <p>Class that draws/animates player and does stuff for player things</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class Player extends Component{

	private static final long serialVersionUID = 3320422621904168014L;
	
	public double x;
	public double y;
	public double tempx;
	public double tempy;
	public double centerX;
	public double centerY;
	public int width = 10;
	public int height = 10;
	
	public int speed = Reference.playerSpeed;
	
	public boolean sprinting = false;
	public int spellCast = 0;
	public int lastSpellCast = 0;
	
	public  double hypoto;
	
	int health = 100;

	public Player(int startingX, int startingY) {
		x = startingX;
		y = startingY;
		centerX = x-(width/2);
		centerY = y-(height/2);
	}
	
	public void draw(Graphics g){
		if(spellCast!=0){
			if(spellCast == 1){
				MagicRangeMarker.draw(g,100,MagicRangeMarker.CIRCLE);
			}else if(spellCast > 9){
				try{
					g.drawImage(Reference.terrain[((spellCast-10)/10)%10][spellCast%10],(int) Reference.mainWindow.getMousePosition().getX()-17,(int)Reference.mainWindow.getMousePosition().getY()-17,32,32 , null);
					g.setColor(Color.black);
					g.drawRect((int) Reference.mainWindow.getMousePosition().getX()-18, (int)Reference.mainWindow.getMousePosition().getY()-18, 33, 33);
				}catch(Exception e){
				}
				
			}
		}
		g.setColor(Color.blue);
		g.fillOval(((int)Math.ceil(x/1.0))-Reference.gamePanel.offX,((int)Math.ceil(y/1.0))-Reference.gamePanel.offY, width, height);
		g.setColor(Color.red);
		g.fillRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+3, width*3, height/2);
		g.setColor(Color.blue);
		g.fillRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+3,(int)(((double)health/100)*width*3), height/2);
		g.setColor(Color.black);
		g.drawRect((((int)Math.ceil(x/1.0))-Reference.gamePanel.offX)-width,(((int)Math.ceil(y/1.0))-Reference.gamePanel.offY)+height+2, (width*3), (height/2)+1);
		
	}
	
	public  void update(){
		if(sprinting){
			speed = Reference.playerSprintSpeed;
		}else{
			speed = Reference.playerSpeed;
		}
		if(KeyInputManager.s && KeyInputManager.d){
			tempx = x;
			tempy = y;
			tempy+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			tempx+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
				y+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
			if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
				x+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
		}else if(KeyInputManager.a && KeyInputManager.w){

			tempx = x;
			tempy = y;
			tempy-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			tempx-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
				y-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
			if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
				x-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
		}else if(KeyInputManager.w && KeyInputManager.d){

			tempx = x;
			tempy = y;
			tempy-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			tempx+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
				y-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
			if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
				x+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
		}else if(KeyInputManager.a && KeyInputManager.s){

			tempx = x;
			tempy = y;
			tempy+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			tempx-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
				y+=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
			if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
				x-=(double)(speed * GameLoop.delta)/Math.sqrt(2.0);
			}
		}else{
			if(KeyInputManager.s){
				tempy = y;
				tempy+=speed * GameLoop.delta;
				if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
					y+=speed * GameLoop.delta;
				}
			}
			if(KeyInputManager.w){
				tempy = y;
				tempy-=speed * GameLoop.delta;
				if(tempy>0&&tempy<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offY){
					y-=speed * GameLoop.delta;
				}
			}
			if(KeyInputManager.d){
				tempx = x;
				tempx+=speed * GameLoop.delta;
				if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
					x+=speed * GameLoop.delta;
				}
			}
			if(KeyInputManager.a){
				tempx = x;
				tempx-=speed * GameLoop.delta;
				if(tempx>0&&tempx<(Reference.gamePanel.mainWorld.map.length*32)-Reference.gamePanel.offX){
					x-=speed * GameLoop.delta;
				}
			}
			if(health<=0){
				health = 100;
			}
		}
		centerX = x+(width/2);
		centerY = y+(height/2);
	}
}
