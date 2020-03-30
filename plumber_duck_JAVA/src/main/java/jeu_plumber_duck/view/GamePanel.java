package jeu_plumber_duck.view;

import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.model.Case;


public class GamePanel extends Panel {
	
	int off = 8;
	public GamePanel() {
		super();
	}
	public GamePanel(GameController gameController) {
		super(gameController);
	}

	public void levelCompleted(Graphics g) {
		try
		{
			/*
			Image victoire = ImageIO.read(new File("images/victoire.png"));
			g.drawImage(victoire, 350+1+off, 350+1+off, this);
			*/
			
			Image victoire = ImageIO.read(new File("images/duck.png"));
			ArrayList<Case> listCasesArrivees = this.gameController.getFenetre().getArrivee();
			for (Case caseArrivee : listCasesArrivees) {
				g.drawImage(victoire, caseArrivee.getAbscisse()*100+off+1, (caseArrivee.getOrdonnee()+1)*100+off+1, this);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		this.removeAll();
		PaintWhite(g);
		for(int column = 0; column <= this.gameController.getFenetre().getLargeur(); column++) {
			g.drawLine(off+100*column, off, off+100*column, off+100*this.gameController.getFenetre().getHauteur());}
		for(int line = 0; line <= this.gameController.getFenetre().getHauteur(); line++) {
			g.drawLine(off, off+100*line, off+100*this.gameController.getFenetre().getLargeur(), off+100*line);}
		
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
		if (this.gameController.getFenetre().updateVictory()) {
			this.levelCompleted(g);
		}
		
	}
	

}
