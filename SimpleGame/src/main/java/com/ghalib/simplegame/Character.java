package com.ghalib.simplegame;

import java.util.Random;

/**
 *
 * @author Ahmad Ghalib Athariq
 */
public class Character {
    private String name;
    private CharacterTrait trait;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private float hp;

    public Character(String name, CharacterTrait trait, Weapon weapon, Armor armor) {
        this.name = name;
        this.trait = trait;
        equippedWeapon = weapon;
        equippedArmor = armor;
        resetHealth();
    }

    public void resetHealth()
    {
        hp = trait.getMaxHp();
    }
    
    /**
     * Health karakter ini dikurangi sebanyak kekuatan serangan opponent, tapi hasil damagenya
     * bisa random tergantung stat karakter yang diserang dan yang menyerang.
     * @param opponent
     * @return Deskripsi dari hasil serangan.
     */
    public String tryDamage(Character opponent) {
        var random = new Random();
        
        if (getTrait().getAgility() > opponent.getTrait().getAgility() && random.nextInt(2) == 1) {
            return getName() + " berhasil mengelak dari serangan " + opponent.getName() + "."; 
        }
        
        var opponentAttackForce = opponent.getEquippedWeapon().getDamage();
        var damageInflicted = opponentAttackForce - (getEquippedArmor().getDefense() / opponentAttackForce);
        if (damageInflicted < 0)
            damageInflicted = 0;
        
        var oldHp = hp;
        hp -= damageInflicted;
        
        if (oldHp == hp) {
            return getName() + " tidak terluka dari serangan " + opponent.getName() + ".";
        }
        else if (isDead()) {
            hp = 0;
            return getName() + " menerima serangan fatal dari " + opponent.getName() + " dan tewas terbunuh.";
        }
        
        return getName() + " menerima serangan fatal dari " + opponent.getName() + ", HP berkurang menjadi " + getHp() + ".";
    }
    
    /**
     * Karakter dianggap tewas kalau jumlah health kurang sama dengan 0.
     * @return apakah karakter sudah mati atau belum.
     */
    public boolean isDead() {
        return getHp() <= 0;
    }
    
    /**
     * @return the character's current health
     */
    public float getHp() {
        return hp;
    }

    /**
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the trait
     */
    public CharacterTrait getTrait() {
        return trait;
    }

    /**
     * @param trait the trait to set
     */
    public void setTrait(CharacterTrait trait) {
        this.trait = trait;
    }

    /**
     * @return the equippedWeapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * @param equippedWeapon the equippedWeapon to set
     */
    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    /**
     * @return the equippedArmor
     */
    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    /**
     * @param equippedArmor the equippedArmor to set
     */
    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }
}
