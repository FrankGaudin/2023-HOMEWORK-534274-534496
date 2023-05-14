package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Map<String, Stanza> stanze;
	private Stanza ultima;
	
	public LabirintoBuilder(){
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getStanze(){
		return this.stanze;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Stanza getUltima() {
		return this.ultima;
	}
	
	public void aggiunta(Stanza s) {
		ultima = s;
		stanze.put(s.getNome(), s);
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanza) {
		Stanza s = new Stanza(stanza);
		this.labirinto.setStanzaCorrente(s);
		this.aggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanza) {
		Stanza s = new Stanza(stanza);
		this.labirinto.setStanzaVincente(s);
		this.aggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.aggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanza, String stanzaAdiacente, String direzione) {
		Stanza current = stanze.get(stanza);
		Stanza toAdd = stanze.get(stanzaAdiacente);
		current.impostaStanzaAdiacente(direzione, toAdd);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo (attrezzo, peso);
		if(this.ultima == null)
			return this;
		this.ultima.addAttrezzo(a);
		return this;	
	}
	
	public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String pass) {
		StanzaBloccata s = new StanzaBloccata(stanza,direzione,pass);
		this.aggiunta(s);
		return this;
		
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza, String pass) {
		StanzaBuia s = new StanzaBuia(stanza,pass);
		this.aggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza) {
		StanzaMagica s = new StanzaMagica(stanza);
		this.aggiunta(s);
		return this;
	}
	
	
}
