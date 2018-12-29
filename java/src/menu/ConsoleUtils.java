package menu;

import java.io.Console;
import java.io.IOException;

/*
 * ConsoleUtils exposes a few useful methods which can be used across a broad range of console apps.
 */
public class ConsoleUtils {
	private static Console console = null;

	/*
	 * This method will force execution to stop and wait until the user presses enter. It prompts the
	 * user to press enter to continue. It is irrelevant if the user types any text, execution will
	 * continue after 'Enter'.
	 */
	public static void pauseExecution() {
            if(console == null) console = System.console();
            System.out.print("Press Enter to Continue... ");
		console.readLine();
	}

	/*
	 * This method can be used if a particular operation requires confirmation, it is useful for delete
	 * or irreversible operations. It forces that the uses explicitly enters "y/yes" or "n/no", any
	 * other input will fail and the confirmation request will be presented again.
	 */
	public static boolean requestConfirmation() {
            String in = "";
            if(console == null) console = System.console();

            while (true) {
			System.out.print("Confirm Operation (y/n)... ");
			in = console.readLine().toLowerCase();
			if(in.equals("y") || in.equals("yes"))
                            return true;
			else if(in.equals("n") || in.equals("no"))
                            return false;
            }
	}

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033\143");
            }
        }
        catch (final IOException | InterruptedException e) {
        }
    }
}