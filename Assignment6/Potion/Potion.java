/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Potion;

import Enums.Ingredients;
import Enums.PotionNames;

import java.util.List;

public abstract class Potion {

    /**
     * The number of gold pieces this potion is worth
     */
    private final int value;

    /**
     * The type of potion this is (specified in subclasses)
     */
    protected PotionNames potionName = null;

    /**
     * Static function for CraftAlgorithm to query for ingredients
     * @param name is the potion to query ingredient
     * @return the ingredients of the query potion
     * @throws IllegalArgumentException if there is no potion of given name
     */
    public static List<Ingredients> getIngredients(PotionNames name) throws IllegalArgumentException {
        if (name == PotionNames.ICE) {
            return IcePotion.ingredients;
        } else if (name == PotionNames.FIRE) {
            return FirePotion.ingredients;
        } else if (name == PotionNames.DIZZY) {
            return DizzyPotion.ingredients;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Static function for CraftAlgorithm to create potion instance
     * @param name is the type of potion create
     * @return the create potion
     * @throws IllegalArgumentException if there is no potion of given name
     */
    public static Potion getPotionInstance(PotionNames name) throws IllegalArgumentException {
        if (name == PotionNames.ICE) {
            System.out.println("You get an ICE Potion.");
            return new IcePotion(10);
        } else if (name == PotionNames.FIRE) {
            System.out.println("You get a FIRE Potion.");
            return new FirePotion(10);
        } else if (name == PotionNames.DIZZY) {
            System.out.println("You get a DIZZY Potion.");
            return new DizzyPotion(10);
        } else if (name == PotionNames.FAILED) {
            System.out.println("You get a FAILED Potion.");
            return new FailedPotion(0);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructor, take in value as parameter and save in instance variable
     * @param value the number of gold pieces this potion is worth
     */
    public Potion(int value) {
        this.value = value;
    }

    /**
     * Get the name/type of this potion
     * @return the PotionName saved in this object
     */
    public PotionNames getName() {
        return this.potionName;
    }

    /**
     * Makes the target drink this potion, and communicate the corresponding effect to the target
     * @param target the entity drinking this potion
     */
    public void drink(Player target)
    {
        // consume potion and apply effect to target
        // This method should be overridden in subclasses
        System.out.println("Player drink the potion.");
    }
}
