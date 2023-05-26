package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{
	
	private final static String NOME = "vai";

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.getParametro() == null)
			this.getIo().mostraMessaggio("Dove vuoi andare ?");

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
		if (prossimaStanza == null) {
			this.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
