/**
 * cs603 Homework1
 * @author Yifei Feng
 */

//concrete class FillIn

package school;

import school.assessment.Question;

//concrete class FillIn
public class FillIn implements Question{
    // question text and correct answers
    private String text;
    private String correct;
    
    // parameters are question text and correct answers
    // initialize parameters
    public FillIn(String text, String correct){
        this.text = text;
        this.correct = correct;
    }
    
    // parameter is the answer filled by a test taker
    // function that compares parameter to the correct answer set in the constructor
    public boolean mark(String ans){
        if(correct.equals(ans)){
        return true;
        }
        return false;
    }
    
    //return a String with the text followed by each possible answer on a separate line
    public String toString(){
        String ques;
        ques = this.text + "\n";
        return ques;
    }
    
}
