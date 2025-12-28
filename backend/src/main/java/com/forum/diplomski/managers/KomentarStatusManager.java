/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.KomentarStatus;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Slobodan
 */
public class KomentarStatusManager extends DBManager implements IKomentarStatusManager {

    @Override
    public ArrayList<KomentarStatus> vratiStatuseKomentar() {
        ArrayList<KomentarStatus> statusi = new ArrayList<KomentarStatus>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            Statement stat = conn.createStatement();
            
            ResultSet res = stat.executeQuery("select * from KomentarStatus");
            
            while (res.next()) {                
                int komstatid = res.getInt("komstatid");
                int komid = res.getInt("komid");
                int korid = res.getInt("korid");
                boolean status = this.convertToBoolean(res.getInt("komstat"));
                
                KomentarStatus komentarStatus = new KomentarStatus(komstatid, korid, komid, status);
                statusi.add(komentarStatus);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return statusi;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean dodajStatusKomentaru(int komid, KomentarStatus komentarStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec dodajKomStat ?, ?, ?");
            stat.setInt(1, komid);
            stat.setInt(2, komentarStatus.getKorid());
            stat.setBoolean(3, komentarStatus.getStatus());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean obrisiStatusKomentaru(int komid, KomentarStatus komentarStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec obrisiStatusKom ?, ?");
            stat.setInt(1, komid);
            stat.setInt(2, komentarStatus.getKorid());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniStatusKomentaru(int komid, KomentarStatus komentarStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec izmeniStatusKom ?, ?, ?");
            stat.setInt(1, komid);
            stat.setInt(2, komentarStatus.getKorid());
            stat.setBoolean(3, komentarStatus.getStatus());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
