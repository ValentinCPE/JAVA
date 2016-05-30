package utilitaire;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p1505332
 */
public class Conteneur<V extends Serializable> {

    private static int indiceCourant;
    private List<V> lesValeurs;
    
    public Conteneur(){
        lesValeurs = null;
        indiceCourant = -1;
    }
    
    public Conteneur(List<V> m){
        if(m != null){
        this.lesValeurs = m;
        indiceCourant=0;
        }
    }
   
    public void charger(String nomFic) throws IOException, ClassNotFoundException{
        ObjectInputStream ofic = new ObjectInputStream(
                                                    new FileInputStream(
                                                            new File(nomFic)));
        lesValeurs = (List<V>) ofic.readObject();
        if(lesValeurs != null && !lesValeurs.isEmpty()){
        indiceCourant = 0;
        }
    }
    
    public void premier(){
        if(!estVide()){
           indiceCourant = 0;
        }
    }
    
    public void dernier(){
       if(!estVide()) {
       indiceCourant = lesValeurs.size()-1;
       }else{
           indiceCourant = 0;
       }
    }
    
    public boolean estVide(){
        if(this.lesValeurs.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public int nbElements(){
        return this.lesValeurs.size();
    }
    
    public void suivant(){
        if(indiceCourant != nbElements() - 1){
            indiceCourant ++;
        }
    }
    
    public void precedent(){
        if(indiceCourant!=0){
            indiceCourant --;
        }
    }
    
    public void sauvegarder(String nomFic) throws IOException{
        ObjectOutputStream ofic = new ObjectOutputStream(
                                                         new FileOutputStream(
                                                            new File(nomFic)));
        ofic.writeObject(lesValeurs);
    }
    
    public V obtenir(){
        return lesValeurs.get(indiceCourant);
    }
    
    public void vider(){
        if(nbElements()>0){
        lesValeurs.clear();
        }
    }
    
}
