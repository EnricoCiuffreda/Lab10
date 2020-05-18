package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


public class Simulator {
	//CODA EVENTI
	private PriorityQueue<Evento> eventi=new PriorityQueue<>();
	//PARAMETRI SIMULAZIONE
	//MODELLO MONDO
	private List<Tavolo> tavoli=new ArrayList<>();
	//VALORI DA CALCOLARE
	private Statistica statistiche=new Statistica();
	//SIMULAZIONE
	public String run() {
		String risultato="";
		this.eventi.clear();
		Tavolo t1=new Tavolo(10);
		tavoli.add(t1);
		t1=new Tavolo(10);
		tavoli.add(t1);
		t1=new Tavolo(8);
		tavoli.add(t1);
		t1=new Tavolo(8);
		tavoli.add(t1);
	    t1=new Tavolo(8);
		tavoli.add(t1);
		t1=new Tavolo(8);
		tavoli.add(t1);
		t1=new Tavolo(6);
		tavoli.add(t1);
		t1=new Tavolo(6);
		tavoli.add(t1);
		t1=new Tavolo(6);
		tavoli.add(t1);
		t1=new Tavolo(6);
		tavoli.add(t1);
		t1=new Tavolo(4);
		tavoli.add(t1);
		t1=new Tavolo(4);
		tavoli.add(t1);
		t1=new Tavolo(4);
		tavoli.add(t1);
		t1=new Tavolo(4);
		tavoli.add(t1);
		t1=new Tavolo(4);
		tavoli.add(t1);
		LocalTime oraArrivoCliente=LocalTime.of(00, 00);
		do {
			Random random=new Random();
			float tolleranza=(float) (((float)random.nextInt(90-1+1)+1)/100.00);
			int NumeroPersone=random.nextInt(10-1+1)+1;
			Evento e=new Evento(it.polito.tdp.bar.model.Evento.EventType.OCCUPA,oraArrivoCliente,NumeroPersone,tolleranza,null);
			this.eventi.add(e);
			//System.out.println(e);
			int Prossimoevento=random.nextInt(10-1+1)+1;
			oraArrivoCliente=oraArrivoCliente.plusMinutes(Prossimoevento);
		}while(eventi.size()<2000);
		//System.out.println("finito\n");
		while(!this.eventi.isEmpty()){
			Evento e=this.eventi.poll();
			risultato+=e.toString()+"\n";
			processEvent(e);	
		}
		risultato+=statistiche;
		return risultato;
	}
	//PROCESSOEVENTO 
	private void processEvent(Evento e) {
		//System.out.println(e);
		switch(e.getType()) {
		case OCCUPA:
			int minimo=200;
			Tavolo tavolo=null;
			for( Tavolo t:tavoli) {
				if(t.isOccupato()==false) {
					if(t.getNumeroposti()<minimo && e.getNum_persone()<=t.getNumeroposti() && t.getNumeroposti()<=2*e.getNum_persone()) {
						minimo=t.getNumeroposti();
					}
				}
			}
			for( Tavolo t:tavoli) {
				if(t.isOccupato()==false && t.getNumeroposti()==minimo) {
					tavolo=t;
					t.setOccupato(true);
				}
			}
			if(tavolo==null) {
				Random random = new Random();
				float ran = (float) (random.nextInt(10)/10.0);
				if(ran <= e.getTolleranza()) {
					statistiche.setClienti(statistiche.getClienti()+e.getNum_persone());
					statistiche.setSoddisfatti(statistiche.getSoddisfatti()+e.getNum_persone());
				} else {
					statistiche.setClienti(statistiche.getClienti()+e.getNum_persone());
					statistiche.setInsoddisfatti(statistiche.getInsoddisfatti()+e.getNum_persone());
				}
			}
			else {
			statistiche.setClienti(statistiche.getClienti()+e.getNum_persone());
			statistiche.setSoddisfatti(statistiche.getSoddisfatti()+e.getNum_persone());
			Random random=new Random();
			int tempoPermanenza=random.nextInt(120-60+1)+60;
			Evento nuovo=new Evento(it.polito.tdp.bar.model.Evento.EventType.LIBERA,e.getOrario().plusMinutes(tempoPermanenza),e.getNum_persone(),0,tavolo);
			this.eventi.add(nuovo);
			}
			break;
		case LIBERA:
			e.getTavolo().setOccupato(false);
			break;
		}
	}

}
