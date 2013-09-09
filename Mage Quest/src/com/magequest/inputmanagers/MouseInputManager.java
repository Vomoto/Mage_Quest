package com.magequest.inputmanagers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.magequest.magic.MagicRangeMarker;
import com.magequest.main.Reference;

/**
 * <b>Mouse Input Manager</b>
 * <p>Manages clicks and maybe mouse positions</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class MouseInputManager implements MouseListener{
	
	private int dx;
	private int dy;
	private int dist;

	public MouseInputManager() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
