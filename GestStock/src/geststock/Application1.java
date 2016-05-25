/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststock;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Valentin
 */
public class Application1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Projecteur premproj = new Projecteur(34622,"ADB","sourcefour");
        Projecteur deuxproj = new Projecteur(6666,"ADB","ledwash");
        Projecteur par = new Par(6666,"ADB","ledwash","64");
        Projecteur asser = new Asservi(7777,"ROBE","pointe","profil",1200);
        Projecteur par2 = new Par(8888,"ADB","ledwash","65");
        Stock stock = new Stock(100);
       
        stock.ajoutStock(par);
        stock.ajoutStock(asser);
        stock.ajoutStock(premproj);
        stock.ajoutStock(par2);
        
        List<Projecteur> Par = stock.collecPar();
        List<Projecteur> Asservi = stock.collecAsservi();    
        
         Iterator it = Par.iterator();
        
  /*      System.out.println("Par dans le stock: \n");
        for(int i = 0;i<Par.size();i++){
            System.out.println(Par.get(i).toString()+"\n");
        } */       
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("Asservi dans le stock: \n");
        for(int i = 0;i<Asservi.size();i++){
            System.out.println(Asservi.get(i).toString()+"\n");
        }
       
        /* System.out.println(premproj.toString()+"\n");
        System.out.println(deuxproj.toString()+"\n");
        System.out.println(par.toString()+"\n");
        System.out.println(asser.toString()+"\n"); */
    }
    
}
