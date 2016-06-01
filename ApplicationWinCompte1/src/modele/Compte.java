/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import static java.time.LocalDate.now;

/**
 *
 * @author Valentin
 */
public abstract class Compte implements Serializable{
    protected String numeroCompte;
    protected float soldeCompte;
    protected String dateOuverture;
    private static int dernierNumeroAttribue = 0;
    
    public Compte(float montant,String numeroClient){
        ++ dernierNumeroAttribue;
        this.soldeCompte = montant;
        this.numeroCompte = String.valueOf(dernierNumeroAttribue);
        this.dateOuverture = String.valueOf(now());
    }
    
    public String getNumero(){
        return this.numeroCompte;
    }
    
    public float getSolde(){
        return this.soldeCompte;
    }
    
    public String getDateOuverture(){
        return this.dateOuverture;
    }
    
    @Override
    public abstract String toString();
    public abstract void crediter(float m);
    public abstract void debiter(float m);
        

    public class Erreur extends Exception{
        private String mesg;
        
        public Erreur(String s){
            mesg = s;
        }
        
        @Override
        public String getMessage(){
            return this.mesg+" : Valeur impossible";
        }
     }
}

    