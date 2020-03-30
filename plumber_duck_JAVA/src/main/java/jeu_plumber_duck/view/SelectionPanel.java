package jeu_plumber_duck.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import jeu_plumber_duck.model.Case;

public class SelectionPanel extends JPanel {
	int off = 0;

	public SelectionPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		for(int column = 0; column <= 3; column++) {
			g.drawLine(off+100*column, off, off+100*column, off+100*2);}
		for(int line = 0; line <= 2; line++) {
			g.drawLine(off, off+100*line, off+100*3, off+100*line);}
		
		PaintTuyauHorizontal(g);
		PaintTuyauTBas(g);
		PaintTuyauCorner69(g);
		PaintTuyauDepartDroite(g);
		PaintTuyauArrivee(g);
		PaintWhite(g);
	}
	
	
	public void PaintTuyauHorizontal(Graphics g) {
		try
		{
			Image tuyauHorizontal = ImageIO.read(new File("images/tuyau_horizontal_2.png"));
			g.drawImage(tuyauHorizontal, 100*0+1+off, 100*0+1+off, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauTBas(Graphics g) {
		try
		{
			Image tuyauTBas = ImageIO.read(new File("images/tuyau_T_bas_2.png"));
			g.drawImage(tuyauTBas, 100*1+1+off, 100*0+1+off, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauCorner69(Graphics g) {
		try
		{
			Image tuyauCorner69 = ImageIO.read(new File("images/tuyau_corner_69_2.png"));
			g.drawImage(tuyauCorner69, 100*0+1+off, 100*1+1+off, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauDepartDroite(Graphics g) {
		try
		{
			Image tuyauDepartDroite = ImageIO.read(new File("images/tuyau_horizontal_connecte_2.png"));
			g.drawImage(tuyauDepartDroite, 100*2+1+off, 100*0+1+off, this);	
			Image valve = ImageIO.read(new File("images/valve.png"));
			g.drawImage(valve, 100*2+1+off, 100*0+1+off, this);	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintTuyauArrivee(Graphics g) {
		try
		{
			Image tuyauArrivee = ImageIO.read(new File("images/tuyau_arrivee_2.png"));
			g.drawImage(tuyauArrivee, 100*1+1+off, 100*1+1+off, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void PaintWhite(Graphics g) {
		try
		{
			Image vide = ImageIO.read(new File("images/vide_blanc.png"));
			g.drawImage(vide, 100*2+1+off, 100*1+1+off, this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
