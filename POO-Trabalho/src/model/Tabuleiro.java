package model;

public class Tabuleiro {
	
	public static final int Tam_Tabuleiro = 8;
	public Pecas[][] tabuleiro = new Pecas[Tam_Tabuleiro][Tam_Tabuleiro];
	
	public Tabuleiro()
	{
			for(int i = 0; i < tabuleiro.length; i++)
			{
				for(int j = 0; j <tabuleiro[0].length; j++){
		                tabuleiro[i][j] = null;
		        }
		     }
			
			InicializaPecas();
	}
	
	 private void InicializaPecas() {
		 // Posiciona as Pecass do xadrez
		 
		    addPeca(new Torre(0,0,Pecas.branco));
		    addPeca(new Torre(0,7,Pecas.branco));
		    addPeca(new Torre(7,7,Pecas.preto));
		    addPeca(new Torre(7,0,Pecas.preto));
		
	        
		    addPeca(new Cavalo(0,1,Pecas.branco));
		    addPeca(new Cavalo(0,6,Pecas.branco));
		    addPeca(new Cavalo(7,6,Pecas.preto));
		    addPeca(new Cavalo(7,1,Pecas.preto));

		    addPeca(new Bispo(0,2,Pecas.branco));
		    addPeca(new Bispo(0,5,Pecas.branco));
		    addPeca(new Bispo(7,2,Pecas.preto));
		    addPeca(new Bispo(7,5,Pecas.preto));

		    addPeca(new Rainha(0,3,Pecas.branco));
		    addPeca(new Rainha(7,3,Pecas.preto));
		    
		    addPeca(new Rei(0,4,Pecas.branco));
		    addPeca(new Rei(7,4,Pecas.preto));         
         
	        for(int i=0; i<8; i++){
	            addPeca(new Peao(1,i,Pecas.branco));
	        }

	       
	        for(int i=0; i<8; i++){
	            addPeca(new Peao(6,i,Pecas.preto));
	        }

	 }
	public Pecas LocalizaPeca(int lin, int col)
	{
		if (tabuleiro[lin][col] == null)
			return null ;
					
		else {
			return tabuleiro[lin][col];
		}
			
	}
	public void addPeca(Pecas peca)
	{
		tabuleiro[peca.lin][peca.col] = peca;
		
	}
	public void removePeca(int lin, int col)
	{
		tabuleiro[lin][col] = null;
		return;
	}


}

