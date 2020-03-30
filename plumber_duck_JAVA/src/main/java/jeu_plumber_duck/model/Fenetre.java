package jeu_plumber_duck.model;

import java.util.ArrayList;
import java.util.HashSet;
import jeu_plumber_duck.model.Case;


public class Fenetre {
	
	private int hauteur;
	private int largeur;

	private ArrayList<Case> arrivee;
	private ArrayList<Case> depart;

	private Case[][] matrixCase;


	public Fenetre() {
		this.hauteur = 0;
		this.largeur = 0;
		this.arrivee = new ArrayList<Case>();
		this.depart = new ArrayList<Case>();
		this.matrixCase = null;
	}
	public Fenetre(int hauteur, int largeur, Case[][] matrixCase) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.arrivee = new ArrayList<Case>();
		this.depart = new ArrayList<Case>();
		this.matrixCase = matrixCase;
	}

	// vérification du flux pour valider ou non le niveau
	public boolean updateVictory() {
		this.ClearAllConnectee();
		for (Case startCase : this.depart) {
			startCase.setConnectee(true);
			updateCaseNeighbours(startCase.getAbscisse(), startCase.getOrdonnee(), startCase.getBas(), startCase.getGauche(), startCase.getHaut(), startCase.getDroite());
		}
		boolean victory = true;
		for (Case arriveeCase : this.arrivee) {
			if (arriveeCase.getConnectee() == false) {victory = false;}
		}
		return victory;
	}
	

	// actualisation de l'attribu "connectee" de manière recursive
	// Les comeFrom... permettent de savoir depuis quelle direction le flux arrive sur la currentCase
	private void updateCaseNeighbours(int x, int y, boolean comeFromHaut, boolean comeFromDroite, boolean comeFromBas, boolean comeFromGauche) {
		
		Case currentCase = this.matrixCase[y][x];
			
			if (currentCase.getDroite() & !(comeFromDroite) & x+1 < this.largeur) {// si currrentCase est ouvert sur la droite ET que le flux n'arrive pas de la doite, alors on teste la case juste à droite de la currentCase pour voir si celle-ci est connectée
				Case caseDroite = this.matrixCase[y][x+1];
				if (caseDroite.getGauche()) { //pour que le tuyau caseDroite soit connecté à currentCase il faut qu'il soit ouvert sur la gauche
					caseDroite.setConnectee(true);
					updateCaseNeighbours(x+1,y,false,false,false,true);//appel recursif 
				}
			}
			// les if permettent de traiter la division de chemin en 2 chemins lors que le tuyau est un T, ce que les ifelse ne permettent pas
			if (currentCase.getBas() & !(comeFromBas) & y+1 < this.hauteur) {
				Case caseBas = this.matrixCase[y+1][x];
				if (caseBas.getHaut()) {
					caseBas.setConnectee(true);
					updateCaseNeighbours(x,y+1,true,false,false,false);
				}
			}
			if (currentCase.getGauche() & !(comeFromGauche) & x-1 >= 0) {
				Case caseGauche = this.matrixCase[y][x-1];
				if (caseGauche.getDroite()) {
					caseGauche.setConnectee(true);
					updateCaseNeighbours(x-1,y,false,true,false,false);
				}
			}
			if (currentCase.getHaut() & !(comeFromHaut) & y-1 >= 0) {
				Case caseHaut = this.matrixCase[y-1][x];
				if (caseHaut.getBas()) {
					caseHaut.setConnectee(true);
					updateCaseNeighbours(x,y-1,false,false,true,false);
				}
			}
	}
	
	
	public void ClearAllConnectee() {
		for (int abscisse = 0; abscisse < this.largeur; abscisse++) {
			for (int ordonnee = 0; ordonnee < this.hauteur; ordonnee ++) {
				this.matrixCase[ordonnee][abscisse].setConnectee(false);
			}
		}
	}
	
	public void shuffle() {
		for (int abscisse = 0; abscisse < this.largeur; abscisse++) {
			for (int ordonnee = 0; ordonnee < this.hauteur; ordonnee ++) {
				if (this.matrixCase[ordonnee][abscisse].isRotatable()) {
					int r = (int)(Math.random()*4);
					for (int i = 0; i <= r; i++) {
						this.matrixCase[ordonnee][abscisse].rotate();
					}
				}
			}
		}
	}
	
	
	public int getHauteur() {
		return this.hauteur;
	}
	public void setHauteur(int newHauteur) {
	    this.hauteur = newHauteur;
	}
	public int getLargeur() {
		return this.largeur;
	}
	public void setLargeur(int newLargeur) {
	    this.largeur = newLargeur;
	}
	public ArrayList<Case> getArrivee() {
		return this.arrivee;
	}
	public void setArrivee(ArrayList<Case> arrivee) {
		this.arrivee = arrivee;
	}
	public ArrayList<Case> getDepart() {
		return this.depart;
	}
	public void setDepart(ArrayList<Case> depart) {
		this.depart = depart;
	}
	public Case[][] getMatrixCase() {
		return this.matrixCase;
	}
	public void setMatrixCase(Case[][] newMatrixCase) {
		this.matrixCase = newMatrixCase;
	}

}
