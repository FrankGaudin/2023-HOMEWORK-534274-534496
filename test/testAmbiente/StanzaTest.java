package testAmbiente;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Stanza s3= new Stanza("s3");
	Attrezzo m = new Attrezzo("camicia", 12);
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(Direzione.valueOf("sud")));
	}
	

	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente(Direzione.valueOf("sud"), s2);
		s1.impostaStanzaAdiacente(Direzione.valueOf("nord"), s3);
		assertEquals(s2, s1.getStanzaAdiacente(Direzione.valueOf("sud")));
		assertEquals(s3, s1.getStanzaAdiacente(Direzione.valueOf("nord")));
		
	}
	
	@Test
	public void testHasAttrezzo() {
		s1.addAttrezzo(m);
		assertEquals(m, s1.getAttrezzo("camicia"));
	}
	

}
