/**
 * 
 */
package com.magequest.main;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Cooper Mahring
 *
 */
public class Window extends JFrame{

	/**
	 * @param title
	 * - Title of the window
	 * @param x
	 * - Width of window
	 * @param y
	 * - Height of window
	 */
	public Window(String title) {
		super(title);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Reference.windowWidth = getWidth();
		Reference.windowHeight = getHeight();
	}
	
	/**
	 * Adds a JPanel to the window
	 * @param panel
	 * - panel that you want to add (should be variable so you can remove it)
	 * 
	 */
	public void addWindow(JPanel panel){
		add(panel);
	}
	
	/**
	 * Removes a JPanel that you added
	 * @param panel
	 * - panel that you want to remove (must be a variable panel)
	 * 
	 */
	public void removeWindow(JPanel panel){
		remove(panel);
	}

}
