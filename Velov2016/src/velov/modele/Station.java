/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.modele;

/**
 *
 * @author Valentin
 */
public class Station {
    private String numeroIdentification;
    private String nomStation;
    private String localisationStation;
    private Integer numeroArrondissementVille;
    
    public Station(){
    }
    
    public Station(String num,String nom,String loc,Integer numarrond){
        this.numeroIdentification = num;
        this.nomStation = nom;
        this.localisationStation = loc;
        this.numeroArrondissementVille = numarrond;
    }
    
    public String getNumeroIdentification(){
        return this.numeroIdentification;
    }
    
    public String getNomStation(){
        return this.nomStation;
    }
    
    public String getlocalisationStation(){
        return this.localisationStation;
    }
    
    public Integer getNumeroArrondissementVille(){
        return this.numeroArrondissementVille;
    }
    
    public void setNumStation(String num){
        this.numeroIdentification = num;
    }
    
    public void setNomStation(String nom){
        this.nomStation = nom;
    }
    
    public void setLocalisation(String loc){
        this.localisationStation = loc;
    }
    
    public void setNumArrondissement(Integer num){
        this.numeroArrondissementVille = num;
    }
}
