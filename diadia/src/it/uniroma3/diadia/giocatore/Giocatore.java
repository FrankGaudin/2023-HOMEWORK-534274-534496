package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.InizializzaDati;

public class Giocatore {
	static final private int CFU_INIZIALI = InizializzaDati.getCFU();
	//static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	public int cfu;

	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu =CFU_INIZIALI;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	
}
