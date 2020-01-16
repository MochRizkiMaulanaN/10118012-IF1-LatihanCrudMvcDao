/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.main;



import edu.rizkimaulana.latihanmvcjdbc.database.KingsBarberShopDatabase;
import edu.rizkimaulana.latihanmvcjdbc.entity.Pelanggan;
import edu.rizkimaulana.latihanmvcjdbc.error.PelangganException;
import edu.rizkimaulana.latihanmvcjdbc.service.PelangganDao;

import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
       PelangganDao Dao = KingsBarberShopDatabase.getPelangganDao();
       
       Dao.deletePelanggan(3);
    }
    
}
