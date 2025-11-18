public class ProduitTNormal extends Produit{ 
    public ProduitTNormal(){}
    public ProduitTNormal(String r,String d,double p)
        {super(r,d,p);}
    public double leprixTTC()
        {return getPrixHT() * 1.196;}
}