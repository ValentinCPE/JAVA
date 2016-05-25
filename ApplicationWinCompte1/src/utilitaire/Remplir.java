/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author valentin
 */
public class Remplir<K,V extends Serializable> {
    Map<K,V> compte = new TreeMap<>();
    
}
