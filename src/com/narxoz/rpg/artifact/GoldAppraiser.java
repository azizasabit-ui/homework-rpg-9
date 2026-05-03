package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;
    
    @Override
    public void visit(Weapon weapon) {
        int weaponValue = weapon.getValue() * 2; // Weapons double value
        totalValue += weaponValue;
        System.out.println("  ⚔️ Weapon: " + weapon.getName() + " - Value: " + weaponValue + 
                          " gold (attack bonus: +" + weapon.getAttackBonus() + ")");
    }
    
    @Override
    public void visit(Potion potion) {
        int potionValue = potion.getValue() + potion.getHealing(); // Potions value + healing power
        totalValue += potionValue;
        System.out.println("  🧪 Potion: " + potion.getName() + " - Value: " + potionValue + 
                          " gold (healing: " + potion.getHealing() + ")");
    }
    
    @Override
    public void visit(Scroll scroll) {
        int scrollValue = scroll.getValue() * 3; // Rare scrolls triple value
        totalValue += scrollValue;
        System.out.println("  📜 Scroll: " + scroll.getName() + " - Value: " + scrollValue + 
                          " gold (spell: " + scroll.getSpellName() + ")");
    }
    
    @Override
    public void visit(Ring ring) {
        int ringValue = ring.getValue() + (ring.getMagicBonus() * 10);
        totalValue += ringValue;
        System.out.println("  💍 Ring: " + ring.getName() + " - Value: " + ringValue + 
                          " gold (magic bonus: +" + ring.getMagicBonus() + ")");
    }
    
    @Override
    public void visit(Armor armor) {
        int armorValue = armor.getValue() + (armor.getDefenseBonus() * 5);
        totalValue += armorValue;
        System.out.println("  🛡️ Armor: " + armor.getName() + " - Value: " + armorValue + 
                          " gold (defense bonus: +" + armor.getDefenseBonus() + ")");
    }
    
    public int getTotalValue() {
        return totalValue;
    }
}