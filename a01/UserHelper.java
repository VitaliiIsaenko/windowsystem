import java.io.*;

/**
 * Class-helper that is responsible for user input treatment
 */
public class UserHelper {
    /**
     * Gets user input from console and transforms it to lower case
     */
    public static String getUserInput() {
        String inputLine = null;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
}
