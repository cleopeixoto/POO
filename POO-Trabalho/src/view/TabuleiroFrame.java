package view;

//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import model.Tabuleiro;
import view.TabuleiroPainel;



@SuppressWarnings("serial")
public class TabuleiroFrame extends JFrame {
	
	public TabuleiroPainel painelTabuleiro;	    
    
	@SuppressWarnings("unused")
	public TabuleiroFrame(Tabuleiro NovoTabuleiro) {	
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();		
		
		Dimension tamTabuleiro = new Dimension(600,600);
    	painelTabuleiro = new TabuleiroPainel(NovoTabuleiro);
    	painelTabuleiro.setPreferredSize(tamTabuleiro);
    	
    	setTitle("Jogo de Xadrez");	
		getContentPane().add(painelTabuleiro);
		
	}
		
}