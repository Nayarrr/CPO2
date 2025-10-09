package tpAnnotETIntro.src.Factoring;

@OpFactoring(nomP = "leBoss", nomRefact = RefactoringName.extractClass, commentaire = "Extraction class adresse", isEclipse = false, nbrCas = 1)
public class Personne {
public Personne (String nom,int age,int numrue,String nomrue,
    String ville,int codepostale){
            this.NomComplet = nom ;
            this.Age = age ;
            this.NumRue = numrue ;
            this.NomRue = nomrue ;
            this.Ville = ville ;
            this.CodePostale = codepostale ; 
    }

    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public String NomComplet ;

    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public int Age ;

    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public int NumRue ;

    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public String NomRue ;

    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public String Ville ;
    
    @OpFactoring(nomP = "Nayarr",nomRefact = RefactoringName.encapsulatedField, commentaire =  "Passe en PV", isEclipse = false, nbrCas = 1)
    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule tes atributs bg de la night", isEclipse = false, nbrCas = 1)
    public int CodePostale ;

    @OpFactoring(nomP = "Rayou",nomRefact = RefactoringName.rename, commentaire =  "Mets en minuscule ta méthode bg de la night", isEclipse = false, nbrCas = 1)
    public void AfficherAdresse(){
        System.out.println("Numero de rue : "+NumRue);
        System.out.println("Nom de la rue : "+NomRue);
        System.out.println("Nom de la ville : "+Ville);
        System.out.println("CodePostale : "+CodePostale);
    }
}