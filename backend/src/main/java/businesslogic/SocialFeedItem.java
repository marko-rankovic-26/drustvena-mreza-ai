/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslogic;

import com.forum.diplomski.data.Diskusija;

/**
 *
 * @author Slobodan
 */
public class SocialFeedItem {
    private Diskusija diskusija;
    private double position;

    public SocialFeedItem(Diskusija diskusija) {
        this.diskusija = diskusija;
        this.position = 0;
    }

    public Diskusija getDiskusija() {
        return diskusija;
    }

    public void setDiskusija(Diskusija diskusija) {
        this.diskusija = diskusija;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }
    
    public double dodeliPoziciju(double position) {
        this.position = position;
        return position;
    }

    @Override
    public String toString() {
        return "Diskusija (" + diskusija + "), pozicija: " + position; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
