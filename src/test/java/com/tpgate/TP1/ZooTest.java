package test.java.com.tpgate.TP1;

import static org.junit.Assert.*;

import org.junit.Test;

import src.main.java.com.tpgate.TP1.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZooTest {
	Zoo zoo;

	@Test
	public void testTropDeVisiteurs() {
		zoo = new Zoo(1);
		assertThrows(LimiteVisiteurException.class,()->{zoo.nouveauVisiteur();});
	}
	
	@Test
	public void testChienDansLeBonSecteur() throws AnimalDansMauvaisSecteurException{
		zoo = new Zoo(1);
		zoo.ajouterSecteur(TypeAnimal.Chien);
		zoo.nouvelAnimal(new Chien("Medore"));
		assertEquals(1,zoo.nombreAnimaux());
	}
}
