package Tournay.Rayan.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editeurs")
public class Editeur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nom_edition", nullable = false)
    private String nomEdition;

    // Relation bidirectionnelle - pas de colonne supplémentaire !
    @OneToMany(mappedBy = "editeur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livre> livres = new ArrayList<>();

    public Editeur() {
        this.livres = new ArrayList<>();
    }

    public Editeur(String nomEdition) {
        this.nomEdition = nomEdition;
        this.livres = new ArrayList<>();
    }

    // Getter pour les livres
    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    // Méthodes utilitaires pour gestion dynamique
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        livre.setEditeur(this);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
        livre.setEditeur(null);
    }
    
    public String getNomEdition() {
        return this.nomEdition;
    }

    public int getId() {
        return this.id;
    }

    public void setNomEdition(String nomEdition) {
        this.nomEdition = nomEdition;
    }

    @Override
    public String toString() {
        return nomEdition + " (" + livres.size() + " livre(s))";
    }
}