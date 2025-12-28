/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.diplomski.managers;

/**
 *
 * @author Slobodan
 */
public abstract class DBManager {
    private Integer port = 1433;
    private String instance = "MSSQLAUTH";
    private String database = "FORUM";
    private String username = "sa";
    private String password = "password123";
    
    protected String getDBUsername() {
        return username;
    }
    
    protected String getDBPassword() {
        return password;
    }
    
    protected String getDBConnectionString() {
        return "jdbc:sqlserver://localhost:" + port + "; databaseName=" + database + ";instance=" + instance + ";encrypt=true;     trustServerCertificate=true";
    }
    
    protected boolean convertToBoolean(int val) {
        return val > 0 ? true : false;
    }
}
