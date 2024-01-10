package DSA_Project_p2;
import java.util.*;

public class Main {
    public static void main(String [] args) {
        // Store the 50 states and their capitals in a 2D String array sorted alphabetically by state name
        String[][] state_capitals = {
            {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
            
            {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
        };
    
        // For ease of reading, initialize variable n to equal the length of the Array's rows
        int n = state_capitals[0].length;
    
        // Print the contents of the array
        for(int i=0;i<50;i++) {
            System.out.println(state_capitals[0][i] + ", " + state_capitals[1][i]);
            }
        
        // Use a bubble sort to sort the 2D array by capital, using nested for loops to incrementally compare one capital to the capital indexed after it, and if they are out of order, swap them. This will sort the capitals alphabetically. It also applies the swap to the states, to ensure that they are moved in alignment with their associated capital.
        for(int i=0; i<n; i++) {
            String tempCities;
            String tempStates;
            for(int j=i+1; j<n; j++) {
                if(state_capitals[1][j].compareTo(state_capitals[1][i]) < 0) {
                    tempCities = state_capitals[1][i];
                    state_capitals[1][i] = state_capitals[1][j];
                    state_capitals[1][j] = tempCities;
    
                    tempStates = state_capitals[0][i];
                    state_capitals[0][i] = state_capitals[0][j];
                    state_capitals[0][j] = tempStates;
                    }
                }
            }
    
        // Ask user to enter a name of the capital corresponding with a U.S. state.
        System.out.println("\n --- You will be given the names of all 50 states. For each state, enter the corresponding state capital! Input is not case sensitive. At the end, see your total score! Type 'Quit' at any time to exit the program. ---\n");
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int correct = 0;
        int incorrect = 0;
        String correctStates[] = new String[50];
        String incorrectStates[] = new String[50];
        for(int i=0;i<n;i++) {
            System.out.println("\n" + state_capitals[0][i] + ": ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase(state_capitals[1][i])) {
                System.out.println("Correct! +1 point. Generating next state.\n");
                score += 1;
                correctStates[i] = state_capitals[0][i];
                correct += 1;
            } else if(answer.equalsIgnoreCase("quit")) {
                System.out.println("Quitting program. Thanks for playing!");
                break;
            } else {
                System.out.println("Incorrect! Generating next state.\n");
                incorrectStates[i] = state_capitals[0][i];
                incorrect += 1;
            }
        }
        System.out.println("Total score: " + score + "/" + n + "\nIf you would like to see an itemized breakdown of your correct/incorrect states, enter '1'. Otherwise, enter '0' to exit program.");
        Scanner finalAnswer = new Scanner(System.in);
        int answer = finalAnswer.nextInt();
        if(answer == 1) {
            System.out.println("\nCORRECT STATES:\n");
            for(int i=0; i<correct; i++) {
                if(correctStates[i] != null) {
                    System.out.println(correctStates[i]);
                } else {
                    continue;
                }
            }
            System.out.println("\nINCORRECT STATES:\n");
            for(int i=0; i<incorrect; i++) {
                if(incorrectStates[i] != null) {
                    System.out.println(incorrectStates[i]);
                    } else {
                        continue;
                    }
            }
            System.out.println("\nThanks for playing!\n");
        } else if(answer == 0) {
            System.out.println("Thanks for playing!");
            }
            scanner.close();
            finalAnswer.close();
    } 
}
