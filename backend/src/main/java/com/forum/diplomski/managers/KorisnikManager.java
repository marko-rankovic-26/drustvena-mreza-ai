/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.Korisnik;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
/**
 *
 * @author Slobodan
 */
public class KorisnikManager extends DBManager implements IKorisnikManager {

    @Override
    public Korisnik login(String korime, String lozinka) {
        Korisnik korisnik = null;
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.loginKorisnika(?, ?)");
            stat.setString(1, korime);
            stat.setString(2, lozinka);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {
                Integer korid = res.getInt("korid");
                String ime = res.getString("ime");
                String prezime = res.getString("prezime");
                String korisnickoIme = res.getString("korime");
                String korisnickaLozinka = res.getString("lozinka");
                String datumKor = formatter.format(res.getDate("datumKor"));
                
                // logika za pretvaranje prfilne iz niza bajtova u bajtovski string!!!!!!!!!1
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                korisnik = new Korisnik(korid, ime, prezime, korisnickoIme, korisnickaLozinka, datumKor, profilna);
            }
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return korisnik;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registracija(Korisnik korisnik) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec registracijaKorisnika ?, ?, ?, ?");
            stat.setString(1, korisnik.getIme());
            stat.setString(2, korisnik.getPrezime());
            stat.setString(3, korisnik.getKorime());
            stat.setString(4, korisnik.getLozinka());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Korisnik> vratiKorisnike() {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            Statement stat = conn.createStatement();
            
            ResultSet res = stat.executeQuery("select * from dbo.vratiKorisnike()");
            
            while (res.next()) {
                Integer korid = res.getInt("korid");
                String ime = res.getString("ime");
                String prezime = res.getString("prezime");
                String korime = res.getString("korime");
                String lozinka = res.getString("lozinka");
                String datumKor = formatter.format(res.getDate("datumKor"));
                
                // logika za pretvaranje prfilne iz niza bajtova u bajtovski string!!!!!!!!!1
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Korisnik korisnik = new Korisnik(korid, ime, prezime, korime, lozinka, datumKor, profilna);
                korisnici.add(korisnik);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return korisnici;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean obrisiKorisnika(int id) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec obrisiKorisnika ?");
            stat.setInt(1, id);
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniKorisnika(int id, Korisnik korisnik) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec izmeniKorisnika ?, ?, ?, ?, ?");
            stat.setInt(1, id);
            stat.setString(2, korisnik.getIme());
            stat.setString(3, korisnik.getPrezime());
            stat.setString(4, korisnik.getKorime());
            stat.setString(5, korisnik.getLozinka());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
