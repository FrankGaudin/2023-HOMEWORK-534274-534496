package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {
	
	Comando c;
	IO io;
	Partita p;
	Attrezzo a;
	Labirinto l;
	
	@BeforeEach
	public void setUp() throws Exception{
		l = Labirinto.newBuilder("file.txt").getLabirinto();
		p = new Partita(l);
		c = new ComandoPosa();
		a = new Attrezzo("peluche",5);
		io = new IOConsole(new Scanner(System.in));
		c.setIo(io);
	}
	
	@Test
	public void testSetParametro() {
		c.setParametro(a.getNome());
		assertEquals("peluche",c.getParametro());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("posa",c.getNome());
	}
	
	@Test
	public void testCreaAttrezzi() {
		for(int i= 0; i<10;i++) {
			p.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}
	
	@Test
	public void testAttrezzoNonPosato() {
		c.setParametro(a.getNome());
		c.esegui(p);
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo(a.getNome()));
	}

	
}
