
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;


class ComandoVaiTest {
	
	Stanza s1;
	Stanza s2;
	Comando c;
	Partita p;
	IO io;
	
	
	@BeforeEach
	public void setUp() {
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		c = new ComandoVai();
		p = new Partita();
		IO io = new IOConsole();
		c.setIo(io);
	}
	
	@Test
	public void testVaiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		c.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezione() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		c.setParametro("sud");
		c.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testSetParametro() {
		c.setParametro("nord");
		assertEquals("nord",c.getParametro());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("vai",c.getNome());
	}
	
	

}
