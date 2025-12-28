/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;
import com.forum.diplomski.data.Komentar;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public interface IKomentarManager {
    public ArrayList<Komentar> vratiKorenskeKomentare(int diskid, int korid);
    
    public ArrayList<Komentar> vratiOdgovoreKomentar(int diskid, int korid, int rodkomid);
    
    public ArrayList<Komentar> vratiStabloKomentar(int diskid, int korid);
    
    public ArrayList<Komentar> vratiStabloOdgovore(int diskid, int korid, int komid);
    
    public boolean dodajKomentar(Komentar komentar);
    
    public boolean obrisiKomentar(int komid);
    
    public boolean izmeniKomentar(Komentar komentar);
}
