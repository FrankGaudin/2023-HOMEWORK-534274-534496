package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException{
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		stanzaCorrente = c.getStanzaIniziale();
		stanzaVincente = c.getStanzaVincente();
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
    	return new LabirintoBuilder(labirinto);
    }

	
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente = stanzaVincente;
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	//
	//
	//
	//
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Map<String, Stanza> stanze;
		private Stanza ultima;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
			this.labirinto = new Labirinto(labirinto);
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
		
		public LabirintoBuilder addAdiacenza(String stanza, String stanzaAdiacente, Direzione direzione) {
			Stanza current = stanze.get(stanza);
			Stanza toAdd = stanze.get(stanzaAdiacente);
			current.impostaStanzaAdiacente(direzione, toAdd);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String attrezzo, int peso, String s) {
			Attrezzo a = new Attrezzo (attrezzo, peso);
			if(this.ultima == null)
				return this;
			this.ultima.addAttrezzo(a);
			return this;	
		}
		
		public LabirintoBuilder addStanzaBloccata(String stanza, Direzione direzione, String pass) {
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
		
		public LabirintoBuilder addCane(String nome, String presentazione, Attrezzo attrezzo) {
			Cane c = new Cane(nome, presentazione, attrezzo);
			if(this.ultima == null)
				return this;
			this.ultima.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultima == null)
				return this;
			this.ultima.setPersonaggio(m);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultima == null)
				return this;
			this.ultima.setPersonaggio(s);
			return this;
		}
	}
	
}
