/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Valentin
 */
public class CompteEpargne extends Compte{
    private float plafondMax;
    private float tauxRemuneration;
    
    public CompteEpargne(float montant,String numero,float plafond, float taux){
        super(montant,numero);
        this.plafondMax = plafond;
        this.tauxRemuneration = taux;
    }
    
    @Override
    public String toString(){
        return ("num: "+this.numeroCompte+"\nsolde: "+this.soldeCompte+"\ndate d'ouverture: "+this.dateOuverture+"\nplafond max autorisé: "+this.plafondMax+"\ntaux rémunération: "+this.tauxRemuneration);

    }
    
    @Override
    public void debiter(float m){
      try{
          if(m <= this.soldeCompte){
              this.soldeCompte = this.soldeCompte - m;
          }else{
              throw new Compte.Erreur(String.valueOf(m));
          }
      }catch(Compte.Erreur e){
          System.err.println(e.getMessage());
      }
    }
    
    @Override
    public void crediter(float m) {
        try{
          if(m + this.soldeCompte > this.plafondMax){
              throw new Compte.Erreur(String.valueOf(m));
          }else{
              this.soldeCompte = this.soldeCompte + m;
          }
      }catch(Compte.Erreur e){
          System.err.println(e.getMessage());
      }
    }
    
    
    public float getPlafondMax(){
        return this.plafondMax;
    }
    
    public float getTauxRemuneration(){
        return this.tauxRemuneration;
    }
    
}
