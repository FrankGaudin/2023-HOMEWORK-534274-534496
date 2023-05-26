package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MESSAGGIO_CANE = "Woof WOof WOof >:3 (Beccati sto mozzicone)";
	
	private static String CIBO = "osso";
	
	private Attrezzo attrezzo;
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_CANE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		String s = new String ("Woof Woof (che mi dai di buono?");
		String s1 = new String(":3 (a quanto pare gli piace)");
		String s2 = new String("WOOF WOOF!!!!!!!!!!!!!! (orco dio)");
		String msg;
		if(attrezzo.getNome().equals(CIBO)) {
			msg = s1;
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
		} else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			msg = s2;
		}
		return s + msg;
	}

}
