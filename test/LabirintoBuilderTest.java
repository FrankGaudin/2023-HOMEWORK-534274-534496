
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoBuilderTest {

	LabirintoBuilder l;

	@Before
	public void setUp() {
		l = new LabirintoBuilder();
	}

	@Test
	public void testGetLabirinto() {
		l.getLabirinto();
		assertEquals(Labirinto.class, l.getLabirinto().getClass());
	}
	
	@Test
	public void testAddStanzaIniziale() {
		l.addStanzaIniziale("n");
		Stanza i = new Stanza("n");
		assertEquals(i, l.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testAddStanza() {
		l.addStanza("a");
		Stanza stanza = new Stanza("a");
		assertEquals(stanza, l.getStanze().get("a"));
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanza(){
		l.addStanza("stanzetta");
        l.addAttrezzo("cacciavite", 3);
        assertTrue(l.getStanze().get("stanzetta").hasAttrezzo("cacciavite"));
    }

	
	
}