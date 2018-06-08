package view;

import javax.swing.JPanel;

import model.Pecas;
import model.Tabuleiro;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class TabuleiroPainel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TXT_X=800;
	public static final int TXT_Y=800;
	public static int tam = 99;
	private Tabuleiro tabuleiro ;
	public TabuleiroPainel(Tabuleiro NovoTabuleiro) {
		tabuleiro = NovoTabuleiro;
	}

	public void paintComponent(Graphics g) {
		
	
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				
				Rectangle2D quadrado = new Rectangle2D.Double(i*tam,j*tam,tam,tam);
				
				if ( (i+j) % 2 == 0 ){
					
					g2d.setPaint(Color.WHITE);
					g2d.fill(quadrado);
				}
				else{
					
					g2d.setPaint(Color.BLACK);
					g2d.fill(quadrado);
				}
			}
		}
		
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Pecas p = tabuleiro.LocalizaPeca(i,j);
				if (p != null) {
					g2d.drawImage(p.getImage(), i*tam, j*tam, tam, tam, null);
				}
					
				}
				
						
			}
		
	}
	
	//void draw(Tabuleiro board) {
		 
	// }
	 
/*	public int[] getLocation(int mouseX, int mouseY) {
		
		 return null;
	 }
	 
	 void selectSquare(int row, int col, Color c) {
		 
	 }
	 
	 void unselectSquare(int row, int col) {
		 
	 }
	 
	 void unselectAll() {
		 
	 }*/
	
	

}
