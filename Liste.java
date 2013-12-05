import java.io.*;
public class Liste implements Serializable {
	private Maillon tete;
	private int nb_element;
	public Liste() {
		nb_element=0;
	}
	public int getNbElement() {
		return nb_element;
	}
	public void ajouter(Livre l) {
		// principe d'une liste chainé, expliquer en commentaire
		tete=new Maillon(l,tete);
		// on incrémente le nombre d'éléments à chaque ajout
		nb_element++;
	}
	public boolean supprime(String titre) {
		// recherche du livre correspondant au titre donné en paramètre
		boolean trouve=false;
		Maillon place=tete;
		Maillon place_precedente=tete;
		int nb=nb_element;
		while (nb>0 && !trouve) {
			if (titre.compareTo(place.getValeur().getTitre())==0)
				trouve=true;
			else {
				place_precedente=place;
				place=place.getMaillon();
			}
		}
		if (trouve) {
			//EXPLIQUER GARBAGE COLLECTOR
			// on saute la place en changeant le successeur
			place_precedente.setMaillon(place.getMaillon());
			// on décrémente le nombre d'éléments
			nb_element--;
		}
		
		return trouve;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(nb_element+"\n");
		// variable permettant le parcours de la liste 
		int nb=nb_element;
		Maillon place=tete;
		while (nb>0) {
		// autre possibilité : while(tete!=null)
			sb.append(place.getValeur()+"\n"); // utiliser direct place toString?
			place=place.getMaillon();
			nb--;
		}
		return sb.toString();
	}

	public String afficheBD() {
		// initialisation des variables nécessaires au parcours
		Maillon place=tete;
		int nb=nb_element;
		int nb_bande_dessinnees=0;
		StringBuffer sb = new StringBuffer();
		Livre livre_courant;

		// parcours de toute la liste
		while (nb>0) {
			livre_courant=place.getValeur();
			// si le livre courant est une BD on l'affiche et on incrémente le nombre de BD
			if ( livre_courant instanceof BD) {
				sb.append(livre_courant+"\n");
				nb_bande_dessinnees++;
			}
			place=place.getMaillon();
			nb--;
		}
		String resultat =(nb_bande_dessinnees+"\n"+sb);
		return resultat;
	}

	public Liste rechercheAuteur(String auteur) {
		Liste liste_resultat = new Liste();
		Maillon place=tete;
		int nb=nb_element;
		Livre livre_courant;
		while(nb>0) {
			livre_courant=place.getValeur();
			if (livre_courant.getAuteur().compareTo(auteur)==0)
				liste_resultat.ajouter(livre_courant);
			place=place.getMaillon();
			nb--;
		}
		return liste_resultat;
	}

	public Liste rechercheDessinateur(String dessinateur) {
		Liste liste_resultat = new Liste();
		Maillon place=tete;
		int nb=nb_element;
		Livre livre_courant;
		while(nb>0) {
			livre_courant=place.getValeur();
			/* si le livre courant est une BD on compare son dessinateur
			 au dessinateur en paramètre */
			if (livre_courant instanceof BD)
				if ( ( (BD)(livre_courant) ).getDessinateur().compareTo(dessinateur) == 0 )
					liste_resultat.ajouter(livre_courant);
			place=place.getMaillon();
			nb--;
		}
		return liste_resultat;
	}
	// fonctions permettant le parcours d'une liste
	public Maillon suc(Maillon p) {
		return p.getMaillon();
	}

	public Maillon tete() {
		return tete;
	}

	public boolean finListe(Maillon p) {
		return (p.getMaillon()==null);
	}
	public Livre val(Maillon p) {
		return p.getValeur();
	}
}