package controller;

import java.awt.Point;

import javax.swing.JOptionPane;

import model.Peao;
import model.Pecas;
import model.Posicoes;
import model.Rei;
import model.Tabuleiro;
import model.TipoPeca;
import view.TabuleiroFrame;

public class Jogo {
	
	protected Tabuleiro[][] tab;
	protected Tabuleiro tabuleiro;
	protected boolean isJogo;
	protected boolean primeiroMov;
	protected Pecas peca;
	private boolean[] enPassantable = new boolean[2];


	public Jogo () {
		//JOptionPane.showMessageDialog (tab, "Jogo iniciado!");
		primeiroMov = true;
	}	
	

	public Tabuleiro get (int x, int y) {
	    if ((x > 7) || (y < 0) || (x < 0) || (y > 7)) {
	        return null;
	      }
	      return tab[y][x];
	}
	
	public Tabuleiro get (Point p) {
		return get(p.x, p.y);
	}
	
	public boolean podeMover (int cor) {
		for (int x=0; x<8; x++) {
			for (int y=0; y<8; y++) {
				peca = get(x,y).getConteudoPeca();
		
				if ((peca != null) && (peca.getColor() == cor) && (!peca.MovimentosPermitidos(x, y, tabuleiro) == true) ) 
						//(!peca.MovValidos(true).isEmpty())) { 	// implementar metodos
					return true;
			}
		}

  	    return false;
	}
	
	public boolean isCastle (int x, int y) {
		if ((Math.abs(x - x) > 1) && ((get(x,y).getConteudoPeca() instanceof Rei))) 
			return true;
		return false;
	}
	
	public boolean inCheck(int cor) {
		Posicoes posRei = PosicaoRei (cor);
//		Pecas peca;
		int enemyColor = peca.corInimigo(cor);
		
		for (int x=0; x<8; x++) {
			for (int y=0; y<8; y++) {
				peca = get(x,y).getConteudoPeca();
				
				if ((peca != null) && (peca.getColor() == enemyColor) && 
						(peca.MovimentosPermitidos(posRei.getX(), posRei.getY(), tabuleiro) == false) ) {
				//		(peca.MovimentosPermitidos(x, y, tabuleiro) == false) && (peca.contains(posRei) == false)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Posicoes PosicaoRei (int cor) {
		for (int x=0; x<8; x++) {
			for (int y=0; y<8; y++) {
				Pecas peca = get(x,y).getConteudoPeca();
				
				if ((peca != null) && (peca instanceof Rei) && (peca.getColor()) == cor) {
					return new Posicoes(x,y);
				}
			}
		}
		return new Posicoes (-1,-1);
	}
	
	public boolean isEnPassant (Posicoes de, Posicoes para) {
		Pecas mover = get(de.getX(), de.getY()).getConteudoPeca();
		
		if ((mover != null) && (mover instanceof Peao) && (de.getX() != para.getY()) && (get(para.getX(), para.getY()).getConteudoPeca() == null) ) {
			return true;
		}
		return false;
	}
	
	public boolean isEnPassantable (int teste) {
		return enPassantable [teste];
	}	
	
	public boolean isPromocao (Posicoes de, Posicoes para) {
		if (((para.getY() == 0) || (para.getY() == 7)) && ((get(de.getX(), de.getY()).getConteudoPeca() instanceof Peao ))) {
			return true;
		}
		return false;
	}
	
	public boolean isPuloPeao (Posicoes de, Posicoes para) {
		Pecas mover = get(de.getX(),de.getY()).getConteudoPeca();
		
		if ((mover != null) && (mover instanceof Peao) && (Math.abs(de.getY() - para.getY()) > 1)) {
			return true;
		}
		return false;
	}

	
	/*
	  
	  
	  public boolean isThreatenedSquare(Point p, PieceColor color)
	  {
	    for (int x = 0; x < 8; x++) {
	      for (int y = 0; y < 8; y++) {
	        ChessPiece piece = get(x, y).getContents();
	        
	        if ((piece != null) && (piece.getColor() == color) && 
	          (piece.getValidMoves(false).contains(p))) {
	          return true;
	        }
	      }
	    }
	    

	    return false;
	  }
	  
	  

	  
	  
	  
	  public void move(Point from, Point to, int test)
	  {
	    if (isPawnJump(from, to)) {
	      enPassantable[test] = true;
	      
	      if (y < y) {
	        enPassantableLoc[test] = new Point(x, y + 1);
	      } else {
	        enPassantableLoc[test] = new Point(x, y - 1);
	      }
	    } else {
	      enPassantable[test] = false;
	    }
	    

	    if (isCastle(from, to))
	    {
	      BoardSquare dest;
	      BoardSquare rook;
	      BoardSquare dest;
	      if (x > x) {
	        BoardSquare rook = get(7, y);
	        dest = get(x - 1, y);
	      } else {
	        rook = get(0, y);
	        dest = get(x + 1, y);
	      }
	      

	      rook.getContents().setMoved(true);
	      setSelectedSquare(rook);
	      dest.moveSelectedPieceHere();
	      
	      lastMoveWasCastle[test] = true;
	    } else {
	      lastMoveWasCastle[test] = false;
	    }
	    

	    BoardSquare f = get(from);BoardSquare t = get(to);
	    
	    oldHasMoved[test] = f.getContents().hasMoved();
	    lastCaptured[test] = t.getContents();
	    

	    if ((test == 0) && (t.getContents() != null)) {
	      BoardSquare sq = new BoardSquare(this);
	      

	      sq.removeActionListener(sq.getActionListeners()[0]);
	      sq.setContents(t.getContents());
	      sq.setDead(true);
	      
	      if (sq.getContents().getColor() == PieceColor.WHITE) {
	        game.deadPiecesLight.add(sq, 0);
	        game.deadPiecesLight.validate();
	        game.deadPiecesLight.repaint();
	      } else {
	        game.deadPiecesDark.add(sq, 0);
	        game.deadPiecesDark.validate();
	        game.deadPiecesDark.repaint();
	      }
	      

	      if (Sound.isSoundOn()) {
	        Sound.captureSound.play();
	      }
	      
	      game.getCurrentPlayer().getMyStats().incrementCapturedCount();
	    }
	    

	    if (isPromotion(from, to)) {
	      ChessPiece queen = new Queen(f.getContents());
	      
	      f.setContents(queen);
	      
	      lastMoveWasPromotion[test] = true;
	    } else {
	      lastMoveWasPromotion[test] = false;
	    }
	    
	    lastMoveWasEnPassant[test] = false;
	    

	    if (lastCaptured[test] != null) {
	      capturedHasMoved[test] = lastCaptured[test].hasMoved();
	    }
	    
	    f.getContents().setMoved(true);
	    setSelectedSquare(f);
	    t.moveSelectedPieceHere();
	    
	    lastMoveFrom[test] = from;
	    lastMoveTo[test] = to;
	    undoable[test] = true;
	    isInGame = true;
	  }
	  
	  
*/	
}
