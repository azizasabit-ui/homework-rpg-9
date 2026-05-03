package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {
    private int enchantmentCount = 0;
    
    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() > 5) {
            enchantmentCount++;
            System.out.println("  ⚡ " + weapon.getName() + " has SHARPENED enchantment! (+" + 
                              weapon.getAttackBonus() + " attack)");
        } else {
            System.out.println("  " + weapon.getName() + " has minor enchantment (+" + 
                              weapon.getAttackBonus() + " attack)");
        }
    }
    
    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() > 30) {
            enchantmentCount++;
            System.out.println("  ✨ " + potion.getName() + " radiates with GREATER healing aura! (" + 
                              potion.getHealing() + " HP)");
        } else {
            System.out.println("  " + potion.getName() + " glows faintly (" + potion.getHealing() + " HP)");
        }
    }
    
    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().contains("FIRE") || scroll.getSpellName().contains("DRAGON")) {
            enchantmentCount += 2;
            System.out.println("  🔥 LEGENDARY enchantment detected on " + scroll.getName() + 
                              "! (Spell: " + scroll.getSpellName() + ")");
        } else {
            enchantmentCount++;
            System.out.println("  📖 " + scroll.getName() + " holds magical potential (" + 
                              scroll.getSpellName() + ")");
        }
    }
    
    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 3) {
            enchantmentCount += 2;
            System.out.println("  💫 " + ring.getName() + " pulses with POWERFUL magic! (+" + 
                              ring.getMagicBonus() + " magic)");
        } else {
            enchantmentCount++;
            System.out.println("  " + ring.getName() + " sparkles with enchantment (+" + 
                              ring.getMagicBonus() + " magic)");
        }
    }
    
    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() > 8) {
            enchantmentCount++;
            System.out.println("  🛡️ " + armor.getName() + " is FORTIFIED! (defense: +" + 
                              armor.getDefenseBonus() + ")");
        } else {
            System.out.println("  " + armor.getName() + " has protective enchantment (+" + 
                              armor.getDefenseBonus() + " defense)");
        }
    }
    
    public int getEnchantmentCount() {
        return enchantmentCount;
    }
}