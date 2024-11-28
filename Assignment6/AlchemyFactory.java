/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

import Algorithm.AlgorithmFactory;
import Algorithm.CraftingAlgorithm;
import Enums.CraftingAlgorithmNames;
import Enums.Ingredients;
import Potion.Potion;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that uses the Factory Design Pattern to abstract the creation/crafting of potions
 */
public class AlchemyFactory {

    /**
     * The crafting algorithm used for crafting potion 
     */
    private CraftingAlgorithm craftingAlgorithm;

    /**
     * Constructor with specified crafting algorithm
     * @param craftingAlgorithmName is the name of the desired algorithm to craft the potion
     */
    public AlchemyFactory(CraftingAlgorithmNames craftingAlgorithmName) {
        this.setCraftingAlgorithm(craftingAlgorithmName);
    }

    /**
     * The factory method for creating a potion, given a list of ingredients
     * @param ingredients a List of the ingredients being combined
     * @return the crafted potion resulting from the list of ingredients
     */
    public Potion craftPotion(List<Ingredients> ingredients) {
        return this.craftingAlgorithm.craft(ingredients);
    }

    /**
     * Update the crafting algorithm to craft the potion
     * @param craftingAlgorithmName is the name of the desired algorithm to craft the potion
     */
    public void setCraftingAlgorithm(CraftingAlgorithmNames craftingAlgorithmName) {
        System.out.println("Set Craft Algorithm " + craftingAlgorithmName);
        AlgorithmFactory factory = new AlgorithmFactory();
        this.craftingAlgorithm = factory.getAlgorithm(craftingAlgorithmName);
    }

    /**
     * Get the current in-use crafting algorithm
     * @return the name of the desired algorithm to craft the potion
     */
    public CraftingAlgorithmNames getCraftingAlgorithmName() {
        System.out.println("Get Craft Algorithm Name");
        return this.craftingAlgorithm.getName();
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        AlchemyFactory alchemyFactory = new AlchemyFactory(CraftingAlgorithmNames.PERFECT_MATCH);
        ArrayList<Ingredients> ingredients = new ArrayList<>();
        System.out.println(alchemyFactory.getCraftingAlgorithmName());
        alchemyFactory.craftPotion(ingredients);

        alchemyFactory.setCraftingAlgorithm(CraftingAlgorithmNames.UNORDERED_MATCH);
        System.out.println(alchemyFactory.getCraftingAlgorithmName());
        alchemyFactory.craftPotion(ingredients);

        alchemyFactory.setCraftingAlgorithm(CraftingAlgorithmNames.LOOSE_MATCH);
        System.out.println(alchemyFactory.getCraftingAlgorithmName());
        alchemyFactory.craftPotion(ingredients);
    }
}
