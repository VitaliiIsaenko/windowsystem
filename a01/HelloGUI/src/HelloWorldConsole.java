import java.io.IOException;

public class HelloWorldConsole {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\r\nSelect one of the following:\r\n [D]eutsch\r\n [E]nglish\r\n [F]rancais\r\n [Q]uit");

            char inputSymbol;
            do {
                inputSymbol = (char) System.in.read();
            }
            while (inputSymbol == '\n' || inputSymbol == '\r');
            inputSymbol = Character.toLowerCase(inputSymbol);

            if (inputSymbol == 'q') {
                System.out.println("Quitting...");
                break;
            }

            String message;
            switch (inputSymbol) {
                case 'd':
                    message = "Guten Tag!";
                    break;
                case 'e':
                    message = "Hello!";
                    break;
                case 'f':
                    message = "Bonjour";
                    break;
                default:
                    message = "Sorry, we don't support this language. Try again!";
                    break;
            }
            System.out.println(message);
        }
    }
}

