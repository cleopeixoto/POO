package model;

import java.awt.Image;

public abstract class Pecas {
	
	public static final int preto = 0;
	public static final int branco = 1;
	protected int lin, col;
	protected int cor;
	protected Image img;
	
	public Posicoes pos;
	
	protected boolean pecaMovida;
	protected Tabuleiro tab;
	
	public abstract TipoPeca getTipo();

	public abstract boolean MovimentosPermitidos (int x, int y, Tabuleiro tabuleiro);
	
	public Pecas () {
		setColor (cor);
		setPecaMovida (pecaMovida);
	}
	
	public void setPecaMovida (boolean pecaMovida) {
		this.pecaMovida = pecaMovida;
	}
	
	public void move (int x, int y) {
		pos.setPosicoes(x, y);
		pecaMovida = true;
	}
	
	public int corInimigo (int color) {
		if (color == 1) 
			return 0;
		else
			return 1;			
	}
	
	public int getLin() {
		return this.lin;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void setColor (int x) {
		this.cor = x;
	}
	
	public int getColor() {
		return this.cor;
	}
	
	public void setImage (Image imgPeca) {
		this.img = imgPeca;
	}
	
	public Image getImage() {
		return this.img;
	}		
}
