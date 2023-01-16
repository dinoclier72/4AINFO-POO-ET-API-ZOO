package src.main.java.com.tpgate.TP1;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Chat extends Animal{
	private static final Logger logger = LogManager.getLogger(MyApp.class);
	
	public Chat(String nom) {
		logger.trace("chat ajoute");
		nomAnimal = nom;
		typeAnimal = TypeAnimal.Chat;
	}
}
