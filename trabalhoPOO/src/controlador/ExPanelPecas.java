package controlador;
import java.awt.*;
import javax.swing.JPanel;


public class ExPanelPecas extends JPanel {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT=800;
	public final int ALT_DEFAULT=800;
	
	private ListaImagens li;
	public ExPanelPecas(ListaImagens l) 
	{
		li=l; 
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Image[] vi = li.getImagemBranca();
		// linha, coluna
		g.drawImage(vi[0],0,0,null);
	/*	g.drawImage(vi[0],700,0,null);
		g.drawImage(vi[1],100,0,null);
		g.drawImage(vi[1],600,0,null);
		g.drawImage(vi[2],200,0,null);
		g.drawImage(vi[2],500,0,null);
		g.drawImage(vi[3],300,0,null);
		g.drawImage(vi[4],400,0,null);
		
		for (int i = 0; i<8 ;i++) {
			g.drawImage(vi[5],i*100,100,null);
		}
		
	/*	Image[] vj = li.getImagemPreta();
		
		g.drawImage(vj[0],0,700,null);
		g.drawImage(vj[0],700,700,null);
		g.drawImage(vj[1],100,700,null);
		g.drawImage(vj[1],600,700,null);
		g.drawImage(vj[2],200,700,null);
		g.drawImage(vj[2],500,700,null);
		g.drawImage(vj[3],300,700,null);
		g.drawImage(vj[4],400,700,null);
		
		for (int i = 0; i<8 ;i++) {
			g.drawImage(vj[5],i*100,600,null);
		}*/
	
	

	
		
		
	}
}
