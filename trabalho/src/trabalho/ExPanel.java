package trabalho;

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
	
	public static final int TXT_X=800;
	public static final int TXT_Y=800;
	
	
	public void paintComponent(Graphics g) {
		 int i,j;
		 int count = 0;
		 
		 super.paintComponent(g);
		  Graphics2D g2d=(Graphics2D) g;
		  
		  
		for (i = 0; i< TXT_X; i = i+100) {
			for (j = 0; j < TXT_Y; j = j+100) {
		   Rectangle2D quadrado ;
		   quadrado = new Rectangle2D.Double(i,j,100,100);
		   count++;
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
			}
		   
		 
		  }
		count = 0;
		for (i = 100; i < 900; i=i+100) {
			
			for (j = 100; j < 900; j=j+100) {
			Line2D linha = new Line2D.Double(j, i, j, count*100);
			if (count%2 == 0) {
				   g2d.setPaint(Color.black);

			   }
			   else {
				   g2d.setPaint(Color.white);

			   }
			
			
			
			
			g2d.draw(linha);
		
			
			
			
			}
			
			
			
			
			count++;
		}
					
	}


}

	
	 
 

