package jeu_plumber_duck.controller;

import jeu_plumber_duck.model.Fenetre;

public class GameController {
	
	private Fenetre fenetre;
	
	
	public GameController(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	
	public Fenetre getFenetre() {
		return this.fenetre;
	}
	public void setFenetre(Fenetre newFenetre) {
		this.fenetre = newFenetre;
	}

}
