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
public class Par extends Projecteur{
    private String type;
    protected String par;
    
    public Par(int num,String mar,String ref,String typ){
        super(num,mar,ref);
        this.type = typ;
        this.par = "par";
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String typ){
        this.type = typ;
    }
    
    @Override
    public String toString(){
        return(super.toString()+"\nType de par: "+this.type);
    }
}
