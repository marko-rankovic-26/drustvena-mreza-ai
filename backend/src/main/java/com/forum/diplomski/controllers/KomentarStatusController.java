/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.data.KomentarStatus;
import com.forum.diplomski.managers.KomentarStatusManager;
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
public class KomentarStatusController {
    private KomentarStatusManager ksm = new KomentarStatusManager();
    
    @GetMapping("/komstatusi")
    public ArrayList<KomentarStatus> GetKomStatusi() {
        return ksm.vratiStatuseKomentar();
    }
    
    @PostMapping("/komstatusi/{id}")
    public boolean PostKomStatus(@PathVariable int id, @RequestBody KomentarStatus komentarStatus) {
        return ksm.dodajStatusKomentaru(id, komentarStatus);
    }
    
    @DeleteMapping("/komstatusi/{id}")
    public boolean DeleteKomStatus(@PathVariable int id, @RequestBody KomentarStatus komentarStatus) {
        return ksm.obrisiStatusKomentaru(id, komentarStatus);
    }
    
    @PutMapping("/komstatusi/{id}")
    public boolean PutKomStatus(@PathVariable int id, @RequestBody KomentarStatus komentarStatus) {
        return ksm.izmeniStatusKomentaru(id, komentarStatus);
    }
}
