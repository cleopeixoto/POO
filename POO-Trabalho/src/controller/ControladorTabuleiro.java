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
import view.TabuleiroPainel;

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
	// controlador cria o tabuleiro e a frame
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
		localizaQuadrado(e.getX(),e.getY());
		
		// primeiro click so é validado quando clica numa casa não vazia
		
		if ( numClick == 0 && tabuleiro.LocalizaPeca(posX, posY)!= null) {
			
			// existe peca, logo validamos o click 
			
			numClick++;
			System.out.println("click valido , numero click"+ numClick);
			
			// colorir o quadrado selecionado com uma nova cor
			
			frame.painelTabuleiro.QuadradoSelecionado(posX, posY);
			frame.painelTabuleiro.repaint();
			
			// salvando a posicao antiga obter o novo click
			
			velhoX = posX;
			velhoY = posY;
			System.out.println( " velhoX " + velhoX + " velhoY " + velhoY );
		}		
		if (numClick == 1 && tabuleiro.LocalizaPeca(posX, posY)== null ) {
			
			System.out.println("click valido , numero click "+ numClick);
			numClick = 0;
			
			// localizacao da nova posica da peca
			
			pecaPrimeiroClick = tabuleiro.LocalizaPeca(velhoX, velhoY);
			System.out.println("peca apertada1 = "+pecaPrimeiroClick.getTipo()+ " 1 = branco ["+velhoX+"]["+velhoY+"]");
			
			// se a peca percorrer uma posicao vazia
			if(tabuleiro.LocalizaPeca(posX, posY) == null) {
				Pecas p = CriaPeca(posX,posY,pecaPrimeiroClick.getTipo(),pecaPrimeiroClick.getColor());
				tabuleiro.addPeca(p);
				tabuleiro.removePeca(velhoX, velhoY);
				frame.painelTabuleiro.repaint();
				System.out.println("peca movida1 = "+pecaPrimeiroClick.getTipo()+ " 1 = branco ["+posX+"]["+posY+"]");
			}
			
		}
					
	}
	
	public void localizaQuadrado(int x, int y) {
		
		alturaFrame = frame.getHeight();
		alturaQuadrado = alturaFrame/8;
				
		posX = x/alturaQuadrado;
			
		larguraFrame = frame.getWidth();
		larguraQuadrado = larguraFrame/8;
				
		posY = y/larguraQuadrado;
			
		System.out.println("Clique na posicao [x][y] = ["+posX+"]["+posY+"]");
		System.out.println("Clique na posicao frame = ["+alturaFrame+"]["+larguraFrame+"]");
		System.out.println("Clique na posicao q = ["+alturaQuadrado+"]["+larguraQuadrado+"]");
		System.out.println("Clique na posicao [x][y] = ["+y+"]["+x+"]");
		if(tabuleiro.LocalizaPeca(posX,posY) != null) {
				Pecas peca = tabuleiro.LocalizaPeca(posX,posY);
			if (peca.getColor() == 1) {
				System.out.println("peca apertada = "+peca.getTipo()+ " Cor peca: Branca ["+posX+"]["+posY+"]");
			}
			else {
				System.out.println("peca apertada = "+peca.getTipo()+ " Cor peca: Preta["+posX+"]["+posY+"]");
		}	}
	}
	public Pecas CriaPeca(int lin, int col, TipoPeca tipo, int cor)
	{	
		Pecas p = null;
		if(tipo == TipoPeca.Torre) {
			p = new Torre(lin, col,cor);
		}
		if(tipo == TipoPeca.Cavalo) {
			p = new Cavalo(lin, col,cor);
		}
		if(tipo == TipoPeca.Bispo) {
			p = new Bispo(lin, col,cor);
		}
		if(tipo == TipoPeca.Rei) {
			p = new Rei(lin, col,cor);
		}
		if(tipo == TipoPeca.Rainha) {
			p = new Rainha(lin, col,cor);
		}
		if(tipo == TipoPeca.Peao) {
			p = new Peao(lin, col,cor);
		}
		return p;
	
		
	}
/*	boolean isInCheckMate(Tabuleiro board) {
		
	}
	
	boolean isInCheck(ChessBoard board, int player) {
		
	}
	
	boolean isInStalemate(ChessBoard board, int player) {
		
	}*/
	public void mouseEntered(MouseEvent e) {		
	}
	public void mouseExited(MouseEvent e) {		
	}
	public void mousePressed(MouseEvent e) {		
	}
	public void mouseReleased(MouseEvent e) {		
	}

}