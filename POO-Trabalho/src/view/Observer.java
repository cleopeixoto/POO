package view;

import model.Pecas;

public abstract class Observer {
	
	public abstract void notify (Observer o, int i);
	
	public abstract void add(Observer o);
	
	public abstract void remove(Observer o);
	
	public abstract int[][] getCasas();
	
	public abstract Pecas[][] getPecas();

}