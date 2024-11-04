/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package IO;

public interface IO {
    /**
     * IO.IO function to handle the quiz process
     *
     * @return the final score of user
     */
    void startQuiz(String fpath);

    /**
     * Get user's NSID
     *
     * @return NSID of the user
     */
    String getNsid();
    double getScore();
}
