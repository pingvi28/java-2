import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class CdCommand {
    public static String main(String path) {
        Scanner scanner = new Scanner(System.in);
        String newPath = scanner.nextLine();
        File paths = Paths.get(newPath).normalize().toAbsolutePath().toFile();
        if(paths.exists()){
            return newPath;
        }
        else System.out.println("Incorrect path");
        return path;
    }
}
