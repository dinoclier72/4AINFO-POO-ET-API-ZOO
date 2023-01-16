package src.main.java.com.tpgate.TP1;

import java.util.List;
import java.util.ArrayList;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Zoo {
	private static final Logger logger = LogManager.getLogger(MyApp.class);
	private int visiteurs;
	private List<Secteur> secteursAnimaux = new ArrayList<Secteur>();
	private int nbvisiteurMaxParSecteur;
	
	public Zoo(int nombreVisiteurMaxParSecteur) {
		logger.trace("Nouveau Zoo ouvert");
		nbvisiteurMaxParSecteur = nombreVisiteurMaxParSecteur;
		
	}
	
	public void ajouterSecteur(TypeAnimal type) {
		logger.trace("Secteur ajoute au Zoo");
		secteursAnimaux.add(new Secteur(type));
	}
	public void nouveauVisiteur() throws LimiteVisiteurException{
		logger.trace("Nouveau visiteur");
		if(visiteurs == getLimiteVisiteur()) {
			logger.error("Trop de visiteurs pour le zoo");
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
				logger.trace("nouvel animal ajoute au secteur du zoo");
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
