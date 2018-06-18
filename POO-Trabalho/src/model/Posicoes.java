package model;

public class Posicoes {
	
	
		private int xPos, yPos;
		
		public Posicoes(int x, int y){
			xPos = x;
			yPos = y;

		}
		
		public void setPosicoes(int x, int y){
			xPos = x;
			yPos = y;
		}
		
		
		public int getX(){
			return xPos;	
		}
		
		public int  getY(){	
			return yPos;	
		}
		
		
}


