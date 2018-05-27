package pecas;

public enum tipoDaPeca {
	peao	(1),
	torre	(2),
	cavalo	(3),
	bispo	(4),
	dama	(5),
	rei		(6);
	
	public int peca;
	
	tipoDaPeca (int peca) {
		this.peca = peca;
	}
}
