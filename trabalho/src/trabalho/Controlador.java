package trabalho;

import java.util.Scanner;
import java.util.*;

public class Controlador {

	public static void main(String[] args) {
		ListaImagens li = new ListaImagens();
		Tabuleiro f= new Tabuleiro("xadrez",li);
		f.setVisible(true);
		
		
		

	}

}
