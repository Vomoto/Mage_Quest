/**
 * 
 */
package com.magequest.savesmanagers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import com.magequest.main.Reference;

/**
 *<b>Load</b>
 *<p>Loads files like worlds and save files</p>
 *<p></p>
 * @author Cooper Mahring
 */
public class Load {

	private int[][] map = new int[1000][1000];
	InputStream input;
	Scanner scanner;
	
	public Load() {
	}
	
	public int[][] LoadSave(String level){
		try {
			//input = new BufferedInputStream(new FileInputStream("saves/"+level+".lvl"));
			scanner = new Scanner(new File("saves/"+level+".lvl"));
		} catch (FileNotFoundException e) {
			Reference.save.newSave("mainWorld", level);
			try {
				//input = new BufferedInputStream(new FileInputStream("saves/"+level+".lvl"));
				scanner = new Scanner(new File("saves/"+level+".lvl"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(int a=0;a<1000;a++){
			for(int b=0;b<1000;b++){
				try{
					map[a][b] = scanner.nextInt();
				}catch(Exception e){
				}
				
			}
		}
		return map;
	}

}
