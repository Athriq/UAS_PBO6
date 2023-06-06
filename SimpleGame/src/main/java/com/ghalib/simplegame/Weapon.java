/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghalib.simplegame;

/**
 *
 * @author Ahmad Ghalib Athariq
 */
public class Weapon {
    private String weaponName;
    private int damage;

    public Weapon(String weaponName, int damage) {
        this.weaponName = weaponName;
        this.damage = damage;
    }

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
