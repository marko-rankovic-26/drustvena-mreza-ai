/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;

import com.forum.diplomski.data.Korisnik;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public interface IKorisnikManager {
    public Korisnik login(String korime, String lozinka);
    
    public boolean registracija(Korisnik korisnik);
    
    public ArrayList<Korisnik> vratiKorisnike();
    
    public boolean obrisiKorisnika(int id);
    
    public boolean izmeniKorisnika(int id, Korisnik korisnik);
}
