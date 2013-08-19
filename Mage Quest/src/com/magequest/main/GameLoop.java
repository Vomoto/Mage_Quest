package com.magequest.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;



public class GameLoop {
	public static Dimension WinDim = new Dimension(500,500);
	public static boolean running = true;
	public static boolean paused = false;
	public static int fps = 0;
	public static int frameCount = 0;
	public static String atComponent = "";
	public static double delta;
	static long now = System.nanoTime();
	static long earlier = System.nanoTime();
	
	public GameLoop(){
		runGameLoop();
	}
	
	
	//Starts a new thread and runs the game loop in it.
	   public static void runGameLoop()
	   {
	      Thread loop = new Thread()
	      {
	         public void run()
	         {
	            gameLoop();
	         }
	      };
	      loop.start();
	   }
	   
	   //Only run this in another Thread!
	   private static void gameLoop()
	   {
	      //This value would probably be stored elsewhere.
	      final double GAME_HERTZ = 60.0;
	      //Calculate how many ns each frame should take for our target game hertz.
	      final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
	      //At the very most we will update the game this many times before a new render.
	      //If you're worried about visual hitches more than perfect timing, set this to 1.
	      final int MAX_UPDATES_BEFORE_RENDER = 500;
	      //We will need the last update time.
	      double lastUpdateTime = System.nanoTime();
	      //Store the last time we rendered.
	      double lastRenderTime = System.nanoTime();
	      
	      //If we are able to get as high as this FPS, don't render again.
	      final double TARGET_FPS = 1000;
	      final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
	      
	      //Simple way of finding FPS.
	      int lastSecondTime = (int) (lastUpdateTime / 1000000000);
	      
	      while (running)
	      {
	         int updateCount = 0;
	         now = System.nanoTime();
	         delta = (double) ((now*0.000000001) - (earlier*0.000000001));
	         earlier = System.nanoTime();
	         
	         if (!paused)
	         {
	             //Do as many game updates as we need to, potentially playing catchup.
	             while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
	            {
	               lastUpdateTime += TIME_BETWEEN_UPDATES;
	            } 
	               updateCount++;
	               updateGame();
	   
	            //If for some reason an update takes forever, we don't want to do an insane number of catchups.
	            //If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
	            if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES)
	            {
	               lastUpdateTime = now - TIME_BETWEEN_UPDATES;
	            }
	         
	            //Render. To do so, we need to calculate interpolation for a smooth render.
	            float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
	            drawGame(interpolation);
	            lastRenderTime = now;
	         
	            //Update the frames we got.
	            int thisSecond = (int) (lastUpdateTime / 1000000000);
	            if (thisSecond > lastSecondTime)
	            {
	               //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
	               fps = frameCount;
	               frameCount = 0;
	               lastSecondTime = thisSecond;
	            }
	         
	            //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
	            while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
	            {
	               Thread.yield();
	            
	               //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
	               //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
	               //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
	               try {Thread.sleep(1);} catch(Exception e) {} 
	               now = System.nanoTime();
	            }
	         }
	      }
	   }
	   
	   private static void updateGame(){
		   Reference.update();
	   }
	   
	   private static void drawGame(float interpolation){
		   Reference.repaint();
	   }
}
