/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.dao;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import velov.modele.Station;

/**
 *
 * @author Valentin
 */
public interface IStationDAO {
    public abstract void setDataSource(DataSource ds);
    public abstract Connection getConnection();
    public abstract List<Station> getLesStations();
    public abstract void creerStation(Station s);
    public abstract void supprimerStation(String numStation);
    public abstract void quitter();
    public abstract void setConnection(Connection c);
    public abstract void modifStation(String numStation,String nomStation,Integer numArron,String loc,String numStationASuppr);
    public abstract boolean testerConnexion();
    public abstract boolean tableStationExiste();
    public abstract void creerTableStation();
    public abstract void supprTable();
}
