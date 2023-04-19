
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	Giocatore g = new Giocatore();
	Borsa b = new Borsa();
	
	private int i = 10;
	
	@Test
	public void testGetCfu() {
		assertEquals(20,g.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(i);
		assertEquals(i,g.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		assertNotNull(g.getBorsa());
	}


}
