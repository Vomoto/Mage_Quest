/**
 * 
 */
package com.magequest.magic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.magequest.main.Reference;

/**
 * <b>Magic Range Marker</b>
 * <p>This is a marker that shows the range and style of attacks </p>
 * <p></p>
 * @author Cooper Mahring
 *
 */
public class MagicRangeMarker extends Component{

	private static final long serialVersionUID = -8716971508760463303L;
	
	public static int CIRCLE = 0;
	
	public static int radius = 0;

	public MagicRangeMarker() {
		
	}

	public static void draw(Graphics g, int range, int type){
		radius = range;
		g.setColor(new Color(0,255,0,100));
		if(type == CIRCLE){
			g.fillOval((int)Reference.gamePanel.player.x-(range-(Reference.gamePanel.player.width/2)), (int)Reference.gamePanel.player.y-(range-Reference.gamePanel.player.height/2), range*2, range*2);
		}
	}
}
