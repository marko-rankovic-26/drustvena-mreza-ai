/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;
import com.forum.diplomski.data.KomentarStatus;
import java.util.ArrayList;
/**
 *
 * @author Slobodan
 */
public interface IKomentarStatusManager {
    public ArrayList<KomentarStatus> vratiStatuseKomentar();
    
    public boolean dodajStatusKomentaru(int komid, KomentarStatus komentarStatus);
    
    public boolean obrisiStatusKomentaru(int komid, KomentarStatus komentarStatus);
    
    public boolean izmeniStatusKomentaru(int komid, KomentarStatus komentarStatus);
}
