public class HelpCommand {
    public static final String BLUE = "\033[0;34m";
    public static final String RESET = "\033[0m";

    public static void main(String path) {
        System.out.println( "\n- path now" +
                            "\n- ls" +
                            "\n- cd " + BLUE + "[path]" + RESET +
                            "\n- touch " + BLUE + "[file path]" + RESET +
                            "\n- mkdir " + BLUE + "[path]" + RESET +
                            "\n- tree " + BLUE + "[path]" + RESET +
                            "\n- rm " + BLUE + "[path|file path]" + RESET +
                            "\n- mkdir " + BLUE + "[path]" +  RESET + " -p" +
                            "\n- exit");
    }
}
