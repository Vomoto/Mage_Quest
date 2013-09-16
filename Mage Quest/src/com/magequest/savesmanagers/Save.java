/**
 * 
 */
package com.magequest.savesmanagers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

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
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file"),"utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SaveWolrd(int world){
		if(world == MAINWORLD){
			
		}
	}

}
