package jeu_plumber_duck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.xml.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.FileOutputStream;
import java.util.ArrayList;

import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.view.GamePanel;
import jeu_plumber_duck.view.GameWindow;
import jeu_plumber_duck.view.MainMenu;
import jeu_plumber_duck.model.Case;
import jeu_plumber_duck.model.Fenetre;
// import jeu_plumber_duck.model.randomLevel;


public class Launcher {
		
	public static void main(String[] args) {
		
		
		MainMenu mainMenu = new MainMenu();

		
		
		/*
		 
		//Launcher code pour randomLevel
		randomLevel Level = new randomLevel(1,10,10);
		Level.melanger(Level.getMatrixLevel());
		Level.getFenetre().updateVictory();
		GameController gameController = new GameController(Level.getFenetre());
		GameWindow gameWindow = new GameWindow(gameController);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getGamePanel().setPreferredSize(new Dimension(1000, 1000));;
		gameWindow.pack();
		gameWindow.setTitle("Plumber Duck");
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setResizable(false);
		gameWindow.setUndecorated(false);
		saveFenetre(Level.getFenetre(),"C:/Users/cleme/project/plumber_duck_JAVA/maps/testXML.xml");
		*/
	}
	
	public static void saveFenetre(Fenetre fenetre, String path) {
		XMLEncoder encoder = null;
		try {
			FileOutputStream stream = new FileOutputStream(path);
			
			encoder = new XMLEncoder(stream);
			encoder.writeObject(fenetre);
			encoder.flush();
			
			encoder.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	public static Fenetre loadFenetre(String path) {
		Fenetre answer = new Fenetre();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(path);
			XMLDecoder decoder = new XMLDecoder(inputStream);
			answer = (Fenetre) (decoder.readObject());
			decoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return answer;
	}
	

	/**
	 * Description of the method launch.
	 */
	public static void launch() {
		
	}
	
}
