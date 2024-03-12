import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/* 1. Intended to be executed through 'inputLouis'.
*  2. Change FILE_PATH to reflect your P1input.txt, as it's hardcoded.
*  3. This code was created by Louis Cubero, if anyone submitted code very similar to mine, they plagiarized and did not use it for educational purposes.
*/

/**
 * This class handles the input for a word puzzle game, reading letters and solutions from our text file.
 */
public class InputLouis {
    /** The file path for the input file. */
    private static final String FILE_PATH = "/Users/louis/Project1/Project1/src/P1input.txt";

    /**
     * The main method that reads the input file, creates a puzzle GUI, and starts the game.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        TextFileInput in = new TextFileInput(FILE_PATH);
        String letters = readLetters(in);
        String[] solutions = readSolutions(in);
        
        PuzzleGUI puzzleGUI = new PuzzleGUI(letters, solutions);
        puzzleGUI.startGame();
        playGame(puzzleGUI, letters, solutions);
    }
    
    /**
     * Reads the letters from the input file.
     *
     * @param in The TextFileInput object for reading the file.
     * @return The letters read from the file.
     */
    private static String readLetters(TextFileInput in) {
        return in.readLine();
    }

    /**
     * Reads the solutions from the input file.
     *
     * @param in The TextFileInput object for reading the file.
     * @return The solutions read from the file.
     */
    private static String[] readSolutions(TextFileInput in) {
        List<String> solutionsList = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            solutionsList.add(line);
        }
        return solutionsList.toArray(new String[0]);
    }

    /**
     * Checks if a guess is valid based on the given letters.
     *
     * @param guess The guess to check.
     * @param letters The letters available for the guess.
     * @return True if the guess is valid, false otherwise.
     */
    private static boolean isValidGuess(String guess, String letters) {
        for (char c : guess.toCharArray()) {
            if (letters.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Displays an error message in a dialog box.
     *
     * @param message The message to display.
     */
    private static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Plays the word puzzle game, prompting the user for guesses and updating the GUI.
     *
     * @param puzzleGUI The PuzzleGUI object representing the game interface.
     * @param letters The letters available for the game.
     * @param solutions The solutions to the puzzle.
     */
    private static void playGame(PuzzleGUI puzzleGUI, String letters, String[] solutions) {
        int score = 0;
        while (score < solutions.length) {
            String input = JOptionPane.showInputDialog("Enter your guess:");
            if (input == null) {
                System.exit(0); // User clicked cancel, exits the game and shuts down the program
            }
            if (input.length() < 5) { // Check if the guess is less than 5 letters long
                displayErrorMessage("Your guess is less than 5 letters long!");
            } else if (!isValidGuess(input, letters)) { // Check if the guess contains letters not in the given set
                displayErrorMessage("Your guess contains letters that are not in the given set!");
            } else if (!containsIgnoreCase(solutions, input)) { // Check if the guess is in the solutions list
                displayErrorMessage("Your guess is not in the solutions list.");
            } else {
                score++;
                puzzleGUI.addGuessedWord(input);
                puzzleGUI.increaseScore(); // Increase the score in the GUI
                JOptionPane.showMessageDialog(null, "Your guess is correct!");
            }
        }
        if (score == solutions.length) { // Displays victory message if score is equal to total amount of solutions.
            JOptionPane.showMessageDialog(null, "Congratulations! You have guessed all possible solutions.");
        }
    }

    /**
     * Checks if a word is in the list of solutions, ignoring case.
     *
     * @param words The list of solutions.
     * @param input The word to check.
     * @return True if the word is in the list, false otherwise.
     */
    private static boolean containsIgnoreCase(String[] words, String input) {
        for (String word : words) { // Loop through the list of solutions
            if (word.equalsIgnoreCase(input)) { // Ignore case when comparing the words, extra precaution in case 'lowercase' function is not working
                return true;
            }
        }
        return false;
    }
}
