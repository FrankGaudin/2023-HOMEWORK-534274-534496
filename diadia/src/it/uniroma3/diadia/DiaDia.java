package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Labirinto;

import java.io.FileNotFoundException;
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	private Partita partita;
	private IO io;
	
	public DiaDia(Labirinto labirinto, IO console) {
		this.partita = new Partita(labirinto);
		this.io = console;
	}

	public void gioca() throws Exception{
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();
		} while
			(!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva fabbrica = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = fabbrica.costruisciComando(istruzione);
		} catch(NullPointerException e) {
			comandoDaEseguire = fabbrica.costruisciComando("Non valido");
		} catch(ClassNotFoundException ce) {
			comandoDaEseguire = fabbrica.costruisciComando("Non valido");
		}
		
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else if(this.partita.isFinita()) {
			io.mostraMessaggio("Grazie per aver giocato.");
		}
			return false;
	}
	

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 * @throws FormatoFileNonValidoException 
	 * @throws FileNotFoundException 
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Stanza corrente:");
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa:");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	private void prendi(String attrezzo) {
		if(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)) {
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		io.mostraMessaggio("Hai raccolto: ");
		io.mostraMessaggio(attrezzo);
		} else {
			io.mostraMessaggio("Non c'è un oggetto del genere");
		}
	}

	private void posa(String attrezzo) {
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
		Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		io.mostraMessaggio("Hai posato: ");
		io.mostraMessaggio(attrezzo);
		} else {
			io.mostraMessaggio("Non hai quell'oggetto in borsa!");
		}
	}
	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	} */

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO console = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("file.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, console);
		gioco.gioca();
		scanner.close();
	}
}