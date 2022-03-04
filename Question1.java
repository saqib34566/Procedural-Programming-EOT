/*
Program asks students series of multiplication table questions and prints out their result
Nazmus Saqib 
*/

import java.util.Scanner;

public class MultTableQuestion
{
    public static void main(String[] args)
    {
        askRange();
    }

    // asks the student to input the range of x values to be used
    // in the multiplication questions
    public static void askRange()
    {
        final int xStart = inputInt("Enter x start (start>0): ");
        final int xEnd = inputInt("Enter x end (end>=start): ");

        askQuestions(xStart, xEnd);
    }

    // asks the students a series of x * y questions
    // given the start and end range as parameters
    public static void askQuestions(int xStart, int xEnd)
    {
        final int maxMult = 12;
        int questionNum = 0;        // total question number
        int questionsCorrect = 0;   // total correct questions

        for (int i = xStart; i <= xEnd; i++)
        {
            for (int j = 1; j <= maxMult; j++)
            {
                int answer = inputInt("what is "+ i +" * "+ j +"? ");

                questionsCorrect += checkAnswer(i, j, answer);
                questionNum++;
            }
        }

        printResult(questionNum, questionsCorrect);
    }
    
    // for the multiplication to see if it is correct
    public static int checkAnswer(int num1, int num2, int answer)
    {
        int isCorrect;
        if (answer == (num1 * num2))
        {
            print("Correct");
            isCorrect = 1;
        }
        else
        {
            print("Incorrect");
            isCorrect = 0;
        }

        return isCorrect;
    }

    // prints the students results from the test
    // showing percentage and grade
    public static void printResult(int questionNum, int questionsCorrect)
    {
        int percentage = calculatePercentage(questionNum, questionsCorrect);
        String grade = calculateGrade(percentage);
        print("You scored "+ questionsCorrect +"/"+ questionNum +" ("+ percentage +"%) "+ grade +" grade.");
    }

    // calculates the percentage of correct answers from total questions
    // to the nearest integer and returns it
    public static int calculatePercentage(int total, int correct)
    {
        double percent = ((double) correct/(double) total) * 100;
        double percentRounded = Math.round(percent);
        int percentInt = (int)percentRounded;

        return  percentInt;
    }

    // calculates the grade based off of the percentage of the student
    public static String calculateGrade(int percentage)
    {
        String grade;
        if (percentage >= 70)
        {
            grade = "A";
        }
        else if (percentage >= 60)
        {
            grade = "B";
        }
        else if (percentage >= 50)
        {
            grade = "C";
        }
        else if (percentage >= 40)
        {
            grade = "D";
        }
        else
        {
            grade = "F";
        }

        return grade;
    }

    // general input method for inputting integers
    public static int inputInt (String message)
    {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        int intResponse = Integer.parseInt(response);

        return intResponse;
    }

    // general print method to print a message
    public static void print(String message)
    {
        System.out.println(message);
    }

}
