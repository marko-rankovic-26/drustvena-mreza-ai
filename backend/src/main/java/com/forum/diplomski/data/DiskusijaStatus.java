/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.data;

/**
 *
 * @author Slobodan
 */
public class DiskusijaStatus {
    private int diskstatid;
    private int korid;
    private int diskid;
    private boolean status;

    public DiskusijaStatus(int diskstatid, int korid, int diskid, boolean status) {
        this.diskstatid = diskstatid;
        this.korid = korid;
        this.diskid = diskid;
        this.status = status;
    }

    public DiskusijaStatus() {
        this.diskstatid = 0;
        this.korid = 0;
        this.diskid = 0;
        this.status = false;
    }

    public DiskusijaStatus(int korid, boolean status) {
        this.diskstatid = 0;
        this.korid = korid;
        this.diskid = 0;
        this.status = status;
    }

    public DiskusijaStatus(int korid) {
        this.diskstatid = 0;
        this.korid = korid;
        this.diskid = 0;
        this.status = false;
    }

    public DiskusijaStatus(int korid, int diskid, boolean status) {
        this.diskstatid = 0;
        this.korid = korid;
        this.diskid = diskid;
        this.status = status;
    }
    
    

    public int getDiskstatid() {
        return diskstatid;
    }

    public void setDiskstatid(int diskstatid) {
        this.diskstatid = diskstatid;
    }

    public int getKorid() {
        return korid;
    }

    public void setKorid(int korid) {
        this.korid = korid;
    }

    public int getDiskid() {
        return diskid;
    }

    public void setDiskid(int diskid) {
        this.diskid = diskid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Diskusija status (id: " + diskstatid + ", diskusija id: " + diskid + ", korisnik id: " + korid + ", status: " + status + ")"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
