package trabalho;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent; 


import javax.swing.*;
public class Tabuleiro extends JFrame implements MouseListener, MouseMotionListener {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public final int LARG_DEFAULT=800;
public final int ALT_DEFAULT=800;
JLayeredPane layeredPane;
JPanel Board;
JPanel Pieces;
JLabel chessPiece;
int NovoX, NovoY;

public Tabuleiro(String s,ListaImagens l) {
	super(s);
	Dimension boardSize = new Dimension(LARG_DEFAULT, ALT_DEFAULT);
	
	//Layer Pane para a aplicacao
	
	layeredPane = new JLayeredPane();
    getContentPane().add(layeredPane);
    layeredPane.setPreferredSize(boardSize);
    layeredPane.addMouseListener(this);
    layeredPane.addMouseMotionListener(this);
    addMouseListener(this);

    
    // Tabuleiro para o xadrez
    ExPanel Board = new ExPanel(l);
 //   layeredPane.add(Board, JLayeredPane.DEFAULT_LAYER);
    Board.setLayout(new GridLayout(800,800));
    Board.setPreferredSize( boardSize );
    Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	int sl=screenSize.width;
	int sa=screenSize.height;
	int x1=sl/2-LARG_DEFAULT/2;
	int y1=sa/2-ALT_DEFAULT/2;
	Board.setBounds(x1,y1,LARG_DEFAULT,ALT_DEFAULT);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(Board);
    
	
	}


@Override
public void mouseDragged(MouseEvent e) {
	if (chessPiece == null) 
		return;
	
	 chessPiece.setLocation(e.getX() + NovoX, e.getY() + NovoY);
	
}


@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mousePressed(MouseEvent e) {
	 chessPiece = null;
	 Component c =  Board.findComponentAt(e.getX(), e.getY());
	 if (c instanceof JPanel) 
		  return;
	 
  Point parentLocation = c.getParent().getLocation();
  NovoX = parentLocation.x - e.getX();
  NovoY = parentLocation.y - e.getY();
  chessPiece = (JLabel)c;
  chessPiece.setLocation(e.getX() + NovoX, e.getY() + NovoY);
  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
}


@Override
public void mouseReleased(MouseEvent e) {
	if(chessPiece == null) return;
	 
	  chessPiece.setVisible(false);
	  Component c = Board.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
	  }
	  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
	  }
	 
	  chessPiece.setVisible(true);
	  }
	
}   






