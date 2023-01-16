package src.main.java.com.tpgate.TP1;

import java.util.ArrayList;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;

public class Secteur {
	private TypeAnimal typeAnimauxDansSecteur;
	private List<Animal> animauxDansSecteur = new ArrayList<Animal>();
	
	private static final Logger logger = LogManager.getLogger(MyApp.class);
	
	public Secteur(TypeAnimal type) {
		logger.trace("Secteur ajoute");
		typeAnimauxDansSecteur = type;
	}
	
	public void ajouterAnimal(Animal nouvelAnimal) throws AnimalDansMauvaisSecteurException{
		if(typeAnimauxDansSecteur != nouvelAnimal.getTypeAnimal()) {
			logger.error("l'animal est pas bon");
			throw new AnimalDansMauvaisSecteurException();
		}
		logger.trace("l'animal est ajoute dans le nouveau secteur");
		animauxDansSecteur.add(nouvelAnimal);
	}
	
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}
}
