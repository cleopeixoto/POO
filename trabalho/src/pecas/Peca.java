package pecas;

import java.awt.Image;

public class Peca {
	
	private tipoDaPeca tipo;
	protected int posX, posY;
	protected int cor; // 0 brancas 1 pretas
	private Image imgPeca;
	
	public Peca (int x, int y, int cor) {
		posX = x;
		posY = y;
		this.cor = cor;
	}
	
	public void movimento (Peca pecas[][], int x, int y) throws MoveException {
		if (x < 0 || x > 8 || y < 0 || y > 8)
			throw new MoveException ("Fora dos limites");
		
		if (posX == x && posY == y)
			throw new MoveException ("Movimento invalido");
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
	
	public int getX () {
		return posX;
	}
	
	public int getY () {
		return posY;
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
	
	public int getALT () {
		return imgPeca.getWidth(null);
	}
	
	public int getLARG () {
		return imgPeca.getHeight(null);
	}
}
