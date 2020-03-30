package jeu_plumber_duck.view;

import java.awt.Dimension;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;

import jeu_plumber_duck.Launcher;
import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.model.Case;
import jeu_plumber_duck.model.Fenetre;
import jeu_plumber_duck.view.EditPanel;


public class EditWindow extends Window implements KeyListener {
	/**
	 * Description of the property gamePanel.
	 */
	private EditPanel editPanel;
	
	
	public EditWindow(GameController gameController) {
		super(gameController);
		this.setTitle("Plumber Duck Editor");
		this.editPanel = new EditPanel(this.gameController);
		this.editPanel.addMouseListener(this);
		this.addKeyListener(this);
		int width = this.gameController.getFenetre().getLargeur();
		int height = this.gameController.getFenetre().getHauteur();
		this.editPanel.setPreferredSize(new Dimension(100*width, 100*height));;
		this.setContentPane(this.editPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {

		int off = 8;
		int abscisse = (e.getPoint().x - off)/100;
		int ordonnee = (e.getPoint().y - off)/100;
		int width = this.gameController.getFenetre().getLargeur();
		int height = this.gameController.getFenetre().getHauteur();
		if ((abscisse < width & abscisse >= 0) & (ordonnee < height & ordonnee >= 0)) {
			// Si clic gauche sur une case, on la fait tourner
			if (e.getButton() == 1) {
				Case currentCase = this.gameController.getFenetre().getMatrixCase()[ordonnee][abscisse];
				if (currentCase.isRotatable() || this.gameController.getFenetre().getDepart().contains(currentCase)) {
					currentCase.rotate();
					this.gameController.getFenetre().updateVictory();
					this.editPanel.repaint();
				}
			}
			// Si clic droit sur une case, on colorie en jaune la case en cours et on lance la fenetre de selection de cases
			if (e.getButton() == 3) {
				this.editPanel.ColorCase(this.editPanel.getGraphics(), abscisse, ordonnee);
				SelectionWindow selectionWindow = new SelectionWindow(abscisse, ordonnee, this.editPanel.getGameController(), this);
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				int locationX = (int) (d.getWidth()/2 + (abscisse - width/2 + 1)*100);
				int locationY = (int) (d.getHeight()/2 + (ordonnee - height/2 - 1)*100);
				if (locationX + 300 > d.getWidth()) locationX = (int) (d.getWidth()) - 300;
				if (locationY + 200 > d.getHeight()) locationY = (int) (d.getHeight()) - 200;
				selectionWindow.setLocation(locationX, locationY);
			}
		}


	}
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			// Si on tape Ctrl+S on melange la grille et on la sauvegarde 
			this.gameController.getFenetre().shuffle();
			this.gameController.getFenetre().updateVictory();
			this.editPanel.repaint();
			String path = "maps/niveau.xml";
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("./maps"));
			chooser.setDialogTitle("Sauvegarde");
			chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) path = chooser.getSelectedFile().getPath();
			// Permet d'assurer l'extension du fichier en xml
			int i = path.lastIndexOf(".");
			if (i>0) path = path.substring(0, i);
			path = path + ".xml";
			// Sauvegarde de la fenetre
			Launcher.saveFenetre(this.gameController.getFenetre(), path);
		}
	}
	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }



	public EditPanel getEditPanel() {
		return this.editPanel;
	}
	public void setEditPanel(EditPanel newEditPanel) {
		this.editPanel = newEditPanel;
	}
}
