/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import businesslogic.SocialFeedBuilder;
import businesslogic.SocialFeedItem;
import com.forum.diplomski.data.Diskusija;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
@RestController
public class TestController {
    static String FUZZY_DIR = "fuzzy";
    static String fname = "social_feed.fcl";
    
    @GetMapping("/test")
    String GetPath() throws IOException {
        ClassPathResource cpr = new ClassPathResource(FUZZY_DIR + File.separator + fname);
        
        // ovo ide u FIS:
        // C:\Users\Slobodan\Desktop\diplomski\build\resources\main\fuzzy\social_feed.fcl
        // ovo se salje izuzetku:
        // getFileName().toString()
        // klasa koja baca izuzetke cuva Path i FIS objekat!
        // klasa za sortiranje cuva listu diskusija i Path!
        // lista diskusija ima wrapper klasu koja cuva samu diskusiju!
        return Paths.get(cpr.getURI()).getFileName().toString();
    }
    
    @GetMapping("/feed")
    public ArrayList<SocialFeedItem> GetItems() throws IOException, Exception {
        DiskusijaController dc = new DiskusijaController();
        ArrayList<Diskusija> d = dc.GetDisksijePoTemi(0, 3);
        
        ClassPathResource cpr = new ClassPathResource(FUZZY_DIR + File.separator + fname);
        Path path = Paths.get(cpr.getURI());
        
        SocialFeedBuilder sfb = new SocialFeedBuilder(d, path);
        sfb.evaluteFeed();
        sfb.sortFeedByRelevancy();
        
        return sfb.getFeed();
    }
}
