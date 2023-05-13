
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	LabirintoBuilder l = new LabirintoBuilder()
			.addStanzaIniziale("aula")
			.addAttrezzo("spada",3)
			.addStanzaVincente("bagno")
			.addStanza("a")
			.addAdiacenza("aula","bagno","sud");
	Stanza s = new Stanza("aula");
	Stanza b = new Stanza("bagno");
	Stanza as = new Stanza("a");
	Attrezzo att = new Attrezzo("spada", 3);

	@BeforeEach
	public void setUp() {
		
	}

	@Test
	public void testGetLabirinto() {
		l.getLabirinto();
		assertEquals(Labirinto.class, l.getLabirinto().getClass());
	}
	
	@Test
	public void testAddStanzaIniziale() {
		s.addAttrezzo(att);
		s.impostaStanzaAdiacente("sud", b);
		assertEquals(s, l.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testAddStanza() {
		assertEquals(as, l.getStanze().get("a"));
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanza(){
		l.addAttrezzo("spada", 3);
		Attrezzo a = new Attrezzo("spada", 3);
		assertEquals(a, l.getLabirinto().getStanzaCorrente().getAttrezzo("spada"));		
	}

	
	
}