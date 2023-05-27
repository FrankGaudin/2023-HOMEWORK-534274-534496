package comandiTest;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;

public class ComandoVeroTest extends AbstractComando{
	
	public final static String MESSAGGIO= "Grazie di aver giocato!";
	private final static String NOME = "ConcreteComando";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
