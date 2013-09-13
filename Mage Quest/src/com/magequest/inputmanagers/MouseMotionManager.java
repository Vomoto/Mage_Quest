/**
 * 
 */
package com.magequest.inputmanagers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.magequest.main.Reference;

/**
 *<b>Mouse Motion Manager</b>
 *<p>Manages when the mouse is moved and dragged</p>
 *<p></p>
 * @author Cooper Mahring
 */
public class MouseMotionManager implements MouseMotionListener{
	
	int startX = 0;
	int startY = 0;

	public MouseMotionManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		Reference.mainWorld.offX += e.getX()-startX;
		Reference.mainWorld.offY += e.getY()-startY;
		System.out.println((e.getX()-startX)+"  "+(e.getY()-startY));
		startX = e.getX();
		startY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		startX = 0;
		startY = 0;
		
	}

}
