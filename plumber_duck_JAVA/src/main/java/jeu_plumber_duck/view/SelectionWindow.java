package jeu_plumber_duck.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.model.Case;

public class SelectionWindow extends JFrame implements MouseListener {
	private SelectionPanel selectionPanel;
	private GameController gameController;
	private EditWindow editWindow;
	private int abscisseFenetre;
	private int ordonneeFenetre;
	
	public SelectionWindow(int abscisseFenetre, int ordonneeFenetre, GameController gameController, EditWindow editWindow) {
		this.setUndecorated(true);
		this.selectionPanel = new SelectionPanel();
		this.selectionPanel.addMouseListener(this);
		this.selectionPanel.setPreferredSize(new Dimension(301, 201));
		this.setContentPane(this.selectionPanel);
		this.gameController = gameController;
		this.abscisseFenetre = abscisseFenetre;
		this.ordonneeFenetre = ordonneeFenetre;
		this.editWindow = editWindow;
		this.pack();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);;
		this.setVisible(true);
		
	}
		
	
	
	public void mouseClicked(MouseEvent e) {		
		// Si clic gauche
		if (e.getButton() == 1) {
			int off = 8;
			int abscisseSelection = (e.getPoint().x - off)/100;
			int ordonneeSelection = (e.getPoint().y - off)/100;
			if ((abscisseSelection < 3 & abscisseSelection >= 0) & (ordonneeSelection < 2 & ordonneeSelection >= 0)) {
			// On ferme la fen�tre et on actualise la fen�tre principale d'edition
				int x = this.abscisseFenetre;
				int y = this.ordonneeFenetre;
				Case currentCase = this.gameController.getFenetre().getMatrixCase()[y][x];
				this.gameController.getFenetre().getDepart().remove(currentCase);
				this.gameController.getFenetre().getArrivee().remove(currentCase);
				// Si tuyau horizontal
				if (abscisseSelection == 0 & ordonneeSelection == 0) {
					currentCase.becomeTuyauHorizontal(x, y);
				}
				// Si tuyau T
				if (abscisseSelection == 1 & ordonneeSelection == 0) {
					currentCase.becomeTBas(x, y);
				}
				// Si tuyau corner
				if (abscisseSelection == 0 & ordonneeSelection == 1) {
					currentCase.becomeCorner69(x, y);
				}
				// Si tuyau depart
				if (abscisseSelection == 2 & ordonneeSelection == 0) {
					currentCase.becomeTuyauDepartDroite(x, y);
					this.gameController.getFenetre().getDepart().add(currentCase);
				}
				// Si tuyau arrivee
				if (abscisseSelection == 1 & ordonneeSelection == 1) {
					currentCase.becomeTuyauArrivee(x, y);
					this.gameController.getFenetre().getArrivee().add(currentCase);
				}
				// Si vide
				if (abscisseSelection == 2 & ordonneeSelection == 1) {
					currentCase.becomeVide(x, y);
				}
				this.gameController.getFenetre().updateVictory();
				this.editWindow.getEditPanel().repaint();
				this.setVisible(false);
				this.dispose();
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {		
	}
	public void mouseExited(MouseEvent arg0) {		
	}
	public void mousePressed(MouseEvent arg0) {		
	}
	public void mouseReleased(MouseEvent arg0) {		
	}

	/*
	public void windowClosing(WindowEvent e) {
		// this.editWindow.getEditPanel().CancelColorCase(this.editWindow.getEditPanel().getGraphics(), this.abscisseFenetre, this.ordonneeFenetre);
		// this.editWindow.getEditPanel().repaint();
		
		if (JOptionPane.showConfirmDialog(this, 
	            "Are you sure you want to close this window?", "Close Window?", 
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	            // System.exit(0);
	        	
	    		this.editWindow.getEditPanel().CancelColorCase(this.editWindow.getEditPanel().getGraphics(), this.abscisseFenetre, this.ordonneeFenetre);
	        }
	
	}
	 */
}
