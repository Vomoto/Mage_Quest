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
	int tempoffX = 0;
	int tempoffY = 0;
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
		System.out.println(e.getModifiers());
		if(e.getModifiers()==16||e.getModifiers()==17||e.getModifiers()==18){
			dx = ((int)(Reference.gamePanel.player.centerX - e.getPoint().getX()))-Reference.gamePanel.offX;
			dy = ((int)(Reference.gamePanel.player.centerY - e.getPoint().getY()))-Reference.gamePanel.offY;
			dist = MagicRangeMarker.radius;
			if((dx*dx)+(dy*dy)<=dist*dist&&Reference.gamePanel.player.spellCast==1){
				Reference.gamePanel.addExplosion((int) e.getPoint().getX(), (int) e.getPoint().getY(), 100);
			}
		}
		startX = e.getX();
		startY = e.getY();
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		mousedown = false;
	}
	
	public void mouseDragged(MouseEvent e){
		//System.out.println(e.getPoint().getX()+"  "+startX);
		//System.out.println(e.getPoint().getY()+"  "+startY);
		if(e.getModifiers()==8||e.getModifiers()==9||e.getModifiers()==10){
			tempoffX = Reference.gamePanel.offX-(e.getX()-startX);
			tempoffY = Reference.gamePanel.offY-(e.getY()-startY);
			if(tempoffX>-200&&tempoffX<((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowWidth-200))){
				Reference.gamePanel.offX += -(e.getX()-startX);
			}
			if(tempoffY>-200&&tempoffY<((Reference.gamePanel.mainWorld.map.length*32)-(Reference.windowHeight-200))){
				Reference.gamePanel.offY += -(e.getY()-startY);
			}
		}
		
		startX = e.getX();
		startY = e.getY();
	}
	
	public void mouseMoved(MouseEvent e){
		startX = e.getX();
		startY = e.getY();
	}
}
