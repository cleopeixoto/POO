package model;


public class Torre extends Pecas {
	

	public Torre(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
	}
	
	 public boolean Movimento(int PecaLin, int PecaCol, Tabuleiro board) {
		 return true;
	 }
	 
	 public TipoPeca getType() {
		 
		return TipoPeca.Torre;

}


	
}
