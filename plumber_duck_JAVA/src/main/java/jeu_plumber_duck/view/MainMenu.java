package jeu_plumber_duck.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.FileSystems;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jeu_plumber_duck.Launcher;
import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.model.Case;
import jeu_plumber_duck.model.Fenetre;

public class MainMenu extends JFrame implements ActionListener {
	private JPanel pan;
	private JButton buttonPlay;
	private JButton buttonEdit;
	
	public MainMenu() {
		this.pan = new JPanel();
		this.setPreferredSize(new Dimension(300,200));
		this.pan.setPreferredSize(new Dimension(500,500));
		this.setTitle("Menu principal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(this.pan);
		this.setVisible(true);
		this.setResizable(false);
		this.buttonPlay = new JButton();
		this.buttonPlay.setText("Jouer");
		this.buttonPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.buttonPlay.addActionListener(this);
		this.pan.add(buttonPlay);
		this.buttonEdit = new JButton();
		this.buttonEdit.setText("Editer");
		this.buttonEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.buttonEdit.addActionListener(this);
		this.pan.add(buttonEdit);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// action play
		if (arg0.getSource() == this.buttonPlay) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("./maps"));
			chooser.setDialogTitle("New party");
			chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String path = chooser.getSelectedFile().getPath();
				Fenetre fenetre = Launcher.loadFenetre(path);
				GameController gameController = new GameController(fenetre);
				GameWindow gameWindow = new GameWindow(gameController);
				this.setVisible(false);
				this.dispose();
			}
		}
		// action editer
		if (arg0.getSource() == this.buttonEdit) {
			// recuperation de la largeur et hauteur de la fenetre
			int width = 8;
			int height = 8;
			boolean error = true;
	        while (error) {
				try {
		        	error = false;
		        	width = Integer.parseInt(JOptionPane.showInputDialog("Largeur : "));
		        	if (width < 2) {error = true;};
		        }
		        catch (NumberFormatException e) {
		        	error = true;
		        }
	        }
	        error = true;
	        while (error) {
				try {
		        	error = false;
			        height = Integer.parseInt(JOptionPane.showInputDialog("Hauteur : "));
		        	if (height < 2) {error = true;};
		        }
		        catch (NumberFormatException e) {
		        	error = true;
		        }
	        }
	        // initialisation de la matrice de cases
	        Case[][] matrixCase = new Case[height][width];
	        for (int line = 0; line < height; line++) {
	        	for (int column = 0; column < width; column++) {
	        		matrixCase[line][column] = new Case();
	        	}
	        }
	        // creation de la fenetre graphique
			Fenetre fenetre = new Fenetre(height, width, matrixCase);
			GameController gameController = new GameController(fenetre);
			EditWindow editWindow = new EditWindow(gameController);
			this.setVisible(false);
			this.dispose();
			}
	}
	
	public JPanel getPan() {
		return this.pan;
	}
	public void setPan(JPanel pan) {
		this.pan = pan;
	}
	public JButton getButtonPlay() {
		return this.buttonPlay;
	}
	public void setButtonPlay(JButton buttonPlay) {
		this.buttonPlay = buttonPlay;
	}
	public JButton getButtonEdit() {
		return this.buttonEdit;
	}
	public void setButtonEdit(JButton buttonEdit) {
		this.buttonEdit = buttonEdit;
	}
}
