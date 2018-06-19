package model;

import javax.swing.JOptionPane;
import view.Sujeito;

public class Tabuleiro {
	
	public static final int Tam_Tabuleiro = 8;
	public Pecas[][] tabuleiro = new Pecas[Tam_Tabuleiro][Tam_Tabuleiro];
	 
	public Tabuleiro tab;
	
	public Tabuleiro()
	{
			for(int i = 0; i < Tam_Tabuleiro; i++)
			{
				for(int j = 0; j <Tam_Tabuleiro; j++){
		                tabuleiro[i][j] = null;
		        }
		     }
			
			InicializaPecas();
	}
	
	 private void InicializaPecas() {
		 // Posiciona as Pecas do xadrez
		 
		    addPeca(new Torre(0,0,Pecas.branco));
		    addPeca(new Torre(7,0,Pecas.branco));
		    addPeca(new Torre(7,7,Pecas.preto));
		    addPeca(new Torre(0,7,Pecas.preto));
		
	        
		    addPeca(new Cavalo(1,0,Pecas.branco));
		    addPeca(new Cavalo(6,0,Pecas.branco));
		    addPeca(new Cavalo(6,7,Pecas.preto));
		    addPeca(new Cavalo(1,7,Pecas.preto));

		    addPeca(new Bispo(2,0,Pecas.branco));
		    addPeca(new Bispo(5,0,Pecas.branco));
		    addPeca(new Bispo(2,7,Pecas.preto));
		    addPeca(new Bispo(5,7,Pecas.preto));

		    addPeca(new Rainha(3,0,Pecas.branco));
		    addPeca(new Rainha(3,7,Pecas.preto));
		    
		    addPeca(new Rei(4,0,Pecas.branco));
		    addPeca(new Rei(4,7,Pecas.preto));         
      
	        for(int i=0; i<8; i++){
	            addPeca(new Peao(i,1,Pecas.branco));
	        }

	       
	        for(int i=0; i<8; i++){
	            addPeca(new Peao(i,6,Pecas.preto));
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
	public boolean posicaoOcupada(int lin, int col) {
		if (tabuleiro[lin][col] == null)
			return false;
		else
			return true;
		
	}
	
	public boolean isRoque (int lin, int col) {
	/*
	 * Move o rei 2 casas em direcao a torre e move a torre para a casa do outro lado do rei, adjacente a ele.
	 * O movimento só é permitido quando:
	 * - o rei e a torre não tenham sido previamente movidos
	 * - não existam peças entre o rei e a torre
	 * - o rei nao pode estar em cheque
	 * - o rei e a torre devem estar na mesma fileira	
	 */
	}
	
	public boolean isPromocao (int lin, int col) {
		/*
		 * se um peao avança até a 8a fileira é então promovido à uma dama, torre, bispo ou cavalo da mesma cor. 
		 * a escolha é do jogador.
		 */
		Object[] opcoes = {"Rainha", "Torre", "Bispo", "Cavalo"};
		String str = (String) JOptionPane.showInputDialog(null, "Escolha a peca a ser substituida: ", 
				"Peao is in Promotion", JOptionPane.PLAIN_MESSAGE, null, opcoes, "Rainha" );
		
		Pecas p = tab.tabuleiro[lin][col];
		if (str.equals("Cavalo"))
			tab.tabuleiro[lin][col] = new Cavalo(lin, col,p.getColor());
		else if (str.equals("Bispo"))
			tab.tabuleiro[lin][col] = new Bispo(lin, col, p.getColor());
		else if (str.equals("Torre"))
			tab.tabuleiro[lin][col] = new Torre(lin, col, p.getColor());
		else if (str.equals("Rainha"))
			tab.tabuleiro[lin][col] = new Rainha(lin, col, p.getColor());
		
		tab.tabuleiro[lin][col].addObserver(this);
		
		return;
		
		isPromocao(lin,col);
		
	}
	
	public boolean intEnPassant (int lin, int col) {
		/*
		 * quando um peao estiver na 5a casa (tiver se movimentado 3 casas além da origem), e um peao adversario, 
		 * da coluna ao lado da sua, executar o primeiro movimento saltando 2 casas, este peao poderá ser capturado 
		 * en passant e o peao que realiza a captura irá ocupar a casa que o adversário saltou ao mover duas casas.
		 */
	}
	
	public boolean[][] isXequeMate (Pecas[][] tabuleiro) {
		/*
		 * quando um rei esta ameaçado , ou seja, não pode mais se movimentar.
		 */
		
		Boolean xequeMate[][] = new Boolean [8][8];
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (tabuleiro[i][j] != null) {
					Pecas p = tabuleiro[i][j];
					if (p instanceof Rei) {
						if ( ( (Rei) p ).xequeMate(i, j, p.getColor(), tabuleiro)  ) {
							xequeMate[i][j] = true;
							continue;
						}
					}
				}
				xequeMate[i][j] = false;
			}
		}
		return xequeMate;
	}
	
	public boolean isEmpate (int lin, int col) {
		/*
		 * quando nenhum dos dois jogadores tem possibilidade de xeque mate, ou seja:
		 * Dois reis sozinhos, um rei e um bispo, um rei e um cavalo ou um rei e dois cavalos contra um rei sozinho.
		 */
	}

}

