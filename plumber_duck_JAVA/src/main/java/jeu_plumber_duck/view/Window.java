package jeu_plumber_duck.view;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import jeu_plumber_duck.controller.GameController;

public abstract class Window extends JFrame implements MouseListener {
	/**
	 * Description of the property gameController.
	 */
	protected GameController gameController;
	
	
	public Window(){}
	public Window(GameController gameController) {
		this.gameController = gameController;
		this.setUndecorated(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Save ?
		this.setResizable(false);
	}
	
	public GameController getGameController() {
		return this.gameController;
	}
	public void setGameController(GameController newGameController) {
		this.gameController = newGameController;
	}
	
}
