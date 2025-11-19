<<<<<<< HEAD
package Tournay.Rayan;
import Tournay.Rayan.model.*;
import Tournay.Rayan.dao.*;

public class App{
    public static void main( String[] args ){
        BibliothequeDAO biblioDAO = new BibliothequeDAO();

        Auteur auteur1 = new Auteur(1, "Hugo", "Victor");
        Editeur editeur1 = new Editeur(1, "Penguin Classics");
        Livre livre1 = new Livre("Les Misérables", auteur1, editeur1, false);

        Livre livreRecherche = biblioDAO.getLivreParId(livre1.getId());
        System.out.println("Livre recherché: " + livreRecherche.getTitre());
        livre1.setLu(true);

        Livre livre2 = new Livre("Les Travailleurs de la mer", auteur1 , editeur1, true);

        System.out.println("Tous les livres dans la bibliothèque:" + biblioDAO.getTousLesLivres());

        biblioDAO.deleteLivre(livre2.getId());

        biblioDAO.close();
    }
}
||||||| empty tree
=======
package Tournay.Rayan;
import java.time.LocalDate;
import java.util.List;

import Tournay.Rayan.dao.BibliothequeDAO;
import Tournay.Rayan.model.Auteur;
import Tournay.Rayan.model.Editeur;
import Tournay.Rayan.model.Genre;
import Tournay.Rayan.model.Livre;

public class App{
    public static void main( String[] args ){
        BibliothequeDAO biblioDAO = new BibliothequeDAO();

        Auteur auteur1 = new Auteur("Hugo", "Victor");
        Editeur editeur1 = new Editeur("Penguin Classics");
        
        biblioDAO.ajouterAuteur(auteur1);
        biblioDAO.ajouterEditeur(editeur1);
        
        Livre livre1 = new Livre("Les Misérables", auteur1, editeur1, false, LocalDate.of(1862, 3, 30), Genre.ROMAN);
        biblioDAO.ajouterLivre(livre1);

        Livre livreRecherche = biblioDAO.getLivreParId(livre1.getId());
        System.out.println("Livre recherché: " + livreRecherche.getTitre());
        
        livre1.setLu(true);

        Livre livre2 = new Livre("Les Travailleurs de la mer", auteur1, editeur1, true, LocalDate.of(1866, 1, 1), Genre.ROMAN);
        biblioDAO.ajouterLivre(livre2);

        System.out.println("Tous les livres dans la bibliothèque: " + biblioDAO.getTousLesLivres());
        
        // Récupérer l'auteur avec ses livres (relation bidirectionnelle)
        Auteur auteurAvecLivres = biblioDAO.getAuteurAvecLivres(1);
        if (auteurAvecLivres != null) {
            System.out.println("\nAuteur: " + auteurAvecLivres.getPrenom() + " " + auteurAvecLivres.getNom());
            System.out.println("Ses livres:");
            for (Livre livre : auteurAvecLivres.getLivres()) {
                System.out.println("- " + livre.getTitre() + " (" + livre.getGenre() + ")");
            }
        }
        
        // Alternative avec requête JPQL directe
        List<Livre> livresDeHugo = biblioDAO.getLivresParAuteur(1);
        System.out.println("\nLivres de Victor Hugo (via requête): " + livresDeHugo.size() + " livre(s)");
        
        // Tester les relations avec les éditeurs
        Editeur editeurAvecLivres = biblioDAO.getEditeurAvecLivres(1);
        if (editeurAvecLivres != null) {
            System.out.println("\nEditeur: " + editeurAvecLivres.getNomEdition());
            System.out.println("Livres publiés:");
            for (Livre livre : editeurAvecLivres.getLivres()) {
                System.out.println("- " + livre.getTitre() + " par " + livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom());
            }
        }
        
        // Alternative avec requête JPQL pour l'éditeur
        List<Livre> livresPenguin = biblioDAO.getLivresParEditeur(1);
        System.out.println("\nLivres de Penguin Classics (via requête): " + livresPenguin.size() + " livre(s)");
        
        biblioDAO.deleteLivre(livre2.getId());
        
        // Vérifier que les deux listes se mettent à jour après suppression
        List<Livre> livresApresSuppr = biblioDAO.getLivresParAuteur(1);
        List<Livre> livresEditeurApresSuppr = biblioDAO.getLivresParEditeur(1);
        System.out.println("Après suppression:");
        System.out.println("- Livres de Victor Hugo: " + livresApresSuppr.size() + " livre(s)");
        System.out.println("- Livres de Penguin Classics: " + livresEditeurApresSuppr.size() + " livre(s)");

        biblioDAO.close();
    }
}
>>>>>>> c6b215e522f19c701d9e9a166ee12abebab1d2dd
