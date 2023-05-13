
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	
	Borsa b;
	Borsa bl;
	Attrezzo spada;
	Attrezzo pistola;
	Attrezzo spadone;
	Attrezzo cannone;
	
	public BorsaTest() {
		
	}
	
	@BeforeEach
	public void setUp() {
		this.b =new Borsa();
		this.bl= new Borsa();
		this.spada= new Attrezzo("spada", 1);
		this.pistola= new Attrezzo("pistola", 3);
		this.spadone= new Attrezzo("spadone", 3);
		this.cannone= new Attrezzo("cannone", 2);
	}
	
    public boolean controllaList(List<?> c1, List<?> c2) {
        if (c1.size() != c2.size()) {
            return false;
        } else {
            for(int i = 0; i < c1.size(); ++i) {
                if (!c1.get(i).equals(c2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
	
	@Test
	public void testIsEmpty() {
		assertTrue(b.isEmpty());
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(spada));
	}
	
	@Test
	public void testHasAttrezzo() {
		this.b.addAttrezzo(spadone);
		this.b.addAttrezzo(spada);
		assertTrue(b.hasAttrezzo("spada"));
	}
	@Test
	public void testGetPeso() {
		b.addAttrezzo(pistola);
		assertEquals(pistola, b.getAttrezzo("pistola"));
	}
	

    
	@Test
	public void testOrdinatoPeso() {
		bl.addAttrezzo(spada);
		bl.addAttrezzo(cannone);
		bl.addAttrezzo(spadone);
		List<Attrezzo> l = new ArrayList<>();
		l.add(spada);
		l.add(cannone);
		l.add(spadone);
		assertTrue(controllaList(l,bl.getContenutoOrdinatoPerPeso()));
	}
}
