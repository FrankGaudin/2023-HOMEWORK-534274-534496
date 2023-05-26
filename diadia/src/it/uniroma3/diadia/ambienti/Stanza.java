package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    private Map<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
    private Map<Direzione,Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }
    
    public void setPersonaggio(AbstractPersonaggio personaggio) {
    	this.personaggio = personaggio;
    }

    public AbstractPersonaggio getPersonaggio() {
    	return this.personaggio;
    }
    
    public boolean hasPersonaggio() {
    	if(personaggio != null)
    		return true;
    	return false;
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
    	boolean fatto = false;
    	if(this.stanzeAdiacenti.containsKey(direzione)) { 
    		stanzeAdiacenti.put(direzione, stanza);
    		fatto = true;
    	}
    	if(!fatto)
    		if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.stanzeAdiacenti.put(direzione, stanza);
    			this.numeroStanzeAdiacenti++;
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if(this.stanzeAdiacenti.containsKey(direzione)) {
			stanza = this.stanzeAdiacenti.get(direzione);
		}
        return stanza;
	}
	
	public List<Stanza> getStanzeAdiacenti(){
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : stanzeAdiacenti.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
		}
	
	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}
	
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}
	
	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}
	
	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return this.attrezzi.values();
    }
    
    public int getNumeroAttrezzi() {
    	return numeroAttrezzi;
    }
    
	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if(attrezzo != null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
    		this.attrezzi.put(attrezzo.getNome(), attrezzo);
    		this.numeroAttrezzi++;
    		return true;
    	} else {
    		return false;
    	}
    	   
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	risultato.append(this.getDirezioni().toString());
    	risultato.append("\nAttrezzi nella stanza: ");
    	risultato.append(this.getAttrezzi().toString());
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		if(this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		// TODO da implementare
		if(attrezzo != null) {
		attrezzi.remove(attrezzo.getNome(), attrezzo);
		return true;
		} else
			return false;
	}


	public Set<Direzione> getDirezioni() {
	    return this.stanzeAdiacenti.keySet();
    }
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
		}

}