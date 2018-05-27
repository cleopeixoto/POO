package trabalho;
import java.awt.*;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ExPanelPecas extends JPanel implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	static int MouseX, MouseY, NovoMouseX,  NovoMouseY;
	private static final long serialVersionUID = 1L;
	
	private ListaImagens li;
	public ExPanelPecas(ListaImagens l) 
	{
		li=l; 
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		Image[] vi = li.getImagemBranca();
		// linha, coluna
		g.drawImage(vi[0],0,0,null);
		g.drawImage(vi[0],700,0,null);
		g.drawImage(vi[1],100,0,null);
		g.drawImage(vi[1],600,0,null);
		g.drawImage(vi[2],200,0,null);
		g.drawImage(vi[2],500,0,null);
		g.drawImage(vi[3],300,0,null);
		g.drawImage(vi[4],400,0,null);
		
		for (int i = 0; i<8 ;i++) {
			g.drawImage(vi[5],i*100,100,null);
		}
		
		Image[] vj = li.getImagemPreta();
		
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
		}
	
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() < 800 && e.getY() < 800) {
			
			MouseX = e.getX();
			MouseY = e.getY();
			repaint(); 
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getX() < 800 && e.getY() < 800) {
			
			NovoMouseX = e.getX();
			NovoMouseY = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				String movimento = ""+MouseY/100+MouseX/100+NovoMouseY/100+NovoMouseX/100;
				
			}
			String possibilidades;
			
			repaint();
			
		}
		
		
	}
}
