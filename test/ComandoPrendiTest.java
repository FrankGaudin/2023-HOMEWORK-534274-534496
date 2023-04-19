
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	Comando c;
	IO io;
	Partita p;
	Attrezzo a;
	
	@BeforeEach
	public void setUp() {
		p = new Partita();
		c = new ComandoPrendi();
		a = new Attrezzo("peluche",5);
		io = new IOConsole();
		c.setIo(io);
	}
	
	@Test
	public void testSetParametro() {
		c.setParametro(a.getNome());
		assertEquals("peluche",c.getParametro());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("prendi",c.getNome());
	}
	
	@Test
	public void testAttrezzoPreso() {
		p.getLabirinto().getStanzaCorrente().addAttrezzo(a);	
		c.setParametro(a.getNome());
		c.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("peluche"));
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo(a.getNome()));
	}
	
	@Test
	public void testAttrezzoNonPreso() {
		p.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("peluche"));
		assertTrue(p.getLabirinto().getStanzaCorrente().hasAttrezzo(a.getNome()));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		c.setParametro(a.getNome());
		c.esegui(p);
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo(a.getNome()));
	}
	

}
