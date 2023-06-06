package com.ghalib.simplegame;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Ahmad Ghalib Athariq
 */
public class SimpleGame {
    private static Character player;
    
    public static void main(String[] args) {
        var traitPresets = new ArrayList<CharacterTrait>();
        var weaponPresets = new ArrayList<Weapon>();
        var armorPresets = new ArrayList<Armor>();
        
        traitPresets.add(new CharacterTrait("Petarung", 10, 3, 8));
        traitPresets.add(new CharacterTrait("Sipil", 5, 8, 3));
        
        weaponPresets.add(new Weapon("Tangan", 1));
        weaponPresets.add(new Weapon("Belati", 4));
        weaponPresets.add(new Weapon("Pedang Panjang", 10));
        
        armorPresets.add(new Armor("Tidak Berbusana", 0));
        armorPresets.add(new Armor("Baju Wol Biasa", 2));
        armorPresets.add(new Armor("Zirah Kulit", 5));
        armorPresets.add(new Armor("Zirah Fullmetal", 10));
        
        player = new Character("Sang Pahlawan", traitPresets.get(0),
                weaponPresets.get(0), armorPresets.get(0));
        
        var charEditor = new CharacterEditor(player, traitPresets, weaponPresets, armorPresets);
        var battleScreen = new BattleScreen();
        
        charEditor.setVisible(true);
        
        charEditor.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                if (charEditor.isBattleStarted()) {
                    battleScreen.setVisible(true);
                }
            }
        });
        
        battleScreen.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                charEditor.setVisible(true);
            }
            
            @Override
            public void componentShown(ComponentEvent e) {
                battleScreen.clearBattleEvent();
                simulateBattle(battleScreen);
            }
        });
    }
    
    private static void simulateBattle(BattleScreen battleScreen) {
        var random = new Random();
        
        // Berapa jumlah musuh yang akan dispawn, jumlahnya random antara 5 sampe 25
        int enemyCount = random.nextInt(20);
        enemyCount += 5;
        
        // Spawn karakter-karakter musuh
        var enemies = new ArrayList<Character>();
        for (int i = 0; i < enemyCount; i++) {
            var trait = new CharacterTrait("Mindless Zombie", random.nextInt(3) + 2, 0, 2);
            var weapon = new Weapon("Zombie Bite", random.nextInt(4) + 1);
            var armor = new Armor("Rotten Flesh", 0);
            enemies.add(new Character("Zombie " + i, trait, weapon, armor));
        }
        
        player.resetHealth();
        
        battleScreen.addBattleEvent(enemyCount + " musuh mulai mendekati " + player.getName() + ".");
        
        var steps = 0;
        while (!enemies.isEmpty() && !player.isDead()) {
            if (steps > 1000) {
                battleScreen.addBattleEvent("Para petarung sudah lelah.");
                break;
            }
            
            // Pilih musuh secara random
            var randomEnemy = enemies.get(random.nextInt(enemies.size()));
            
            if (random.nextInt(2) == 1) {
                if (steps == 0)
                    battleScreen.addBattleEvent(player.getName() + " berhasil melakukan serangan pertama kepada " + randomEnemy.getName() + ".");
                
                // Player berkesempatan menyerang musuh
                battleScreen.addBattleEvent(randomEnemy.tryDamage(player));
            } else {
                // Musuh berkesempatan menyerang player
                battleScreen.addBattleEvent(player.tryDamage(randomEnemy));
            }
            
            // Hapus semua musuh yang sudah mati dari arraylist
            enemies.removeIf(e -> e.isDead());
            steps++;
        }
        
        battleScreen.addBattleEventSeparator();
        battleScreen.addBattleEvent("Pertarungan selesai, sisa musuh: " + enemies.size());
        battleScreen.addBattleEvent("Sisa health pemain: " + player.getHp() + " dari " + player.getTrait().getMaxHp());
        battleScreen.addBattleEvent(player.getName() + (player.isDead() ? " kalah dari pertarungan." : " memenangkan pertarungan!"));
    }
}
