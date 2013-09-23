/**
 * 
 */
package com.magequest.savesmanagers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

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
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("saves/mainworld"),"utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SaveWolrd(int[][] map){
			for(int a = 0; a < map.length;a++){
				for(int b = 0; b<map.length;b++){
					try {
						writer.write(map[a][b]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		}
	}

}
