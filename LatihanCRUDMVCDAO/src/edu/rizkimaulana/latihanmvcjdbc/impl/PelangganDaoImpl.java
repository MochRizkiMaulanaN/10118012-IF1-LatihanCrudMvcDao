/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.impl;

import edu.rizkimaulana.latihanmvcjdbc.entity.Pelanggan;
import edu.rizkimaulana.latihanmvcjdbc.error.PelangganException;
import edu.rizkimaulana.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PelangganDaoImpl implements PelangganDao{

    private Connection conn;
    private final String insertPelanggan = "INSERT INTO Pelanggan(nama,alamat,telepon,email) VALUES(?,?,?,?)"; 
    private final String updatePelanggan = "UPDATE Pelanggan SET nama=?,alamat=?,telepon=?,email=? WHERE id=?";
    private final String deletePelanggan = "DELETE FROM Pelanggan WHERE id=?";
    private final String getById = "SELECT * FROM Pelanggan WHERE id=?";
    private final String getByEmail = "SELECT * FROM Pelanggan WHERE email=?";
    private final String selectAll = "SELECT * FROM Pelanggan";

    public PelangganDaoImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.prepareStatement(insertPelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.executeUpdate();
            
            conn.commit();
            
        } catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
         PreparedStatement statement = null;
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setInt(5, pelanggan.getId());
            statement.executeUpdate();
            
             conn.commit();
             
        } catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    } 

    @Override
    public void deletePelanggan(int id) throws PelangganException {
         PreparedStatement statement = null;
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.prepareStatement(deletePelanggan);
            statement.setInt(1, id);
            statement.executeUpdate();
            
             conn.commit();
            
        } catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    }

    @Override
    public Pelanggan getPelanggan(int id) throws PelangganException {
         PreparedStatement statement = null;
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result= statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("id"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));
            }else{
                throw new PelangganException("Pelanggan Dengan Id "+id+" Tidak Ditemukan");
            }
            conn.commit();
            return pelanggan;
            
        } catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
         PreparedStatement statement = null;
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.prepareStatement(getByEmail);
            statement.setString(1, email);
            
            ResultSet result= statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("id"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));
            }else{
                throw new PelangganException("Pelanggan Dengan Email "+email+" Tidak Ditemukan");
            }
            conn.commit();
            return pelanggan;
            
        } catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        
        try {
            conn.setAutoCommit(false);
            
            statement = conn.createStatement();
            
            ResultSet result= statement.executeQuery(selectAll);
            Pelanggan pelanggan = null;
            
            while(result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("id"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));
                list.add(pelanggan);
            }
            conn.commit();
            return list;
            
        }catch (SQLException e) {
            
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            
            if (statement != null) {
                try {
                statement.close();
                } catch (SQLException e) {
                
                }
            }
            
            
        }
    }
    
}
