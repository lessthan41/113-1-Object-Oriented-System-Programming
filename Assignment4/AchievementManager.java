import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AchievementManager {

    /**
     * Map storing all achievements, keyed by unique IDs
     */
    private Map<Integer, Achievement> achievements;

    /**
     * Constructor, sets up achievements Map
     */
    public AchievementManager() {
        // todo: set up achievements class variable as a HashMap
        this.achievements = new HashMap<>();
    }

    /**
     * Adds a new achievement
     * @param achievement the achievment object to be added
     * @throws IllegalArgumentException if achievement is null
     */
    public void addAchievement(Achievement achievement) {
        // todo: adds achievement to achievements map, key should be next available integer
        this.achievements.put(this.achievements.size(), achievement);
    }

    /**
     * Gets an achievement corresponding to specified id
     * @param id the unique identifier for the achievement
     * @return the achievement corresponding to the provided id
     * @throws IllegalArgumentException if id does not exist in collection
     */
    public Achievement getAchievement(int id)
    {
        // todo: returns Achievement object stored in map with specified integer key
        return this.achievements.get(id);
    }

    /**
     * Returns a List of all achievements that are currently locked
     * @return a List containing all currently locked achievements
     */
    public List<Achievement> getLockedAchievements()
    {
        // todo: implement this method
        List<Achievement> lockedAchievements = new ArrayList<>();
        for (Achievement achievement : this.achievements.values()) {
            if (!achievement.checkUnlocked()) {
                lockedAchievements.add(achievement);
            }
        }
        return lockedAchievements;
    }

    /**
     * Returns a list of all achievements that are currently unlocked
     * @return A List containing all currently unlocked achievements
     */
    public List<Achievement> getUnlockedAchievements()
    {
        // todo: implement this method
        List<Achievement> lockedAchievements = new ArrayList<>();
        for (Achievement achievement : this.achievements.values()) {
            if (achievement.checkUnlocked()) {
                lockedAchievements.add(achievement);
            }
        }
        return lockedAchievements;
    }

    /**
     * Returns a list of all Achievement objects currently stored in the map
     * @return a List of Achievements
     */
    public List<Achievement> getAllAchievements()
    {
        // Create a new ArrayList
        List<Achievement> a = new ArrayList<Achievement>();
        // Iterate through all achievements stored in the map
        for(Achievement achievement : achievements.values())
        {
            // Add each achievement to the end of the List
            a.add(achievement);
        }
        // Return the List containing all Achievements
        return a;
    }

    /**
     * Returns a list containing all integer keys
     * @return a List of Integers
     */
    public List<Integer> getAllKeys()
    {
        // Create a new Array List
        List<Integer> keys = new ArrayList<Integer>();
        // Iterate through all keys in the map
        for(int key: achievements.keySet())
        {
            // add each unique integer key to the list
            keys.add(key);
        }
        // return the final list of keys
        return keys;
    }

    /**
     * Returns a string representation of the AchievementManager object
     * Should display each achievement with its associated id
     * @return the string representation
     */
    public String toString()
    {
        // todo: implement the toString method
        StringBuilder sb = new StringBuilder();
        for (Integer key : achievements.keySet()) {
            Achievement achievement = achievements.get(key);
            sb.append(key).append(" ").append(achievement.toString()).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     * Regression testing
     * @param args
     */
    public static void main(String[] args)
    {
        // todo: write regression test for all of the methods that YOU had to implement
        // there is no need to test the methods that were already implemented
        AchievementManager manager = new AchievementManager();
        Achievement achievement1 = new Achievement("a1", "acheivement1");
        Achievement achievement2 = new Achievement("a2", "acheivement2");
        achievement2.unlockAchievement();
        manager.addAchievement(achievement1);
        manager.addAchievement(achievement2);
        System.out.println(manager);
        System.out.println(manager.getLockedAchievements());
        System.out.println(manager.getUnlockedAchievements());
        System.out.println(manager.getAllAchievements());
        System.out.println(manager.getAchievement(0));
        System.out.println(manager.getAllKeys());
    }
}
