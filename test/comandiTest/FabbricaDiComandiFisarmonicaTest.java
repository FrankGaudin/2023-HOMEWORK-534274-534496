package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoGuarda;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	
	FabbricaDiComandiFisarmonica f;
	Comando c;
	IO io;
	
	@BeforeEach
	public void setUp() {
		Scanner scan = new Scanner(System.in);
		io = new IOConsole(scan);
		f = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	public void testComandoNonValido() {
		c = new ComandoNonValido();
		assertEquals(c.getNome(), f.costruisci("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		c = new ComandoVai();
		c.setParametro("nord");
		Comando current = f.costruisci("vai nord");
		assertEquals( c.getNome(), current.getNome());
		assertEquals( c.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		c = new ComandoGuarda();
		assertEquals( c.getNome(), f.costruisci("guarda").getNome());
	}
	
}
