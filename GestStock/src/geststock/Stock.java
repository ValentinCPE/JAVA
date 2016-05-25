/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststock;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Valentin
 */
public class Stock {
    private List<Projecteur> stock;
    
    public Stock(){
        stock = new ArrayList<>();
    }
    
    public Stock(int m){
        stock = new ArrayList<>(m);
    }
    
    public void ajoutStock(Projecteur p){
        stock.add(p);
    }
    
    public void enlevStock(Projecteur p) {
        stock.remove(p);
    }
    
    public List<Projecteur> collecPar(){
        List<Projecteur> collec = new ArrayList<>();
        for(int i = 0;i<this.stock.size();i++){
            if(this.stock.get(i).getClass().getName().contains("Par")){
                collec.add(this.stock.get(i));
            }else{
                
            }
        }
        return collec;
    }
    
    public List<Projecteur> collecAsservi(){
        List<Projecteur> collec = new ArrayList<>();
        for(int i = 0;i<this.stock.size();i++){
            if(this.stock.get(i).getClass().getName().contains("Asservi")){
                collec.add(this.stock.get(i));
            }else{
                
            }
        }
        return collec;
    }
}
