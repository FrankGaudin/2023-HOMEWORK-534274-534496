
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	LabirintoBuilder l;

	@BeforeEach
	public void setUp(){
		l = new LabirintoBuilder();
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(l.getLabirinto());
		assertEquals(Labirinto.class, l.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		l.addStanza("aula");
		Stanza s = new Stanza("aula");
		assertEquals(s, l.getStanze().get("aula"));
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanza(){
		assertEquals(LabirintoBuilder.class, l.addAttrezzo("spada", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanza(){
		l.addStanzaIniziale("aula").addAttrezzo("spada", 3);
		Attrezzo a = new Attrezzo("spada", 3);
		assertEquals(a, l.getLabirinto().getStanzaCorrente().getAttrezzo("spada"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        l.addStanza("aula");
        l.addAttrezzo("spada", 3);
        assertTrue(l.getStanze().get("aula").hasAttrezzo("spada"));
    }
	
	
}