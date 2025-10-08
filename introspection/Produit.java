public abstract class Produit{
    private String reference,designation;

    private double prixHT;

    public Produit(){}

    public Produit(String r,String d,double p){
        reference=r; designation=d; prixHT=p;}

    public String getReference(){return reference;}

    public void setReference(String r){reference=r;}

    public String getDesignation(){return designation;}

    public void setDesignation(String d){designation=d;}

    public double getPrixHT(){return prixHT;}

    public void setPrixHT(double p){prixHT=p;}

    abstract public double leprixTTC();

    public String infos(){return getReference()+" "+ getDesignation()+" "+leprixTTC();}
}