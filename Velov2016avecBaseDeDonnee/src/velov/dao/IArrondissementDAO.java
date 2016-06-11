/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.dao;

import java.sql.Connection;
import java.util.List;
import javax.activation.DataSource;
import velov.modele.ArrondissementVille;

/**
 *
 * @author Valentin
 */
public interface IArrondissementDAO {
    public abstract void setDataSource(DataSource ds);
    public abstract Connection getConnection(DataSource s);
    public abstract List<ArrondissementVille> listeDesArrondissements();
    }
