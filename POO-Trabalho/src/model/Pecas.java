package model;

import java.awt.Image;

public abstract class Pecas {
	public static final int preto = 0;
	public static final int branco = 1;
	protected int lin, col;
	protected int cor;
	protected Image img;
	
	public abstract TipoPeca getTipo();
	  
	public abstract boolean Movimento(int PecaLin, int PecaCol, Tabuleiro board);
	
	
	public int getLin() {
		return this.lin;
	}
	
	public int getCol() {
		return this.col;
		
	}
	
	public int getColor() {
		return this.cor;
	}
	
	public Image getImage() {
		return this.img;
	}
	
	public void Mover(int linNova, int colNova) {
		this.lin = linNova;
		this.col = colNova;
	}
	

	
	
}

