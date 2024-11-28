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
import java.util.List;

public class PerfectMatch implements CraftingAlgorithm {

    /**
     * The craft function that implement the crafting process by PerfectMatch algorithm
     * @param ingredients is the given ingredients with orders matter
     * @return the output Potion.Potion
     */
    @Override
    public Potion craft(List<Ingredients> ingredients) {
        System.out.println("Craft Potion with PerfectMatch Algorithm.");
        PotionNames name = PotionNames.FAILED;
        for (PotionNames n : PotionNames.values()) {
            if (n != PotionNames.FAILED) {
                List<Ingredients> correctIngredients = Potion.getIngredients(n);
                if (correctIngredients.size() == ingredients.size()) {
                    boolean success = true;
                    for (int i = 0; i < correctIngredients.size(); i++) {
                        if (!correctIngredients.get(i).equals(ingredients.get(i))) {
                            success = false;
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
        return CraftingAlgorithmNames.PERFECT_MATCH;
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        CraftingAlgorithm craftingAlgorithm = new PerfectMatch();
        System.out.println(craftingAlgorithm.getName());

        // failed craft
        List<Ingredients> ingredients = new ArrayList<>();
        Potion potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // ice potion
        ingredients.clear();
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.MORNING_DEW);
        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");

        // failed craft (order)
        ingredients.clear();
        ingredients.add(Ingredients.ICE_FLOWER);
        ingredients.add(Ingredients.MORNING_DEW);
        ingredients.add(Ingredients.ICE_FLOWER);
        potion = craftingAlgorithm.craft(ingredients);
        System.out.println("You get a " + potion.getName() + " potion.");
    }
}
