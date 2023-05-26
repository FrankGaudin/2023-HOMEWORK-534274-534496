package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Partita;

public abstract class AbstractComando implements Comando{
	
	private IO io;
	private final static String NOME = "Abstract comando";
	private String parametro;

	
	abstract public void esegui(Partita partita);

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.parametro = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.parametro;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	public IO getIo() {
		return this.io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
