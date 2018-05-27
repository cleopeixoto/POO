package controlador;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
public class ListaImagens {
	

	private Image img;
	private static Image[] imBranca = new Image[6]; // tipos de pecas :   0 - Torre , 1 - Cavalo , 2 - Bispo , 3 - Rei , 4 - Rainha , 5 - Peao
	private static Image[] imPreta= new Image[6]; 
	public ListaImagens() {
		try {
			img = ImageIO.read(new File("Imagens/CyanR.png"));
			imBranca[0]=img;
			
			img = ImageIO.read(new File("Imagens/CyanN.png"));
			imBranca[1]=img;
			
			img = ImageIO.read(new File("Imagens/CyanB.png"));
			imBranca[2]=img;
			
			img = ImageIO.read(new File("Imagens/CyanK.png"));
			imBranca[3]=img;
			
			img = ImageIO.read(new File("Imagens/CyanQ.png"));
			imBranca[4]=img;
			
			img = ImageIO.read(new File("Imagens/CyanP.png"));
			imBranca[5]=img;
			
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try {
			img = ImageIO.read(new File("Imagens/b_torre.gif"));
			imPreta[0]=img;
			
			img = ImageIO.read(new File("Imagens/b_cavalo.gif"));
			imPreta[1]=img;
			
			img = ImageIO.read(new File("Imagens/b_bispo.gif"));
			imPreta[2]=img;
			
			img = ImageIO.read(new File("Imagens/b_dama.gif"));
			imPreta[3]=img;
			
			img = ImageIO.read(new File("Imagens/b_rei.gif"));
			imPreta[4]=img;
			
			img = ImageIO.read(new File("Imagens/b_peao.gif"));
			imPreta[5]=img;
			
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
		
	
	
	Image []getImagemBranca() 
	{ 
		return imBranca; 
	}
	Image []getImagemPreta() 
	{ 
		return imPreta; 
	}
			
		

}
