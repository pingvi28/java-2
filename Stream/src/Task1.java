import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\79179\\Desktop\\test.txt"), UTF_8);

        System.out.print(lines.stream()
                                .filter(s -> s.length() % 2 == 1)
                                .filter(o -> lines.indexOf(o) % 2 == 0)
                                .count()
        );
    }
}


