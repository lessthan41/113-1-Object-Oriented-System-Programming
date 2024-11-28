/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Algorithm;

import Enums.CraftingAlgorithmNames;
import Enums.Ingredients;
import Enums.PotionNames;
import Potion.Potion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LooseMatch implements CraftingAlgorithm {

    /**
     * The craft function that implement the crafting process by LooseMatch algorithm
     * @param ingredients is the given ingredients with orders matter
     * @return the output Potion.Potion
     */
    @Override
    public Potion craft(List<Ingredients> ingredients) {
        System.out.println("Craft Potion with LooseMatch Algorithm.");
        PotionNames name = PotionNames.FAILED;
        for (PotionNames n : PotionNames.values()) {
            if (n != PotionNames.FAILED) {
                List<Ingredients> correctIngredients = Potion.getIngredients(n);
                // record correct ingredients
                HashMap<Ingredients, Integer> map = new HashMap<>();
                for (Ingredients i : correctIngredients) {
                    if (map.containsKey(i)) {
                        map.put(i, map.get(i) + 1);
                    } else {
                        map.put(i, 1);
                    }
                }
                // check quantity of ingredients more than recipe
                for (Ingredients i : ingredients) {
                    if (!map.containsKey(i)) {
                        continue;
                    } else {
                        map.put(i, map.get(i) - 1);
                    }
                }
                // success if all ingredients <= 0
                boolean success = true;
                for (Integer i : map.values()) {
                    if (i > 0) {
                        success = false;
                    }
                }
                // check success
                if (success) {
                    name = n;
                }
            }
        }

        return Potion.getPotionInstance(name);
    }

    /**
     * Get name of the crafting algorithm
     * @return the name of the crafting algorithm
     */
    @Override
    public CraftingAlgorithmNames getName() {
        return CraftingAlgorithmNames.LOOSE_MATCH;
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        CraftingAlgorithm craftingAlgorithm = new LooseMatch();
        System.out.println(craftingAlgorithm.getName());

        // failed craft
        List<Ingredients> ingredients = new ArrayList<>();
        Potion potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // dizzy potion (unordered & quantity)
        ingredients.clear();
        ingredients.add(Ingredients.MORNING_DEW);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.DARK_POWDER);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.FIRE_DUST);

        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // ice potion (unordered & quantity)
        ingredients.clear();
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.MORNING_DEW);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.SNAKE_POISON);
        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");
    }
}
