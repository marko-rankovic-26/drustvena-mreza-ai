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
public class Korisnik {
    private Integer korid;
    private String ime;
    private String prezime;
    private String korime;
    private String lozinka;
    private String datumkor;
    private String profilna;
    private ArrayList<Diskusija> diskusije;
    private ArrayList<Komentar> komentari;

    public ArrayList<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }

    public ArrayList<Diskusija> getDiskusije() {
        return diskusije;
    }

    public void setDiskusije(ArrayList<Diskusija> diskusije) {
        this.diskusije = diskusije;
    }

    public Korisnik(Integer korid, String ime, String prezime, String korime, String lozinka, String datumkor, String profilna) {
        this.korid = korid;
        this.ime = ime;
        this.prezime = prezime;
        this.korime = korime;
        this.lozinka = lozinka;
        this.datumkor = datumkor;
        this.profilna = profilna;
        this.diskusije = null;
        this.komentari = null;
    }

    public Korisnik() {
        this.korid = 0;
        this.ime  = "";
        this.prezime = "";
        this.korime = "";
        this.lozinka = "";
        this.datumkor = "";
        this.profilna = null;
        this.diskusije = null;
        this.komentari = null;
    }

    public Korisnik(String ime, String prezime, String korime, String lozinka) {
        this.korid = 0;
        this.ime = ime;
        this.prezime = prezime;
        this.korime = korime;
        this.lozinka = lozinka;
        this.datumkor = "";
        this.profilna = null;
        this.diskusije = null;
        this.komentari = null;
    }

    public Korisnik(String korime, String lozinka) {
        this.korid = 0;
        this.ime = "";
        this.prezime = "";
        this.korime = korime;
        this.lozinka = lozinka;
        this.datumkor = "";
        this.profilna = null;
        this.diskusije = null;
        this.komentari = null;
    }

    public Integer getKorid() {
        return korid;
    }

    public void setKorid(Integer korid) {
        this.korid = korid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getDatumkor() {
        return datumkor;
    }

    public void setDatumkor(String datumkor) {
        this.datumkor = datumkor;
    }

    public String getProfilna() {
        return profilna;
    }

    public void setProfilna(String profilna) {
        this.profilna = profilna;
    }
    
    public void dodajDiskusije(ArrayList<Diskusija> diskusije) {
        this.diskusije = diskusije;
    }
    
    public void dodajKomentare(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }

    @Override
    public String toString() {
        return "Korisnik (korid: " + korid + ", ime: " + ime + ", prezime: " + prezime + ", lozinka: " + lozinka + ", datum: " + datumkor + ", prfilna: " + profilna + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
