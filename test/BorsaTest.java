
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo spada;
	Attrezzo pistola;
	
	@Before
	public void setUp() {
		spada = new Attrezzo("spada", 20);
		pistola = new Attrezzo("pistola", 16);
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
}
