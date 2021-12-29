/**
 * cs603 Homework1
 * @author Yifei Feng
 */

// concrete class MultipleChoice

package school;

import school.assessment.Question;
import java.util.List;

// concrete class MultipleChoice
public class MultipleChoice implements Question{
    // question text, choice list and correct answers
    private String text;
    private List<String> choice;
    private String correct;
    
    // parameters are question text, choice list and correct answers
    // initialize parameters
    public MultipleChoice(String text, List<String> choice, String correct){
        this.text = text;
        this.choice = choice;
        this.correct = correct;
    }
    
    // parameter is the answer chosen by a test taker
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
        for(int i = 0; i<choice.size();i++){
            ques = ques + choice.get(i) + "\n";
        }
        return ques;
    }
}
