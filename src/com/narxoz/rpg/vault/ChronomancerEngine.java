package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {
    
    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║        CHRONOMANCER'S VAULT - VISITOR + MEMENTO         ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        int artifactsAppraised = 0;
        int mementosCreated = 0;
        int restoredCount = 0;
        
        for (Hero hero : party) {
            if (!hero.isAlive()) continue;
            
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("Visiting " + hero.getName() + "'s inventory");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            
            if (hero.getInventory().size() == 0) {
                System.out.println("  📦 Inventory is empty!");
                continue;
            }
            
            // Apply first visitor: GoldAppraiser
            System.out.println("\n💰 GOLD APPRAISER visiting artifacts:");
            GoldAppraiser goldAppraiser = new GoldAppraiser();
            hero.getInventory().accept(goldAppraiser);
            artifactsAppraised += hero.getInventory().size();
            System.out.println("  Total appraised value: " + goldAppraiser.getTotalValue() + " gold");
            
            // Apply second visitor: EnchantmentScanner
            System.out.println("\n✨ ENCHANTMENT SCANNER analyzing artifacts:");
            EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
            hero.getInventory().accept(enchantmentScanner);
            System.out.println("  Enchantments detected: " + enchantmentScanner.getEnchantmentCount());
            
            // Apply third visitor: CurseDetector
            System.out.println("\n☠️ CURSE DETECTOR inspecting artifacts:");
            CurseDetector curseDetector = new CurseDetector();
            hero.getInventory().accept(curseDetector);
            System.out.println("  Curses found: " + curseDetector.getCurseCount());
            
            // Demonstrate Memento pattern
            System.out.println("\n⏰ TIME CRYSTAL DEMONSTRATION:");
            Caretaker caretaker = new Caretaker();
            
            // Save initial state
            System.out.println("  Saving initial hero state...");
            caretaker.save(hero.createMemento());
            mementosCreated++;
            
            System.out.println("\n  💀 A time trap damages " + hero.getName() + "!");
            hero.takeDamage(50);
            hero.spendMana(30);
            hero.spendGold(40);
            System.out.println("  New state: HP=" + hero.getHp() + ", Mana=" + hero.getMana() + 
                              ", Gold=" + hero.getGold());
            
            System.out.println("\n  Saving damaged state...");
            caretaker.save(hero.createMemento());
            mementosCreated++;
            
            System.out.println("\n  💥 Another trap strikes!");
            hero.takeDamage(40);
            hero.spendMana(20);
            System.out.println("  Critical state: HP=" + hero.getHp());
            
            System.out.println("\n  ⌛ Activating time crystal to rewind...");
            HeroMemento restored = caretaker.undo();
            if (restored != null) {
                hero.restoreFromMemento(restored);
                restoredCount++;
            }
            
            System.out.println("\n  Final state after rewind: HP=" + hero.getHp() + 
                              ", Mana=" + hero.getMana() + ", Gold=" + hero.getGold());
            
            // Apply weight calculator as 4th visitor (open/closed proof)
            System.out.println("\n⚖️ WEIGHT CALCULATOR (4th visitor - Open/Closed proof):");
            WeightCalculator weightCalc = new WeightCalculator();
            hero.getInventory().accept(weightCalc);
            System.out.println("  Total inventory weight: " + weightCalc.getTotalWeight() + " kg");
        }
        
        System.out.println("║                 VAULT RUN COMPLETE                       ║");
        
        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}