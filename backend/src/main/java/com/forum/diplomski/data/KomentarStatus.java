/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.data;

/**
 *
 * @author Slobodan
 */
public class KomentarStatus {
    private int komstatid;
    private int korid;
    private int komid;
    private boolean status;

    public KomentarStatus(int komstatid, int korid, int komid, boolean status) {
        this.komstatid = komstatid;
        this.korid = korid;
        this.komid = komid;
        this.status = status;
    }

    public KomentarStatus() {
        this.komstatid = 0;
        this.korid = 0;
        this.komid = 0;
        this.status = false;
    }

    public KomentarStatus(int korid, boolean status) {
        this.komstatid = 0;
        this.korid = korid;
        this.komid = 0;
        this.status = status;
    }

    public KomentarStatus(boolean status) {
        this.komstatid = 0;
        this.korid = 0;
        this.komid = 0;
        this.status = status;
    }

    public KomentarStatus(int korid) {
        this.komstatid = 0;
        this.korid = korid;
        this.komid = 0;
        this.status = false;
    }

    public int getKomstatid() {
        return komstatid;
    }

    public void setKomstatid(int komstatid) {
        this.komstatid = komstatid;
    }

    public int getKorid() {
        return korid;
    }

    public void setKorid(int korid) {
        this.korid = korid;
    }

    public int getKomid() {
        return komid;
    }

    public void setKomid(int komid) {
        this.komid = komid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Komentar status (id: " + komstatid + ", korid: " + korid + ", komid: " + komid + ", status: " + status + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
