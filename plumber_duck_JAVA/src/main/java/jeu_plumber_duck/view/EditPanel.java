package jeu_plumber_duck.view;

import java.awt.Color;
import java.awt.Graphics;

import jeu_plumber_duck.controller.GameController;

public class EditPanel extends Panel {
	
	int off = 8;
	
	public EditPanel() {
		super();
	}
	public EditPanel(GameController gameController) {
		super(gameController);
	}
	
	public void paintComponent(Graphics g) {
		this.removeAll();
		PaintWhite(g);
		g.setColor(Color.red);
		for(int column = 0; column <= this.gameController.getFenetre().getLargeur(); column++) {
			g.drawLine(off+100*column, off, off+100*column, off+100*this.gameController.getFenetre().getHauteur());}
		for(int line = 0; line <= this.gameController.getFenetre().getHauteur(); line++) {
			g.drawLine(off, off+100*line, off+100*this.gameController.getFenetre().getLargeur(), off+100*line);}
		g.setColor(Color.black);
		
		PaintTuyauHorizontal(g);
		PaintTuyauHorizontalConnecte(g);
		PaintTuyauVertical(g);
		PaintTuyauVerticalConnecte(g);
		PaintTuyauDepartDroite(g);
		PaintTuyauDepartBas(g);
		PaintTuyauDepartGauche(g);
		PaintTuyauDepartHaut(g);
		PaintTuyauTDroite(g);
		PaintTuyauTBas(g);
		PaintTuyauTGauche(g);
		PaintTuyauTHaut(g);
		PaintTuyauTDroiteConnecte(g);
		PaintTuyauTBasConnecte(g);
		PaintTuyauTGaucheConnecte(g);
		PaintTuyauTHautConnecte(g);
		PaintTuyauCorner03(g);
		PaintTuyauCorner36(g);
		PaintTuyauCorner69(g);
		PaintTuyauCorner90(g);
		PaintTuyauCorner03Connecte(g);
		PaintTuyauCorner36Connecte(g);
		PaintTuyauCorner69Connecte(g);
		PaintTuyauCorner90Connecte(g);
		PaintTuyauArrivee(g);
		PaintTuyauArriveeConnecte(g);		
	}
	
	public void ColorCase(Graphics g, int abscisse, int ordonnee) {
		g.setColor(Color.yellow);
		g.drawLine(off+abscisse*100, off+ordonnee*100, off+(abscisse+1)*100, off+ordonnee*100);
		g.drawLine(off+(abscisse+1)*100, off+ordonnee*100, off+(abscisse+1)*100, off+(ordonnee+1)*100);
		g.drawLine(off+(abscisse+1)*100, off+(ordonnee+1)*100, off+abscisse*100, off+(ordonnee+1)*100);
		g.drawLine(off+abscisse*100, off+(ordonnee+1)*100, off+abscisse*100, off+ordonnee*100);
		g.setColor(Color.black);
	}
	public void CancelColorCase(Graphics g, int abscisse, int ordonnee) {
		g.setColor(Color.black);
		g.drawLine(off+abscisse*100, off+ordonnee*100, off+(abscisse+1)*100, off+ordonnee*100);
		g.drawLine(off+(abscisse+1)*100, off+ordonnee*100, off+(abscisse+1)*100, off+(ordonnee+1)*100);
		g.drawLine(off+(abscisse+1)*100, off+(ordonnee+1)*100, off+abscisse*100, off+(ordonnee+1)*100);
		g.drawLine(off+abscisse*100, off+(ordonnee+1)*100, off+abscisse*100, off+ordonnee*100);
	}
	
}
