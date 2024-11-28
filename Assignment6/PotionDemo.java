/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

import Enums.CraftingAlgorithmNames;
import Enums.Ingredients;
import Potion.Potion;
import Potion.Player;

import java.util.ArrayList;

public class PotionDemo {

    /**
     * Main program to test your PotionFactory
     * Below is some provided starter code setting up the player and factory class.
     *
     * You should add your own code demonstrating your Factory in action, highlighting the different types of potions
     * as well as the different algorithms your factory supports.
     *
     * This is essentially a form of integration testing - testing that your Factory creates the correct potion, and
     * that the player is set up to be able to 'drink' the potion.
     *
     * The markers will heavily rely on your tests here to verify that your Factory and Potion.Player are implemented correctly.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Player player = new Player();

        AlchemyFactory factory = new AlchemyFactory(CraftingAlgorithmNames.PERFECT_MATCH);
//        AlchemyFactory factory = new AlchemyFactory(CraftingAlgorithmNames.UNORDERED_MATCH);
//        AlchemyFactory factory = new AlchemyFactory(CraftingAlgorithmNames.LOOSE_MATCH);

        Potion newPotion;
        ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();

        // DIZZY POTION = DARK_POWDER * 1 + SNAKE_POISON * 2 + MORNING_DEW * 1
        // Perfect -> FAILED / Unordered -> FAILED / Loose -> DIZZY
        ingredients.add(Ingredients.DARK_POWDER);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.MORNING_DEW);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.FIRE_DUST);

        newPotion = factory.craftPotion(ingredients);
        newPotion.drink(player);
        System.out.println("============== reset ==============");

        // FIRE POTION = FIRE_DUST * 2 + SNAKE_POISON * 1
        // Perfect -> FAILED / Unordered -> FIRED / Loose -> FIRED
        ingredients.clear();
        ingredients.add(Ingredients.FIRE_DUST);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.FIRE_DUST);

        newPotion = factory.craftPotion(ingredients);
        newPotion.drink(player);
        System.out.println("============== reset ==============");

        // ICE POTION = ICE_FLOWER * 2 + MORNING_DEW * 1
        // Perfect -> ICE / Unordered -> ICE / Loose -> ICE
        ingredients.clear();
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.MORNING_DEW);

        newPotion = factory.craftPotion(ingredients);
        newPotion.drink(player);
        System.out.println("============== reset ==============");
    }
}
