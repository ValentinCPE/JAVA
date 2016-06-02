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
    
    public Station(String num,String nom,String loc,Integer numarrond){
        this.numeroIdentification = num;
        this.nomStation = nom;
        this.localisationStation = loc;
        this.numeroArrondissementVille = numarrond;
    }
}
