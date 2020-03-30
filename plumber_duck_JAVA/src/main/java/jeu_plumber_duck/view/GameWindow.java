package jeu_plumber_duck.view;

import jeu_plumber_duck.Launcher;
import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.view.GamePanel;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameWindow extends Window {
	/**
	 * Description of the property gamePanel.
	 */
	private GamePanel gamePanel;


	public GameWindow(GameController gameController) {
		super(gameController);
		this.setTitle("Plumber Duck Game");
		this.gamePanel = new GamePanel(this.gameController);
		this.gamePanel.addMouseListener(this);
		int width = this.gameController.getFenetre().getLargeur();
		int height = this.gameController.getFenetre().getHauteur();
		this.gamePanel.setPreferredSize(new Dimension(100*width, 100*height));
		this.setContentPane(this.gamePanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.gameController.getFenetre().updateVictory();
		this.setVisible(true);
	}


	public void mouseClicked(MouseEvent e) {
		// Si clic gauche
		if (e.getButton() == 1) {
			int off = 8;
			int abscisse = (e.getPoint().x - off)/100;
			int ordonnee = (e.getPoint().y - off)/100;
			int width = this.gameController.getFenetre().getLargeur();
			int height = this.gameController.getFenetre().getHauteur();
			if ((abscisse < width & abscisse >= 0) & (ordonnee < height & ordonnee >= 0)) {
				if (this.gameController.getFenetre().getMatrixCase()[ordonnee][abscisse].isRotatable()) {
					this.gameController.getFenetre().getMatrixCase()[ordonnee][abscisse].rotate();
					if (this.gameController.getFenetre().updateVictory())
						this.gamePanel.removeMouseListener(this);
					this.gamePanel.repaint();
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	public void setGamePanel(GamePanel newGamePanel) {
		this.gamePanel = newGamePanel;
	}

}
