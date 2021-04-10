import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MkdirCommand {
    private static boolean mkPFlag = false;

    public static void main(String path) {
        File paths = Paths.get(path).normalize().toAbsolutePath().toFile();
        if(paths.exists()){
            Scanner scanner = new Scanner(System.in);
            String newDirectories = scanner.nextLine();
            if (!chekNewDirectory(newDirectories).equals("0")){
                path = path + "\\" + chekNewDirectory(newDirectories);
                paths = Paths.get(path).normalize().toAbsolutePath().toFile();
                if(mkPFlag){
                    paths.mkdirs();
                    System.out.println("I create directories");
                }
                else {
                    paths.mkdir();
                    System.out.println("I create directory");
                }
            }
            else System.out.println("I can find this path, but your directory path doesn't correct");
        }
        else System.out.println("I can't find this path");
    }

    public static String chekNewDirectory(String newDirectories){
        String pathWithoutP = null;
        String flagToCorrect = null;
        String flagForP = null;
        String flagForOne = null;
        String ret = "0";
        String mkP= "-p";
        Pattern pattern1 = Pattern.compile("(((([^\\*\\|\\\\\\:\\\"<>\\?\\/]*)(\\\\|\\/)*)+([^\\*\\|\\\\\\:\\\"<>\\?\\/]*))[^\\s\\-\\*\\|\\\\\\:\\\"<>\\?\\/]{1})([\\ ]+(-p)?)");
        Pattern pattern2 = Pattern.compile("(((([^\\*\\|\\\\\\:\\\"<>\\?\\/]*)(\\\\|\\/)*)+([^\\*\\|\\\\\\:\\\"<>\\?\\/]*))[^\\s\\-\\*\\|\\\\\\:\\\"<>\\?\\/]{1})");
        Pattern pattern3 = Pattern.compile("(([^\\*\\|\\\\\\:\\\"<>\\?\\/]*)[^\\s\\-\\*\\|\\\\\\:\\\"<>\\?\\/]{1})");

        Matcher matcher1 = pattern1.matcher(newDirectories);
        if(matcher1.find()){
            pathWithoutP = matcher1.group(1);  // отделяем -р
            flagForP = matcher1.group(8);
        }
        if (pathWithoutP == null){pathWithoutP ="1";}
        if (flagForP == null){flagForP = "1";}

        try {
            Matcher matcher2 = pattern2.matcher(pathWithoutP);
            if(matcher2.find() && flagForP.equals(mkP)){
                flagToCorrect = matcher2.group(1);
            }
        }
        catch (NullPointerException ex){ }
        if (flagToCorrect == null){flagToCorrect = "1";}

        Matcher matcher3 = pattern3.matcher(newDirectories);
        if(matcher3.find()){
            flagForOne = matcher3.group(1);
        }

        if (pathWithoutP.length() == flagToCorrect.length() && flagForP.equals(mkP)){
            mkPFlag = true;
            return pathWithoutP;
        }
        else if(flagForOne != null){
            return flagForOne;
        }
        else return ret;
    }
}
