package src.main.java.com.tpgate.TP1;

import java.util.ArrayList;
import java.util.List;

public class Secteur {
	private TypeAnimal typeAnimauxDansSecteur;
	private List<Animal> animauxDansSecteur = new ArrayList<Animal>();
	
	public Secteur(TypeAnimal type) {
		typeAnimauxDansSecteur = type;
	}
	
	public void ajouterAnimal(Animal nouvelAnimal) throws AnimalDansMauvaisSecteurException{
		if(typeAnimauxDansSecteur != nouvelAnimal.getTypeAnimal()) {
			throw new AnimalDansMauvaisSecteurException();
		}
		animauxDansSecteur.add(nouvelAnimal);
	}
	
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}
}
