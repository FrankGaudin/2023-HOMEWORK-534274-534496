
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	
	Borsa b;
	Borsa bl;
	Attrezzo spada;
	Attrezzo pistola;
	Attrezzo spadone;
	Attrezzo cannone;
	
	public BorsaTest() {
		
	}
	
	@BeforeEach
	public void setUp() {
		this.b =new Borsa();
		this.bl= new Borsa();
		this.spada= new Attrezzo("spada", 1);
		this.pistola= new Attrezzo("pistola", 3);
		this.spadone= new Attrezzo("spadone", 3);
		this.cannone= new Attrezzo("cannone", 2);
	}
	
    public boolean controllaList(List<?> c1, List<?> c2) {
        if (c1.size() != c2.size()) {
            return false;
        } else {
            for(int i = 0; i < c1.size(); ++i) {
                if (!c1.get(i).equals(c2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public boolean controllaSet(Set<Attrezzo> s1, Set<Attrezzo> s2) {
		if(s1.size() != s2.size())
			return false;
		Iterator<Attrezzo> iter = s1.iterator();
		Iterator<Attrezzo> iter1 = s2.iterator();
		while(iter.hasNext() && iter1.hasNext()) {
			if(!iter.next().equals(iter1.next()))
				return false;
		}
		return true;
	}
    
    public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(b.isEmpty());
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(spada));
	}
	
	@Test
	public void testHasAttrezzo() {
		this.b.addAttrezzo(spadone);
		this.b.addAttrezzo(spada);
		assertTrue(b.hasAttrezzo("spada"));
	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(pistola);
		assertEquals(pistola, b.getAttrezzo("pistola"));
	}
	
	@Test
	public void testOrdinatoPeso() {
		bl.addAttrezzo(spada);
		bl.addAttrezzo(cannone);
		bl.addAttrezzo(spadone);
		List<Attrezzo> l = new ArrayList<>();
		l.add(spada);
		l.add(cannone);
		l.add(spadone);
		assertTrue(controllaList(l,bl.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> l = new TreeSet<Attrezzo>();
		b.addAttrezzo(spada);
		b.addAttrezzo(spadone);
		l.add(spada);
		l.add(spadone);
		assertTrue(controllaSet(l, b.getContenutoOrdinatoPerNome()));
		
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();
		Set<Attrezzo> set = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		set.add(pistola);
		set.add(spadone);
		mappa.put(spada.getPeso(), set);
		bl.addAttrezzo(pistola);
		bl.addAttrezzo(spadone);
		assertTrue(controllaMap(mappa, bl.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.add(spada);
		s.add(cannone);
		b.addAttrezzo(spada);
		b.addAttrezzo(cannone);
		assertTrue(controllaSet(s,b.getSortedSetOrdinatoPerPeso()));
	}
}
