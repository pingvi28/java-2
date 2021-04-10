import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class TouchCommand {
    public static void main(String path) {
        try{
            File paths = Paths.get(path).normalize().toAbsolutePath().toFile();
            Scanner scanner = new Scanner(System.in);
            long time = scanner.nextLong();
            if (paths.setLastModified(time)) {
                System.out.println("Last modified time is set");
            }
            else {
                System.out.println("Last modified time cannot be set");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
