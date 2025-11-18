package Tournay.Rayan.dao;
import java.util.List;
import Tournay.Rayan.model.*;
import jakarta.persistence.*;

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
}