
/**
 * Class contains main method for the HelloWorldConsole application
 */
public class HelloWorldConsole {
    private String userInput = "abs";

    /**
     * Provides information to user about possible language selection options
     */
    private void setUpChoice() {
        System.out.println("Select one of the followig:\n    [D]eutsche\n    [E]nglish\n    [F]rancais\n [Q]uit");
    }

    /**
     * Launches a loop that requires user to write an input
     * Terminates when user gives terminator character
     */
    private void startAsking() {
        while (!(userInput = UserHelper.getUserInput()).equals("q")) {
            checkUserInput(userInput);
        }
        closeWindow();
    }

    /**
     * Defines what greeting the program should output based on user's input
     * @param userInput Is a user input character/sequence of characters
     */
    private void checkUserInput(String userInput) {
        switch (userInput) {
        case "d":
            System.out.println("Guten Tag!");
            break;
        case "e":
            System.out.println("Hello there!");
            break;
        case "f":
            System.out.println("Bonjour!");
            break;
        case "q":
            break;
        default:
            System.out.println("Input is not valid, please follow the guidelines");
        }
        setUpChoice();
    }

    /**
     * Notifies user on application closing
     */
    private void closeWindow() {
        System.out.println("Quitting...");
    }

    /**
     * Main method of the HelloWorldConsole program
     * Shows user options to choose and start asking for input
     */
    public static void main(String[] args) {
        HelloWorldConsole helloWorld = new HelloWorldConsole();
        helloWorld.setUpChoice();
        helloWorld.startAsking();
    }

}
