import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class FileManager {
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";

    private static final HashMap<String, Class> mapCommand = new HashMap<>();
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        mapCommand.put("path now", PathNowCommand.class);
        mapCommand.put("help", HelpCommand.class);
        mapCommand.put("ls", LsCommand.class);
        mapCommand.put("cd", CdCommand.class);
        mapCommand.put("touch", TouchCommand.class);
        mapCommand.put("mkdir", MkdirCommand.class);
        mapCommand.put("tree", TreePathCommand.class);
        mapCommand.put("rm", RmCommand.class );

        String path = "\\Users\\79179\\Documents\\jaja";
        Scanner scanner = new Scanner(System.in);
        System.out.println(YELLOW + "Enter a command: [if you don't know ==> 'help']\\n" + RESET);
        String command = scanner.nextLine();
        while (!(command.equals("exit"))){
            if(mapCommand.containsKey(command)){
                Method method = mapCommand.get(command).getMethod("main",String.class);
                if(command.equals("cd") || command.equals("rm")){
                    path = (String) method.invoke(mapCommand.get(command), path);
                } else{
                    method.invoke(mapCommand.get(command), path);}
            }
            else System.out.println("Unknown command. Try again");

            System.out.println(YELLOW + "\nEnter a command:" + RESET);
            command = scanner.nextLine();
        }
    }
}
