package com.magequest.main;

import javax.swing.JFrame;

import com.magequest.inputmanagers.KeyInputManager;

/**
 * <b>Main Window Class</b>
 * <p>Window (JFrame) that holds the game</p>
 * <p></p>
 * @author Cooper Mahring
 */
public class MainWindow extends JFrame{

	private static final long serialVersionUID = -4028548615096775906L;

	public MainWindow() {
		super();
		if(!Reference.devBuild){
			setTitle(Reference.title + "  " + Reference.version + " - Dev Build");
		}else{
			setTitle(Reference.title + "  " + Reference.version + " - Public Build");
		}
		
		
		setUndecorated(true);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		try{
			Reference.myDevice.setFullScreenWindow(this);
		}catch(Exception e){
			System.out.println(e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		addKeyListener(new KeyInputManager());
	}
}
