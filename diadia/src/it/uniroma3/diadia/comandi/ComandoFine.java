package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Partita;

public class ComandoFine extends AbstractComando {
	
	static final public String MESSAGGIO_FINE = "Fine del gioco!";
	private final static String NOME = "fine";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.getIo().mostraMessaggio(MESSAGGIO_FINE);
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
