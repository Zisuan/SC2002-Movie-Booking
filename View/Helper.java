package View;

public class Helper {
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                System.out.print("\033[2J\033[1;1H");
            } else {
                System.out.print("\033[2J\033[1;1H");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static String getCharacterFromInt(int i) {
        return String.valueOf((char) (i + 'A'));
    }

    public static int getIntFromCharacter(String s) {
        return s.charAt(0) - 'A';
    }
}
