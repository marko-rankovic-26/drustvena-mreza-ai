/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;
import com.forum.diplomski.data.Diskusija;
import java.util.ArrayList;
/**
 *
 * @author Slobodan
 */
public interface IDiskusijaManager {
    public ArrayList<Diskusija> vratiDiskusijeInfo(int korid);
    
    public Diskusija vratiDiskusijuInfo(int korid, int diskid);
    
    public boolean dodajDiskusijuInfo(Diskusija diskusija);
    
    public boolean izbrisiDiskusijuInfo(int diskid);
    
    public boolean izmeniDiskusijuInfo(Diskusija diskusija);
    
    public Integer brojStrana(int prageSize);
    
    public ArrayList<Diskusija> vratiStrDiskusije(int pageIndex, int pageSize, int korid);
}
