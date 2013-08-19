/**
 * 
 */
package com.magequest.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.magequest.entities.Player;

/**
 * <b>Reference Class</b>
 * <p>Class that holds most global variables and resources.</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class Reference {
	
	static StringBuilder sb;
	public static GraphicsEnvironment graphicsEnvirement = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public static GraphicsDevice myDevice = graphicsEnvirement.getDefaultScreenDevice();
	
	public static int windowWidth = 100;
	public static int windowHeight = 100;
	public static int playerSpeed = 75;
	
	public static String title = "Mage Quest";
	public static String version = "0.0.02";
	public static String fps = "0";
	
	public static boolean devBuild = true;
	
	public static JFrame mainWindow;
	
	public static JPanel gamePanel;
	
	public static GameLoop gl;

	public Reference() {
		gamePanel = new GamePanel();
	}
	
	public static void exit(){
		System.out.println("bye :/");
		System.exit(0);
	}

	/**
	 * <b>Update</b>
	 * <p>Updates any necessary math</p>
	 */
	public static void update() {
		try{
		windowWidth = mainWindow.getWidth();
		windowHeight = mainWindow.getHeight();
		}catch(Exception e){
		}
		sb = new StringBuilder();
		sb.append(GameLoop.fps);
		fps = sb.toString();
		GamePanel.math();
		Player.update();
	}

	/**
	 * <b>Repaint</b>
	 * <p>Redraws graphics</p>
	 */
	public static void repaint() {
		gamePanel.repaint();
		GameLoop.frameCount++;
	}

}
