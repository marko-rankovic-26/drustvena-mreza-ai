/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import businesslogic.SocialFeedBuilder;
import com.forum.diplomski.data.Diskusija;
import com.forum.diplomski.data.Korisnik;
import com.forum.diplomski.managers.DiskusijaManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Slobodan
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DiskusijaController {
    private DiskusijaManager dm = new DiskusijaManager();
    
    private int PAGE_SIZE = 20;
    
    private String IMAGE_DIR = "images";
    private static String FUZZY_DIR = "fuzzy";
    private static String fname = "social_feed.fcl";
    
    /*
    stranicenje => /diskusije/indexstrane (u body je korid!!!!)
    ulaz u diskusiju => /diskusija/diskid
    */
    
    @GetMapping("/diskusija")
    public ArrayList<Diskusija> GetDiskusije(@RequestParam int korid) {
        return dm.vratiDiskusijeInfo(korid);
    }
    
    @GetMapping("/diskusija/{id}")
    public Diskusija GetDiskusija(@PathVariable int id, @RequestParam int korid) {
        return dm.vratiDiskusijuInfo(korid, id);
    }
    
//    @GetMapping("/stranice")
//    public Stranica GetStranice() {
//        return dm.brojStrana(PAGE_SIZE);
//    }
    
    @GetMapping("/diskusije/{index}")
    public ArrayList<Diskusija> GetStrDiskusije(@PathVariable int index, @RequestBody Korisnik korisnik) {
        return dm.vratiStrDiskusije(index, PAGE_SIZE, korisnik.getKorid());
    }
    
    @PostMapping("/diskusija")
    public boolean PostDiskusija(@RequestPart("disk") Diskusija diskusija, @RequestParam("fajl") MultipartFile file) {
        
        System.out.println(diskusija);
        
        String putanja = null;
        Diskusija d = null;
        String slikaPutanja = null;
        
        if(file.getSize() > 0) {
//            System.out.println("Poslat je fajl!");

            putanja = "src/main/resources/static" + File.separator + IMAGE_DIR;
            
            File uploadDir = new File(putanja);
            
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
//            System.out.println("Tip fajla je: " + file.getContentType().split("/")[1]);
            
            String ekstenzija = file.getContentType().split("/")[1];
            
            putanja += File.separator + "image_" + diskusija.getKorid() + "." + ekstenzija;
            
            slikaPutanja = IMAGE_DIR + File.separator + "image_" + diskusija.getKorid() + "." + ekstenzija;
//            ovo proslediti u konstruktor diskusije i dalje proslediti manager-u!!!!!!!!!!
            try {
                FileOutputStream fos = new FileOutputStream(new File(putanja));
                fos.write(file.getBytes());
            } catch (Exception e) {
                System.out.println("Greska je: " + e.getMessage());
            }
            
//            dodati cuvanje fajlova (sa FileWriter klasom????)
        }
        else {
            System.out.println("Nije poslat fajl!");
        }
        
        d = new Diskusija(diskusija.getTemaid(), diskusija.getKorid(), diskusija.getNaslov(), diskusija.getTekst(), putanja);
        
        if(!file.isEmpty()) {
            // sacuvaj fajl
            
            d = new Diskusija(0, diskusija.getTemaid(), diskusija.getKorid(), "", "", diskusija.getNaslov(), diskusija.getTekst(), "", "", "naziv fajla", 0, 0, 0, Boolean.FALSE);
        }
        d = new Diskusija(0, diskusija.getTemaid(), diskusija.getKorid(), "", "", diskusija.getNaslov(), diskusija.getTekst(), "", "", null, 0, 0, 0, Boolean.FALSE);
        
        return dm.dodajDiskusijuInfo(d);
        
//        ako ne cuvas sliku slika=null, u suprotnom slika="images/ime_slike.ekstenzija"  !!!!!!!!
        
//        return false;
    }
    
    @DeleteMapping("/diskusija/{id}")
    public boolean DeleteDiskusija(@PathVariable int id) {
        return dm.izbrisiDiskusijuInfo(id);
    }
    
    @PutMapping("/diskusija/{id}")
    public boolean PutDiskusija(@PathVariable int id, @RequestPart("disk") Diskusija diskusija, @RequestPart("fajl") MultipartFile file) {
        Diskusija d;
        
        if(!file.isEmpty()) {
            // sacuvaj fajl
            
            d = new Diskusija(id, diskusija.getTemaid(), diskusija.getKorid(), "", "", diskusija.getNaslov(), diskusija.getTekst(), "", "", "naziv fajla", 0, 0, 0, Boolean.FALSE);
        }
        d = new Diskusija(id, diskusija.getTemaid(), diskusija.getKorid(), "", "", diskusija.getNaslov(), diskusija.getTekst(), "", "", null, 0, 0, 0, Boolean.FALSE);
        
        return dm.izmeniDiskusijuInfo(d);
    }
    
    @GetMapping("/diskusije")
    public ArrayList<Diskusija> GetDisksijePoTemi(@RequestParam int korid, @RequestParam int temaid) throws IOException, Exception {
        //return dm.vratiDiskusijeInfoPoTemi(korid, temaid);
//        return primeniAlgoritam(korid, temaid);
//        ArrayList<Diskusija> diskusije = dm.vratiDiskusijeInfoPoTemi(korid, temaid);
//        tweakValues(diskusije);
        return primeniAlgoritam(korid, temaid);
    }
    
    private void tweakValues(ArrayList<Diskusija> diskusije) {
        for(Diskusija d : diskusije) {
            switch (d.getDiskid()) {
                case 2 -> {
                    d.setLajkovi(11);
                    d.setDislajkovi(14);
                    d.setBrojKom(7);
                    break;
                }
                case 7 -> {
                    d.setLajkovi(12);
                    d.setDislajkovi(46);
                    d.setBrojKom(27);
                    break;
                }
                case 14 -> {
                    d.setLajkovi(16);
                    d.setDislajkovi(26);
                    d.setBrojKom(19);
                    break;
                }
                default -> throw new AssertionError();
            }
        }
    }
    
    private ArrayList<Diskusija> primeniAlgoritam(int korid, int temaid) throws IOException, Exception {
        // vrati diskusije po temi za trenutno ulogovanog korisnika
        ArrayList<Diskusija> diskusije = dm.vratiDiskusijeInfoPoTemi(korid, temaid);
        
        // komentovati ovaj deo koda kasnije!!!!!!!!
//        tweakValues(diskusije);
        
        // napravi putanju do skripte gde se nalazi sistem fuzzy pravila
        ClassPathResource cpr = new ClassPathResource(FUZZY_DIR + File.separator + fname);
        Path path = Paths.get(cpr.getURI());
        
        // odredi fuzzy vrednosti za svaku diskusiju
        // i sortiraj diskusije po rastucem poredku po toj vrednosti
        SocialFeedBuilder sfb = new SocialFeedBuilder(diskusije, path);
        sfb.evaluteFeed();
        sfb.sortFeedByRelevancy();
        
        // vrati rezultat sortiranja kao odgovor servera
        return sfb.vratiFeed();
    }
}
