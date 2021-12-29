/**
 * cs603 Homework1
 * @author Yifei Feng
 */

// concrete class Quiz

package school;

import school.assessment.Question;
import java.util.List;
import java.util.ArrayList;

// concrete class Quiz
public class Quiz {
    // list to record questions in the quiz
    public List<Question> questions;
    // score in this quiz
    private int score;
    
    // initialize questions list
    public Quiz(){
        this.questions = new ArrayList<Question>();
    }
    
    // parameter is the question that needs to be added to questions list
    // add a question to the questions list
    void add(Question question){
        questions.add(question);
    }
    
    // parameter is the list of student's answers
    // function that return the number of correct answers in the parameter
    int grade(List<String> answers){
        // initialize score
        score = 0;
        // grade questions and increase score if the answer is correct
        for(int i = 0; i<answers.size();i++){
            if(this.questions.get(i).mark(answers.get(i))){
                score++;
            }
        }
        return score;
    }
    
    // function to get the size of questions list
    public int getquestionnumber(){
        return questions.size();
    }
}
