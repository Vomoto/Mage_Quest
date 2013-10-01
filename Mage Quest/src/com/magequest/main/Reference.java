/**
 * 
 */
package com.magequest.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.magequest.savesmanagers.*;;

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
	public static int playerSprintSpeed = 200;
	
	public static String title = "Mage Quest";
	public static String version = "0.0.16";
	public static String fps = "0";
	public static String fullTitle = "";
	
	public static boolean devBuild = true;
	
	public static Load load;
	public static Save save;
	public static Window mainWindow;
	public static GamePanel gamePanel;
	public static GameLoop gl;
	
	public static BufferedImage explosionWhole;
	public static Image[][] explosion = new Image[9][11];
	public static BufferedImage terrainWhole;
	public static BufferedImage[][] terrain = new BufferedImage[10][10];
	public static BufferedImage terrainModeratesWhole;
	public static BufferedImage[][] terrainModerates = new BufferedImage[10][10];
	
	public static Random randomGenerator = new Random();

	public Reference() {
		if(devBuild){
			fullTitle = Reference.title + "  " + version + " - Dev Build";
		}else{
			fullTitle = Reference.title + "  " + version + " - Public Build";
		}
		addImages();
		
		load = new Load();
		save = new Save();
		gamePanel = new GamePanel();
	}
	
	private void addImages(){
		try {
			explosionWhole = ImageIO.read(new File("res/explosion2.png"));
			terrainWhole = ImageIO.read(new File("res/Terrain.png"));
			terrainModeratesWhole = ImageIO.read(new File("res/TerrainModerates.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int a = 0;a<3;a++){
			for(int b = 0;b<10;b++){
				explosion[a][b] = explosionWhole.getSubimage(100*b, 100*a, 100, 100);
			}
		}
		for(int a = 0;a<=10;a++){
			for(int b = 0;b<=10;b++){
				try{
					terrain[a][b] = terrainWhole.getSubimage(16*b, 16*a, 16, 16);
				}catch(Exception e){
					
				}
			}
		}
		for(int a = 0;a<=10;a++){
			for(int b = 0;b<=10;b++){
				try{
					terrainModerates[a][b] = terrainModeratesWhole.getSubimage(16*b, 16*a, 16, 16);
				}catch(Exception e){
					
				}
			}
		}
	}
	
	public static void exit(){
		System.out.println("bye :/");
		System.exit(0);
	}

	/**
	 * <b>Update</b>
	 * <p>Updates any necessary math</p>
	 */
	public static void update(float interpolation) {
		try{
			windowWidth = mainWindow.getWidth();
			windowHeight = mainWindow.getHeight();
		}catch(Exception e){
		}
		sb = new StringBuilder();
		sb.append(GameLoop.fps);
		fps = sb.toString();
		gamePanel.update(interpolation);
		
	}

	/**
	 * <b>Repaint</b>
	 * <p>Redraws graphics</p>
	 */
	public static void repaint() {
		gamePanel.repaint();
	}

}
