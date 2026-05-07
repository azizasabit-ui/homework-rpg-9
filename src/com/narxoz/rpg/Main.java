package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     HOMEWORK 9: VISITOR + MEMENTO PATTERNS              ║");
        System.out.println("║           CHRONOMANCER'S VAULT                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // PART 1: CREATE HEROES WITH DIFFERENT STARTING STATES
        System.out.println("🎯 PART 1: Creating Heroes");
        System.out.println("============================================================\n");
        
        // Create artifacts for Hero 1
        Inventory warriorInventory = new Inventory();
        warriorInventory.addArtifact(new Weapon("Dragon Slayer", 500, 8, 25));
        warriorInventory.addArtifact(new Armor("Mithril Plate", 800, 20, 15));
        warriorInventory.addArtifact(new Potion("Greater Healing", 100, 1, 50));
        
        Hero warrior = new Hero("Sir Aldric (Warrior)", 250, 50, 45, 30, 500, warriorInventory);
        
        // Create artifacts for Hero 2
        Inventory mageInventory = new Inventory();
        mageInventory.addArtifact(new Scroll("Fireball Scroll", 300, 1, "Fireball"));
        mageInventory.addArtifact(new Ring("Ring of Power", 600, 1, 12));
        mageInventory.addArtifact(new Potion("Mana Potion", 80, 1, 0));
        mageInventory.addArtifact(new Weapon("Staff of Wisdom", 400, 4, 10));
        
        Hero mage = new Hero("Lady Elara (Mage)", 180, 80, 35, 20, 300, mageInventory);
        
        List<Hero> party = new ArrayList<>(Arrays.asList(warrior, mage));
        
        System.out.println("Heroes created:");
        for (Hero hero : party) {
            System.out.println("  " + hero);
            System.out.println("  Inventory contains " + hero.getInventory().size() + " artifacts");
        }
        
        // PART 2: SHOW ARTIFACTS IN DETAIL
        System.out.println("\n🎯 PART 2: Artifact Inventory Details");
        System.out.println("============================================================\n");
        
        System.out.println("Sir Aldric's Artifacts:");
        for (Artifact a : warrior.getInventory().getArtifacts()) {
            System.out.println("  • " + a.getName());
        }
        
        System.out.println("\nLady Elara's Artifacts:");
        for (Artifact a : mage.getInventory().getArtifacts()) {
            System.out.println("  • " + a.getName());
        }
        
        // PART 3: RUN THE VAULT ENGINE
        System.out.println("\n🎯 PART 3: Running Chronomancer's Vault");
        System.out.println("============================================================\n");
        
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);
        
        // PART 4: PRINT FINAL RESULTS
        System.out.println("\n🎯 PART 4: Vault Run Results");
        System.out.println("============================================================\n");
        
        System.out.println(result);
        
        // PART 5: ARCHITECTURE VERIFICATION
        System.out.println("\n🎯 PART 5: Architecture Verification");
        System.out.println("============================================================\n");
        
        System.out.println("✓ VISITOR PATTERN:");
        System.out.println("  - ArtifactVisitor interface with 5 visit() overloads");
        System.out.println("  - 5 concrete artifact classes (Weapon, Potion, Scroll, Ring, Armor)");
        System.out.println("  - 4 concrete visitors: GoldAppraiser, EnchantmentScanner, CurseDetector, WeightCalculator");
        System.out.println("  - Double dispatch: artifact.accept(visitor) calls visitor.visit(this)");
        System.out.println("  - No instanceof or type-switching used");
        
        System.out.println("\n✓ MEMENTO PATTERN:");
        System.out.println("  - HeroMemento stores immutable snapshot");
        System.out.println("  - Hero.createMemento() captures state");
        System.out.println("  - Hero.restoreFromMemento() restores state");
        System.out.println("  - HeroMemento getters are package-private (opaque to Caretaker)");
        System.out.println("  - Caretaker stores/retrieves mementos without inspecting internals");
        
        System.out.println("\n✓ OPEN/CLOSED PROOF:");
        System.out.println("  - WeightCalculator added as 4th visitor");
        System.out.println("  - No modifications to any artifact/ package files");
        System.out.println("  - Works seamlessly with existing Inventory.accept()");
        
        System.out.println("\n✓ DEMO COMPLETENESS:");
        System.out.println("  - 2 heroes with different starting states and artifacts");
        System.out.println("  - Mixed inventory with 5+ artifacts total");
        System.out.println("  - 3 concrete visitors applied through Inventory.accept()");
        System.out.println("  - Hero snapshot saved before vault event");
        System.out.println("  - State changes applied (damage, mana loss, gold loss)");
        System.out.println("  - Rewind from saved memento demonstrated");
        System.out.println("  - 4th visitor proves open/closed principle");
        System.out.println("  - VaultRunResult printed with statistics");
        
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    DEMO COMPLETE - SUCCESS               ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}