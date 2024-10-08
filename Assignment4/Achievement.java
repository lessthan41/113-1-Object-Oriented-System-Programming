public class Achievement {
    /**
     * String that represents the name of this Achievement
     */
    private String achievementName;
    /**
     * String that represents a written description of this Achievement
     */
    private String achievementDescription;
    /**
     * Boolean that keeps track of whether this achievement has been unlocked yet
     */
    private Boolean isUnlocked;

    /**
     * Constructor
     * @param name is the String that represents the name of this Achievement
     * @param description is the String that represents a written description of this Achievement
     */
    public Achievement(String name, String description) {
        this.achievementName = name;
        this.achievementDescription = description;
        this.isUnlocked = false;
    }

    /**
     * Get the name of the achievement
     * @return the name of the achievement
     */
    public String getAchievementName() {
//        System.out.println(this.achievementName);
        return this.achievementName;
    }

    /**
     * Get the description of the achievement
     * @return the description of the achievement
     */
    public String getAchievementDescription() {
//        System.out.println(this.achievementDescription);
        return this.achievementDescription;
    }

    /**
     * Check whether or not the achievement is unlocked
     * @return a Boolean indicating whether or not the achievement is unlocked
     */
    public Boolean checkUnlocked() {
//        System.out.println(this.isUnlocked);
        return this.isUnlocked;
    }

    /**
     * Change the achievement’s state to unlocked
     */
    public void unlockAchievement() {
//        System.out.println("Unlock Achievement!");
        this.isUnlocked = true;
    }

    /**
     * Override the toString method and return a string that indicates the name and description
     * of the achievement, as well as its current locked state
     * @return String representation of this Achievement
     */
    @Override
    public String toString() {
//        System.out.println("String Representation of Achievement");
        if (this.isUnlocked)
            return "Achievement with name: " + this.achievementName + ", description: " + this.achievementDescription + " and is unlocked";
        else
            return "Achievement with name: " + this.achievementName + ", description: " + this.achievementDescription + " and is not unlocked";
    }

    /**
     * Regression test
     * @param args is not used in the test
     */
    public static void main(String[] args) {
        Achievement a =  new Achievement("name", "description");
        System.out.println(a.getAchievementName());
        System.out.println(a.getAchievementDescription());
        System.out.println(a);
        System.out.println(a.checkUnlocked());
        a.unlockAchievement();
        System.out.println(a.checkUnlocked());
        System.out.println(a);
    }
}
