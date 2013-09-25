/**
 * 
 */
package com.magequest.savesmanagers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *<b>Load</b>
 *<p>Loads files like worlds and save files</p>
 *<p></p>
 * @author Cooper Mahring
 */
public class Load {

	private int[][] map = new int[1000][1000];
	InputStream input;
	
	public Load() {
	}
	
	public int[][] LoadWorld(String level){
		try {
			input = new BufferedInputStream(new FileInputStream("saves/"+level+".lvl"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int a=0;a<1000;a++){
			for(int b=0;b<1000;b++){
				try {
					map[a][b] = input.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return map;
	}

}
