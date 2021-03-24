import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task4 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\79179\\Desktop\\test.txt"), UTF_8);

        MyComparator myComparator = new MyComparator();
        lines.stream().sorted(myComparator).forEach(System.out :: println);
    }
}
