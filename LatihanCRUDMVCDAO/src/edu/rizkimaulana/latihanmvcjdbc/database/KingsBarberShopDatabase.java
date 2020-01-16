/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.rizkimaulana.latihanmvcjdbc.impl.PelangganDaoImpl;
import edu.rizkimaulana.latihanmvcjdbc.service.PelangganDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class KingsBarberShopDatabase {
    
    private static Connection conn;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException{
    
            
        if (conn == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            conn = dataSource.getConnection();
        }
        return  conn;
    }
    
    public static PelangganDao getPelangganDao() throws SQLException{
        
        if (pelangganDao == null) {
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        
        return pelangganDao;
    }
}
 