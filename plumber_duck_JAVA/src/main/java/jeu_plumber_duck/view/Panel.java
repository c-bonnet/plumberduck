package jeu_plumber_duck.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import jeu_plumber_duck.controller.GameController;
import jeu_plumber_duck.model.Case;

public abstract class Panel extends JPanel {
	/**
	 * Description of the property gameController.
	 */
	protected GameController gameController;

	int off = 8;
	
	public Panel() {}
	public Panel(GameController gameController) {
		this.gameController = gameController;
	}
	
	public void PaintTuyauHorizontal(Graphics g) {
		try
		{
			Image tuyauHorizontal = ImageIO.read(new File("images/tuyau_horizontal_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTuyauHorizontal()) {
						g.drawImage(tuyauHorizontal, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauHorizontalConnecte(Graphics g) {
		try
		{
			Image tuyauHorizontalConnecte = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTuyauHorizontal() & myCase.estConnectee()) {
						g.drawImage(tuyauHorizontalConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauVertical(Graphics g) {
		try
		{
			Image tuyauVertical = ImageIO.read(new File("images/tuyau_vertical_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTuyauVertical()) {
						g.drawImage(tuyauVertical, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauVerticalConnecte(Graphics g) {
		try
		{
			Image tuyauVerticalConnecte = ImageIO.read(new File("images/tuyau_vertical_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTuyauVertical() & myCase.estConnectee()) {
						g.drawImage(tuyauVerticalConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauDepartDroite(Graphics g) {
		try
		{
			Image tuyauDepartDroite = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (this.gameController.getFenetre().getDepart().contains(myCase) & myCase.getDroite() == true) {
						tuyauDepartDroite = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
						g.drawImage(tuyauDepartDroite, 100*column+1+off, 100*line+1+off, this);
						tuyauDepartDroite = ImageIO.read(new File("images/valve.png"));
						g.drawImage(tuyauDepartDroite, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauDepartBas(Graphics g) {
		try
		{
			Image tuyauDepartBas = ImageIO.read(new File("images/tuyau_vertical_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (this.gameController.getFenetre().getDepart().contains(myCase) & myCase.getBas() == true) {
						tuyauDepartBas = ImageIO.read(new File("images/tuyau_vertical_connecte_2.png"));
						g.drawImage(tuyauDepartBas, 100*column+1+off, 100*line+1+off, this);
						tuyauDepartBas = ImageIO.read(new File("images/valve.png"));
						g.drawImage(tuyauDepartBas, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauDepartGauche(Graphics g) {
	try
	{
		Image tuyauDepartGauche = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
		for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
		{
			for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
			{
				Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
				if (this.gameController.getFenetre().getDepart().contains(myCase) & myCase.getGauche() == true) {
					tuyauDepartGauche = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
					g.drawImage(tuyauDepartGauche, 100*column+1+off, 100*line+1+off, this);
					tuyauDepartGauche = ImageIO.read(new File("images/valve.png"));
					g.drawImage(tuyauDepartGauche, 100*column+1+off, 100*line+1+off, this);
				}				
			}
		}
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}
	public void PaintTuyauDepartHaut(Graphics g) {
		try
		{
			Image tuyauDepartHaut = ImageIO.read(new File("images/tuyau_vertical_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (this.gameController.getFenetre().getDepart().contains(myCase) & myCase.getHaut() == true) {
						tuyauDepartHaut = ImageIO.read(new File("images/tuyau_vertical_connecte_2.png"));
						g.drawImage(tuyauDepartHaut, 100*column+1+off, 100*line+1+off, this);
						tuyauDepartHaut = ImageIO.read(new File("images/valve.png"));
						g.drawImage(tuyauDepartHaut, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PaintTuyauTDroite(Graphics g) {
		try
		{
			Image tuyauTDroite = ImageIO.read(new File("images/tuyau_T_droite_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTDroite() & !(myCase.estConnectee())) {
						g.drawImage(tuyauTDroite, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTBas(Graphics g) {
		try
		{
			Image tuyauTBas = ImageIO.read(new File("images/tuyau_T_bas_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTBas() & !(myCase.estConnectee())) {
						g.drawImage(tuyauTBas, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTGauche(Graphics g) {
		try
		{
			Image tuyauTGauche = ImageIO.read(new File("images/tuyau_T_gauche_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTGauche() & !(myCase.estConnectee())) {
						g.drawImage(tuyauTGauche, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTHaut(Graphics g) {
		try
		{
			Image tuyauTHaut = ImageIO.read(new File("images/tuyau_T_haut_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTHaut() & !(myCase.estConnectee())) {
						g.drawImage(tuyauTHaut, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTDroiteConnecte(Graphics g) {
		try
		{
			Image tuyauTDroiteConnecte = ImageIO.read(new File("images/tuyau_T_droite_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTDroite() & (myCase.estConnectee())) {
						g.drawImage(tuyauTDroiteConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTBasConnecte(Graphics g) {
		try
		{
			Image tuyauTBasConnecte = ImageIO.read(new File("images/tuyau_T_bas_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTBas() & (myCase.estConnectee())) {
						g.drawImage(tuyauTBasConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTGaucheConnecte(Graphics g) {
		try
		{
			Image tuyauTGaucheConnecte = ImageIO.read(new File("images/tuyau_T_gauche_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTGauche() & (myCase.estConnectee())) {
						g.drawImage(tuyauTGaucheConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTHautConnecte(Graphics g) {
		try
		{
			Image tuyauTHautConnecte = ImageIO.read(new File("images/tuyau_T_haut_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estTHaut() & (myCase.estConnectee())) {
						g.drawImage(tuyauTHautConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PaintTuyauCorner03(Graphics g) {
		try
		{
			Image tuyauCorner03 = ImageIO.read(new File("images/tuyau_corner_03_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner03() & !(myCase.estConnectee())) {
						g.drawImage(tuyauCorner03, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner36(Graphics g) {
		try
		{
			Image tuyauCorner36 = ImageIO.read(new File("images/tuyau_corner_36_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner36() & !(myCase.estConnectee())) {
						g.drawImage(tuyauCorner36, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner69(Graphics g) {
		try
		{
			Image tuyauCorner69 = ImageIO.read(new File("images/tuyau_corner_69_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner69() & !(myCase.estConnectee())) {
						g.drawImage(tuyauCorner69, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner90(Graphics g) {
		try
		{
			Image tuyauCorner90 = ImageIO.read(new File("images/tuyau_corner_90_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner90() & !(myCase.estConnectee())) {
						g.drawImage(tuyauCorner90, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner03Connecte(Graphics g) {
		try
		{
			Image tuyauCorner03Connecte = ImageIO.read(new File("images/tuyau_corner_03_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner03() & (myCase.estConnectee())) {
						g.drawImage(tuyauCorner03Connecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner36Connecte(Graphics g) {
		try
		{
			Image tuyauCorner36Connecte = ImageIO.read(new File("images/tuyau_corner_36_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner36() & (myCase.estConnectee())) {
						g.drawImage(tuyauCorner36Connecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner69Connecte(Graphics g) {
		try
		{
			Image tuyauCorner69Connecte = ImageIO.read(new File("images/tuyau_corner_69_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner69() & myCase.estConnectee()) {
						g.drawImage(tuyauCorner69Connecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void PaintTuyauCorner90Connecte(Graphics g) {
		try
		{
			Image tuyauCorner90Connecte = ImageIO.read(new File("images/tuyau_corner_90_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (myCase.estCorner90() & (myCase.estConnectee())) {
						g.drawImage(tuyauCorner90Connecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PaintTuyauArrivee(Graphics g) {
		try
		{
			Image tuyauArrivee = ImageIO.read(new File("images/tuyau_arrivee_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (this.gameController.getFenetre().getArrivee().contains(myCase) & !(myCase.estConnectee())) {
						g.drawImage(tuyauArrivee, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauArriveeConnecte(Graphics g) {
		try
		{
			Image tuyauArriveeConnecte = ImageIO.read(new File("images/tuyau_arrivee_connecte_2.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{
					Case myCase = this.gameController.getFenetre().getMatrixCase()[line][column];
					if (this.gameController.getFenetre().getArrivee().contains(myCase) & (myCase.estConnectee())) {
						g.drawImage(tuyauArriveeConnecte, 100*column+1+off, 100*line+1+off, this);
					}				
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PaintGrey(Graphics g) {
		try
		{
			Image videGris = ImageIO.read(new File("images/vide_gris.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{						
					g.drawImage(videGris, 100*column+1+off, 100*line+1+off, this);			
				}
			}
			g.drawImage(videGris, 0, 0, 310, 210, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PaintWhite(Graphics g) {
		try
		{
			Image videBlanc = ImageIO.read(new File("images/vide_blanc.png"));
			for(int line = 0; line < this.gameController.getFenetre().getHauteur(); line++)
			{
				for(int column = 0; column < this.gameController.getFenetre().getLargeur(); column++)
				{						
					g.drawImage(videBlanc, 100*column+1+off, 100*line+1+off, this);			
				}
			}
			Image videGris = ImageIO.read(new File("images/vide_gris.png"));
			g.drawImage(videGris, 0, 0, 10, 210, this);
			g.drawImage(videGris, 0, 0, 310, 10, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GameController getGameController() {
		return this.gameController;
	}
	public void setGameController(GameController newGameController) {
		this.gameController = newGameController;
	}
	
}
