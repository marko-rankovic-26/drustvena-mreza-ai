/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslogic;

/**
 *
 * @author Slobodan
 */
// ZA GENERISANJE KORISTI ALT + INSERT!!!!
public class ScriptNotLoadedException extends Exception {
    private String fname;

    public ScriptNotLoadedException(String fname) {
        this.fname = fname;
    }

    @Override
    public String getMessage() {
        return "Script '" + fname + "' is not loaded!"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
