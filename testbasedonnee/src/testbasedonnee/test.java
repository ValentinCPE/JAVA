/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbasedonnee;

/**
 *
 * @author Valentin
 */
public class test {
    public static void main(String[] args){
    String sdf = "8b8";
if(!sdf.matches("[a-zA-Z]+")){
	System.out.println("correct");
}else{
	System.out.println("incorrect");
}
    }
}
