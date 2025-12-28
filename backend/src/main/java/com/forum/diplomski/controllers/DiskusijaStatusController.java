/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.data.DiskusijaStatus;
import com.forum.diplomski.managers.DiskusijaStatusManager;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Slobodan
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DiskusijaStatusController {
    private DiskusijaStatusManager dsm = new DiskusijaStatusManager();
    
    @GetMapping("/diskstatusi")
    public ArrayList<DiskusijaStatus> GetDiskStatusi() {
        return dsm.vratiStatuseDiskusija();
    }
    
    @PostMapping("/diskstatusi/{id}")
    public boolean PostDiskStatus(@PathVariable int id, @RequestBody DiskusijaStatus diskusijaStatus) {
        return dsm.dodajStatusDiskusiji(id, diskusijaStatus);
    }
    
    @DeleteMapping("/diskstatusi/{id}")
    public boolean DeleteDiskStatus(@PathVariable int id, @RequestBody DiskusijaStatus diskusijaStatus) {
        return dsm.obrisiStatusDiskusije(id, diskusijaStatus);
    }
    
    @PutMapping("/diskstatusi/{id}")
    public boolean PutDiskStatus(@PathVariable int id, @RequestBody DiskusijaStatus diskusijaStatus) {
        return dsm.izmeniStatusDiskusije(id, diskusijaStatus);
    }
}
