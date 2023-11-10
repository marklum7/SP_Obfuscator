import java.io.*;
import java.util.regex.*;

public class Main1 {
    public static void main(String[] args) {

        String inputFileName = "src/Main.java";
        String outputFileName = "src/vibeplus.java";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            String stroke;

            while ((stroke = reader.readLine()) != null) {
                stroke = stroke.replaceAll("//.*|/\\*(.|\\n)*?\\*/", "");
                stroke = stroke.replaceAll("\\s+", "");
                stroke = ReplaceIndef(stroke);
                writer.write(stroke);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String ReplaceIndef(String kod) {
        String[] indefs = kod.split("[^A-Za-z0-9_]+");
        int counter = 0;

        for (String indef : indefs) {
            if (indef.matches("[A-Za-z_][A-Za-z0-9_]*")) {
                String name = "z" + counter++;
                kod = kod.replaceFirst(Pattern.quote(indef), name);

            }
        }
        return kod;
    }
}