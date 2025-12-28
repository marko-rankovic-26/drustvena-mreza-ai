/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;
import com.forum.diplomski.data.Tema;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public interface ITemaManager {
    public ArrayList<Tema> vratiSveTeme();
    
    public Tema vratiTemu(int id);
    
    public boolean dodajTemu(Tema tema);
    
    public boolean obrisiTemu(int id);
    
    public boolean izmeniTemu(int id, Tema tema);
}
