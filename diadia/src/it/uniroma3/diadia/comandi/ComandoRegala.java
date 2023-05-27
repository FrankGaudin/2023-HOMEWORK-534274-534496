package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	private final static String NOME = "regala";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a;
		
		if(this.getParametro() == null) {
			this.getIo().mostraMessaggio("Non hai selezionato cosa dare");
		} else if(partita.getGiocatore().getBorsa().hasAttrezzo(this.getParametro())) {
			a = partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
		} else {
			this.getIo().mostraMessaggio("Non hai questo oggetto");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
