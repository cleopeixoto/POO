package trabalho;
import java.awt.*;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.util.Scanner;

import javax.swing.*;
public class Tabuleiro extends JFrame {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public final int LARG_DEFAULT=1000;
public final int ALT_DEFAULT=1000;
JPanel p = new JPanel();

/*public Tabuleiro(String s, int x, int y) {
	
	super(s);
	ExPanel p = new ExPanel();		
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	int sl=screenSize.width;
	int sa=screenSize.height;
	int x1=sl/2-LARG_DEFAULT/2;
	int y1=sa/2-ALT_DEFAULT/2;
	setBounds(x1,y1,LARG_DEFAULT,ALT_DEFAULT);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	p.setLayout(new GridLayout(x,y));
	getContentPane().add(p);
	
	
	
	
	
}*/

public Tabuleiro(String s,ListaImagens l) {
	super(s);
	p=new ExPanelPecas(l);
	p.setBackground(Color.WHITE);
	p.setLayout(new GridLayout(8,8));
	getContentPane().add(p);
	p.setSize(800,800);
	
	
	}   



}


