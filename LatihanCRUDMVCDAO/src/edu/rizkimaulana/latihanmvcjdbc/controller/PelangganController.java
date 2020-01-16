/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.controller;


import edu.rizkimaulana.latihanmvcjdbc.model.PelangganModel;
import edu.rizkimaulana.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        
        String nama= view.getTxtNAMA().getText();
        String alamat= view.getTxtALAMAT().getText();
        String telepon= view.getTxtTELEPON().getText();
        String email= view.getTxtEMAIL().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        }else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh lebih dari 255 karakter");
        }else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "No telepon Tidak Boleh lebih dari 12 karakter");
        }else if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        }else{
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Data Berhasil disimpan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan",throwable.getMessage()});
            }
        }
                
        
    }
    
    public void updatePelanggan(PelangganView view){
        
        if (view.getTblPelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang akan Di ubah");
            return;
        }
        
        int id = Integer.parseInt(view.getTxtID().getText());
        String nama= view.getTxtNAMA().getText();
        String alamat= view.getTxtALAMAT().getText();
        String telepon= view.getTxtTELEPON().getText();
        String email= view.getTxtEMAIL().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        }else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh lebih dari 255 karakter");
        }else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "No telepon Tidak Boleh lebih dari 12 karakter");
        }else if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        }else{
            
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Data Berhasil di ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan",throwable.getMessage()});
            }
        }
        
    }
    
    public void deletePelanggan(PelangganView view){
        
         if (view.getTblPelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang akan Di Hapus");
            return;
            
        }
         
         if (JOptionPane.showConfirmDialog(view, "Anda Yakin Ingin Mengahapus") == JOptionPane.OK_OPTION) {
             int id =Integer.parseInt(view.getTxtID().getText());
             model.setId(id);
             
              try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data Berhasil di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan",throwable.getMessage()});
            }
            
        }
    }
}
