package controller;

import model.Pecas;
import model.Bispo;
import model.Rainha;
import model.Rei;
import model.Torre;
import model.Cavalo;
import model.Peao;

import model.Tabuleiro;
import model.TipoPeca;
import view.TabuleiroFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import java.util.Observable;
//import java.util.Observer;

public class ControladorTabuleiro  implements MouseListener {
	
	private TabuleiroFrame frame;
	Tabuleiro tabuleiro;
	private int alturaFrame, alturaQuadrado,larguraFrame,larguraQuadrado;
	private int posX, posY, velhoX, velhoY;
	private int numClick = 0;
	public Pecas pecaPrimeiroClick,pecaSegundoClick;
	
	public ControladorTabuleiro() {
		
	tabuleiro = new Tabuleiro();
	frame = new TabuleiroFrame(tabuleiro);
	frame.pack();
	frame.setResizable(true);
	frame.setLocationRelativeTo( null );
	frame.setVisible(true);	
	frame.addMouseListener(this);
	
	}

	
	public void mouseClicked(MouseEvent e) {
		
		//transformar a frame nos quadrados
		localizaQuadrado(e.getX(), e.getY());
		
		if ( tabuleiro.LocalizaPeca(posX, posY)!= null) {
			// existe peca, logo validamos o click 
			numClick++;
			
			// salvando a posicao para o novo click
			velhoX = posX;
			velhoY = posY;
		}		
		if (numClick == 2) {
			
			numClick = 0;
			// localizacao da nova posica da peca
			pecaPrimeiroClick = tabuleiro.LocalizaPeca(velhoX, velhoY);
			
			
			//localiza a peca do segundo click
			
			pecaSegundoClick = tabuleiro.LocalizaPeca(posX, posY);
//			if ( jogadavalida())!= false) {
				
				// remove a peca
			//	pecaPrimeiroClick.Mover(posX,posY);
				tabuleiro.removePeca(velhoX, velhoY);
				System.out.println("peca velha = ["+pecaPrimeiroClick.getTipo());
			//	tabuleiro.addPeca(pecaPrimeiroClick);
				frame.painelTabuleiro.repaint();
				//adiciona uma nova peca no tabuleiro com a nova localizacao
			
				
				
//			}
			
			
		}
	}
	
	public void localizaQuadrado(int x, int y) {
		
		
		alturaFrame = frame.getHeight();
		
		alturaQuadrado = (alturaFrame)/8;
		
		posX = y/alturaQuadrado;
	
		larguraFrame = frame.getWidth();
		larguraQuadrado = (larguraFrame)/8;
		
		posY = x/larguraQuadrado;
	
		System.out.println("Clique na posicao frame = ["+alturaFrame+"]["+larguraFrame+"]");
		System.out.println("Clique na posicao q = ["+alturaQuadrado+"]["+larguraQuadrado+"]");
		System.out.println("Clique na posicao [posX][posY] = ["+posX+"]["+posY+"]");
	
		
		
	}

	
	public void mouseEntered(MouseEvent e) {		
	}
	public void mouseExited(MouseEvent e) {		
	}
	public void mousePressed(MouseEvent e) {		
	}
	public void mouseReleased(MouseEvent e) {		
	}
	
/*	boolean isInCheckMate(Tabuleiro board) {
		
	}
	
	boolean isInCheck(ChessBoard board, int player) {
		
	}
	
	boolean isInStalemate(ChessBoard board, int player) {
		
	}*/

}