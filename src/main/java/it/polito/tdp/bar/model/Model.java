package it.polito.tdp.bar.model;

public class Model {
	private Simulator simulator=new Simulator();
	
	public Model() {
		
	}
	
	public String run() {
		return simulator.run();
	}
	
	
	
}
