/*
 * Exemple simple d'accès à une base de données Oracle
 *
 * On utilise le driver THIN d'Oracle.
 */

package testbasedonnee;

import java.sql.*;
import java.util.*;
import java.text.*; // pour formater la date

/**
 *
 * @author aelkhan
 */
public class Testbasedonnee  {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) 
            throws SQLException, ClassNotFoundException 
    {
        // Charge le driver
    Class.forName ("oracle.jdbc.OracleDriver");
    // Connexion à la base
    // Exemple à ne pas suivre : les informations de connexion sont en dur
    Connection conn =
    DriverManager.getConnection ("jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl", "p1500515", "239307");
				   
	// Creation et execution d'un ordre SQL
    Statement stmt = conn.createStatement ();
    ResultSet rset = stmt.executeQuery ("SELECT ename, hiredate FROM emp ORDER BY ename");
    
    
    // Juste pour le plaisir de tester un bug du driver Oracle : le nom de la table est vide
    System.out.println("Nom de la table : " + rset.getMetaData().getTableName(1));
    System.out.println("Type de la colonne  : " + rset.getMetaData().getColumnType(1));
    System.out.println("Nom de la colonne : " + rset.getMetaData().getColumnName(1));
    
    
    // Récupère les données
    while (rset.next()) 
    {
      System.out.println(rset.getString(1));
    } 
       
      // Mise en forme de la date
      java.sql.Date datemb = rset.getDate(2);
      System.out.println(datemb.toString());
    }
     /* if (! rset.wasNull()) 
      {
	// Un peu d'exercice sur les dates en français ne fait pas de mal...
        String datembF = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.FRANCE).format(datemb);
	SimpleDateFormat formateur = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.FRANCE);
	formateur.applyPattern("MMMM"); // configure le formateur pour avoir
	                                // le mois en lettres (avec plus de
	                                // 3 lettres (car plus de 3 M)
	String mois = formateur.format(datemb);
	System.out.println(" embauché le : " + datembF);
	System.out.println("Au mois de " + mois);
      }
      else
	System.out.println();
    }

    // Modification d'une date d'embauche pour tester la syntaxe spéciale
    int nbLignesModifiees = stmt.executeUpdate ("UPDATE emp "
					 + "SET hiredate = {d '2014-01-22'}"
					 + "WHERE ename = 'SMITH'");
    System.out.println(nbLignesModifiees + " lignes modifiees");
    
    rset = stmt.executeQuery ("SELECT nome, datemb FROM emp "
					+ "WHERE nome = 'SMITH'"
					+ "ORDER BY ename");
    rset.next();
    System.out.println("SMITH a ete embauche le " + rset.getDate(2));

    }
*/
    
}
