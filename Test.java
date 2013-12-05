// classe principale permettant de tester l'application Bibliothèque
public class Test {

	public static void main(String [] args) {

		/* ------- Tests sur la classe Bibliothèque -------- */


		// variable qui s'incrémentera à chaque test réussi
		int nb_test_reussis=0;
		//Création d'une bibliothèque
		Bibliotheque biblio = new Bibliotheque();

		/* Affichage des livres de la bibliothèque vide.
		 Affichage attendue : 
		 l'affichage doit comporter seulement un 0 qui indique que la bibliothèque est vide */
		biblio.afficheLivres();


		if (biblio.getTestAffichage().equals("0\n")) {
			System.out.println("Test affichage Bibliotheque vide: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test affichage Bibliotheque vide: Echec");
		






		//Test d'ajout quand la bibliothèque est vide : ajout d'un livre à la bibliothèque
		biblio.ajouteRoman("auteur_roman_test","titre_roman_test");
		/*on affiche de nouveau le contenu de la bibliothèque et on vérifie si on a bien le numéro 1
		 qui indique que la bibliothèque contient bien un livre 
		 et qu'elle contient le Roman que l'on vient d'ajouter 
		 l'affichage attendue est donc :
		1
		Roman;1;auteur_roman_test;titre_roman_test
		 ( id=1 car c'est le premier livre créé) */

		biblio.afficheLivres();


		if (biblio.getTestAffichage().equals("1\nRoman;1;auteur_roman_test;titre_roman_test\n")) {
			System.out.println("Test ajout d'un element dans la Bibliotheque: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test ajout d'un element dans la Bibliotheque: Echec");






		// Test d'ajouts de livres de différents types ( Roman, Manga, Comics)
		biblio = new Bibliotheque();
		biblio.ajouteRoman("auteur_roman_test","titre_roman_test");
		biblio.ajouteManga("manga_test_titre","manga_test_scenariste","manga_test_dessinateur");
		biblio.ajouteComics("comics_test_titre","comics_test_scenariste","comics_test_dessinateur");
		
		//Ce test permet de tester la création de livres et les identifiants qui s'incrémentent

		/** on affiche le contenu de la bibliothèque pour vérifier que le résultat 
		comporte bien les trois livres créés
		Résultat attendu :
		3
		Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		Roman;2;auteur_roman_test;titre_roman_test */
		biblio.afficheLivres();
		//Construction de la chaine de caractère pour tester l'affichage
		StringBuffer sb1 = new StringBuffer();
		sb1.append("3\n");
		sb1.append("Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		sb1.append("Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		sb1.append("Roman;2;auteur_roman_test;titre_roman_test\n");

		if (biblio.getTestAffichage().equals(sb1.toString())) {
			System.out.println("Test ajout plusieurs elements dans la Bibliotheque: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test ajout plusieurs elements dans la Bibliotheque: Echec");





		/* Test de l'affichage des BD à l'aide de la méthode afficheBD()
		 On doit donc avoir 2 BD qui s'affichent à l'écran pour cette Bibliothèque
		 Résultat attendu :
		 2
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur */
		biblio.afficheBD();
		//Construction de la chaine de caractère pour tester l'affichage
		StringBuffer sb2 = new StringBuffer();
		sb2.append("2\n");
		sb2.append("Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		sb2.append("Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		
		if (biblio.getTestAffichage().equals(sb2.toString())) {
			System.out.println("Test affichage des BDs de la Bibliotheque: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test affichage des BDs de la Bibliotheque: Echec");

		/* création de plusieurs livres ayant le même auteur pour pouvoir tester la
		 recherche de livres par auteur */
		 biblio.ajouteManga("manga_test_titre2","auteur_cherche","manga_test_dessinateur2");
		 biblio.ajouteRoman("titre_roman_test2","auteur_cherche");
		 biblio.ajouteComics("comics_test_titre","auteur_cherche","comics_test_dessinateur2");
		 biblio.ajouteManga("manga_test_titre3","auteur_cherche","manga_test_dessinateur3");





		/* Test de la méthode pour afficher les livres écrits par le même auteur,
		 la méthode rechercheAuteur doit afficher tous les livres écrits par l'auteur
		 en paramètre.
		 Résultat attendu : 
		 4
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3 */
		  biblio.rechercheAuteur("auteur_cherche");
		//Construction de la chaine de caractère pour tester l'affichage
		StringBuffer sb3 = new StringBuffer();
		sb3.append("4\n");
		sb3.append("Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2\n");
		sb3.append("Roman;6;titre_roman_test2;auteur_cherche\n");
		sb3.append("Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2\n");
		sb3.append("Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3\n");

		if (biblio.getTestAffichage().equals(sb3.toString())) {
			System.out.println("Test de la méthode rechercheAuteur: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test de la méthdoe rechercheAuteur: Echec");








		/* Test de la méthode rechercheAuteur avec un auteur qui n'existe pas dans la bibliothèque 
		 Aucun livre ne doit apparaître et juste un "0" correspondant au nombre de livres trouvés
		 doit être affiché */
		  biblio.rechercheAuteur("auteur_inconnu");

		if (biblio.getTestAffichage().equals("0\n")) {
			System.out.println("Test recherche auteur inconnu: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test recherche auteur inconnu: Echec");








		/* création de plusieurs BD ayant le même dessinateur pour pouvoir tester la
		 recherche de livres par dessinateur */
		 biblio.ajouteManga("manga_test_titre4","manga_test_scenariste2","dessinateur_cherche");
		 biblio.ajouteComics("comics_test_titre2","comics_test_scenariste2","dessinateur_cherche");
		 biblio.ajouteManga("manga_test_titre5","manga_test_scenariste3","dessinateur_cherche");

		/* Test de la méthode pour afficher les livres écrits par le même dessinateur,
		 la méthode rechercheDessinateur doit afficher tous les livres écrits par le dessinateur
		 en paramètre.
		 Résultat attendu : 
		 3
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche */

		biblio.rechercheDessinateur("dessinateur_cherche");

		StringBuffer sb4 = new StringBuffer();
		sb4.append("3\n");
		sb4.append("Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche\n");
		sb4.append("Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche\n");
		sb4.append("Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche\n");
		
		if (biblio.getTestAffichage().equals(sb4.toString())) {
			System.out.println("Test recherche dessinateur: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test recherche dessinateur: Echec");









		/* Test de la méthode rechercheDessinateur avec un dessinateur qui n'existe pas dans la bibliothèque 
		 Aucun livre ne doit apparaître et juste un "0" correspondant au nombre de livres trouvés
		 doit être affiché */
		biblio.rechercheDessinateur("dessinateur_inconnu");

		if (biblio.getTestAffichage().equals("0\n")) {
			System.out.println("Test recherche dessinateur inconnu: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test recherche dessinateur inconnu: Echec");






		// Sauvegarde de la bibliothèque afin de tester la charge et la sauvegarde 
		biblio.sauve("fichier_sauvegarde");

		/* On efface le contenu de la bibliothèque en créant un nouvel objet Bibliothèque
		 et on affiche le contenu de la bibliothèque pour vérifier que la bibliothèque 
		 est bien vide. */
		biblio=new Bibliotheque();

		biblio.afficheLivres();
		//permet de vérifier que la bibliothèque est bien vide
		boolean biblio_etait_vide=false;
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_etait_vide=true;

		/* Une fois le contenu de la bibliothèque effacé, on charge le fichier sauvegardé
		 précédemment pour tester si la sauvegarde a bien fonctionné (on teste la charge
		 par la même occasion) */
		try {
			biblio=Bibliotheque.charge("fichier_sauvegarde");
		} catch(Throwable e) { e.printStackTrace();}

		/* On affiche la bibliothèque pour vérifier si le contenu est bien le même que précedemment
		Résultat attendu :
		 10
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		 Roman;2;auteur_roman_test;titre_roman_test */

		biblio.afficheLivres();

		StringBuffer sb5 = new StringBuffer();
		sb5.append("10\n");
		sb5.append("Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche\n");
		sb5.append("Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche\n");
		sb5.append("Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche\n");
		sb5.append("Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3\n");
		sb5.append("Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2\n");
		sb5.append("Roman;6;titre_roman_test2;auteur_cherche\n");
		sb5.append("Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2\n");
		sb5.append("Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		sb5.append("Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		sb5.append("Roman;2;auteur_roman_test;titre_roman_test\n");
		/* Si la bibliothèque était vide et qu'une fois chargée, elle contient les bons livres
		 le test est bon */
		if (biblio_etait_vide && biblio.getTestAffichage().equals(sb5.toString())) {
			System.out.println("Test méthode de charge bibliotheque: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test méthode de charge bibliotheque: Echec");









		// Exportation de la bibliothèque afin de tester l'exportation et l'importation
		biblio.exporte("fichier_sauvegarde_CSV");

		/* On efface le contenu de la bibliothèque en créant un nouvel objet Bibliothèque
		 et on affiche le contenu de la bibliothèque pour vérifier que la bibliothèque 
		 est bien vide. */
		biblio=new Bibliotheque();

		biblio.afficheLivres();

		if (biblio.getTestAffichage().equals("0\n")) 
			biblio_etait_vide=true;


		/* Une fois le contenu de la bibliothèque effacé, on importe la bibliothèque contenue
		 dans le  fichier sauvegardé précédemment pour tester si la sauvegarde a bien fonctionné
		 (on teste l'importation par la même occasion) */
		
		try {
			biblio=Bibliotheque.importe("fichier_sauvegarde_CSV");
		} catch(Throwable e) { e.printStackTrace();}

		/* On affiche la bibliothèque pour vérifier si le contenu est bien le même que précedemment
		 Résultat attendu : 
		 10
		 Roman;2;auteur_roman_test;titre_roman_test
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche */
		 
		 biblio.afficheLivres();
		 StringBuffer sb6 = new StringBuffer();
		 sb6.append("10\n");
		 sb6.append("Roman;2;auteur_roman_test;titre_roman_test\n");
		 sb6.append("Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		 sb6.append("Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		 sb6.append("Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2\n");
		 sb6.append("Roman;6;titre_roman_test2;auteur_cherche\n");
		 sb6.append("Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2\n");
		 sb6.append("Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3\n");
		 sb6.append("Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche\n");
		 sb6.append("Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche\n");
		 sb6.append("Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche\n");


		if (biblio_etait_vide && biblio.getTestAffichage().equals(sb6.toString())) {
			System.out.println("Test importation de bibliothèque: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test importation de bibliothèque: Echec");












		 /* Création d'un fichier contenant une erreur pour tester MauvaisFormatException
		  on utilise le fichier "fichier_erreur_ligne.csv"
		  */
		try {
		  	biblio=Bibliotheque.importe("fichier_erreur_ligne");
		} catch (Exception e ) {e.printStackTrace();}
		 /* Résultat attendue :
		  L'écran doit afficher une erreur dans le fichier ligne 2 et la bibliothèque
		  doit être vide */
		biblio.afficheLivres();

		//On vérifie si la bibliothèque est vide
		boolean biblio_est_vide;	
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_est_vide=true;
		else
			biblio_est_vide=false;

		/* si la bibliothèque n'est pas vide, elle a chargé le fichier malgrès l'erreur,
		 donc le test échoue */
		if (biblio_est_vide && MauvaisFormatException.test_exception.equals("Erreur ligne : 2")) {
			System.out.println("Test erreur sur une ligne: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test erreur sur une ligne: Echec");
		






		/* Test d'importation d'une bibliothèque contenant des livres ayant des id négatifs */
		biblio=new Bibliotheque();
		try {
			 biblio=Bibliotheque.importe("fichier_erreur_id_negatif");
		} catch(Exception e){e.printStackTrace();} 
		/* Résultat attendu :
		 Erreur ligne 3 et la bibliothèque ne contient pas de livre */
		biblio.afficheLivres();
		/* si la bibliothèque n'est pas vide (donc que l'importation a eu lieu) 
		 et si l'erreur affichée n'est pas la bonne alors le test s'est mal passé */
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_est_vide=true;
		else
			biblio_est_vide=false;
		if (biblio_est_vide && MauvaisFormatException.test_exception.equals("Erreur ligne : 4")) {
			System.out.println("Test erreur fichier id_negatif: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test erreur fichier id_negatif: Echec");







		/* Création d'un fichier contenant un nombre de lignes différents du nombre de livre
		 donné à la première ligne du fichier : "fichier_erreur_nblignes.csv"*/
		try {
			 biblio=Bibliotheque.importe("fichier_erreur_nblignes");
		} catch(Exception e){e.printStackTrace();} 
		/* Résultat attendu :
		 Erreur ligne 1 et la bibliothèque ne contient pas de livre */
		biblio.afficheLivres();

		/* si la bibliothèque n'est pas vide (donc que l'importation a eu lieu) 
		 et si l'erreur affichée n'est pas la bonne alors le test s'est mal passé */
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_est_vide=true;
		else
			biblio_est_vide=false;
		if (biblio_est_vide && MauvaisFormatException.test_exception.equals("Erreur ligne : 1")) {
			System.out.println("Test erreur fichier nb_lignes: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test erreur fichier nb_lignes: Echec");






		/* Test d'importation d'une bibliothèque contenant des livres ayant une catégorie 
		différente de Manga,BD et Roman */
		biblio=new Bibliotheque();
		try {
			 biblio=Bibliotheque.importe("fichier_erreur_categorie");
		} catch(Exception e){e.printStackTrace();} 
		/* Résultat attendu :
		 Erreur ligne 3 et la bibliothèque ne contient pas de livre */
		biblio.afficheLivres();
		/* si la bibliothèque n'est pas vide (donc que l'importation a eu lieu) 
		 et si l'erreur affichée n'est pas la bonne alors le test s'est mal passé */
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_est_vide=true;
		else
			biblio_est_vide=false;
		if (biblio_est_vide && MauvaisFormatException.test_exception.equals("Erreur ligne : 3")) {
			System.out.println("Test erreur fichier categorie: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test erreur fichier categorie: Echec");


		//Test d'importation d'une bibliothèque lorsque deux ids de livres sont identiques

		biblio=new Bibliotheque();
		try {
			 biblio=Bibliotheque.importe("fichier_erreur_id_identiques");
		} catch(Exception e){e.printStackTrace();} 
		/* Résultat attendu :
		 Erreur ligne 3 et la bibliothèque ne contient pas de livre */
		biblio.afficheLivres();
		/* si la bibliothèque n'est pas vide (donc que l'importation a eu lieu) 
		 et si l'erreur affichée n'est pas la bonne alors le test s'est mal passé */
		if (biblio.getTestAffichage().equals("0\n"))
			biblio_est_vide=true;
		else
			biblio_est_vide=false; 
		if (biblio_est_vide && MauvaisFormatException.test_exception.equals("Erreur ligne : 3")) {
			System.out.println("Test erreur fichier id_identiques: Réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test erreur fichier id_identiques: Echec");



		/* ------- Tests sur la classe Liste -------- */


		// Création d'un tableau de livre qui sera utilisé pour les différents tests
		Livre[] tableau_tests = new Livre[3];
		tableau_tests[0]=new Manga("manga_test_titre","manga_test_scenariste","manga_test_dessinateur");
		tableau_tests[1]=new Comics("comics_test_titre","comics_test_scenariste","comics_test_dessinateur");
		tableau_tests[2]=new Roman("titre_roman_test","auteur_roman_test");

		/*Test de suppression dans une liste vide:
		 Création d'une liste sans aucun élément, et on essaie de supprimer l'élement,
		 si la méthode "supprime" retourne false le test a fonctionné */
		 Liste liste = new Liste();
		 
		if( !liste.supprime("livre_inexistant")) {
			System.out.println("Test suppression sur liste vide : réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test suppression sur liste vide : echec");








		/*Test de suppression sur une liste contenant des éléments
		 On remplit la liste avec plusieurs élément, et on essaie de supprimer un élement,
		 si la méthode "supprime" retourne true le test a fonctionné */
		
		 //Remplissage de la liste
		 for(int i=0;i<tableau_tests.length;i++)
		 	liste.ajouter(tableau_tests[i]);
		 /* création de l'affichage attendu pour effectuer la vérification une fois la suppression
		 effectuée */
		 StringBuffer sbliste = new StringBuffer();
		 sbliste.append("2\n");
		 sbliste.append("Roman;32;titre_roman_test;auteur_roman_test\n");
		 sbliste.append("Manga;30;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		 // On effectue la suppression et on compare au résultat attendu
	


		 boolean suppression_reussie=liste.supprime("comics_test_titre");
	
	
		 if ( suppression_reussie && sbliste.toString().equals(liste.toString())) {
			System.out.println("Test suppression d'un élement : réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test suppression d'un élement : echec");



		





		/* Test de suppresion en tête de liste */

		 // création d'une nouvelle liste
		 liste=new Liste();
		 //remplissage de la liste
		 for(int i=0;i<tableau_tests.length;i++)
		 	liste.ajouter(tableau_tests[i]);
		 /* création de l'affichage attendu pour effectuer la vérification une fois la suppression
		 effectuée */
		sbliste=new StringBuffer();
		sbliste.append("2\n");
		sbliste.append("Comics;31;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		sbliste.append("Manga;30;manga_test_titre;manga_test_scenariste;manga_test_dessinateur\n");
		

		suppression_reussie = liste.supprime("titre_roman_test");

		 // test de la suppression en tête de liste et on compare au résultat attendu
		 if (suppression_reussie && sbliste.toString().equals(liste.toString())) {
			System.out.println("Test suppression d'un élement en tête de liste: réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test suppression d'un élement en tête de liste: echec");







		/* Test de suppresion en queue de liste */
		

		 // création d'une nouvelle liste
		 liste=new Liste();
		 for(int i=0;i<tableau_tests.length;i++)
		 	liste.ajouter(tableau_tests[i]);
		 

		
		 /* création de l'affichage attendu pour effectuer la vérification une fois la suppression
		 effectuée */
		sbliste=new StringBuffer();
		sbliste.append("2\n");
		sbliste.append("Roman;32;titre_roman_test;auteur_roman_test\n");
		sbliste.append("Comics;31;comics_test_titre;comics_test_scenariste;comics_test_dessinateur\n");
		
		 // test de la suppression en queue de liste et on compare la liste au résultat attendu
		suppression_reussie = liste.supprime("manga_test_titre");
		
		if (suppression_reussie && sbliste.toString().equals(liste.toString())) {
			System.out.println("Test suppression d'un élement en queue de liste : réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test suppression d'un élement en queue de liste : echec");
		






		/* test de suppression d'un élement dans une liste non vide qui ne comporte pas 
		 cet élement */

		 // création d'une nouvelle liste
		 liste=new Liste();
		 for(int i=0;i<tableau_tests.length;i++)
		 	liste.ajouter(tableau_tests[i]);

		 // test de la suppression avec élement inexistant
		 if (!liste.supprime("titre_indisponible")) {
			System.out.println("Test suppression d'un élement inexistant : réussi");
			nb_test_reussis++;
		}
		else
			System.out.println("Test suppression d'un élement inexistant : echec");

		System.out.println("Test réussis :"+nb_test_reussis+" sur 20");



	


	}
	
}