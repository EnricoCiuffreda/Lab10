package it.polito.tdp.bar.model;

public class Tavolo {
	private int numeroposti;
	private boolean occupato;
	/**
	 * @param numeroposti
	 */
	public Tavolo(int numeroposti) {
		super();
		this.numeroposti = numeroposti;
		this.occupato=false;
	}
	public int getNumeroposti() {
		return numeroposti;
	}
	public void setNumeroposti(int numeroposti) {
		this.numeroposti = numeroposti;
	}
	public boolean isOccupato() {
		return occupato;
	}
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	
	

}
