package model;

public class Rainha extends Pecas{
	
	public Rainha(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
	}
	
	 public boolean Movimento(int PecaLin, int PecaCol, Tabuleiro board) {
		 return true;
	 }
	 
	 public TipoPeca getType() {
		 
		return TipoPeca.Rainha;
	 }

}
