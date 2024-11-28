/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Potion;

import Enums.Ingredients;
import Enums.PotionNames;

import java.util.ArrayList;
import java.util.List;

public class DizzyPotion extends Potion {

    /**
     * Static recipe for dizzy potion
     */
    public static List<Ingredients> ingredients = new ArrayList<>(
            List.of(Ingredients.DARK_POWDER,
                    Ingredients.SNAKE_POISON,
                    Ingredients.SNAKE_POISON,
                    Ingredients.MORNING_DEW)
    );

    /**
     * Constructor, calls the constructor from the super class and sets potionName to indicate which specific type
     * of potion this is
     * @param value the value of this potion
     */
    public DizzyPotion(int value) {
        super(value);
        this.potionName = PotionNames.DIZZY;
    }

    /**
     * Makes the target drink this potion, and communicate the corresponding effect to the target
     * @param target the entity drinking this potion
     */
    @Override
    public void drink(Player target) {
        super.drink(target);
        target.dizzyEffect();
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        Potion potion = new DizzyPotion(10);
        Player player = new Player();
        System.out.println("It's a " + potion.getName() + " potion");
        potion.drink(player);
    }
}
