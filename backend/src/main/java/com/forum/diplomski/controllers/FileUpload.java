/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.controllers;

import com.forum.diplomski.managers.FileManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Slobodan
 */
@RestController
public class FileUpload {
    private String IMAGE_DIR = "static/images";
    private FileManager fm = new FileManager();
    
    @GetMapping(path = "/images/{filename}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public byte[] GetImage(@PathVariable String filename) throws IOException {
        ClassPathResource imagePath = new ClassPathResource(IMAGE_DIR + File.separator + filename);
        
        /*
        kod u konstruktoru vraca apsolutnu putanju do odredjenog resursa!!!!!!
        */
        byte[] imageData = Files.readAllBytes(Paths.get(imagePath.getURI()));
        
        return imageData;
    }
    
    @PostMapping("/profilna")
    public boolean PostProfilna(@RequestParam("korid") int korid, @RequestParam("fajl") MultipartFile file) throws IOException {
        if(file.getSize() > 0) {
            return fm.DodajProfilnu(file.getInputStream(), korid);
        }
        else
            return false;
    }
}
