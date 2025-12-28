/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.data.Tema;
import com.forum.diplomski.managers.TemaManager;
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
public class TemaController {
    private TemaManager tm = new TemaManager();
    
    @GetMapping("/teme")
    public ArrayList<Tema> GetTeme() {
        return tm.vratiSveTeme();
    }
    
    @GetMapping("/teme/{id}")
    public Tema GetTema(@PathVariable int id) {
        return tm.vratiTemu(id);
    }
    
    @PostMapping("/teme")
    public boolean PostTema(@RequestBody Tema tema) {
        return tm.dodajTemu(tema);
    }
    
    @DeleteMapping("/teme/{id}")
    public boolean DeleteTema(@PathVariable int id) {
        return tm.obrisiTemu(id);
    }
    
    @PutMapping("/teme/{id}")
    public boolean PutTema(@PathVariable int id, @RequestBody Tema tema) {
        return tm.izmeniTemu(id, tema);
    }
}
