import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //don't find
        DisplayingTheWeather display = new DisplayingTheWeather("Kazan");
        display.displayTheWeather();
        // must find
        DisplayingTheWeather display1 = new DisplayingTheWeather("Moscow");
        display1.displayTheWeather();
    }
}
