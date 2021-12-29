/**
 * cs603 Homework1
 * @author Yifei Feng
 */

// strategy interface Question

package school.assessment;

// the Strategy interface Question
public interface Question {
    // parameter is the answer entered by a test taker
    // function that returns true if its parameter is the correct answer, false if not
    public boolean mark(String ans);
}