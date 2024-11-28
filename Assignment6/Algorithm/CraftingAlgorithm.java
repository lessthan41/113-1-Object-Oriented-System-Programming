/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Algorithm;

import Enums.CraftingAlgorithmNames;
import Enums.Ingredients;
import Potion.Potion;

import java.util.List;

public interface CraftingAlgorithm {

    /**
     * The function that implement the crafting process
     * @param ingredients is the given ingredients with orders matter
     * @return the output Potion.Potion
     */
    public Potion craft(List<Ingredients> ingredients);

    /**
     * Get name of the crafting algorithm
     * @return the name of the crafting algorithm
     */
    public CraftingAlgorithmNames getName();
}
