/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghalib.simplegame;

/**
 *
 * @author Ahmad Ghalib Athariq
 */
public class Armor {

    private String armorName;
    private int defense;

    public Armor(String armorName, int defense) {
        this.armorName = armorName;
        this.defense = defense;
    }

    /**
     * @return the armorName
     */
    public String getArmorName() {
        return armorName;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}
