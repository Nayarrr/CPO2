package Tournay.Rayan.dao;
import java.util.ArrayList;
import java.util.List;

import Tournay.Rayan.model.Auteur;
import Tournay.Rayan.model.Editeur;
import Tournay.Rayan.model.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BibliothequeDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BibliothequeDAO() {
        this.emf = Persistence.createEntityManagerFactory("bibliothequePU");
        this.em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void ajouterLivre(Livre livre) {
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
    }

    public void ajouterAuteur(Auteur auteur) {
        em.getTransaction().begin();
        em.persist(auteur);
        em.getTransaction().commit();
    }

    public void ajouterEditeur(Editeur editeur) {
        em.getTransaction().begin();
        em.persist(editeur);
        em.getTransaction().commit();
    }

    public void updateLivre(Livre livre) {
        em.getTransaction().begin();
        em.merge(livre);
        em.getTransaction().commit();
    }

    public Livre getLivreParId(int id) {
        return em.find(Livre.class, id);
    }

    public List<Livre> getTousLesLivres() {
        return em.createQuery("SELECT l FROM Livre l", Livre.class).getResultList();
    }

    public List<Livre> getLivreByTitre(String titre) {
        return em.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre", Livre.class)
                 .setParameter("titre", titre)
                 .getResultList();
    }

    public void deleteLivre(int id) {
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class, id);
        if (livre != null) {
            em.remove(livre);
        }
        em.getTransaction().commit();
    }

    public Auteur getAuteurParId(int id) {
        return em.find(Auteur.class, id);
    }

    public Auteur getAuteurAvecLivres(int auteurId) {
        em.getTransaction().begin();
        try {
            Auteur auteur = em.find(Auteur.class, auteurId);
            if (auteur != null) {
                // Force le chargement de la liste (à cause du LAZY loading)
                auteur.getLivres().size();
            }
            em.getTransaction().commit();
            return auteur;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public List<Livre> getLivresParAuteur(int auteurId) {
        try {
            return em.createQuery("SELECT l FROM Livre l WHERE l.auteur.id = :auteurId", Livre.class)
                     .setParameter("auteurId", auteurId)
                     .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // NOUVELLES MÉTHODES pour accéder aux livres d'un éditeur
    public Editeur getEditeurParId(int id) {
        return em.find(Editeur.class, id);
    }

    public Editeur getEditeurAvecLivres(int editeurId) {
        em.getTransaction().begin();
        try {
            Editeur editeur = em.find(Editeur.class, editeurId);
            if (editeur != null) {
                // Force le chargement de la liste (à cause du LAZY loading)
                editeur.getLivres().size();
            }
            em.getTransaction().commit();
            return editeur;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public List<Livre> getLivresParEditeur(int editeurId) {
        try {
            return em.createQuery("SELECT l FROM Livre l WHERE l.editeur.id = :editeurId", Livre.class)
                     .setParameter("editeurId", editeurId)
                     .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
