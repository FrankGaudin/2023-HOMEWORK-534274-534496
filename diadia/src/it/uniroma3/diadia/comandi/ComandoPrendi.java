package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.getParametro());
		if(a==null) {
			this.getIo().mostraMessaggio("Non c'è questo attrezzo nella stanza");
		} else {
			if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			} 
			else
				this.getIo().mostraMessaggio("Attrezzo troppo pesante");
			}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
