package model;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Rei extends Pecas {
	
	boolean pecaMovida = false;
	
	public boolean getPecaMovida () {
		return pecaMovida;
	}
	
	public Rei(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
		try {
			
			if (cor == 1) {
				img = ImageIO.read(new File("Imagens/CyanK.png"));
			}
			else {
				img = ImageIO.read(new File("Imagens/PurpleK.png"));
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	 public boolean MovimentosPermitidos(int PecaLin, int PecaCol, Tabuleiro tabuleiro) {

		 	int adversario;
		 	if (this.cor == preto) {
		 		adversario = branco;
		 	}
		 	else {
		 		adversario = preto;
		 	}

	        if(this.lin-1 ==PecaLin && this.col == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin+1 ==PecaLin && this.col == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin ==PecaLin && this.col+1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin ==PecaLin && this.col-1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin+1 ==PecaLin && this.col+1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin-1 ==PecaLin && this.col+1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin+1 ==PecaLin && this.col-1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else if(this.lin-1 ==PecaLin && this.col-1 == PecaCol && (!tabuleiro.posicaoOcupada(PecaLin, PecaCol) || (tabuleiro.LocalizaPeca(PecaLin, PecaCol).getColor() == adversario)) )
	            return true;
	        else
	            return false;
	 }
	 
	 public TipoPeca getTipo(){
		 
		return TipoPeca.Rei;
	 }
	 
	 public Vector<Posicoes> VetorMovimentos(Tabuleiro tabuleiro) {
		 Vector<Posicoes> pos = new Vector<Posicoes>();

	        for(int i = 0; i < 8;i++ ){
	            for(int j = 0; j < 8;j++){
	                if( MovimentosPermitidos(i, j,tabuleiro))
	                    pos.add(new Posicoes(i, j));
	            }
	        }
	        return pos;
	 }
	 
	 public boolean reiAtacado (int x, int y, int cor, Pecas[][] tab) {
		 for (int i=0; i<8; i++) {
			 for (int j=0; j<8; j++) {
				 Pecas p = tab[i][j];
				 int corPeca = p.getColor();
				 
				 if (p instanceof Peao) {
					 int z;
					 if (corPeca == 1)
						 z = 1;
					 else
						 z = -1;
					 
					 if ((y == j+z) && ((x == i+1) && (x == i-1)))
						 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean reiRoque (int x, int y, Pecas[][] tab) {
		 Pecas p = tab[x][y];
		 // roque curto	
		 if (pecaMovida == false) {
			 if (x == p.lin+2 && p.col == y) {
				p = tab[7][y];

				if (p instanceof Torre) {
					if (p.getColor() == this.getColor() && ((Torre)p).getPecaMovida() == false) {
						// verificando se tem pecas entre a torre e o rei
						if (tab[x+1][y] == null && tab[x+1][y] == null) 
							return true;
					}
				}
			 }
			 else if (x == p.lin-2 && p.col == y) {
				 p = tab[0][y];
			 
				 if (p instanceof Torre) {
					 if (p.getColor() == this.getColor() && ((Torre)p).getPecaMovida() == false) {
						 if (tab[x-1][y] == null && tab[x-2][y] == null && tab[x-3][y] == null)
							 return true;
					 }
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean xequeMate (int x, int y, int cor, Pecas[][] tab) {
		 if (reiAtacado(x, y, cor, tab) == true) {
			 for (int i=0; i<8; i++) {
				 for (int j=0; j<8; j++) {
					 Tabuleiro tabuleiro;
					 Pecas p = tab[i][j];
					 
					 if ( tabuleiro.posicaoOcupada(i, j) == true ) {
						 if (p.MovimentosPermitidos(i, j, tabuleiro) == true) {
							 return false;
						 }
					 }
				 }
			 }
			 return true;
		 }
		 return false;
	 }

}
