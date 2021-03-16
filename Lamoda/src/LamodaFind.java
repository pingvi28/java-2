import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LamodaFind<T>{

    public void findBlock(String regX, List<String> htmlCode, Collection<String> c1) throws IllegalArgumentException{
        Pattern pattern1 = Pattern.compile(regX);
        String text = htmlCode.toString();
        Matcher matcher1 = pattern1.matcher(text);
        while(matcher1.find()){
            c1.add(matcher1.group());
        }
    }

    public void findMatch(String regX, String block, Collection<String> c1) throws IllegalArgumentException{
        Pattern pattern1 = Pattern.compile(regX);
        Matcher matcher1 = pattern1.matcher(block);
        boolean flag = true;
        while(matcher1.find() && flag){
            c1.add(matcher1.group(1));
            flag = false;
        }
    }
}
