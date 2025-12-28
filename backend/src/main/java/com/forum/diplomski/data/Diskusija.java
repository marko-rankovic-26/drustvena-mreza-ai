/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.data;
import java.util.ArrayList;
import org.apache.tomcat.util.digester.ArrayStack;
/**
 *
 * @author Slobodan
 */
public class Diskusija {
    private int diskid;
    private int temaid;
    private Integer korid;
    private String tema;
    private String korime;
    private String naslov;
    private String tekst;
    private String datum;
    private String profilna;
    private String slika;
    private int brojKom;
    private int lajkovi;
    private int dislajkovi;
    private Boolean lajkovan;
    private ArrayList<Komentar> komentari;

    public Diskusija(int diskid, int temaid, Integer korid, String tema, String korime, String naslov, String tekst, String datum, String profilna, String slika, int brojKom, int lajkovi, int dislajkovi, Boolean lajkovan) {
        this.diskid = diskid;
        this.temaid = temaid;
        this.korid = korid;
        this.tema = tema;
        this.korime = korime;
        this.naslov = naslov;
        this.tekst = tekst;
        this.datum = datum;
        this.profilna = profilna;
        this.slika = slika;
        this.brojKom = brojKom;
        this.lajkovi = lajkovi;
        this.dislajkovi = dislajkovi;
        this.lajkovan = lajkovan;
        this.komentari = new ArrayList<Komentar>();
    }

    public Diskusija() {
    }

    public Diskusija(int temaid, Integer korid, String naslov, String tekst) {
        this.temaid = temaid;
        this.korid = korid;
        this.naslov = naslov;
        this.tekst = tekst;
    }

    public Diskusija(int temaid, Integer korid, String naslov, String tekst, String slika) {
        this.temaid = temaid;
        this.korid = korid;
        this.naslov = naslov;
        this.tekst = tekst;
        this.slika = slika;
    }
    
    

    public int getId() {
        return diskid;
    }

    public void setId(int diskid) {
        this.diskid = diskid;
    }

    public int getTemaid() {
        return temaid;
    }

    public void setTemaid(int temaid) {
        this.temaid = temaid;
    }

    public Integer getKorid() {
        return korid;
    }

    public void setKorid(Integer korid) {
        this.korid = korid;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
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

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getBrojKom() {
        return brojKom;
    }

    public void setBrojKom(int brojKom) {
        this.brojKom = brojKom;
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

    public int getDiskid() {
        return diskid;
    }

    public void setDiskid(int diskid) {
        this.diskid = diskid;
    }

    public ArrayList<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }
    
    

    @Override
    public String toString() {
        return "Diskusija (korid : " + korid + ", temaid: " + temaid + ", naslov: " + naslov + ", tekst: " + tekst + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public void dodajKomentare(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }
}
