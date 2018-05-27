package pecas;

public class Bispo extends Peca {
	
	public Bispo (int x, int y, int cor) {
		super (x,y, cor);
	}
	
	public void Move (Peca pecas[][], int x, int y) throws MoveException {
		Peca peca = pecas[x][y];
		
		if (peca != null && peca.getCor() == cor)
			throw new MoveException ("Movimento invalido");
		
		if (Math.abs(getX()- x) != Math.abs(getY() - y))
				throw new MoveException ("Movimento invalido");
		
		if (x > getX()) {
			if (y > getY()) {
				for (int i =1; i < Math.abs(getX()-x); i++)
					if (pecas[getY()+i][getX()+i] != null)
						throw new MoveException ("Movimento invalido");
			}
			else {
				for (int i =1; i < Math.abs(getX()-x); i++)
					if (pecas[getY()-i][getX()+i] != null)
						throw new MoveException ("Movimento invalido");
			}
		}
		
		else {
			if (y > getY()) {
				for(int i =1; i < Math.abs(getX()-x); i++)
					if (pecas[getY()+i][getX()-i] != null)
						throw new MoveException ("Movimento invelido");
			}
			else {
				for(int i = 1; i < Math.abs(getX()-x); i++)
					if (pecas[getY()-i][getX()-i] != null)
						throw new MoveException ("Movimento invalido");
			}
		}
	}
}
