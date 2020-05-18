package it.polito.tdp.bar.model;

import java.time.LocalTime;


public class Evento implements Comparable<Evento> {
	public enum EventType{
		OCCUPA,LIBERA
	}
	private EventType type;
	private LocalTime orario;
	private int num_persone;
	private float tolleranza;
	private Tavolo tavolo;
	/**
	 * @param orario
	 * @param num_persone
	 * @param tolleranza
	 */

	
	public LocalTime getOrario() {
		return orario;
	}
	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	/**
	 * @param type
	 * @param orario
	 * @param num_persone
	 * @param tolleranza
	 * @param tavolo
	 */
	public Evento(EventType type, LocalTime orario, int num_persone, float tolleranza, Tavolo tavolo) {
		super();
		this.type = type;
		this.orario = orario;
		this.num_persone = num_persone;
		this.tolleranza = tolleranza;
		this.tavolo = tavolo;
	}
	public int getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return this.orario.compareTo(o.orario);
	}
	@Override
	public String toString() {
		return "Evento [type=" + type + ", orario=" + orario + ", num_persone=" + num_persone + "]";
	}
	
	
	
	
	
	
	

}
