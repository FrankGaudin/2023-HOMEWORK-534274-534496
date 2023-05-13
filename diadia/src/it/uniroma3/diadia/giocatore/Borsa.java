package it.uniroma3.diadia.giocatore;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private	Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.attrezzi = new TreeMap<String, Attrezzo>();
		this.pesoMax = pesoMax;
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
		attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		}
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(Attrezzo b : attrezzi.values()) {
			if(b.getNome().equals(nomeAttrezzo))
				a=b;
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		if(!isEmpty()) {
		for(Attrezzo a : attrezzi.values())
				peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		if(nomeAttrezzo!=null){
			for(Attrezzo att : this.attrezzi.values()) {
				if(att != null) {
					if(att.getNome().equals(nomeAttrezzo)) {
						a = att;
						att = null;
						this.numeroAttrezzi--;
					}
				}
			}
		}
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi.values().toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziOrdinati = new ArrayList<Attrezzo>();
		attrezziOrdinati.addAll(this.attrezzi.values());
		Collections.sort(attrezziOrdinati, new ComparatoreAttrezziPerPeso());
		return attrezziOrdinati;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> l = new TreeSet<Attrezzo>();
		l.addAll(attrezzi.values());
		return l;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> m = new HashMap<Integer, Set<Attrezzo>>();
		for(Attrezzo a : attrezzi.values()) {
			if(m.containsKey(a.getPeso())) {
				m.get(a.getPeso()).add(a);
			} else {
				Set<Attrezzo> l = new HashSet<Attrezzo>();
				l.add(a);
				m.put(a.getPeso(), l);
			}
		}
		return m;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> l = new TreeSet<Attrezzo>();
		l.addAll(attrezzi.values());
		return l;
	}
}
