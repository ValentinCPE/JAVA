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
    //Map<Integer,Compte> compte = new TreeMap<>();
    Map<Integer,Compte> compte = new HashMap<>();
    List<Map> listeComptes = new ArrayList<>();
    
    Compte compte1 = new CompteBancaire(200,"1",100,10);
    Compte compte2 = new CompteEpargne(2000,"2",14000,1000);
    
    compte.put(Integer.valueOf(compte1.getNumero()), compte1);
    compte.put(Integer.valueOf(compte2.getNumero()), compte2);
    
    listeComptes.add(compte);
    
    Conteneur difcompte = new Conteneur(listeComptes);
    
    difcompte.sauvegarder("F-HASHMAP");
   }catch(IOException e){
       
   } 
  }
}
