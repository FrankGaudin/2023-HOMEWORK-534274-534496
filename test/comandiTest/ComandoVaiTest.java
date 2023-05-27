package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
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
	Labirinto l;
	
	
	@BeforeEach
	public void setUp() throws Exception{
		Scanner scan = new Scanner(System.in);
		s1 = new Stanza("biblioteca");
		s2 = new Stanza("N10");
		s1.impostaStanzaAdiacente(Direzione.valueOf("nord"), s1);
		c = new ComandoVai();
		l = Labirinto.newBuilder("bilocale.txt").getLabirinto();
		p = new Partita(l);
		IO io = new IOConsole(scan);
		c.setIo(io);
	}
	
	@Test
	public void testVaiNull() {
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezione() {
		c.setParametro("nord");
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
