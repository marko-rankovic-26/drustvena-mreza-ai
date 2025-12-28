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
public class Tema {
    private Integer id;
    private String naziv;
    private ArrayList<Diskusija> diskusije;

    public ArrayList<Diskusija> getDiskusije() {
        return diskusije;
    }

    public void setDiskusije(ArrayList<Diskusija> diskusije) {
        this.diskusije = diskusije;
    }

    public Tema(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
        this.diskusije = null;
    }

    public Tema(String naziv) {
        this.id = 0;
        this.naziv = naziv;
        this.diskusije = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    public void dodajDiskusije(ArrayList<Diskusija> diskusije) {
        this.diskusije = diskusije;
    }

    @Override
    public String toString() {
        return "Tema (id: " + id + ", naziv: " + naziv + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
