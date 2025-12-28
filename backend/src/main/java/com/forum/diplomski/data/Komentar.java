/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.data;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public class Komentar {
    private int komid;
    private Integer rodKomId;
    private int korid;
    private String korime;
    private int diskid;
    private String tekst;
    private String datum;
    private String profilna;
    private int lajkovi;
    private int dislajkovi;
    private Boolean lajkovan;
    private ArrayList<Komentar> odgovori;

    public Komentar(int komid, Integer rodKomId, int korid, String korime, int diskid, String tekst, String datum, String profilna, int lajkovi, int dislajkovi, Boolean lajkovan) {
        this.komid = komid;
        this.rodKomId = rodKomId;
        this.korid = korid;
        this.korime = korime;
        this.diskid = diskid;
        this.tekst = tekst;
        this.datum = datum;
        this.profilna = profilna;
        this.lajkovi = lajkovi;
        this.dislajkovi = dislajkovi;
        this.lajkovan = lajkovan;
        this.odgovori = new ArrayList<Komentar>();
    }

    public Komentar() {
    }

    public Komentar(Integer rodKomId, int korid, int diskid, String tekst) {
        this.rodKomId = rodKomId;
        this.korid = korid;
        this.diskid = diskid;
        this.tekst = tekst;
    }

    public Komentar(int korid, int diskid, String tekst) {
        this.rodKomId = null;
        this.korid = korid;
        this.diskid = diskid;
        this.tekst = tekst;
    }

    public int getKomid() {
        return komid;
    }

    public void setKomid(int komid) {
        this.komid = komid;
    }

    public Integer getRodKomId() {
        return rodKomId;
    }

    public void setRodKomId(Integer rodKomId) {
        this.rodKomId = rodKomId;
    }

    public int getKorid() {
        return korid;
    }

    public void setKorid(int korid) {
        this.korid = korid;
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }

    public int getDiskid() {
        return diskid;
    }

    public void setDiskid(int diskid) {
        this.diskid = diskid;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getProfilna() {
        return profilna;
    }

    public void setProfilna(String profilna) {
        this.profilna = profilna;
    }

    public int getLajkovi() {
        return lajkovi;
    }

    public void setLajkovi(int lajkovi) {
        this.lajkovi = lajkovi;
    }

    public int getDislajkovi() {
        return dislajkovi;
    }

    public void setDislajkovi(int dislajkovi) {
        this.dislajkovi = dislajkovi;
    }

    public Boolean getLajkovan() {
        return lajkovan;
    }

    public void setLajkovan(Boolean lajkovan) {
        this.lajkovan = lajkovan;
    }

    public ArrayList<Komentar> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(ArrayList<Komentar> odgovori) {
        this.odgovori = odgovori;
    }
    
    public void dodajOdgovore(ArrayList<Komentar> odgovori) {
        this.odgovori = odgovori;
    }

    @Override
    public String toString() {
        return "Komentar (diskusija - " + diskid + ", korisnik - " + korid + ", roditeljski komentar - " + rodKomId + ", tekst - " + tekst + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
