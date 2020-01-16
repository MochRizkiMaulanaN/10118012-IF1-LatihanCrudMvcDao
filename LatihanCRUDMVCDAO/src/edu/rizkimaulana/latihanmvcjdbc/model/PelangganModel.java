/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.model;

import edu.rizkimaulana.latihanmvcjdbc.database.KingsBarberShopDatabase;
import edu.rizkimaulana.latihanmvcjdbc.entity.Pelanggan;
import edu.rizkimaulana.latihanmvcjdbc.error.PelangganException;
import edu.rizkimaulana.latihanmvcjdbc.event.PelangganListener;
import edu.rizkimaulana.latihanmvcjdbc.service.PelangganDao;
import java.sql.SQLException;



/**
 *
 * @author LENOVO
 */
public class PelangganModel{
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    private PelangganListener Listener;

    public PelangganListener getListener() {
        return Listener;
    }

    public void setListener(PelangganListener Listener) {
        this.Listener = Listener;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if (Listener != null) {
            Listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pelanggan pelanggan){
        if (Listener != null) {
            Listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnDelete(){
        if (Listener != null) {
            Listener.onDelete();
        }
    }
    
    protected void fireOnUpdate(Pelanggan pelanggan){
        if (Listener != null) {
            Listener.onUpdate(pelanggan);
        }
    }
    
    public void insertPelanggan()throws SQLException, PelangganException{
        PelangganDao Dao = KingsBarberShopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        
        pelanggan.setNama(nama);
        pelanggan.setNama(alamat);
        pelanggan.setNama(telepon);
        pelanggan.setNama(email);
        
        Dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }
    
     public void updatePelanggan()throws SQLException, PelangganException{
        PelangganDao Dao = KingsBarberShopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        
        pelanggan.setNama(nama);
        pelanggan.setNama(alamat);
        pelanggan.setNama(telepon);
        pelanggan.setNama(email);
        pelanggan.setId(id);
        
        Dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
     
     public void deletePelanggan()throws SQLException, PelangganException{
        PelangganDao Dao = KingsBarberShopDatabase.getPelangganDao();
        Dao.deletePelanggan(id);
        fireOnDelete();
    }
    
    public void resetPelanggan(){
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    }
   
  
}
