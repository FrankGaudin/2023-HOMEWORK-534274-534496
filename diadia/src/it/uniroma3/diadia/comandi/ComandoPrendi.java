package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		this.getIo().mostraMessaggio("Hai raccolto: ");
		this.getIo().mostraMessaggio(nomeAttrezzo);
		} 
		else {
			this.getIo().mostraMessaggio("Non c'è un oggetto del genere");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
