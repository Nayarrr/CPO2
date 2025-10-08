class Livre extends ProduitTNormal{ 
    public String editeur;
    public Livre(){}
    public Livre(String r,String d,double p,String e)
        {super(r,d,p);editeur=e;}
    public String getEditeur(){return editeur;}
    public void setEditeur(String e){editeur=e;}
    public String infos(){return super.infos()+" "+getEditeur();}
}