import java.io.File;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RmCommand {
    public static String main(String path) {
        File paths = Paths.get(path).normalize().toAbsolutePath().toFile();
        Pattern pattern = Pattern.compile("(((([^\\*\\|\\\\\\:\\\"<>\\?\\/]*)(\\\\|\\/)*)+)(\\\\|\\/){1}([^\\-\\*\\|\\\\\\:\\\"<>\\?\\/]*))");
        Matcher matcher = pattern.matcher(path);
        if (paths.exists() && paths.isFile() && paths.delete()) {
            System.out.println("I delete this file");
            if(matcher.find()){
                path = matcher.group(2);
            }
        } else if (paths.exists() && paths.isDirectory()) {
            deleteCont(paths);
            System.out.println("I delete this directory");
            if(matcher.find()){
                path = matcher.group(2);
            }
        } else System.out.println("I delete");
        return path;
    }

    public static void deleteCont(File paths){
        String[] entries = paths.list();
        for (String s : entries) {
            File currentFile = new File(paths.getPath(), s);
            if(currentFile.isDirectory()){
                deleteCont(currentFile);
            }
            currentFile.delete();
        }
        paths.delete();
    }
}
