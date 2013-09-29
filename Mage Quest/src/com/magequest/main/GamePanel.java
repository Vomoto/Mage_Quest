/**
 * 
 */
package com.magequest.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.magequest.entities.Explosion;
import com.magequest.entities.Player;
import com.magequest.envirement.MainWorld;

/**
 * <b>Game Panel Class</b>
 * <p>JPanel that holds the graphics for the game.</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = -9216362209081556437L;
	
	public Player player = new Player(150,150);

    List<Explosion> explosions = new ArrayList<Explosion>();
    List<Explosion> expltbr = new ArrayList<Explosion>();
    Explosion lastExplosion;
    
	public MainWorld mainWorld = new MainWorld();
	
	public int ax = 0;
	public int by = 0;
	
	int z = 0;
	
	public int offX = 0;
	public int offY = 0;
	
	public boolean following = false;

	public GamePanel() {
		super();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
		mainWorld.draw(g);
		player.draw(g);
		g.setColor(Color.black);
		for(Explosion expl : explosions){
			expl.draw(g,expl);
		}
		explosions.remove(expltbr);
		expltbr = new ArrayList<Explosion>();
		g.drawString(Reference.fullTitle,0,15);
		g.drawString(Reference.fps, 0, 30);
		//g.dispose();
		if(explosions.size()>= 500){
			lastExplosion = explosions.get(explosions.size()-1);
			explosions = new ArrayList<Explosion>();
			explosions.add(lastExplosion);
		}
	}
	
	public void addExplosion(int x, int y, int size){
		explosions.add(new Explosion(x,y,size));
	}
	
	public void removeExplosion(Explosion e){
		expltbr.add(e);
	}
	
	public void math(){
		if(following){
			offX = ((int) player.x)-(Reference.windowWidth/2);
			offY = ((int)player.y)-(Reference.windowHeight/2);
			if(!(offX>-200)){
				offX = -199;
			}
			if(!(offX<((mainWorld.map.length*32)-(Reference.windowWidth-200)))){
				offX = ((mainWorld.map.length*32)-(Reference.windowWidth-201));
			}
			if(!(offY>-200)){
				offY = -199;
				
			}
			if(!(offY<((mainWorld.map.length*32)-(Reference.windowHeight-200)))){
				offY = ((mainWorld.map.length*32)-(Reference.windowWidth-201));
				
			}
		}
	}

}
