import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	StanzaBloccata s;
	Attrezzo a;
	Stanza s1;
	
	@BeforeEach
	public void setUp() {
		s = new StanzaBloccata("Stanza Bloccata", "nord","ascia");
		a = new Attrezzo("ascia", 6);
		s1 = new Stanza("aula 1");
		s.impostaStanzaAdiacente("nord", s1);
	}
	
	@Test
	public void testGetDescrizione1() {
		assertEquals("C'è una stanza bloccata a: nord"+"\nProva a posare: ascia",s.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione2() {
		s.addAttrezzo(a);
		assertEquals(s.toString(),s.getDescrizione());
	}
	
	@Test
	public void testGetStanzaAdiacente1() {
		assertEquals(s, s.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		s.addAttrezzo(a);
		assertEquals(s1, s.getStanzaAdiacente("nord"));
	}
}
