/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.Komentar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.Base64;

/**
 *
 * @author Slobodan
 */
public class KomentarManager extends DBManager implements IKomentarManager {

    @Override
    public ArrayList<Komentar> vratiKorenskeKomentare(int diskid, int korid) {
        ArrayList<Komentar> komentari = new ArrayList<Komentar>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiKorenskeKomInfo(?, ?)");
            stat.setInt(1, diskid);
            stat.setInt(2, korid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int komid = res.getInt("komid");
                int idKor = res.getInt("korid");
                String korime = res.getString("korime");
                int idDisk = res.getInt("diskid");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumKom"));
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                
                Integer rodKomId = res.getInt("rodkomid");
                if(res.wasNull())
                    rodKomId = null;
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("profilna");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Komentar komentar = new Komentar(komid, rodKomId, idKor, korime, idDisk, tekst, datum, profilna, lajkovi, dislajkovi, lajkovan);
                
                komentari.add(komentar);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return komentari;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Komentar> vratiOdgovoreKomentar(int diskid, int korid, int rodkomid) {
        ArrayList<Komentar> komentari = new ArrayList<Komentar>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("select * from dbo.vratiOdgovorKomInfo(?, ?, ?)");
            stat.setInt(1, diskid);
            stat.setInt(2, korid);
            stat.setInt(3, rodkomid);
            
            ResultSet res = stat.executeQuery();
            
            while (res.next()) {                
                int komid = res.getInt("komid");
                int idKor = res.getInt("korid");
                String korime = res.getString("korime");
                int idDisk = res.getInt("diskid");
                String tekst = res.getString("tekst");
                String datum = formatter.format(res.getTimestamp("datumKom"));
                int lajkovi = res.getInt("lajkovi");
                int dislajkovi = res.getInt("dislajkovi");
                
                Integer rodKomId = res.getInt("rodkomid");
                if(res.wasNull())
                    rodKomId = null;
                
                Boolean lajkovan = res.getBoolean("lajkovan");
                if(res.wasNull())
                    lajkovan = null;
                
                String profilna = null;
                Blob blobProfilne = res.getBlob("profilna");
                if(res.wasNull())
                    profilna = null;
                else {
                    byte[] bajtoviProfilne = blobProfilne.getBytes(1, (int)blobProfilne.length());
                    profilna = Base64.getEncoder().encodeToString(bajtoviProfilne);
                }
                
                Komentar komentar = new Komentar(komid, rodKomId, idKor, korime, idDisk, tekst, datum, profilna, lajkovi, dislajkovi, lajkovan);
                
                komentari.add(komentar);
            }
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return komentari;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Komentar> vratiStabloKomentar(int diskid, int korid) {
        ArrayList<Komentar> stablo = vratiKorenskeKomentare(diskid, korid);
        
//        for(Komentar k : stablo) {
//            ArrayList<Komentar> list1 = vratiOdgovoreKomentar(k.getDiskid(), korid, k.getKomid());
//            
//            for(Komentar list2 : list1) {
//                ArrayList<Komentar> list3 = vratiOdgovoreKomentar(list2.getDiskid(), korid, list2.getKomid());
//                
////                ovde dodati jos jedan nivo komentara!!!!!!!!!!!!!!
//                
//                list2.dodajOdgovore(list3);
//            }
//            
//            k.dodajOdgovore(list1);
//        }

//        DUBINA STABLA JE DEPTH=4 (obratiti paznju na frontend-u)!!!!!!!!!!!
        
        for(Komentar k : stablo) {
            ArrayList<Komentar> list1 = vratiOdgovoreKomentar(k.getDiskid(), korid, k.getKomid());
            
            for(Komentar list2 : list1) {
                ArrayList<Komentar> list3 = vratiOdgovoreKomentar(list2.getDiskid(), korid, list2.getKomid());
                
//                ovde dodati jos jedan nivo komentara!!!!!!!!!!!!!!

                for(Komentar list4 : list3) {
                    ArrayList<Komentar> list5 = vratiOdgovoreKomentar(list4.getDiskid(), korid, list4.getKomid());
                    
                    list4.dodajOdgovore(list5);
                }
                
                list2.dodajOdgovore(list3);
            }
            
            k.dodajOdgovore(list1);
        }
        
        return stablo;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Komentar> vratiStabloOdgovore(int diskid, int korid, int komid) {
        ArrayList<Komentar> stablo = vratiOdgovoreKomentar(diskid, korid, komid);
        
//        for(Komentar k : stablo) {
//            ArrayList<Komentar> list1 = vratiOdgovoreKomentar(k.getDiskid(), korid, k.getKomid());
//            
//            for(Komentar list2 : list1) {
//                ArrayList<Komentar> list3 = vratiOdgovoreKomentar(list2.getDiskid(), korid, list2.getKomid());
//                
//                list2.dodajOdgovore(list3);
//            }
//            
//            k.dodajOdgovore(list1);
//        }
        
        for(Komentar k : stablo) {
            ArrayList<Komentar> list1 = vratiOdgovoreKomentar(k.getDiskid(), korid, k.getKomid());
            
            for(Komentar list2 : list1) {
                ArrayList<Komentar> list3 = vratiOdgovoreKomentar(list2.getDiskid(), korid, list2.getKomid());
                
//                ovde dodati jos jedan nivo komentara!!!!!!!!!!!!!!

                for(Komentar list4 : list3) {
                    ArrayList<Komentar> list5 = vratiOdgovoreKomentar(list4.getDiskid(), korid, list4.getKomid());
                    
                    list4.dodajOdgovore(list5);
                }
                
                list2.dodajOdgovore(list3);
            }
            
            k.dodajOdgovore(list1);
        }
        
        return stablo;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean dodajKomentar(Komentar komentar) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec dodajKomentar ?, ?, ?, ?");
            
            if(komentar.getRodKomId() == null)
                stat.setNull(1, java.sql.Types.INTEGER);
            else
                stat.setInt(1, komentar.getRodKomId());
            
            stat.setInt(2, komentar.getKorid());
            stat.setInt(3, komentar.getDiskid());
            stat.setString(4, komentar.getTekst());
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean obrisiKomentar(int komid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean izmeniKomentar(Komentar komentar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
