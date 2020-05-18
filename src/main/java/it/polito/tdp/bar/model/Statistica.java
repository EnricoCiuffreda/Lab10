package it.polito.tdp.bar.model;

public class Statistica {
	private int clienti;
	private int soddisfatti;
	private int insoddisfatti;
	/**
	 * 
	 */
	public Statistica() {
		this.clienti=0;
		this.soddisfatti=0;
		this.insoddisfatti=0;
	}
	public int getClienti() {
		return clienti;
	}
	public void setClienti(int clienti) {
		this.clienti = clienti;
	}
	public int getSoddisfatti() {
		return soddisfatti;
	}
	public void setSoddisfatti(int soddisfatti) {
		this.soddisfatti = soddisfatti;
	}
	public int getInsoddisfatti() {
		return insoddisfatti;
	}
	public void setInsoddisfatti(int insoddisfatti) {
		this.insoddisfatti = insoddisfatti;
	}
	@Override
	public String toString() {
		return "Statistica [clienti=" + clienti + ", soddisfatti=" + soddisfatti + ", insoddisfatti=" + insoddisfatti
				+ "]";
	}
	
	
	

}
