package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	private IO io;
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		io.mostraMessaggio("Hai raccolto: ");
		io.mostraMessaggio(nomeAttrezzo);
		} else {
			io.mostraMessaggio("Non c'è un oggetto del genere");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
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
