import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


public class LabirintoTest {

	Labirinto l;
	Stanza s1;
	Stanza s2;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		l = Labirinto.newBuilder("file.txt").getLabirinto();
		s1 = new Stanza("N11");
		s2 = new Stanza("N10");
	}
	
	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(s1);
		assertEquals(s1, l.getStanzaCorrente());		
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}
}
