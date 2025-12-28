/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.Diskusija;
import com.forum.diplomski.data.Komentar;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
/**
 *
 * @author Slobodan
 */
public class DiskusijaManager extends DBManager implements IDiskusijaManager{

    @Override
    public ArrayList<Diskusija> vratiDiskusijeInfo(int korid) {
        ArrayList<Diskusija> diskusije = new ArrayList<Diskusija>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiDiskusijeInfo(?)");
            stat.setInt(1, korid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int diskid = res.getInt("diskid");
                int temaid = res.getInt("temaid");
                int korisnikid = res.getInt("korid");
                String tema = res.getString("tema");
                String korime = res.getString("korime");
                String naslov = res.getString("naslov");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumDisk"));
                int brojkom = res.getInt("brojkom");
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                // logika za profilnu/sliku/lajkovana diskusija!!!!!!!!!
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String slika = res.getString("slika");
                if(res.wasNull())
                    slika = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Diskusija diskusija = new Diskusija(diskid, temaid, korisnikid, tema, korime, naslov, tekst, datum, profilna, slika, brojkom, lajkovi, dislajkovi, lajkovan);
                diskusije.add(diskusija);
            }
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return diskusije;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Diskusija vratiDiskusijuInfo(int korid, int diskid) {
        Diskusija diskusija = null;
        KomentarManager km = new KomentarManager();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiDiskusijuInfo(?, ?)");
            stat.setInt(1, diskid);
            stat.setInt(2, korid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int diskusijaid = res.getInt("diskid");
                int temaid = res.getInt("temaid");
                int korisnikid = res.getInt("korid");
                String tema = res.getString("tema");
                String korime = res.getString("korime");
                String naslov = res.getString("naslov");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumDisk"));
                int brojkom = res.getInt("brojkom");
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                // logika za profilnu/sliku/lajkovana diskusija!!!!!!!!!
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String slika = res.getString("slika");
                if(res.wasNull())
                    slika = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                diskusija = new Diskusija(diskusijaid, temaid, korid, tema, korime, naslov, tekst, datum, profilna, slika, brojkom, lajkovi, dislajkovi, lajkovan);
            }
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        ArrayList<Komentar> komentari = km.vratiStabloKomentar(diskid, korid);
        diskusija.dodajKomentare(komentari);
        
        return diskusija;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean dodajDiskusijuInfo(Diskusija diskusija) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec dodajDiskusiju ?, ?, ?, ?, ?");
            stat.setInt(1, diskusija.getTemaid());
            stat.setInt(2, diskusija.getKorid());
            stat.setString(3, diskusija.getNaslov());
            stat.setString(4, diskusija.getTekst());
            
            if(diskusija.getSlika() == null)
                stat.setNull(5, java.sql.Types.VARCHAR);
            else
                stat.setString(5, diskusija.getSlika());
            
            rez = stat.execute();
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izbrisiDiskusijuInfo(int diskid) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec obrisiDiskusiju ?");
            stat.setInt(1, diskid);
            
            rez = stat.execute();
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniDiskusijuInfo(Diskusija diskusija) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec izmeniDiskusiju ?, ?, ?, ?, ?");
            stat.setInt(1, diskusija.getId());
            stat.setInt(2, diskusija.getTemaid());
            stat.setString(3, diskusija.getNaslov());
            stat.setString(4, diskusija.getTekst());
            
            if(diskusija.getSlika() == null)
                stat.setNull(5, java.sql.Types.VARCHAR);
            else
                stat.setString(5, diskusija.getSlika());
            
            rez = stat.execute();
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer brojStrana(int pageSize) {
        Integer str = 0;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select dbo.brojStranica(?) as stranice");
            stat.setInt(1, pageSize);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                Integer brStr = res.getInt("stranice");
                if(res.wasNull())
                    str = 0;
                
                str = brStr;
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return str;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Diskusija> vratiStrDiskusije(int pageIndex, int pageSize, int korid) {
        ArrayList<Diskusija> diskusije = new ArrayList<Diskusija>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiStrDiskusije(?, ?, ?)");
            stat.setInt(1, pageIndex);
            stat.setInt(2, pageSize);
            stat.setInt(3, korid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int diskid = res.getInt("diskid");
                int temaid = res.getInt("temaid");
                int korisnikid = res.getInt("korid");
                String tema = res.getString("tema");
                String korime = res.getString("korime");
                String naslov = res.getString("naslov");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumDisk"));
                int brojkom = res.getInt("brojkom");
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                // logika za profilnu/sliku/lajkovana diskusija!!!!!!!!!
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String slika = res.getString("slika");
                if(res.wasNull())
                    slika = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Diskusija diskusija = new Diskusija(diskid, temaid, korisnikid, tema, korime, naslov, tekst, datum, profilna, slika, brojkom, lajkovi, dislajkovi, lajkovan);
                diskusije.add(diskusija);
            }
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return diskusije;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public ArrayList<Diskusija> vratiDiskusijeInfoPoTemi(int korid, int temaid) {
        ArrayList<Diskusija> diskusije = new ArrayList<Diskusija>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiDiskusijeInfoPoTemi(?, ?)");
            stat.setInt(1, temaid);
            stat.setInt(2, korid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int diskid = res.getInt("diskid");
                int idteme = res.getInt("temaid");
                int korisnikid = res.getInt("korid");
                String tema = res.getString("tema");
                String korime = res.getString("korime");
                String naslov = res.getString("naslov");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumDisk"));
                int brojkom = res.getInt("brojkom");
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                // logika za profilnu/sliku/lajkovana diskusija!!!!!!!!!
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String slika = res.getString("slika");
                if(res.wasNull())
                    slika = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("slika");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Diskusija diskusija = new Diskusija(diskid, idteme, korisnikid, tema, korime, naslov, tekst, datum, profilna, slika, brojkom, lajkovi, dislajkovi, lajkovan);
                diskusije.add(diskusija);
            }
            
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return diskusije;
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
