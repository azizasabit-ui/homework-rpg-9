package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {
    private int curseCount = 0;
    
    @Override
    public void visit(Weapon weapon) {
        if (weapon.getName().toLowerCase().contains("cursed") || 
            weapon.getName().toLowerCase().contains("shadow")) {
            curseCount++;
            System.out.println("  ☠️ CURSE DETECTED: " + weapon.getName() + 
                              " is a cursed weapon! Avoid at all costs!");
        } else {
            System.out.println("  ✓ " + weapon.getName() + " appears safe to use");
        }
    }
    
    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() > 40) {
            System.out.println("  ⚠️ Highly potent potion: " + potion.getName() + 
                              " - may have side effects");
            curseCount++;
        } else {
            System.out.println("  ✓ " + potion.getName() + " passes inspection");
        }
    }
    
    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("death") || 
            scroll.getSpellName().toLowerCase().contains("doom")) {
            curseCount += 2;
            System.out.println("  💀 DARK CURSE on " + scroll.getName() + 
                              "! Contains forbidden spell: " + scroll.getSpellName());
        } else if (scroll.getSpellName().toLowerCase().contains("chaos")) {
            curseCount++;
            System.out.println("  ⚡ " + scroll.getName() + " feels chaotic - handle with care");
        } else {
            System.out.println("  ✓ " + scroll.getName() + " is benign");
        }
    }
    
    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 5) {
            System.out.println("  ⚠️ " + ring.getName() + " is suspiciously powerful... may be cursed");
            curseCount++;
        } else {
            System.out.println("  ✓ " + ring.getName() + " enchantment appears safe");
        }
    }
    
    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() > 10) {
            curseCount++;
            System.out.println("  🛡️ " + armor.getName() + " is too heavy with dark energy - cursed!");
        } else {
            System.out.println("  ✓ " + armor.getName() + " seems fine");
        }
    }
    
    public int getCurseCount() {
        return curseCount;
    }
}