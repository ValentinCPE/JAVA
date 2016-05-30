/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import modele.Compte;
import modele.CompteBancaire;
import modele.CompteEpargne;
import utilitaire.Conteneur;
import vue.Fenetre;

/**
 *
 * @author Valentin
 */
public class Consulter {
   public static void main(String[] args){     
   Conteneur<Compte> cont = new Conteneur<>();
      Fenetre fen = new Fenetre(cont);
   fen.setVisible(true);
  }
}   
