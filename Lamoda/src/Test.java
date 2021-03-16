import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        List<String> htmlCode = Files.readAllLines(Paths.get("c://Users/79179/Desktop/Lamoda/lamoda.html"));
        LamodaFind<String> stringLamodaFind = new LamodaFind<>();
        ArrayList<String> block = new ArrayList<>();
        ArrayList<String> name_goods = new ArrayList<>();
        ArrayList<String> color_goods = new ArrayList<>();
        ArrayList<String> price_goods = new ArrayList<>();
        ArrayList<String> link_goods = new ArrayList<>();


        String regX = "data-quick-promotion-provider-id=\"\"([А-Яа-яёЁ\\s\\d\\w\\S\\W\\D]+?)data-quick-type=\"category\"";
        stringLamodaFind.findBlock(regX, htmlCode, block);

        String regX1 = "alt=\"([А-Яа-яёЁ\\s\\d\\w\\S\\W\\D]+?), ц";
        for (int i = 0; i < block.size(); i++){
            stringLamodaFind.findMatch(regX1, block.get(i), name_goods);
        }

        String regX2 = "alt=\"[А-Яа-яёЁ\\s\\d\\w\\S\\W\\D]+?цвет: ([А-Яа-яёЁ]*).";
        for (int i =0; i < block.size(); i++){
            stringLamodaFind.findMatch(regX2, block.get(i), color_goods);
        }

        String regX3 = "href=\"(\\/p[\\s\\d\\w\\S\\W\\D]+?)\"";
        for (int i =0; i < block.size(); i++) {
            stringLamodaFind.findMatch(regX3, block.get(i), link_goods);
        }

        String regX4 = "data-price=\"([\\d\\.]*)";
        for (int i =0; i < block.size(); i++) {
            stringLamodaFind.findMatch(regX4, block.get(i), price_goods);
        }

        if( block.size() == name_goods.size() && block.size() == color_goods.size() && block.size() == price_goods.size()
              && block.size()== link_goods.size()){
            for ( int i = 0; i < block.size() ; i++){
                System.out.println("name: " + name_goods.get(i) + "\t||\tcolor: " + color_goods.get(i) + "\t||\tprice: " +
                        price_goods.get(i) + "\t||\tlink: https://www.lamoda.ru/" + link_goods.get(i));
            }
        }
        else {
            System.out.print("You have a mistake(s). Check the ArrayList.size()");
        }
    }
}
