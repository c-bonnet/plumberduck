package jeu_plumber_duck.model;

public class Case {
	
	private boolean haut = false;
	private boolean droite = false;
	private boolean bas = false;
	private boolean gauche = false;
	
	private int abscisse = 0;
	private int ordonnee = 0;

	private boolean connectee = false;
	
	
	
	public Case() {
	}
	public Case(boolean haut, boolean droite, boolean bas, boolean gauche, int abscisse, int ordonnee) {
		this.haut = haut;
		this.droite = droite;
		this.bas = bas;
		this.gauche = gauche;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.connectee = false;
	}

	
	public void rotate() {
		boolean oldHaut = this.haut;
		this.haut = this.gauche;
		this.gauche = this.bas;
		this.bas = this.droite;
		this.droite = oldHaut;
	}

	
	// methodes de creation des differents types de tuyaux :
	public void becomeTuyauHorizontal(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(true);
		this.setBas(false);
		this.setGauche(true);
		// update coordonnées (info venant de EditWindow)
		//
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauVertical(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(false);
		this.setBas(true);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeCorner03(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(true);
		this.setBas(false);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeCorner36(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(true);
		this.setBas(true);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeCorner69(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(false);
		this.setBas(true);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeCorner90(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(false);
		this.setBas(false);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTHaut(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(true);
		this.setBas(false);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setConnectee(false);
		this.setOrdonnee(ordonnee);
	}
	public void becomeTDroite(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(true);
		this.setBas(true);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setConnectee(false);
		this.setOrdonnee(ordonnee);
	}
	public void becomeTBas(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(true);
		this.setBas(true);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTGauche(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(false);
		this.setBas(true);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauDepartDroite(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(true);
		this.setBas(false);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauDepartBas(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(false);
		this.setBas(true);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauDepartGauche(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(false);
		this.setBas(false);
		this.setGauche(true);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauDepartHaut(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(false);
		this.setBas(false);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeTuyauArrivee(int abscisse, int ordonnee) {
		this.setHaut(true);
		this.setDroite(false);
		this.setBas(false);
		this.setGauche(false);
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.setConnectee(false);
	}
	public void becomeVide(int abscisse, int ordonnee) {
		this.setHaut(false);
		this.setDroite(false);
		this.setBas(false);
		this.setGauche(false);
		this.setAbscisse(0);
		this.setOrdonnee(0);
		this.setConnectee(false);
	}
	// fin creation des types de tuyaux
	
	
	// test sur les cases
	public boolean estVide() {
		return (this.haut == false & this.droite == false & this.bas == false & this.gauche == false);
	}
	public boolean estConnectee() {
		return this.connectee;
	}
	public boolean estTuyauHorizontal() {
		return (this.haut == false & this.droite == true & this.bas == false & this.gauche == true);
	}
	public boolean estTuyauVertical() {
		return (this.haut == true & this.droite == false & this.bas == true & this.gauche == false);
	}
	public boolean estCorner03() {
		return (this.haut == true & this.droite == true & this.bas == false & this.gauche == false);
	}
	public boolean estCorner36() {
		return (this.haut == false & this.droite == true & this.bas == true & this.gauche == false);
	}
	public boolean estCorner69() {
		return (this.haut == false & this.droite == false & this.bas == true & this.gauche == true);
	}
	public boolean estCorner90() {
		return (this.haut == true & this.droite == false & this.bas == false & this.gauche == true);
	}
	public boolean estTHaut() {
		return (this.haut == true & this.droite == true & this.bas == false & this.gauche == true);
	}
	public boolean estTDroite() {
		return (this.haut == true & this.droite == true & this.bas == true & this.gauche == false);
	}
	public boolean estTBas() {
		return (this.haut == false & this.droite == true & this.bas == true & this.gauche == true);
	}
	public boolean estTGauche() {
		return (this.haut == true & this.droite == false & this.bas == true & this.gauche == true);
	}
	
	
	public int countAccess() {
		int s = 0;
		if(this.haut) {s+=1;};
		if(this.droite) {s+=1;};
		if(this.bas) {s+=1;};
		if(this.gauche) {s+=1;};
		return s;
	}
	public boolean isRotatable() {
		return (this.countAccess() > 1);
	}
	
	
	public boolean getHaut() {
		return this.haut;
	}
	public void setHaut(boolean newHaut) {
	    this.haut = newHaut;
	}
	public boolean getDroite() {
		return this.droite;
	}
	public void setDroite(boolean newDroite) {
	    this.droite = newDroite;
	}
	public boolean getBas() {
		return this.bas;
	}
	public void setBas(boolean newBas) {
	    this.bas = newBas;
	}
	public boolean getGauche() {
		return this.gauche;
	}
	public void setGauche(boolean newGauche) {
	    this.gauche = newGauche;
	}
	public int getAbscisse() {
		return this.abscisse;
	}
	public void setAbscisse(int newAbscisse) {
	    this.abscisse = newAbscisse;
	}
	public int getOrdonnee() {
		return this.ordonnee;
	}
	public void setOrdonnee(int newOrdonnee) {
	    this.ordonnee = newOrdonnee;
	}
	public boolean getConnectee() {
		return this.connectee;
	}
	public void setConnectee(boolean newConnectee) {
	    this.connectee = newConnectee;
	}
	
}
