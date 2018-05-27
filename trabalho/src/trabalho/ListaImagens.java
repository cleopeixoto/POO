package trabalho;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
public class ListaImagens {
	

	private Image img;
	private static Image[] imBranca = new Image[6]; // tipos de pecas :   0 - Torre , 1 - Cavalo , 2 - Bispo , 3 - Rei , 4 - Rainha , 5 - Peao
	private static Image[] imPreta= new Image[6]; 
	public ListaImagens() {
		try {
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanR.png"));
			imBranca[0]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanN.png"));
			imBranca[1]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanB.png"));
			imBranca[2]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanK.png"));
			imBranca[3]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanQ.png"));
			imBranca[4]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/CyanP.png"));
			imBranca[5]=img;
			
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try {
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_torre.gif"));
			imPreta[0]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_cavalo.gif"));
			imPreta[1]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_bispo.gif"));
			imPreta[2]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_dama.gif"));
			imPreta[3]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_rei.gif"));
			imPreta[4]=img;
			
			img = ImageIO.read(new File("C:/Users/Mariana Ribeiro/eclipse-workspace/trabalho/Imagens/b_peao.gif"));
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
