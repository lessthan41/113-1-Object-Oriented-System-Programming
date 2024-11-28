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

public class UnorderedMatch implements CraftingAlgorithm {

    /**
     * The craft function that implement the crafting process by UnorderedMatch algorithm
     * @param ingredients is the given ingredients with orders matter
     * @return the output Potion.Potion
     */
    @Override
    public Potion craft(List<Ingredients> ingredients) {
        System.out.println("Craft Potion with UnorderedMatch Algorithm.");
        PotionNames name = PotionNames.FAILED;
        for (PotionNames n : PotionNames.values()) {
            if (n != PotionNames.FAILED) {
                List<Ingredients> correctIngredients = Potion.getIngredients(n);
                if (correctIngredients.size() == ingredients.size()) {
                    boolean success = true;
                    // record correct ingredients
                    HashMap<Ingredients, Integer> map = new HashMap<>();
                    for (Ingredients i : correctIngredients) {
                        if (map.containsKey(i)) {
                            map.put(i, map.get(i) + 1);
                        } else {
                            map.put(i, 1);
                        }
                    }
                    // check quantity of ingredients match
                    for (Ingredients i : ingredients) {
                        if (!map.containsKey(i)) {
                            success = false;
                        } else if (map.get(i) <= 0) {
                            success = false;
                        } else {
                            map.put(i, map.get(i) - 1);
                        }
                    }
                    if (success) {
                        name = n;
                    }
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
        return CraftingAlgorithmNames.UNORDERED_MATCH;
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        CraftingAlgorithm craftingAlgorithm = new UnorderedMatch();
        System.out.println(craftingAlgorithm.getName());

        // failed craft
        List<Ingredients> ingredients = new ArrayList<>();
        Potion potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // fire potion (unordered)
        ingredients.clear();
        ingredients.add(Ingredients.FIRE_DUST);
        ingredients.add(Ingredients.SNAKE_POISON);
        ingredients.add(Ingredients.FIRE_DUST);
        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // failed craft (quantity)
        ingredients.clear();
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.MORNING_DEW);
        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");
    }
}
