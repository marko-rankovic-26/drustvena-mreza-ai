/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.Tema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public class TemaManager extends DBManager implements ITemaManager{

    @Override
    public ArrayList<Tema> vratiSveTeme() {
        ArrayList<Tema> teme = new ArrayList<Tema>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), 
                                                         this.getDBUsername(), 
                                                      this.getDBPassword());
            
            Statement stat = conn.createStatement();
            
            ResultSet res = stat.executeQuery("select * from dbo.vratiTeme()");
            
            while (res.next()) {
                Integer id = res.getInt("temaid");
                String naziv = res.getString("naziv");
                
                Tema tema = new Tema(id, naziv);
                teme.add(tema);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return teme;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tema vratiTemu(int id) {
        Tema tema = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareStatement("select * from dbo.vratiTemu(?)");
            stat.setInt(1, id);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {
                Integer temaid = res.getInt("temaid");
                String naziv = res.getString("naziv");
                
                tema = new Tema(temaid, naziv);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return tema;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean dodajTemu(Tema tema) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareStatement("exec dodajTemu ?");
            stat.setString(1, tema.getNaziv());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean obrisiTemu(int id) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareStatement("exec obrisiTemu ?");
            stat.setInt(1, id);
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniTemu(int id, Tema tema) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareStatement("exec izmeniTemu ?, ?");
            stat.setInt(1, id);
            stat.setString(2, tema.getNaziv());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
