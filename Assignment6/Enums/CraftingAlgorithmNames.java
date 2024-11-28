/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Enums;

public enum CraftingAlgorithmNames {
    /**
     * Crafting Algorithm that success if both ingredient order and quantity are the same as recipe
     */
    PERFECT_MATCH,
    /**
     * Crafting Algorithm that success if ingredient quantity is the same as recipe
     */
    UNORDERED_MATCH,
    /**
     * Crafting Algorithm that success if ingredient quantity is more than recipe
     */
    LOOSE_MATCH,
}
