/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import modele.Compte;
import modele.CompteBancaire;
import modele.CompteEpargne;

/**
 *
 * @author valentin
 *
 */
public class Remplir{
   public static void main(String[] args){ 
   try{    
    Map<Integer,Compte> compte = new TreeMap<>();
    // Map<Integer,Compte> compte = new HashMap<>();
    
    Compte compte1 = new CompteBancaire(200,"1",100,10);
    Compte compte2 = new CompteEpargne(2000,"2",14000,1000);
    Compte compte3 = new CompteEpargne(100000,"3",56,100);
    Compte compte4 = new CompteBancaire(3450,"38",3500,10);
    
    compte.put(Integer.valueOf(compte1.getNumero()), compte1);
    compte.put(Integer.valueOf(compte2.getNumero()), compte2);
    compte.put(Integer.valueOf(compte3.getNumero()), compte3);
    compte.put(Integer.valueOf(compte4.getNumero()), compte4);
    
    
    
    Conteneur difcompte = new Conteneur(new ArrayList<>(compte.values()));
    
    difcompte.sauvegarder("F-TREEMAP");
   }catch(IOException e){
       
   } 
  }
}
