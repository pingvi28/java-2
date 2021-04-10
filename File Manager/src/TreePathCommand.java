import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

public class TreePathCommand {
    private static String space = "";
    private static String chekLast;
    private static String printBranch = "├── ";
    private static boolean ifFlag1 = true;
    private static boolean isFlag2 = true;
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE_BOLD = "\033[1;34m";

    public static void main(String path) {
        checkPath(path);
    }

    public static void checkPath(String directory){
        File path = Paths.get(directory).normalize().toAbsolutePath().toFile();
        if(path.isAbsolute() && path.listFiles() != null) {
            System.out.println( CYAN + "directory: " + RESET + path.getAbsoluteFile());
            printDirectoryContent(path);
        }
        else System.out.println("Uncorrected path");
    }

    public static void printDirectoryContent(File dir){
        chekLast = dir.list()[dir.list().length - 1];
        for(File item : Objects.requireNonNull(dir.listFiles())){
            if(chekLast.equals(item.getName())){
                printBranch = "└──  ";
            }
            if(item.isDirectory()){
                System.out.println( "|\n" + printBranch + BLUE_BOLD + item.getName() + RESET);
                space = "";
                findContent(item.getAbsoluteFile());
            }
            else{
                if(chekLast.equals(item.getName())){
                    printBranch = "└──  ";
                }
                System.out.println("|\n" + printBranch + GREEN + item.getName() + RESET);
            }
        }
    }

    public static void findContent(File dir){
        int count = 0;
        boolean flag= true;
        if (dir.getName().equals(chekLast)){
            lastContent(dir);
            flag = false;
        }

        space = space + "    ";
        if(flag){
            content(dir, count, "|");
        }
        space =  "    ";
    }

    public static void lastContent(File dir){
        space = space + "    ";
        int count = 0;
        isFlag2 = false;
        content(dir, count, "");
        space =  "    ";
    }

    public static void content(File dir, int count, String print){
        for(File item : Objects.requireNonNull(dir.listFiles())){
            System.out.print(print);
            if(item.isDirectory()){
                count ++;

                System.out.println(space +  "└── " + PURPLE + item.getName() + RESET);
                if(Objects.requireNonNull(dir.list()).length == count){ ifFlag1 = false; }
                if(ifFlag1){ space = space + "|"; }

                if (item.list().length == 0 || item.list().length == 1 ) { ifFlag1 = true;}
                else { ifFlag1 = false;}

                if(isFlag2){ findContent(item.getAbsoluteFile()); }
                else{ lastContent(item.getAbsoluteFile()); }
            }
            else{
                count ++;
                System.out.println( space + "└── " + YELLOW + item.getName() + RESET);
                ifFlag1 = true;
            }
        }
    }
}
