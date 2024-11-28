/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Potion;

public class Player {

    /**
     * The constructor for player object
     */
    public Player() {}

    /**
     * A placeholder stub for the effect from drinking a Potion.FailedPotion
     */
    public void randomEffect()
    {
        System.out.println("Something strange happened...");
    }

    /**
     * A stub for the effect from drinking a Potion.IcePotion
     */
    public void frozenEffect() {
        System.out.println("Player start to feel cold.");
    }

    /**
     * A stub for the effect from drinking a Potion.FirePotion
     */
    public void burningEffect() {
        System.out.println("Player start to feel hot.");
    }

    /**
     * A stub for the effect from drinking a Potion.DizzyPotion
     */
    public void dizzyEffect() {
        System.out.println("Player start to feel dizzy.");
    }

    /**
     * Regression test of the class
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        Player player = new Player();
        player.randomEffect();
        player.frozenEffect();
        player.burningEffect();
        player.dizzyEffect();
    }
}
