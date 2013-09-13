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
    
	
	
	public int ax = 0;
	public int by = 0;

	public GamePanel() {
		super();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
		Reference.mainWorld = new MainWorld();
		Reference.mainWorld.draw(g);
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
		
	}

}
