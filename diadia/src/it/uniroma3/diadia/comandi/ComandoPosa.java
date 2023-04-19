package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	private IO io;
	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		io.mostraMessaggio("Hai posato: ");
		io.mostraMessaggio(nomeAttrezzo);
		} else {
			io.mostraMessaggio("Non hai quell'oggetto in borsa!");
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
