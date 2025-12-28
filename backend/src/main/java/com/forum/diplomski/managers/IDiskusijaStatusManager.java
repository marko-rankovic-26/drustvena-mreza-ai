/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.forum.diplomski.managers;
import com.forum.diplomski.data.DiskusijaStatus;
import java.util.ArrayList;
/**
 *
 * @author Slobodan
 */
public interface IDiskusijaStatusManager {
    public ArrayList<DiskusijaStatus> vratiStatuseDiskusija();
    
    public boolean dodajStatusDiskusiji(int  diskid, DiskusijaStatus diskusijaStatus);
    
    public boolean obrisiStatusDiskusije(int diskid, DiskusijaStatus diskusijaStatus);
    
    public boolean izmeniStatusDiskusije(int diskid, DiskusijaStatus diskusijaStatus);
}
