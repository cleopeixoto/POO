package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Torre extends Pecas {
	

	public Torre(int PecaLin, int PecaCol, int PecaCor)
	{
		lin = PecaLin;
		col = PecaCol;
		cor = PecaCor;
		try {
		
			if (cor == 1) {
				img = ImageIO.read(new File("Imagens/CyanR.png"));
			}
			else {
				img = ImageIO.read(new File("Imagens/PurpleR.png"));
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
		 
		return TipoPeca.Torre;

}


	
}
