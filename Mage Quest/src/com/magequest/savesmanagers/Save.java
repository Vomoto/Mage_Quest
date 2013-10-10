/**
 * 
 */
package com.magequest.savesmanagers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.magequest.entities.Enemy;
import com.magequest.main.Reference;

/**
 *<b>Save</b>
 *<p>Saves files and stuffs</p>
 *<p></p>
 * @author Cooper Mahring
 */
public class Save {
	
	public int MAINWORLD = 1;
	
	Writer writer = null;
	
	public Save() {
		
	}
	
	public void SaveWolrd(int[][] map, String saveName){
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("saves/"+saveName+".lvl")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			for(int a = 0; a < map.length;a++){
				for(int b = 0; b<map.length;b++){
					try {
						writer.write(map[a][b]+" ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					writer.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
				for(Enemy e : Reference.gamePanel.getEnemies()){
					try {
						writer.write("enemy ");
						writer.write(e.getType() + " ");
						writer.write(e.getX()+" ");
						writer.write(e.getY()+" ");
						writer.write(e.getHealth()+"\n");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	
	public void newSave(String world, String saveName){
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("saves/"+saveName+".lvl")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int a = 0; a < 1000;a++){
			for(int b = 0; b < 1000;b++){
				try {
					writer.write((100+Reference.randomGenerator.nextInt(3))+" ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				writer.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try{
			writer.write("enemy "+"soldier" + " 500"+" 500"+" 100\n");
			writer.write("enemy "+"soldier" + " 500"+" 600"+" 100\n");
			writer.write("enemy "+"soldier" + " 600"+" 500"+" 100\n");
			writer.write("enemy "+"soldier" + " 600"+" 600"+" 100\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
