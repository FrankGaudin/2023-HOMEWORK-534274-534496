
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo spada;
	Attrezzo pistola;
	Attrezzo spadone;
	Attrezzo cannone;
	List<Attrezzo> l;
	
	@Before
	public void setUp() {
		spada = new Attrezzo("spada", 1);
		pistola = new Attrezzo("pistola", 3);
		spadone = new Attrezzo("spada", 3);
		cannone = new Attrezzo("cannone", 2);
		l = new ArrayList<Attrezzo>();
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
	public void testGetPeso() {
		b.addAttrezzo(pistola);
		assertEquals(pistola, b.getAttrezzo("pistola"));
	}
	
	@Test
	public void testOrdinatoPeso() {
		b.addAttrezzo(spada);
		b.addAttrezzo(spadone);
		l.addAll(b.getContenutoOrdinatoPerPeso());
		assertEquals(2, l.size());
	}
}
