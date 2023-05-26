package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;

public class ComandoGuarda extends AbstractComando{
	
	private final static String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Disponi ancora di:" + partita.getGiocatore().getCfu() + "CFU");
		this.getIo().mostraMessaggio("Borsa:");
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		if(partita.getLabirinto().getStanzaCorrente().hasPersonaggio())
			this.getIo().mostraMessaggio("C'è qualcuno nella stanza..");
		
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
