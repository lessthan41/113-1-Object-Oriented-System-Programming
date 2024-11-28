/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Algorithm;

import Enums.CraftingAlgorithmNames;

public class AlgorithmFactory {

    /**
     * Factory pattern to get crafting algorithm by name
     * @param name is the algorithm name
     * @return the crafting algorithm instance
     */
    public CraftingAlgorithm getAlgorithm(CraftingAlgorithmNames name) {
//        System.out.println("Get Crafting Algorithm " + name);
        if (name == CraftingAlgorithmNames.PERFECT_MATCH) {
            return new PerfectMatch();
        } else if (name == CraftingAlgorithmNames.UNORDERED_MATCH) {
            return new UnorderedMatch();
        } else if (name == CraftingAlgorithmNames.LOOSE_MATCH) {
            return new LooseMatch();
        } else {
            throw new RuntimeException("Invalid name");
        }
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        AlgorithmFactory factory = new AlgorithmFactory();
        CraftingAlgorithm algorithm = factory.getAlgorithm(CraftingAlgorithmNames.PERFECT_MATCH);
        System.out.println(algorithm);
        algorithm = factory.getAlgorithm(CraftingAlgorithmNames.UNORDERED_MATCH);
        System.out.println(algorithm);
        algorithm = factory.getAlgorithm(CraftingAlgorithmNames.LOOSE_MATCH);
        System.out.println(algorithm);
    }
}
