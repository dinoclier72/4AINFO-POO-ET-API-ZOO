package src.main.java.com.tpgate.TP1;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Chien extends Animal{
	private static final Logger logger = LogManager.getLogger(MyApp.class);
	
	public Chien(String nom) {
		logger.trace("Chien ajoute");
		nomAnimal = nom;
		typeAnimal = TypeAnimal.Chien;
	}
}
