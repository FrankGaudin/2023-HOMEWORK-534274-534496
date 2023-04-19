import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	StanzaBuia s;
	Attrezzo a;
	
	@BeforeEach
	public void setUp() {
		s = new StanzaBuia("Stanza Buia", "candela");
		a = new Attrezzo("candela",1);
	}
	
	@Test
	public void testGetDescrizione1() {
		assertEquals("qui c'è un buio pesto",s.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione2() {
		s.addAttrezzo(a);
		assertEquals(s.toString(),s.getDescrizione());
	}
	

}
