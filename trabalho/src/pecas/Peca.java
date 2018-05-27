package pecas;

import java.awt.Image;

public class Peca {
	
	private tipoDaPeca tipo;
	private int posX, posY;
	private int cor; // 0 brancas 1 pretas
	private Image imgPeca;
	
	public void movimento (int xi, int yi, int xf, int yf) {
		
	}
	
	public void setCor (int x) {
		this.cor = x;
	}
	
	public int getCor () {
		return this.cor;
	}
	
	public void setPos (int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public void setImg(Image imgPeca) {
		this.imgPeca = imgPeca;
	}
	
	public Image getImgPeca () {
		return imgPeca;
	}
	
	public tipoDaPeca getTipo () {
		return tipo;
	}
	
	public void setTipo (tipoDaPeca tipo) {
		this.tipo = tipo;
	}
}
