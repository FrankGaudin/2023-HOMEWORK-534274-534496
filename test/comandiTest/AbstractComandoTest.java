package comandiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Partita;

public class AbstractComandoTest {

	ComandoVeroTest c;
	Partita p;
	
	@Before
	public void setUp() throws Exception {
		c = new ComandoVeroTest();
		p = new Partita(Labirinto.newBuilder("file.txt").getLabirinto());
	}

	@Test
	public void testComandoGetNome() {
		 assertNotEquals("AbstractComando", c.getNome());
		 assertEquals("ConcreteComando", c.getNome());
	}
	
	@Test
	public void testComandoEsegui() {
		c.esegui(p);
		 assertTrue(p.isFinita());
	}
	
	@Test
	public void testComandoParametro() {
		c.setParametro("pippo");
		 assertNotNull(c.getParametro());
	}

}
