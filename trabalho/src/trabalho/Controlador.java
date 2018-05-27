package trabalho;



public class Controlador {

	public static void main(String[] args) {
		ListaImagens li = new ListaImagens();
		Tabuleiro f= new Tabuleiro("xadrez",li);
		f.pack();
		f.setResizable(true);
		f.setLocationRelativeTo( null );
		f.setVisible(true);
		
		
		

	}

}
