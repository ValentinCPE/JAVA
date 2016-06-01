/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststock;

/**
 *
 * @author Valentin
 */
public class Asservi extends Projecteur{
    private String typeAsser;
    private int puissance;
    
    public Asservi(int num,String mar,String ref,String typ,int puiss){
        super(num,mar,ref);
        this.typeAsser = typ;
        this.puissance = puiss;
    }
    
    public String getTypeAsser(){
        return this.typeAsser;
    }
    
    public int getPuiss(){
        return this.puissance;
    }
    
    public void setTypeAsser(String m){
        this.typeAsser = m;
    }
    
    public void setPuiss(int m){
        this.puissance = m;
    }
    
    @Override
    public String toString(){
        return(super.toString()+"\nType d'asservi: "+this.typeAsser+" de puissance "+this.puissance);
    }
}
