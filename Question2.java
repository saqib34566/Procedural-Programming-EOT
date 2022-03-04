/*
program gets 10 people to enter their names and vote amongst each other
whoever gets the highest number of votes wins

Author: Nazmus Saqib 210054318
6/1/2022

*/

import java.util.Scanner;

public class Voting
{
    public static void main(String[] args)
    {
        final int maxCandidate = 10;
        Candidate[] candidateArr = new Candidate[maxCandidate];

        askCandidateName(candidateArr, maxCandidate);
        VoteCandidate(candidateArr, maxCandidate);
        printWinners(candidateArr, maxCandidate);

    }

    // asks all 10 candidates for their name and stores it into the
    // Candidate Array
    public static void askCandidateName(Candidate[] candidateArray, int candidateNum)
    {
        for (int i = 0; i < candidateNum; i++)
        {
            String name = inputString("Name "+ (i+1) +"? ");
            candidateArray[i] = createCandidate(name);
        }

    }

    // voting phase: asks each candidates to vote one of the listed candidates
    public static void VoteCandidate(Candidate[] candidateArray, int candidateNum)
    {
        print("Voting: ");
        printSummary(candidateArray, candidateNum);

        for (int i = 0; i < candidateNum; i++)
        {
            int vote = inputVote(getName(candidateArray[i]) + " who do you vote for? ");
            addVotes(candidateArray[(vote-1)]);
        }
    }
  
    // method prints out the final winner or winners at the end
    // whoever got the most amount of votes
    public static void printWinners(Candidate[] candidateArray, int candidateNum)
    {
        int highestVotes = 0;
        String winners = "";
        for (int i = 0; i < candidateNum; i++)
        {
            if (getVotes(candidateArray[i]) > highestVotes)
            {
                winners = getName(candidateArray[i]);
                highestVotes = getVotes(candidateArray[i]);
            }
            else if (getVotes(candidateArray[i]) == highestVotes)
            {
                winners += " " + getName(candidateArray[i]);
            }
        }
        print("Winner(s): " + winners);
    }

    // prints out all the voting candidates numbered from 1 - 10
    public static void printSummary(Candidate[] candidateArray, int candidateNum)
    {
        for (int i = 0; i < candidateNum; i++)
        {
            print(" "+(i+1) +"="+ getName(candidateArray[i]));
        }
        print("\n");
    }

    // *****************************************************************
    // ADT for Candidate
    // operations:
    // -create a new candidate given a name
    // -get the name of a candidate
    // -get the amount of votes a candidate has
    // -increment the number of votes for a candidate

    // Candidate record
    public static class Candidate
    {
        String name;
        int votes;
    }
  
          return c.votes;
    }

    // increment the amount of votes for the candidate
    public static void addVotes(Candidate c)
    {
        c.votes = c.votes + 1;
    }

    //*********************************************************************

    // general method to input a String
    public static String inputString(String message)
    {
        print(message);
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        return response;
    }

    // method to input an integer for voting phase
    public static int inputVote(String message)
    {
        int response = Integer.parseInt(inputString(message));

        // repeatedly asks to input a number between 1 and 10,
        // if user has not done so
        while (response < 1 || response > 10)
        {
            response = Integer.parseInt(inputString("please enter a valid candidate number: "));
        }
        return response;
    }


    // general method to print out a string
    public static void print(String message)
    {
        System.out.print(message);
    }
}



