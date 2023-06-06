/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghalib.simplegame;

/**
 *
 * @author Ahmad Ghalib Athariq
 */
public class CharacterTrait {
    private String traitName;
    private int maxHp;
    private int intelligence;
    private int agility;

    public CharacterTrait(String traitName, int maxHp, int intelligence, int agility) {
        this.traitName = traitName;
        this.maxHp = maxHp;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    /**
     * @return the trait's name
     */
    public String getTraitName() {
        return traitName;
    }

    /**
     * @return the maxHp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * @return the agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * @param maxHp the maxHp to set
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * @param agility the agility to set
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }
}
