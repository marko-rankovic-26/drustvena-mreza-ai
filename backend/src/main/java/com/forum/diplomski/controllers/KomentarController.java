/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.data.Komentar;
import com.forum.diplomski.managers.KomentarManager;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Slobodan
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class KomentarController {
    private KomentarManager km = new KomentarManager();
    
    @GetMapping("/komentar")
    public ArrayList<Komentar> GetKomentarStablo(@RequestParam int diskid, @RequestParam int korid) {
        return km.vratiStabloKomentar(diskid, korid);
        
//        dodati vracanje stabla komentara (samo u ovom slucaju odgovora!)
    }
    
    @GetMapping("/odgovor")
    public ArrayList<Komentar> GetOdgovorStablo(@RequestParam int diskid, @RequestParam int korid, @RequestParam int komid) {
        return km.vratiStabloOdgovore(diskid, korid, komid);
    }
    
    @PostMapping("/komentar")
    public boolean PostKomentar(@RequestBody Komentar komentar) {
//        System.out.println(komentar);
//        return false;
        
        return km.dodajKomentar(komentar);
    }
}
