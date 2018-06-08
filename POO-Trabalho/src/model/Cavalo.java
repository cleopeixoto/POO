package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cavalo extends Pecas{
	
	public Cavalo(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
		try {
			
			if (cor == 1) {
				img = ImageIO.read(new File("Imagens/CyanN.png"));
			}
			else {
				img = ImageIO.read(new File("Imagens/PurpleN.png"));
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	 public boolean Movimento(int PecaLin, int PecaCol, Tabuleiro board) {
		 return true;
	 }
	 
	 public TipoPeca getTipo() {
		 
		return TipoPeca.Cavalo;
	 }

}
