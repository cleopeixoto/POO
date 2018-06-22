package view;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import model.Tabuleiro;



public class TabuleiroFrame extends JFrame {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		public TabuleiroPainel painelTabuleiro;
	    public final int LARG_DEFAULT=800;
	    public final int ALT_DEFAULT=800;
	    
	    
	    public TabuleiroFrame(Tabuleiro NovoTabuleiro) {
	    	
	    	   
			
			Dimension tamTabuleiro = new Dimension(LARG_DEFAULT, ALT_DEFAULT);
	    	painelTabuleiro = new TabuleiroPainel(NovoTabuleiro);
	    	painelTabuleiro.setPreferredSize( tamTabuleiro );
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	    	setTitle("Xadrez");	
			getContentPane().add(painelTabuleiro);

		
		}
	    
	   
}
		
		
					
	




	
	 
 

