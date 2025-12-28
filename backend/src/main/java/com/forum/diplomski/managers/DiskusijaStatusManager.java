/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.DiskusijaStatus;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public class DiskusijaStatusManager extends DBManager implements IDiskusijaStatusManager {

    @Override
    public ArrayList<DiskusijaStatus> vratiStatuseDiskusija() {
        ArrayList<DiskusijaStatus> statusi = new ArrayList<DiskusijaStatus>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            Statement stat = conn.createStatement();
            
            ResultSet res = stat.executeQuery("select * from DiskusijaStatus");
            
            while (res.next()) {                
                int diskstatid = res.getInt("diskstatid");
                int diskid = res.getInt("diskid");
                int korid = res.getInt("korid");
                boolean status = this.convertToBoolean(res.getInt("diskstat"));
                
                DiskusijaStatus diskusijaStatus = new DiskusijaStatus(diskstatid, korid, diskid, status);
                statusi.add(diskusijaStatus);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return statusi;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean dodajStatusDiskusiji(int diskid, DiskusijaStatus diskusijaStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec dodajDiskStat ?, ?, ?");
            stat.setInt(1, diskid);
            stat.setInt(2, diskusijaStatus.getKorid());
            stat.setBoolean(3, diskusijaStatus.getStatus());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean obrisiStatusDiskusije(int diskid, DiskusijaStatus diskusijaStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec obrisiStatusDisk ?, ?");
            stat.setInt(1, diskid);
            stat.setInt(2, diskusijaStatus.getKorid());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniStatusDiskusije(int diskid, DiskusijaStatus diskusijaStatus) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec izmeniStatusDisk ?, ?, ?");
            stat.setInt(1, diskid);
            stat.setInt(2, diskusijaStatus.getKorid());
            stat.setBoolean(3, diskusijaStatus.getStatus());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
