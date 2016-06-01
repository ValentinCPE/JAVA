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
public class CompteBancaire extends Compte{
    private float decouvertMax;
    private float tauxAgios;
    
    public CompteBancaire(float montant,String numero,float dec, float agio){
        super(montant,numero);
        this.decouvertMax = dec;
        this.tauxAgios = agio;
    }
    
    @Override
    public String toString(){
        return ("num: "+this.numeroCompte+"\nsolde: "+this.soldeCompte+"\ndate d'ouverture: "+this.dateOuverture+"\ndécouvert max autorisé: "+this.decouvertMax+"\ntaux d'agios: "+this.tauxAgios);
    }
 

    @Override
    public void debiter(float m){
     try{   
        if(m <= (this.decouvertMax + this.soldeCompte)){
            this.soldeCompte = this.soldeCompte - m;
        }else{
            throw new Compte.Erreur(String.valueOf(m));
        }
        }catch(Compte.Erreur e) {
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public void crediter(float m){
      this.soldeCompte = this.soldeCompte + m;  
    }
       
    public float getDecouvertMax(){
        return this.decouvertMax;
    }
    
    public float getTauxAgios(){
        return this.tauxAgios;
    }
}
