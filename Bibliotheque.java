import java.io.*;
public class Bibliotheque implements Serializable {
	
	//liste contenant les livres de la bibliothèque
	private Liste listeLivres;

	/* Attribut utilisé pour faire fonctionner les tests
	et pour vérifier si les affichages sont ceux attendus */
	static String attribut_test;
	
	/**
	* Ce constructeur permet de créer une Bibliothèque,
	* en initialisant une nouvelle Liste
	**/
	public Bibliotheque() {
		listeLivres = new Liste();
	}


	/**
	* Méthode permettant d'ajouter un Roman à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	*
	* @param auteur auteur du livre à ajouter
	* @param titre titre du livre à ajouter
	**/
	public void ajouteRoman(String auteur,String titre) {
		listeLivres.ajouter(new Roman(auteur,titre));
	}


	/**
	* Méthode permettant d'ajouter un Manga à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	*
	* @param auteur auteur du Manga à ajouter
	* @param titre titre du Manga à ajouter
	* @param dessinateur dessinateur du Manga à ajouter
	**/
	public void ajouteManga(String auteur, String dessinateur,String titre) {
		listeLivres.ajouter(new Manga(auteur,dessinateur,titre));
	}


	/**
	* Méthode permettant d'ajouter un Comics à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	* @param auteur auteur du Comics à ajouter
	* @param titre titre du Comics à ajouter
	* @param dessinateur dessinateur du Comics à ajouter
	**/
	public void ajouteComics(String auteur, String dessinateur,String titre) {
		listeLivres.ajouter(new Comics(auteur,dessinateur,titre));
	}


	/**
	* Méthode permettant de rechercher une liste de livres 
	* écrits par un auteur donné en paramètre
	* (Pour les BD le scénariste représente l'auteur du livre)
	*
	* @param auteur auteur recherché 
	**/
	public void rechercheAuteur(String auteur) {
		System.out.println(listeLivres.rechercheAuteur(auteur));
		attribut_test=listeLivres.rechercheAuteur(auteur).toString();
	}


	/**
	* Méthode permettant de rechercher une liste de BD
	* dessinées par un dessinateur donné en paramètre
	*
	* @param dessinateur dessinateur recherché 
	**/
	public void rechercheDessinateur(String dessinateur) {
		System.out.println(listeLivres.rechercheDessinateur(dessinateur));
		attribut_test=listeLivres.rechercheDessinateur(dessinateur).toString();
	}


	/**
	* Méthode permettant d'afficher toutes les BD de la bibliothèque
	**/
	public void afficheBD() {
		System.out.println(listeLivres.afficheBD());
		attribut_test=listeLivres.afficheBD();
	}

	
	/**
	* Méthode permettant d'afficher tous les livres de la bibliothèque
	**/
	public void afficheLivres() {
		System.out.println(listeLivres);
		attribut_test=listeLivres.toString();
	}

	/**
	* Méthode permettant de sauvegarder la bibliothèque dans un fichier
	* binaire dont le nom est passé en paramètre
	*
	* @param nom nom du fichier binaire
	**/
	public void sauve(String nom) {
		try {
			ObjectOutputStream biblio=new ObjectOutputStream(new FileOutputStream(nom));
			biblio.writeObject(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Méthode permettant de charger une bibliothèque à partir d'un
	* binaire dont le nom est passé en paramètre
	* une fois chargée l'objet Bibliotheque est retourné par la méthode
	*
	* @param nom nom du fichier binaire
	* @return la bibliothèque chargée à partir du fichier
	* @throws Exception
	**/
	public static Bibliotheque charge(String nom) throws Exception {
		
			ObjectInputStream fichier=new ObjectInputStream(new FileInputStream(nom));
			/* On ne teste pas si l'objet est bien une instance de Bibliothèque car 
			 le fichier ne contient qu'un seul objet bibliothèque, de plus on suppose
			 qu'il contient bien une bibliothèque */
			Bibliotheque b= (Bibliotheque)(fichier.readObject());
			fichier.close();
			return b;
	}

	/**
	* Méthode permettant de sauvegarder la bibliothèque dans un fichier
	* d'extension .csv dont le nom est passé en paramètre
	* <p>
	* l'extension du .csv est ajouté automatiquement au nom passé en paramètre
	* @param nom nom du fichier à enregistrer au format csv
	**/
	public void exporte(String nom) {
		
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(nom+".csv"));
				fichier.write(""+listeLivres);
				fichier.close();
		} catch(Exception e) {}
	}

	/**
	* méthode permettant le parcours d'un fichier .csv passé en paramètre
	* et qui récupère une bibliothèque si le fichier est au bon format
	* Une fois la bibliothèque récupérée, elle est retournée par la méthode
	* Si la bibliothèque est au mauvais format on déclenche l'Exception
	* MauvaisFormatException
	* <p>
	* l'extension .csv est ajouté automatiquement au nom passé en paramètre
	*
	* @param nom nom du fichier à enregistrer au format csv
	* @throws Exception
	* @return la bibliothèque importée à partir du fichier nom.csv
	**/
	public static Bibliotheque importe(String nom) throws Exception {
		BufferedReader fichier = new BufferedReader(new FileReader(nom+".csv"));
		Bibliotheque biblio = new Bibliotheque();
		try {
			String ligne;
			String mots[];
			
			/* Premier parcours pour connaitre le nombre de lignes réel du fichier */
			int nb_lignes_reelles=0;
			while(fichier.readLine()!=null)
				nb_lignes_reelles++;
			/* Fin du premier parcours */
			//fermeture du fichier pour recommencer à le lire depuis le début lors du 2eme parcours
			fichier.close();


			fichier = new BufferedReader(new FileReader(nom+".csv"));
			//initialisation d'une liste pour importer les différents livres
			Liste liste=biblio.listeLivres;
			// première ligne du fichier qui contient un numéro correspondant au nombre de livres
			int nb_livres=Integer.parseInt(fichier.readLine());

			/* on compare donc le nombre de livres au nombre de lignes réelles nb_lignes_reelles-1
			 (-1 car la première ligne correspond au nombre de livres)
			 si ce nombre est différent, le format du fichier n'est pas respecté et on déclenche
			 MauvaisFormatException */
			 if ((nb_lignes_reelles-1)!=nb_livres)
			 	throw new MauvaisFormatException(1);

			/* initialisation du numero de ligne utilisé pour la création d'une Exception
			 MauvaisFormatException */
			int numeroLigne=1;

			/* tableau contenant les différents ids des livres importés, il permettra de vérifier
			 si tous les livres possèdent bien un id différent */
			Integer tab_id[] = new Integer[nb_livres];
			int incrementeur_id=0; // variable permettant les différents ajouts dans tab_id[]
			int id; // id courant d'un livre
			/*Comme on sait grace au test précédent que le nombre de lignes est cohérent
			 par rapport au nombre de livre on parcourt en fonction du nombre de livres */
			while(nb_livres>0) {
				numeroLigne++;
				ligne=fichier.readLine();
				mots=ligne.split(";");
				// si on a une BD la taille du tableau est de 5
				if (mots.length==5)
					if (mots[0].compareTo("Manga")==0) {
						Manga manga= new Manga(mots[2],mots[3],mots[4]);
						id=Integer.parseInt(mots[1]);
						/*si l'id est négatif, le format n'est pas respecté car la bibliothèque ne permet 
						que d'enregistrer des fichiers contenant des livres avec des ids positifs */
						if (id<=0) {
							throw new MauvaisFormatException(numeroLigne);
						}
						else {
							tab_id[incrementeur_id]=id;
							incrementeur_id++;
							manga.setNumero(id);
							liste.ajouter(manga);
						}
					}
					else if (mots[0].compareTo("Comics")==0) {
						Comics comics= new Comics(mots[2],mots[3],mots[4]);
						id=Integer.parseInt(mots[1]);
						/*si l'id est négatif, le format n'est pas respecté car la bibliothèque ne permet 
						que d'enregistrer des fichiers contenant des livres avec des ids positifs */
						if (id<=0) {
							throw new MauvaisFormatException(numeroLigne);
						}
						else {
							tab_id[incrementeur_id]=id;
							incrementeur_id++;
							comics.setNumero(id);
							liste.ajouter(comics);
						}
					} // Si ce n'est pas une BD on déclenche MauvaisFormatException
					else
						throw new MauvaisFormatException(numeroLigne);


				// sinon si la taille est 4 on a un roman
				else if(mots.length==4)
					if (mots[0].compareTo("Roman")==0) {
						Roman roman= new Roman(mots[2],mots[3]);
						id=Integer.parseInt(mots[1]);
						/*si l'id est négatif, le format n'est pas respecté car la bibliothèque ne permet 
						que d'enregistrer des fichiers contenant des livres avec des ids positifs */
						if (id<=0) {
							throw new MauvaisFormatException(numeroLigne);
						}
						else {
							tab_id[incrementeur_id]=id;
							incrementeur_id++;
							roman.setNumero(id);
							liste.ajouter(roman);
						}
					}
					else// Si ce n'est pas un roman on déclenche MauvaisFormatException
						throw new MauvaisFormatException(numeroLigne);

				// sinon le format n'est pas respecté
				else 
					throw new MauvaisFormatException(numeroLigne);

				nb_livres--;
			}

			/* Une fois la bibliothèque construite, on parcourt celle-ci pour vérifier que tous les identifiants
			 sont uniques */


			boolean trouve=false;
			int i=0;
			int j=0;

			while(i<tab_id.length && !trouve) {
				j=i+1;
				while (!trouve && j<tab_id.length) {
					trouve=(tab_id[j].equals(tab_id[i]));
						j++;
				}
				i++;
			}

			/* Si deux id sont identiques on déclenche MauvaisFormatException
			 (j'ai choisi de construire une erreur contenant la première ligne 
			 responsable de la répétition d'un id) */
			if (trouve) 
				throw new MauvaisFormatException(j); 





		} catch (MauvaisFormatException e ) {
			System.out.println(e);
			// si le format n'est pas bon j'ai choisi de ne pas charger la liste même partiellement
			biblio.listeLivres=new Liste();
			fichier.close();
		} catch(EOFException e) {
			fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Une fois la liste de livres remplie, on retourne la nouvelle bibliothèque
		return biblio;
	}

	/**
	 * Méthode permettant de retourner l'attribut permettant de tester
	 * l'affichage
	 *
	 * @return attribut permettant de tester l'affichage
	 **/ 
	public String getTestAffichage() {
		return attribut_test;
	}
}