import java.io.*;

public class CSVFile {
    private static int n = 0;
    private static int m = 0;

    public static void main(String[] args) throws IOException {
        String[][] arr = readCSVFile();
        writeCSVFile(arr);
    }

    public static String[][] readCSVFile() throws IOException {
        calculationNM();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("testRead"));
        String[][] data = new String[n][m];

        n = 0;
        while ((line = reader.readLine()) != null){
            if(line.isEmpty()){
                continue;
            }
            String[] dataLine = line.split(",");

            for (int i = 0; i < dataLine.length; i++) {
                data[n][i] = dataLine[i];
            }
            n++;
        }
        reader.close();
        return data;
    }

    public static void writeCSVFile(String[][] data) throws IOException {
        FileWriter writer = new FileWriter("testWrite");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] == null){
                    data[i][j] = "";
                }
                writer.append(String.valueOf(data[i][j]));
                writer.append(",");
            }
            writer.append("\n");
        }
        writer.close();
    }

    public static void calculationNM() throws IOException {
        String line;
        BufferedReader reader2 = new BufferedReader(new FileReader("testRead"));
        while ((line = reader2.readLine()) != null){
            String[] dataLine = line.split(",");
            if(m < dataLine.length){
                m = dataLine.length;
            }
            n++;
        }
    }
}
