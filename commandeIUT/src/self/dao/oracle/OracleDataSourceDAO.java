/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.dao.oracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Valentin
 */
public class OracleDataSourceDAO extends OracleDataSource{
    private static OracleDataSourceDAO ods;
    
    private OracleDataSourceDAO() throws SQLException{
    }
    
    public static OracleDataSourceDAO getOracleDataSourceDAO(){
        FileInputStream fichier = null;
        try{
            Properties props = new Properties();
            fichier = new FileInputStream(".\\src\\velov\\dao\\oracle\\connexion.properties");
            props.load(fichier);
            ods = new OracleDataSourceDAO();
            ods.setDriverType(props.getProperty("pilote"));
            ods.setPortNumber(new Integer(props.getProperty("port")));
            ods.setServiceName(props.getProperty("service"));
            ods.setUser(props.getProperty("user"));
            ods.setPassword(props.getProperty("pwd"));
            ods.setServerName(props.getProperty("serveur"));
          } catch (IOException | SQLException ex) {
                System.err.println(ex.getMessage());
        }finally{
            try{
                fichier.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return ods;
    }
}
