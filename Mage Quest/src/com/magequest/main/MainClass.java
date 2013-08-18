/**
 * 
 */
package com.magequest.main;

import javax.swing.JFrame;

/**
 * <b>Main Class</b>
 * <p>Class that holds main thread and
 *  starts the window, nothing much else</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class MainClass {

	public MainClass() {
		new Reference();
		new GameLoop();
		Reference.mainWindow = new MainWindow();
		Reference.mainWindow.add(Reference.gamePanel);
	}

	/**
	 * <b>Main Thread</b>
	 * <p>Started main thread</p>
	 * <p></p>
	 * @param args
	 */
	public static void main(String[] args) {
		new MainClass();
		
	}

}
