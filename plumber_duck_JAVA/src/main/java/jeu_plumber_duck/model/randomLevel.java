package jeu_plumber_duck.model;

public class randomLevel {
	private int nbDeparts = 0;
	private int hauteur = 0;
	private int largeur = 0;
	private Case[][] matrixLevel ;
	private Fenetre fenetre ;
	private int x_depart = 0;
	private int y_depart = 0;
	
 
	public randomLevel(int nbDeparts, int hauteur, int largeur) {
		
		this.nbDeparts = nbDeparts;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.matrixLevel = new Case[hauteur][largeur];
		
		for (int i=0;i<this.hauteur;i++) {
			for (int j=0;j<this.largeur;j++) {
				this.matrixLevel[i][j].setAbscisse(j);
				this.matrixLevel[i][j].setOrdonnee(i);
			}
		}
		
		this.fenetre = new Fenetre(this.hauteur, this.largeur, this.matrixLevel);
		
		for (int i=0 ; i<this.nbDeparts ; i++) {
			
			// les départs se font le long des cotés haut, droit ou gauche
			// choix aléatoire du coté de départ et création de la case de départ :
			int face = (int)(Math.random()*3);
			if (face == 0) {
				this.x_depart = 0;
				this.y_depart = (int)(Math.random()*(hauteur-1));
				this.matrixLevel[this.y_depart][this.x_depart].setDroite(true);
				this.matrixLevel[this.y_depart][this.x_depart].setConnectee(true);
				this.fenetre.getDepart().add(this.matrixLevel[this.y_depart][this.x_depart]);
			}
			if (face == 2) {
				this.x_depart = largeur-1;
				this.y_depart = (int)(Math.random()*(hauteur-1));
				this.matrixLevel[this.y_depart][this.x_depart].setGauche(true);
				this.matrixLevel[this.y_depart][this.x_depart].setConnectee(true);
				this.fenetre.getDepart().add(this.matrixLevel[this.y_depart][this.x_depart]);
			}
			if (face == 1) {
				this.x_depart = (int)(Math.random()*largeur);
				this.y_depart = 0;
				this.matrixLevel[this.y_depart][this.x_depart].setBas(true);
				this.matrixLevel[this.y_depart][this.x_depart].setConnectee(true);
				this.fenetre.getDepart().add(this.matrixLevel[this.y_depart][this.x_depart]);
			}
			//fin initialisation du départ
			
			//construction traget
			this.creationPath(this.matrixLevel, this.y_depart, this.x_depart);
		}
	}
	
	public void creationPath(Case[][] matrix, int y_depart, int x_depart) {
		Case nextCase = matrix[y_depart][x_depart];
		while (nextCase.getOrdonnee() != matrix.length) {
			nextCase = this.creationNextTuyau(matrix, nextCase.getOrdonnee(), nextCase.getAbscisse());
		}
		
		if (nextCase.getOrdonnee() == matrix.length) {
			this.fenetre.getArrivee().add(matrix[nextCase.getOrdonnee()][nextCase.getAbscisse()]);
			matrix[nextCase.getOrdonnee()][nextCase.getAbscisse()].setHaut(true);
			matrix[nextCase.getOrdonnee()][nextCase.getAbscisse()].setBas(false);
			matrix[nextCase.getOrdonnee()][nextCase.getAbscisse()].setDroite(false);
			matrix[nextCase.getOrdonnee()][nextCase.getAbscisse()].setGauche(false);
		}
	}
	
	public Case creationNextTuyau(Case[][] matrix, int y, int x) {
		Case currentCase = matrix[y][x];
		Case nextCase = new Case();
		if (currentCase.estTuyauHorizontal()){
			// la nextCase est celle qui n'est pas déjà parcourue par un tuyau càd celle dont les attribus cardinaux st ts à false
			if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);
				//si currentCase est déjà connectée à Droite alors en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03(x,y);}
				if (r == 1) {nextCase.becomeCorner36(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x-1] = nextCase;
			}
			if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y);
				//si currentCase est déjà connectée à Gauche alors en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner69(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTGauche(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x+1] = nextCase;
			}
		}
		if (currentCase.estTuyauVertical()) {
			if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);
				//si currentCase est déjà connectée en Bas alors en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36(x,y);}
				if (r == 1) {nextCase.becomeCorner69(x,y);}
				if (r == 2) {nextCase.becomeTBas(x,y);}
				if (r == 3) {nextCase.becomeTGauche(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauVertical(x,y);}
				matrix[y-1][x] = nextCase;
			}
			if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);
				//si currentCase est déjà connectée en Haut alors en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner03(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTGauche(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauVertical(x,y);}
				matrix[y+1][x] = nextCase;
			}
		}
		if (currentCase.estCorner03()) {
			if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);
				// si currentCase est déjà connectée à droite alors en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36(x,y);}
				if (r == 1) {nextCase.becomeCorner69(x,y);}
				if (r == 2) {nextCase.becomeTBas(x,y);}
				if (r == 3) {nextCase.becomeTGauche(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauVertical(x,y);}
				matrix[y-1][x] = nextCase;
			}
			if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y); // déjà connectée par le haut donc la case suivante est à droite
				//en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner69(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTGauche(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x+1] = nextCase; 
			}
		}
		if (currentCase.estCorner36()) {
			if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y);// déjà connectée par le bas donc la case suivante est à droite
				//en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner69(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTGauche(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x+1] = nextCase; 
			}
			if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);// déjà connectée par la droite donc la case suivante est en bas
				//en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner03(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTGauche(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauVertical(x,y);}
				matrix[y+1][x] = nextCase;
			}
		}
		if (currentCase.estCorner69()) {
			if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);// déjà connectée par la gauche donc la case suivante est en bas
				//en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90(x,y);}
				if (r == 1) {nextCase.becomeCorner03(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTGauche(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauVertical(x,y);}
				matrix[y+1][x] = nextCase; 
			}
			if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);// déjà connectée par le bas donc la case suivante est à gauche
				//en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03(x,y);}
				if (r == 1) {nextCase.becomeCorner36(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x-1] = nextCase; 
			}
		}
		if (currentCase.estCorner90()) {
			if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);// déjà connectée par le haut donc la case suivante est à gauche
				//en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03(x,y);}
				if (r == 1) {nextCase.becomeCorner36(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x-1] = nextCase; 
			}
			
			/*
			if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);// déjà connectée par la gauche donc la case suivante est en haut
				// en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36(x,y);}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTBas();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y-1][x] = nextCase; 
			}
		}
		if (currentCase.estTHaut()) {
			// pour l'instant les T sont traité comme des tuyaux à 2 issues --> un chemin ne se divise pas en 2 chemins suite à un T
			if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);
				//en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03();}
				if (r == 1) {nextCase.becomeCorner36();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTBas();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauHorizontal();}
				matrix[y][x-1] = nextCase;
			}
			else if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);
				// si currentCase est déjà connectée à droite alors en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTBas();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y-1][x] = nextCase;
			}
			else if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y);// déjà connectée par le bas donc la case suivante est à droite
				//en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTBas();}
				if (r == 4) {nextCase.becomeTGauche();}
				if (r == 5) {nextCase.becomeTuyauHorizontal();}
				matrix[y][x+1] = nextCase; 
			}
		}
		if (currentCase.estTBas()) {
			if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);
				//en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03();}
				if (r == 1) {nextCase.becomeCorner36();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTBas();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauHorizontal();}
				matrix[y][x-1] = nextCase;
			}
			else if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);
				//en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner03();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y+1][x] = nextCase;
			}
			else if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y);// déjà connectée par le bas donc la case suivante est à droite
				//en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTBas();}
				if (r == 4) {nextCase.becomeTGauche();}
				if (r == 5) {nextCase.becomeTuyauHorizontal();}
				matrix[y][x+1] = nextCase; 
			}
		}
		if (currentCase.estTDroite()) {
			if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);// si currentCase est déjà connectée à droite alors en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTBas();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y-1][x] = nextCase;
			}
			else if (!matrix[y][x+1].getHaut() & !matrix[y][x+1].getDroite() & !matrix[y][x+1].getBas() & !matrix[y][x+1].getGauche()) {
				nextCase.setAbscisse(x+1);
				nextCase.setOrdonnee(y);// déjà connectée par le bas donc la case suivante est à droite
				//en x+1 on a THaut ou Tbas ou TGauche ou Horizontal ou corner69 ou corner90
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTBas();}
				if (r == 4) {nextCase.becomeTGauche();}
				if (r == 5) {nextCase.becomeTuyauHorizontal();}
				matrix[y][x+1] = nextCase; 
			}
			else if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);
				//en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner03();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y+1][x] = nextCase;
			}
		}
		if (currentCase.estTGauche()) {
			if (!matrix[y+1][x].getHaut() & !matrix[y+1][x].getDroite() & !matrix[y+1][x].getBas() & !matrix[y+1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y+1);
				//en y+1 on a THaut ou TGauche ou TDroite ou Vertical ou corner90 ou corner03
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner90();}
				if (r == 1) {nextCase.becomeCorner03();}
				if (r == 2) {nextCase.becomeTHaut();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y+1][x] = nextCase;
			}
			else if (!matrix[y-1][x].getHaut() & !matrix[y-1][x].getDroite() & !matrix[y-1][x].getBas() & !matrix[y-1][x].getGauche()) {
				nextCase.setAbscisse(x);
				nextCase.setOrdonnee(y-1);
				// si currentCase est déjà connectée à droite alors en y-1 on a TBas ou TGauche ou TDroite ou Vertical ou corner69 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner36();}
				if (r == 1) {nextCase.becomeCorner69();}
				if (r == 2) {nextCase.becomeTBas();}
				if (r == 3) {nextCase.becomeTGauche();}
				if (r == 4) {nextCase.becomeTDroite();}
				if (r == 5) {nextCase.becomeTuyauVertical();}
				matrix[y-1][x] = nextCase;
			}
			else if (!matrix[y][x-1].getHaut() & !matrix[y][x-1].getDroite() & !matrix[y][x-1].getBas() & !matrix[y][x-1].getGauche()) {
				nextCase.setAbscisse(x-1);
				nextCase.setOrdonnee(y);
				//en x-1 on a THaut ou Tbas ou TDroite ou Horizontal ou corner03 ou corner36
				int r = (int)(Math.random()*5);
				if (r == 0) {nextCase.becomeCorner03(x,y);}
				if (r == 1) {nextCase.becomeCorner36(x,y);}
				if (r == 2) {nextCase.becomeTHaut(x,y);}
				if (r == 3) {nextCase.becomeTBas(x,y);}
				if (r == 4) {nextCase.becomeTDroite(x,y);}
				if (r == 5) {nextCase.becomeTuyauHorizontal(x,y);}
				matrix[y][x-1] = nextCase;
			}
		*/
		}
		return nextCase;
	}
	
	public void melanger(Case[][] matrix) {
		for (int i=0; i<matrix.length ; i++) {
			for (int j=0; j<matrix[0].length ; j++) {
				Case oneCase = matrix[i][j];
				if (oneCase.isRotatable()) {
					int r = (int)(Math.random()*3);
					for (int k=0 ; k<=r ; k++){
						oneCase.rotate();
					}
				}
			}
		}
	}

	public Fenetre getFenetre() {
		return this.fenetre;
	}
	
	public Case[][] getMatrixLevel(){
		return this.matrixLevel;
	}
}
