package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rei extends Pecas {
	
	public Rei(int x, int y, int PecaCor) {
		lin = x;
		col = y;
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
	
	 public TipoPeca getTipo() {
		 
		return TipoPeca.Rei;
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

}

