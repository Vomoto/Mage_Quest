package com.magequest.inputmanagers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputAdapter;

import com.magequest.magic.MagicRangeMarker;
import com.magequest.main.Reference;

/**
 * <b>Mouse Input Manager</b>
 * <p>Manages clicks and maybe mouse positions</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class MouseInputManager extends MouseInputAdapter implements MouseMotionListener{
	
	private int dx;
	private int dy;
	private int dist;
	int startX=0;
	int startY=0;
	boolean mousedown = false;

	public MouseInputManager() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		dx = (int)(Reference.gamePanel.player.centerX - e.getPoint().getX());
		dy = (int)(Reference.gamePanel.player.centerY - e.getPoint().getY());
		dist = MagicRangeMarker.radius;
		if((dx*dx)+(dy*dy)<=dist*dist&&Reference.gamePanel.player.spellCastReady){
			Reference.gamePanel.addExplosion((int) e.getPoint().getX(), (int) e.getPoint().getY(), 100);
		}
		startX = e.getX();
		startY = e.getY();
		System.out.println(startX+"  "+startY+" clicked");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		mousedown = false;
		System.out.println();
	}
	
	public void mouseDragged(MouseEvent e){
		//System.out.println(e.getPoint().getX()+"  "+startX);
		//System.out.println(e.getPoint().getY()+"  "+startY);
		Reference.mainWorld.offX += e.getX()-startX;
		Reference.mainWorld.offY += e.getY()-startY;
		System.out.println((e.getX()-startX)+"  "+(e.getY()-startY)+" total");
		startX = e.getX();
		startY = e.getY();
		System.out.println(startX+ "  "+startY+" dragged");
	}
}
