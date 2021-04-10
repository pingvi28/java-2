import java.io.File;
import java.nio.file.Paths;


public class LsCommand {
    public static void main(String path) {
        String[] l;
        File paths = Paths.get(path).normalize().toAbsolutePath().toFile();

        if(paths.isAbsolute() && paths.listFiles() != null) {
            l = paths.list();
            for (String elem: l){
                System.out.println(elem);
            }
        }
        else System.out.println("Uncorrected path");
    }
}