package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio{
	private static final String MES_SALUTATA = "Sei gentile, ora sparisci. ";
	
	private static final String MES_NONSALUTATA = "Le persone come te non le digerisco fuori dalla mia vista.";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> l = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		
		Stanza maxA = l.get(0);
		Stanza minA = l.get(0);
		
		for(Stanza s : l) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxA.getNumeroAttrezzi()) {
					maxA = s;
				}
				if(s.getNumeroAttrezzi() < minA.getNumeroAttrezzi()) {
					minA = s;
				}
			}
		}
		
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxA);
			msg = MES_SALUTATA;
		} else {
			partita.getLabirinto().setStanzaCorrente(minA);
			msg = MES_NONSALUTATA;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String s = new String("HIHIHIHIHI HUEHUEHEUHE >:D");
		return s;
	}
	
	
}
