/**
 * cs603 Homework1
 * @author Yifei Feng
 */

//main

package school;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// class to take the quiz
public class School {

    // main function
    public static void main(String[] args) {
        // create new quiz
        Quiz quiz = new Quiz();
        // create new questions(Multiplechoice/Fillin)
        MultipleChoice q1 = new MultipleChoice("On which continent is the country of India?",new ArrayList<String>(Arrays.asList("Asia","Europe","Africa")),"Asia");
        FillIn q2 = new FillIn("CSUEB is in the city of _______","Hayward");
        // list to record student's answers
        List<String> studentanswer= new ArrayList<String>();
        // record keyboard input
        Scanner input = new Scanner(System.in);
        
        // add questions into quiz
        quiz.add(q1);
        quiz.add(q2);
        
        // for loop to display questions and record answers
        for(int i = 0; i<quiz.getquestionnumber();i++){
            // display question
            System.out.println(quiz.questions.get(i).toString());
            System.out.println("Please enter your answer");
            // get student answer
            String inputans = input.nextLine();
            // record student answer
            studentanswer.add(inputans);
        }
        // grade and display the student score
        System.out.println("Score: "+quiz.grade(studentanswer));
    
    }
    
}
