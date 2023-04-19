package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	
	private String direzione;
	private IO io;
	private final static String NOME = "vai";

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		
		if(this.direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
