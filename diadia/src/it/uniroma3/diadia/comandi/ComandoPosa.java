package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{
	
	private String nomeAttrezzo;
	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		this.getIo().mostraMessaggio("Hai posato: ");
		this.getIo().mostraMessaggio(nomeAttrezzo);
		} else {
			this.getIo().mostraMessaggio("Non hai quell'oggetto in borsa!");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}


}
