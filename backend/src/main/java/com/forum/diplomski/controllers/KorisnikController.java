/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.data.Korisnik;
import com.forum.diplomski.managers.KorisnikManager;
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
public class KorisnikController {
    private KorisnikManager km = new KorisnikManager();
    
    @GetMapping("/korisnik")
    public ArrayList<Korisnik> GetKorisnike() {
        return km.vratiKorisnike();
    }
    
    @DeleteMapping("/korisnik/{id}")
    public boolean DeleteKorisnik(@PathVariable int id) {
        return km.obrisiKorisnika(id);
    }
    
    @PutMapping("/korisnik/{id}")
    public boolean PutKorisnik(@PathVariable int id, @RequestBody Korisnik korisnik) {
        return km.izmeniKorisnika(id, korisnik);
    }
    
    @PostMapping("/login")
    public Korisnik GetLogin(@RequestBody Korisnik korisnik) {
        return km.login(korisnik.getKorime(), korisnik.getLozinka());
    }
    
    @PostMapping("/registracija")
    public boolean PostRegistracija(@RequestBody Korisnik korisnik) {
        return km.registracija(korisnik);
    }
}
