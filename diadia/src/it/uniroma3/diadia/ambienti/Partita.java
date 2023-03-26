package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	
	public Partita(){
		giocatore = new Giocatore();
		labirinto = new Labirinto();
		labirinto.creaStanze();
		this.finita = false;
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
	public Labirinto getLabirinto(){
		return labirinto;
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
}
