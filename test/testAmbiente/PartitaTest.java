package testAmbiente;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	Labirinto l;
	Partita p;
	Stanza s;
	
	@BeforeEach
	public void setUp() throws Exception{
		l = Labirinto.newBuilder("bilocale.txt").getLabirinto();
		p = new Partita(l);
		s = new Stanza("Stanza");
	}

	 
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("N10", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	
}
