package src.main.java.com.tpgate.TP1;

import java.util.List;
import java.util.ArrayList;


public class Zoo {
	private int visiteurs;
	private List<Secteur> secteursAnimaux = new ArrayList<Secteur>();
	private int nbvisiteurMaxParSecteur;
	
	public Zoo(int nombreVisiteurMaxParSecteur) {
		nbvisiteurMaxParSecteur = nombreVisiteurMaxParSecteur;
		
	}
	
	public void ajouterSecteur(TypeAnimal type) {
		secteursAnimaux.add(new Secteur(type));
	}
	public void nouveauVisiteur() throws LimiteVisiteurException{
		if(visiteurs == getLimiteVisiteur()) {
			throw new LimiteVisiteurException();
		}
		visiteurs += 1;
	}
	public int getLimiteVisiteur() {
		return nbvisiteurMaxParSecteur*secteursAnimaux.size();
	}
	public void nouvelAnimal(Animal nouveau) throws AnimalDansMauvaisSecteurException{
		for(Secteur s: secteursAnimaux) {
			if(s.obtenirType() == nouveau.getTypeAnimal()) {
				s.ajouterAnimal(nouveau);
				return;
			}
		}
	}
	public int nombreAnimaux() {
		int animaux = 0;
		for(Secteur s: secteursAnimaux) {
			animaux += s.getNombreAnimaux();
		}
		return animaux;
	}
}
