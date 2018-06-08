package model;

import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;



public class Bispo extends Pecas{
	
	public Bispo(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
		try {
			
			if (cor == 1) {
				img = ImageIO.read(new File("Imagens/CyanB.png"));
			}
			else {
				img = ImageIO.read(new File("Imagens/PurpleB.png"));
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
		 
		return TipoPeca.Bispo;
	 }

}
