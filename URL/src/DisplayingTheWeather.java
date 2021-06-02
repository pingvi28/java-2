import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class DisplayingTheWeather {
    private String city;
    private String regexFindCityId = "[w][o][e][i][d][\"][:]([0-9]*)[,]";
    private String regexFindInformation =   "(\"weather_state_name\":\")([a-zA-Z\\ ]*)\".{0,100}(\"applicable_date\":\")" +
                                            "([0-9\\-]{10})(\",\"min_temp\":)([0-9\\.]*)" +
                                            "(,\"max_temp\":)([0-9\\.]*)(,\"the_temp\":)([0-9\\.]*)(,\"wind_speed\":)" +
                                            "([0-9\\.]*)";
    private String regexReverseData = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
    private String[] columnNames = {
            "date",
            "weather state",
            "min temperature",
            "max temperature",
            "the temperature",
            "wind speed"};

    public DisplayingTheWeather(String city){
        this.city = city;
    }

    /**
    * the method get city -> find city id -> if city find == display the weather
    */
    public void displayTheWeather() throws IOException {
        URLConnection conn = new URL("https://www.metaweather.com/api/location/search/?query=" + city ).openConnection();
        String idCity = findId(conn);

        try {
            URLConnection conn1 = new URL("https://www.metaweather.com/api/location/" + idCity + "/").openConnection();
            JFrame.setDefaultLookAndFeelDecorated(true);
            createGUI(findWeather(conn1));
        }
        catch (FileNotFoundException ex){
            JFrame.setDefaultLookAndFeelDecorated(true);
            canNotCreateGUI();
        }
    }

    public String findId(URLConnection conn) throws IOException {
        String id = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer line = stringBuffer.append(reader.readLine());

        Pattern pattern = Pattern.compile(regexFindCityId);
        Matcher matcher = pattern.matcher(line);

        while(matcher.find()) {
            id = matcher.group(1);
        }

        return id;
    }

    public String[][] findWeather(URLConnection conn) throws IOException {
        String[][] data = new String[6][columnNames.length];
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line;

        while((line = reader.readLine()) != null){
            stringBuffer.append(line);
        }

        Pattern pattern = Pattern.compile(regexFindInformation);
        Matcher matcher = pattern.matcher(stringBuffer.toString());
        Pattern pattern1 = Pattern.compile(regexReverseData);
        int n = 0;
        String day;
        while(matcher.find()) {
            day = null;
            Matcher matcher1 = pattern1.matcher(matcher.group(4));
            while(matcher1.find()) {
                day = matcher1.group(3) + "-" + matcher1.group(2) + "-" + matcher1.group(1);
            }
            data[n][0] = "  " + day;
            data[n][1] = "  " + matcher.group(2).toLowerCase();
            data[n][2] = "  " + matcher.group(6).substring(0,4) + "°C";
            data[n][3] = "  " + matcher.group(8).substring(0,4) + "°C";
            data[n][4] = "  " + matcher.group(10).substring(0,4) + "°C";
            data[n][5] = "  " + matcher.group(12).substring(0,4) + " m/s";
            n++;
        }

        return data;
    }

    public void createGUI(String[][] data) {
        JFrame frame = new JFrame("Weather in " + city);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(650, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void canNotCreateGUI() {
        JFrame frame = new JFrame("Weather in " + city + " don't exit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(400, 100));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

