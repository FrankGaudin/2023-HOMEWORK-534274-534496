import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	LabirintoBuilder l = new LabirintoBuilder()
						.addStanzaVincente("Biblioteca")
						.addStanzaIniziale("Stanza");
	Partita p = new Partita(l.getLabirinto());
	Stanza s = new Stanza("Stanza");
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
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
