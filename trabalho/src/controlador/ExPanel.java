package controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class ExPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ListaImagens li;
	
	public ExPanel(ListaImagens l) 
	{
		li=l; 
	}
	
	
	public static final int TXT_X=800;
	public static final int TXT_Y=800;
	
	
	public void paintComponent(Graphics g) {
		 int i,j;
		 int count = 0;
		 
		 super.paintComponent(g);
		  Graphics2D g2d=(Graphics2D) g;
		  
		  
		for (i = 0; i< TXT_X; i = i+100) {
			count = 0;
			for (j = 0; j < TXT_Y; j = j+100) {
			   Rectangle2D quadrado ;
			
			   
			   if ( i%200 == 0 ) {
				   quadrado = new Rectangle2D.Double(i,j,100,100);
				   if (count%2 == 0) {
					   g2d.setPaint(Color.white);
		
					  	g2d.fill(quadrado);
					  	g2d.draw(quadrado);
				   }
				   else {
					   g2d.setPaint(Color.black);
		
					  	g2d.fill(quadrado);
					  	g2d.draw(quadrado);
				   }
				   count++;
				   
			   }
			   
			   else {
				   quadrado = new Rectangle2D.Double(i,j,100,100);
				   if (count%2 == 0) {
					   g2d.setPaint(Color.black);
		
					  	g2d.fill(quadrado);
					  	g2d.draw(quadrado);
				   }
				   else {
					   g2d.setPaint(Color.white);
		
					  	g2d.fill(quadrado);
					  	g2d.draw(quadrado);
				   }
				   count++;
			   }
			   
			   
			   
			  
			}
		   
		 
		  }
		
		Image[] vi = li.getImagemBranca();
		// linha, coluna
		g2d.drawImage(vi[0],0,0,null);
		g2d.drawImage(vi[0],700,0,null);
		g2d.drawImage(vi[1],100,0,null);
		g2d.drawImage(vi[1],600,0,null);
		g2d.drawImage(vi[2],200,0,null);
		g2d.drawImage(vi[2],500,0,null);
		g2d.drawImage(vi[3],300,0,null);
		g2d.drawImage(vi[4],400,0,null);
		
		for (int x = 0; x < 8 ;x++) {
			g2d.drawImage(vi[5],x*100,100,null);
		}
		
		Image[] vj = li.getImagemBranca();
		
		g2d.drawImage(vj[0],0,700,null);
		g2d.drawImage(vj[0],700,700,null);
		g2d.drawImage(vj[1],100,700,null);
		g2d.drawImage(vj[1],600,700,null);
		g2d.drawImage(vj[2],200,700,null);
		g2d.drawImage(vj[2],500,700,null);
		g2d.drawImage(vj[3],300,700,null);
		g2d.drawImage(vj[4],400,700,null);
		
		for (int y = 0; y <8 ;y++) {
			g2d.drawImage(vj[5],y*100,600,null);
		
		}
	}
}
		
		
					
	




	
	 
 

