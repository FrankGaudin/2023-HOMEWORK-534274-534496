package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Partita;

public class ComandoFine implements Comando {
	
	static final public String MESSAGGIO_FINE = "Fine del gioco!";
	private IO io;
	private final static String NOME = "fine";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
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
