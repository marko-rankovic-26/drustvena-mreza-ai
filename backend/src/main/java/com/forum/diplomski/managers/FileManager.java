/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

import java.io.InputStream;
import java.sql.*;
/**
 *
 * @author Slobodan
 */
public class FileManager extends DBManager {
    public boolean DodajProfilnu(InputStream in, int korid) {
        boolean rez = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conn = DriverManager.getConnection(this.getDBConnectionString(), this.getDBUsername(), this.getDBPassword());
            
            PreparedStatement stat = conn.prepareCall("exec dodajProfilnu ?, ?");
            stat.setInt(1, korid);
            stat.setBlob(2, in);
            
            rez = stat.execute();
        } catch (Exception e) {
            System.out.println("Greska je: " + e.getMessage());
        }
        
        return rez;
    }
}
