/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geststock;

import java.util.List;

/**
 *
 * @author Valentin
 */
public class Projecteur {
    private float numeroProj;
    protected int numSer;
    protected String marque;
    protected String reference;
    private static int dernierNum = 1;
    
    public Projecteur(int num,String mar,String ref){
        this.marque = mar;
        this.numSer = num;
        this.reference = ref;
        this.numeroProj = dernierNum ++;
        
    }
    
    public float getNumProj(){
        return this.numeroProj;
    }
    
    public int getNumSer(){
        return this.numSer;
    }
    
    public String getMarque(){
        return this.marque;
    }
    
    public String getReference(){
        return this.reference;
    }
    
    public void setNumProj(float v){
        this.numeroProj = v;
    }
    
    public void setNumSer(int num){
        this.numSer = num;
    }
    
    public void setMarque(String mar){
        this.marque = mar;
    }
    
    public void setReference(String ref){
        this.reference = ref;
    }
    
    @Override
    public String toString(){
        return ("Projecteur numéro: "+this.numeroProj+"\nN°série: "+this.numSer+"\nMarque: "+this.marque+"\nRéférence: "+this.reference);
    }
}
